package com.proin.albaran;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.reactive.function.server.*;

import lombok.extern.slf4j.Slf4j;

import static org.springframework.http.MediaType.TEXT_HTML;
import static org.springframework.web.reactive.function.server.RouterFunctions.resources;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


@SpringBootApplication
@Slf4j()
public class AlbaranApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlbaranApplication.class, args);
	}

	
    /**
     * Returns index.html on all urls that:
     * - do not start with "/api/"
     * - do not contain a dot (omit static resources like "main.js")
     */
    @Bean
    public RouterFunction<ServerResponse> indexRouter(
            @Value("classpath:/static/frontend/index.html")
                    Resource indexHtml
    ) {
        log.info("prepare index angular");
        IndexPageRequestPredicate predicate = new IndexPageRequestPredicate();
        HandlerFunction<ServerResponse> indexHtmlResponse =
                request -> ok()
                        .contentType(TEXT_HTML)
                        .bodyValue(indexHtml);
        return route(predicate, indexHtmlResponse);
    }

    @Bean
    RouterFunction<ServerResponse> staticResourcesRouter() {
        log.info("router statics angular");
        return resources("/**", new ClassPathResource("static/frontend/"));
    }

    private static class IndexPageRequestPredicate implements RequestPredicate {
        private final AntPathMatcher antPathMatcher = new AntPathMatcher();

        @Override
        public boolean test(ServerRequest request) {
            String path = request.path();
            log.info("evaluate request " + path);
            return request.method() == HttpMethod.GET
                    && (path.equals("/") || (pathIsNotAFile(path) && pathIsNotApi(path)));
        }

        private boolean pathIsNotAFile(String path) {
            return antPathMatcher.match("/**/{path:[^\\.]*}", path);
        }

        private boolean pathIsNotApi(String path) {
            return !antPathMatcher.match("/api/**", path);
        }
    }

}
