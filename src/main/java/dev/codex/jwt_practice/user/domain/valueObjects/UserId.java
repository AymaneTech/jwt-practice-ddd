package dev.codex.jwt_practice.user.domain.valueObjects;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

/**
 * UserId
 */
public record UserId(@NotNull UUID value) {
}
