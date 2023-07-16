package com.proin.albaran.configuration.security;
import org.springframework.security.config.web.server.ServerHttpSecurity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SecurityConfigurationContainer {

    private ServerHttpSecurity security;

}