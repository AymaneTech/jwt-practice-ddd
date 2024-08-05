package dev.codex.jwt_practice.authentication.dtos.responses;

import jakarta.validation.constraints.NotBlank;

/**
 * AuthenticationResponse
 */
public record AuthenticationResponse(
        @NotBlank String token) {
}
