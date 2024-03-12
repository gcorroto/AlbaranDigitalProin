package com.proin.albaran.configuration.security;
import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http.authorizeExchange().anyExchange().permitAll().and().httpBasic().and().build();
    }

   @Bean
    public MapReactiveUserDetailsService userDetailsService() {
        UserDetails user = User.builder()
            .username("B14952631")
            .password("{noop}B14952631")
            .roles("USER")
            .build();
        return new MapReactiveUserDetailsService(user);
    }


@Bean
public CorsWebFilter corsWebFilter() {

    CorsConfiguration corsConfig = new CorsConfiguration();
    corsConfig.setAllowedOrigins(Arrays.asList("*"));
    corsConfig.setAllowedMethods(Arrays.asList(
            HttpMethod.GET.name(),
            HttpMethod.HEAD.name(),
            HttpMethod.POST.name(),
            HttpMethod.DELETE.name(),
            HttpMethod.PUT.name()));
    corsConfig.setMaxAge(3600L);
    corsConfig.setAllowedHeaders(Arrays.asList("*"));

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", corsConfig);

    return new CorsWebFilter(source);
}
}