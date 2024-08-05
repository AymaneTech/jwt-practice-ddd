package dev.codex.jwt_practice.user.domain.valueObjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

/**
 * UserId
 */
@Embeddable
public record UserId(@NotNull @Column(name = "id") Integer value) {

}
