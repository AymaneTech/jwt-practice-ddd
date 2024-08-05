package dev.codex.jwt_practice.user.domain.valueObjects;

import java.util.UUID;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

/**
 * RoleId
 */
@Embeddable
public record RoleId(@NotNull UUID value) {

    public RoleId(UUID value) {
        this.value = value;
    }

    public RoleId() {
        this(UUID.randomUUID());
    }
}
