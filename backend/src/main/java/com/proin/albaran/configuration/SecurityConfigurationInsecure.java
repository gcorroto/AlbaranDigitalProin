package com.proin.albaran.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j()
@Profile({"insecure"})
public class SecurityConfigurationInsecure {

    @Bean
    @Profile("insecure")
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        log.debug("prepare configuration insecure security");
        return
        http.csrf().disable() // deshabilitamos en local
        .authorizeExchange().anyExchange().permitAll() // permitimos todo en dev
        .and().build();
    }


}