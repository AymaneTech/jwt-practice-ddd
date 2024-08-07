package dev.codex.jwt_practice.user.domain.valueObjects;

import java.util.UUID;

import jakarta.persistence.Embeddable;

/**
 * UserId
 */
@Embeddable
public record UserId(UUID value) {
    public UserId {
        if (value == null) {
            throw new IllegalArgumentException("RoleId cannot be null");
        }
    }

    public UserId() {
        this(UUID.randomUUID());
    }
}
