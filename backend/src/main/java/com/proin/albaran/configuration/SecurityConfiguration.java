package com.proin.albaran.configuration;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity.CsrfSpec;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.csrf.CookieServerCsrfTokenRepository;

import com.proin.albaran.configuration.matcher.CsfrServerWebExchangeMatcher;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j()
@Profile({"dev", "pro"})
public class SecurityConfiguration {

    

    @Value("${security.csrf.enabled}") boolean csrfEnabled;
    @Value("${security.csrf.cookie.domain}") String csrfCookieDomain;
    @Value("${security.csrf.cookie.name}") String csrfCookieName;
    @Value("${security.csrf.cookie.httOnly}") boolean csrfCookieHttpOnly;
    @Value("${security.csrf.cookie.secure}") boolean csrfCookieSecure;
    @Value("${security.paths.exclude}") String[] securityExcludePaths;
    @Value("${security.paths.include}") String[] securityIncludePaths;

    @Bean
    @Profile({"dev", "pro"})
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        log.debug("prepare configuration with security cookie " + csrfCookieName);
        final CookieServerCsrfTokenRepository cookieCsrfTokenRepository = new CookieServerCsrfTokenRepository();
        final CsfrServerWebExchangeMatcher csfrServerWebExchangeMatcher = new CsfrServerWebExchangeMatcher(securityExcludePaths, securityIncludePaths, csrfCookieName);

        ServerHttpSecurity security = serverHttpSecurity(http);
        CsrfSpec spec = security.csrf();

        if(csrfEnabled) {
            log.debug("prepare csrf token enabled");
            cookieCsrfTokenRepository.setCookieDomain(csrfCookieDomain);
            cookieCsrfTokenRepository.setCookieHttpOnly(csrfCookieHttpOnly);  // se tiene que leer por el frontend
            cookieCsrfTokenRepository.setSecure(csrfCookieSecure); // localhost no tiene https
            if(StringUtils.isNotBlank(csrfCookieName)){
                cookieCsrfTokenRepository.setCookieName(csrfCookieName); // cookie name CSRF
            }
            security = spec
            .csrfTokenRepository(cookieCsrfTokenRepository)
            .requireCsrfProtectionMatcher(csfrServerWebExchangeMatcher).and();
        } else {
            log.debug("prepare csrf token DISABLED");
            security = spec.disable();
        }
        security
        .formLogin();

        return security.build();
    }

    private ServerHttpSecurity serverHttpSecurity(ServerHttpSecurity http) {
        return
            http
            .authorizeExchange((authorize) -> authorize
                .pathMatchers(securityExcludePaths).permitAll()
                .pathMatchers(securityIncludePaths).authenticated()
                // .hasRole("ADMIN") // roles ?¿
                .anyExchange().denyAll()
            );
    }

}