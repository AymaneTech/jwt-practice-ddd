package dev.codex.jwt_practice.user.domain.valueObjects;

import java.util.UUID;

import jakarta.persistence.Embeddable;

/**
 * RoleId
 */
@Embeddable
public record RoleId(UUID value) {
    public RoleId {
        if (value == null) {
            throw new IllegalArgumentException("RoleId cannot be null");
        }
    }

    public RoleId() {
        this(UUID.randomUUID());
    }
}
