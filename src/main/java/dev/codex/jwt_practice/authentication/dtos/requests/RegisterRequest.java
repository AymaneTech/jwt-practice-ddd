package dev.codex.jwt_practice.authentication.dtos.requests;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;

import io.micrometer.common.lang.NonNull;

/**
 * RegisterRequest
 */
public record RegisterRequest(
        @NotBlank String firstName,
        @NotBlank String lastName,
        @NotBlank String email,
        @NotBlank String password,
        @NonNull UUID roleId) implements AuthRequest {
}
