package dev.codex.jwt_practice.Authentication.Application.DTOs.Requests;

import jakarta.validation.constraints.NotBlank;

/**
 * LoginRequest
 */
public record LoginRequest(
        @NotBlank String email,
        @NotBlank String password) implements AuthRequest {
}
