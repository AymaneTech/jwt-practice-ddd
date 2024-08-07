package dev.codex.jwt_practice.authentication.application.dtos.requests;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;

import dev.codex.jwt_practice.user.domain.valueObjects.FullName;
import io.micrometer.common.lang.NonNull;

/**
 * RegisterRequest
 */
public record RegisterRequest(
        @NotBlank FullName fullName,
        @NotBlank String email,
        @NotBlank String password,
        @NonNull UUID roleId) implements AuthRequest {
}
