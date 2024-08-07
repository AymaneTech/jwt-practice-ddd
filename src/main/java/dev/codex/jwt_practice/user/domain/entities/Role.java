package dev.codex.jwt_practice.user.domain.entities;

import dev.codex.jwt_practice.user.domain.valueObjects.RoleId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import org.springframework.scheduling.support.SimpleTriggerContext;

/**
 * Role
 */
@Entity
@Table(name = "roles")

@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue
    private RoleId id;

    private String name;

    Role() {}

    public Role(String name) {
        this.id = new RoleId();
        this.name = name;
    }
}
