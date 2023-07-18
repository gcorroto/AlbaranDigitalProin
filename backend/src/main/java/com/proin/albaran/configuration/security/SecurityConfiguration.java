package com.proin.albaran.configuration.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.server.SecurityWebFilterChain;

import com.proin.albaran.configuration.annotation.CsrfQualifier;
import com.proin.albaran.configuration.annotation.InsecuredQualifier;
import com.proin.albaran.configuration.annotation.Oauth2Qualifier;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j()
@AllArgsConstructor
public class SecurityConfiguration {

    // @Autowired(required = false)
    @Oauth2Qualifier() // no funciona aún
    @CsrfQualifier()
    @InsecuredQualifier()
    private final SecurityConfigurationContainer httpSecurity;

    @Bean
    public SecurityWebFilterChain securityWebFilterChain() throws Exception {
        log.debug("prepare configuration with security");

        if(httpSecurity == null) {
            throw new Exception("debe definir un profile de seguridad en la aplicación 'dev' o 'pro' acompañado del perfil de seguridad 'csrf' , 'oauth2' o 'insecure' por ejemplo [spring.profiles.active=dev-insecure]");
        }
        return httpSecurity.getSecurity().build();
    }

}