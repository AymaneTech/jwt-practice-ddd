package dev.codex.jwt_practice.user.domain.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import dev.codex.jwt_practice.user.domain.User;
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

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, targetEntity = User.class)
    private List<User> users;

    Role() {
    }
}
