package com.proin.albaran.configuration.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter{

    private final UserDetails userDetails;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        //throw new UnsupportedOperationException("Unimplemented method 'doFilterInternal'");
    }

}
