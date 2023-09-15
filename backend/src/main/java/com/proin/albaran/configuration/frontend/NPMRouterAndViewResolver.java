package com.proin.albaran.configuration.frontend;
import static org.springframework.http.MediaType.TEXT_HTML;
import static org.springframework.web.reactive.function.server.RouterFunctions.resources;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpMethod;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.expression.ThymeleafEvaluationContext;
import org.thymeleaf.templateresolver.StringTemplateResolver;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j()
@Profile("!oauth2")
public class NPMRouterAndViewResolver {
	
	private static final String STATIC_INDEX_NPM = "classpath:/static/frontend/index.html";
    // private static final String STATIC_FOLDER_NPM = "classpath:/static/frontend/";
	private static final String PATH_ROUTER_BACKEND = "/**";
	private static final String PATH_API_BACKEND = "/api/**";
	private static final String PATH_ROUTER_FRONTEND = "static/frontend/";
	private static final String PATH_FILE_FRONTEND = "/**/{path:[^\\.]*}";

    @Autowired 
    private ApplicationContext applicationContext;
    /**
     * Returns index.html on all urls that:
     * - do not start with "/api/"
     * - do not contain a dot (omit static resources like "main.js")
     */
    @Bean
    public RouterFunction<ServerResponse> indexRouter(
        @Value(STATIC_INDEX_NPM) Resource indexHtml
    ) {
        log.debug("prepare index.html Angular " + STATIC_INDEX_NPM);
        IndexPageRequestPredicate predicate = new IndexPageRequestPredicate();
        Context context = new Context();

        // Set the Thymeleaf evaluation context to allow access to Spring beans with @beanName in SpEL expressions
        context.setVariable(ThymeleafEvaluationContext.THYMELEAF_EVALUATION_CONTEXT_CONTEXT_VARIABLE_NAME,
                new ThymeleafEvaluationContext(applicationContext, null));

        // Set additional variables
        // variables.forEach { (key, value) -> context.setVariable(key, value) }

        log.debug("compile template index.html Angular with Thymeleaf " + STATIC_INDEX_NPM);
        String processTemplate = templateEngine().process(ResourceReader.asString(indexHtml), context);
        Resource compileIndex = new ByteArrayResource(processTemplate.getBytes());

        HandlerFunction<ServerResponse> indexHtmlResponse =
                request -> ok()
                        .contentType(TEXT_HTML)
                        .bodyValue(compileIndex);
        return route(predicate, indexHtmlResponse);
    }

    @Bean
	// index de la aplicación angular que retomara el resto del url
    RouterFunction<ServerResponse> staticResourcesRouter() {
        log.debug("Config REDIRECT TO router Angular");
        return resources(PATH_ROUTER_BACKEND, new ClassPathResource(PATH_ROUTER_FRONTEND));
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }

    @Bean
    public StringTemplateResolver templateResolver() {
        StringTemplateResolver templateResolver = new StringTemplateResolver();
        templateResolver.setCacheable(false);
        templateResolver.setTemplateMode("HTML");

        return templateResolver;
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

    private static class ResourceReader {

        public static String asString(Resource resource) {
            try (Reader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)) {
                return FileCopyUtils.copyToString(reader);
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }

        // more utility methods
    }

}
