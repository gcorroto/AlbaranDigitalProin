package com.proin.albaran.configuration;
import static org.springframework.http.MediaType.TEXT_HTML;
import static org.springframework.web.reactive.function.server.RouterFunctions.resources;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j()
public class NPMRouterAndViewResolver {
	
	private static final String STATIC_FOLDER_NPM = "classpath:/static/frontend/index.html";
	private static final String PATH_ROUTER_BACKEND = "/**";
	private static final String PATH_API_BACKEND = "/api/**";
	private static final String PATH_ROUTER_FRONTEND = "static/frontend/";
	private static final String PATH_FILE_FRONTEND = "/**/{path:[^\\.]*}";
    /**
     * Returns index.html on all urls that:
     * - do not start with "/api/"
     * - do not contain a dot (omit static resources like "main.js")
     */
    @Bean
    public RouterFunction<ServerResponse> indexRouter(
        @Value(STATIC_FOLDER_NPM) Resource indexHtml
    ) {
        log.debug("prepare index.html Angular " + STATIC_FOLDER_NPM);
        IndexPageRequestPredicate predicate = new IndexPageRequestPredicate();
        HandlerFunction<ServerResponse> indexHtmlResponse =
                request -> ok()
                        .contentType(TEXT_HTML)
                        .bodyValue(indexHtml);
        return route(predicate, indexHtmlResponse);
    }

    @Bean
	// index de la aplicación angular que retomara el resto del url
    RouterFunction<ServerResponse> staticResourcesRouter() {
        log.debug("Config REDIRECT TO router Angular");
        return resources(PATH_ROUTER_BACKEND, new ClassPathResource(PATH_ROUTER_FRONTEND));
    }

    private static class IndexPageRequestPredicate implements RequestPredicate {
        private final AntPathMatcher antPathMatcher = new AntPathMatcher();

        @Override
		// evaluamos si la request es para el backend o el frontend
        public boolean test(ServerRequest request) {
            String path = request.path();
            boolean requestForNPM =  request.method() == HttpMethod.GET
                    && (path.equals("/") || (pathIsNotAFileNPM(path) && pathIsNotApi(path)));
			log.debug("Evaluate request [" + path + "] is requestForNPM = " + requestForNPM);
			return requestForNPM;
        }

        private boolean pathIsNotAFileNPM(String path) {
            return antPathMatcher.match(PATH_FILE_FRONTEND, path);
        }

        private boolean pathIsNotApi(String path) {
            return !antPathMatcher.match(PATH_API_BACKEND, path);
        }
    }

}
