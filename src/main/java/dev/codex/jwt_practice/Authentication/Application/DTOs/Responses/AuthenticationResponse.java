package dev.codex.jwt_practice.Authentication.Application.DTOs.Responses;

import jakarta.validation.constraints.NotBlank;

/**
 * AuthenticationResponse
 */
public record AuthenticationResponse(
        @NotBlank String token) {
}
