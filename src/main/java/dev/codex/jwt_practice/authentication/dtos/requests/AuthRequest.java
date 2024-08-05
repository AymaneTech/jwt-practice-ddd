package dev.codex.jwt_practice.authentication.dtos.requests;

/**
 * AuthRequest
 */
public interface AuthRequest {

    String email();
    String password();
}
