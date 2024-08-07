package dev.codex.jwt_practice.Config.Filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import dev.codex.jwt_practice.Authentication.Application.Services.JWTService;
import io.jsonwebtoken.io.IOException;
import lombok.RequiredArgsConstructor;

/**
 * JWTAuthenticationFilter
 */
@RequiredArgsConstructor
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    private final UserDetailsService userDetailsService;
    private final JWTService jwtService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws IOException, ServletException {

        final String authHeader = request.getHeader("Authorization");

        try {
            if (!isJwtAutRequest(authHeader)) {
                filterChain.doFilter(request, response);
                return;
            }

            final String token = extractJWTToken(authHeader);
            processJwtAuthentication(request, token);
            filterChain.doFilter(request, response);

        } catch (Exception e) {
            handleException(response, e);
        }
    }

    private void processJwtAuthentication(HttpServletRequest request, String token) {
        final String userEmail = jwtService.extractUsername(token);
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (userEmail != null && authentication == null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(userEmail);

            if (jwtService.isTokenValid(token, userDetails)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
    }

    private String extractJWTToken(String authHeader) {
        return authHeader.substring(7);
    }

    private boolean isJwtAutRequest(String authHeader) {
        return authHeader != null && authHeader.startsWith("Bearer ");
    }

    private void handleException(HttpServletResponse response, Exception e) throws IOException {
        try {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            String jsonError = "{\"error\": \"" + e.getMessage() + "\"}";
            response.getWriter().write(jsonError);

        } catch (java.io.IOException ex) {
            ex.printStackTrace();
        }
    }
}
