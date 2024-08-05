package dev.codex.jwt_practice.user.domain.valueObjects;

import jakarta.validation.constraints.NotBlank;

/**
 * FullName
 */
public record FullName(
        @NotBlank String firstName,
        @NotBlank String lastName) {
}
