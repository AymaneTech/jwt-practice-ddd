package dev.codex.jwt_practice.user.domain.valueObjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;

/**
 * Email
 */
@Embeddable
public record Email(
        @NotBlank String value) {

    public Email {
        if (!value.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) {
            throw new IllegalArgumentException("Invalid email address");
        }
    }
}
