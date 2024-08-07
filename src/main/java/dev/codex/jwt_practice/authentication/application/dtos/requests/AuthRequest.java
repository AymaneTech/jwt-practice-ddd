package dev.codex.jwt_practice.authentication.application.dtos.requests;

/**
 * AuthRequest
 */
public interface AuthRequest {

    String email();
    String password();
}
