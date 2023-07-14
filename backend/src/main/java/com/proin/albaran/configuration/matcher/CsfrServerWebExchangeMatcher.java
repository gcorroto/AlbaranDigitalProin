package com.proin.albaran.configuration.matcher;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatcher;
import org.springframework.web.server.ServerWebExchange;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Profile({"dev", "pro"})
@AllArgsConstructor
public class CsfrServerWebExchangeMatcher implements ServerWebExchangeMatcher {

    private final String[] securityExcludePaths;
    private final String[] securityIncludePaths;
    private final String csrfCookieName;

    @Override
    public Mono<MatchResult> matches(ServerWebExchange exchange) {
        // Aquí puedes implementar la lógica para verificar si el intercambio cumple con tus requisitos
        // Puedes utilizar métodos como getRequest(), getPath(), getHeaders(), etc. de ServerWebExchange
        // y aplicar las condiciones necesarias para la coincidencia

        // Ejemplo: Verificar si la ruta del intercambio contiene "/api"
        String path = exchange.getRequest().getPath().toString();
        boolean matchesExcludes = securityExcludePaths!=null ?  Stream.of(securityExcludePaths).anyMatch(e -> path.contains(e.replace("/**",""))): false;
        boolean matchesIncludes = securityIncludePaths!=null ? Stream.of(securityIncludePaths).anyMatch(e -> path.contains(e.replace("/**",""))): false;
        boolean matchesCookieCsrf = Optional.ofNullable(exchange.getRequest().getHeaders().get(csrfCookieName)).isPresent();
        boolean matchesGetMethod = HttpMethod.GET.equals(exchange.getRequest().getMethod());

        if ((matchesIncludes && matchesCookieCsrf) || (matchesExcludes && matchesGetMethod)) {
            return MatchResult.notMatch();
        } else {
            return MatchResult.match();
        }
    }
}