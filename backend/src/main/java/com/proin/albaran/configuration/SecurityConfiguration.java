package com.proin.albaran.configuration;

// import java.util.function.Function;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;


// @Configuration
// public class SecurityConfiguration {

// 	@Bean
//     public WebSecurityCustomizer webSecurityCustomizer() {
//         return (web) -> web.ignoring().anyRequest();
//     }
	
// 	@Bean
//     public InMemoryUserDetailsManager userDetailsService() {
    	
//     	Function<String, String> encoder = input -> passwordEncoder().encode(input);

//     	UserDetails user = User.builder().passwordEncoder(encoder)
//             .username("hugo")
//             .password("hugo")
//             .roles("USER")
//             .build();
//         return new InMemoryUserDetailsManager(user);
//     }
    
//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     } 
	
// }

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@Profile("dev") // tiramos con profile dev
public class SecurityConfiguration {
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http.authorizeExchange().anyExchange().permitAll().and().build();  
    }

}