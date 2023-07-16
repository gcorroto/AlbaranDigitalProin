package com.proin.albaran.configuration.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.web.server.ServerHttpSecurity;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j()
@Profile({"insecure"})
public class SecurityConfigurationInsecure {

    @Bean(value = "httpSecurityInsecure")
    @Profile("insecure")
    public SecurityConfigurationContainer securityWebFilterChain(ServerHttpSecurity http) {
        log.debug("prepare configuration insecure security");
        return new SecurityConfigurationContainer(
        http.csrf().disable() // deshabilitamos csrf 
        .cors().disable() // deshabilitamos cors 
        .authorizeExchange().anyExchange().permitAll() // permitimos todo en dev
        .and());
    }


}
