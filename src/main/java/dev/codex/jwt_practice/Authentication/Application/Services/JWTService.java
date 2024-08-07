package dev.codex.jwt_practice.Authentication.Application.Services;

import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * JWTService
 */
public interface JWTService {

    String extractUsername(final String token);

    String generateToken(final UserDetails userDetails);

    String generateToken(final UserDetails userDetails, final Map<String, Object> extraClaims);

    Long getExpirationDate();

    boolean isTokenValid(final String token, final UserDetails userDetails);

}
