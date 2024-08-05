package dev.codex.jwt_practice.user.domain.entities;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;

import dev.codex.jwt_practice.user.domain.valueObjects.RoleId;
import lombok.Getter;
import lombok.Setter;

/**
 * Role
 */
@Entity
@Table(name = "roles")

@Getter
@Setter
public class Role {

    @EmbeddedId
    @GeneratedValue
    @AttributeOverride(name = "value", column = @Column(name = "id"))
    private RoleId id;

    private String name;

    Role() {
    }
}
