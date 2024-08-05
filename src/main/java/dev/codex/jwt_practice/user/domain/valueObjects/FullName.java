package dev.codex.jwt_practice.user.domain.valueObjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;

/**
 * FullName
 */
@Embeddable
public record FullName(
        @NotBlank String firstName,
        @NotBlank String lastName) {
}
