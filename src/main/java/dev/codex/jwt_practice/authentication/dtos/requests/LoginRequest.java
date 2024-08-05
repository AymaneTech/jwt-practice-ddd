package dev.codex.jwt_practice.authentication.dtos.requests;

import jakarta.validation.constraints.NotBlank;

/**
 * LoginRequest
 */
public record LoginRequest(
        @NotBlank String email,
        @NotBlank String password) implements AuthRequest {
}
