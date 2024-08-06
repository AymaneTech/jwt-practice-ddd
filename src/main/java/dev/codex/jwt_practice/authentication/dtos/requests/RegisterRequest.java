package dev.codex.jwt_practice.authentication.dtos.requests;

import jakarta.validation.constraints.NotBlank;

import io.micrometer.common.lang.NonNull;

/**
 * RegisterRequest
 */
public record RegisterRequest(
        @NotBlank String fullName,
        @NotBlank String email,
        @NotBlank String password,
        @NonNull Long roleId) implements AuthRequest {
}
