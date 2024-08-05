package dev.codex.jwt_practice.user.domain.valueObjects;

import java.util.UUID;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

/**
 * UserId
 */
@Embeddable
public record UserId(@NotNull UUID value) {
}
