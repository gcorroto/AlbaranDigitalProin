package com.proin.albaran.configuration.security;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.web.server.authentication.RedirectServerAuthenticationSuccessHandler;
import org.springframework.security.web.server.authentication.ServerAuthenticationSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

import lombok.extern.slf4j.Slf4j;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@Profile({"oauth2"})
// @Import(OAuth2AuthorizationServerConfiguration.class)
@Slf4j()
// @EnableWebFluxSecurity // al utilizar webflux hacemos uso de EnableWebFluxSecurity y no  EnableWebSecurity
public class SecurityConfigurationOauth2 {

    @Value("${security.oauth2.enabled}") boolean oauth2Enabled;
    @Value("${security.oauth2.credentials.clientId}") String oauth2ClientId;
    @Value("${security.oauth2.credentials.secret}") String oauth2Secret;
    @Value("${security.oauth2.paths.code}") String oauth2PathCode;
    @Value("${security.oauth2.paths.authorize}") String oauth2PathAuthorize;
    @Value("${security.oauth2.paths.home}") String oauth2PathHome;
    @Value("${security.oauth2.scopes.read}") String oauth2ScopeRead;
    @Value("${security.oauth2.scopes.write}") String oauth2ScopeWrite;
    @Value("${security.oauth2.cors.origins}") String oauth2CorsOrigin;
    @Value("${security.oauth2.cors.methods}") String[] oauth2CorsMethods;
    @Value("${security.oauth2.authorization-server-url}") String oauth2UrlAuthorizationServer;
    @Value("${security.paths.exclude}") String[] securityExcludePaths;
    @Value("${security.paths.include}") String[] securityIncludePaths;

    @Bean(value = "httpSecurityOauth2")
    @Profile("oauth2")
    SecurityConfigurationContainer httpSecurity(ServerHttpSecurity http) throws Exception {
      
        log.debug("prepare configuration Oauth2 security");
        http
        .csrf()
        .disable()
        .cors()
        .configurationSource(corsConfiguration())
        .and()
        .authorizeExchange(authorizeRequests ->
          authorizeRequests
          .pathMatchers("/login", "/login/**").permitAll()
          .pathMatchers(securityIncludePaths).authenticated()
          // .hasRole("ADMIN") // roles ?¿
          .anyExchange().denyAll()
        )
        // .formLogin(withDefaults())
        .formLogin()
                .loginPage("/login")
                .authenticationSuccessHandler(frontEndUrlAuthenticationSuccessHandler())
        ;

        return new SecurityConfigurationContainer(http);
    }

    @Bean
    @Profile("oauth2")
    public ServerAuthenticationSuccessHandler frontEndUrlAuthenticationSuccessHandler(){
        return new RedirectServerAuthenticationSuccessHandler(oauth2CorsOrigin+oauth2PathHome);
    }

    private CorsConfigurationSource corsConfiguration() {
        CorsConfiguration corsConfig = new CorsConfiguration();

        if(oauth2CorsMethods!=null){
          Stream<String> methods = Stream.of(oauth2CorsMethods);
          corsConfig.applyPermitDefaultValues();
          methods.forEach(m -> {
              corsConfig.addAllowedMethod(m);
          });
        }
        if(oauth2CorsOrigin!=null){
          corsConfig.setAllowedOrigins(Arrays.asList(oauth2CorsOrigin));
        }

        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);
        return source;
    }

    @Bean
    @Profile("oauth2")
    public RegisteredClientRepository registeredClientRepository() {
        RegisteredClient registeredClient = RegisteredClient.withId(UUID.randomUUID().toString())
          .clientId(oauth2ClientId)
          .clientSecret("{noop}" + oauth2Secret)
          // .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_POST)
          // .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
          .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
          .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
          .redirectUri(oauth2UrlAuthorizationServer + oauth2PathCode)
          .redirectUri(oauth2UrlAuthorizationServer + oauth2PathAuthorize)
          .postLogoutRedirectUri(oauth2UrlAuthorizationServer + oauth2PathAuthorize)
          .scope(OidcScopes.OPENID)
          .scope(oauth2ScopeRead)
          .scope(oauth2ScopeWrite)
          .build();
        return new InMemoryRegisteredClientRepository(registeredClient);
    }

    @Bean
    @Profile("oauth2")
    @Primary
    public JWKSource<SecurityContext> jwkSource() throws NoSuchAlgorithmException {
        RSAKey rsaKey = generateRsa();
        JWKSet jwkSet = new JWKSet(rsaKey);
        return (jwkSelector, securityContext) -> jwkSelector.select(jwkSet);
    }

    private static RSAKey generateRsa() throws NoSuchAlgorithmException {
        KeyPair keyPair = generateRsaKey();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        return new RSAKey.Builder(publicKey)
        .privateKey(privateKey)
        .keyID(UUID.randomUUID().toString())
        .build();
    }

    private static KeyPair generateRsaKey() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        return keyPairGenerator.generateKeyPair();
    }


}