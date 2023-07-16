// package com.proin.albaran.configuration.security;

// import java.io.IOException;

// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpSession;

// import org.springframework.http.server.reactive.ServerHttpRequest;
// import org.springframework.http.server.reactive.ServerHttpResponse;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.web.DefaultRedirectStrategy;
// import org.springframework.security.web.RedirectStrategy;
// import org.springframework.security.web.WebAttributes;
// import org.springframework.security.web.server.WebFilterExchange;
// import org.springframework.security.web.server.authentication.ServerAuthenticationSuccessHandler;

// import lombok.AllArgsConstructor;
// import lombok.extern.slf4j.Slf4j;

// @Slf4j()
// @AllArgsConstructor
// public class FrontEndUrlAuthenticationSuccessHandler implements ServerAuthenticationSuccessHandler {

//     private final String urlFrontEndSuccessLogin;

//     @Override
//     public void onAuthenticationSuccess(WebFilterExchange webFilterExchange, Authentication authentication)
//       throws IOException {
 
//         handle(webFilterExchange.getExchange().getRequest(), webFilterExchange.getExchange().getResponse(), authentication);
//     }

//     private void handle(
//         ServerHttpRequest request,
//         ServerHttpResponse response, 
//         Authentication authentication
//     ) throws IOException {
//         RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
//         String targetUrl = urlFrontEndSuccessLogin;

//         if (response.isCommitted()) {
//             log.debug(
//                     "Response has already been committed. Unable to redirect to "
//                             + targetUrl);
//             return;
//         }

//         redirectStrategy.sendRedirect(request, response, targetUrl);
//     }

//     private void clearAuthenticationAttributes(HttpServletRequest request) {
//     HttpSession session = request.getSession(false);
//     if (session == null) {
//         return;
//     }
//     session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
// }
// }