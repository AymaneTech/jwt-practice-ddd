package dev.codex.jwt_practice.user.domain;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import dev.codex.jwt_practice.common.models.AbstractEntity;
import dev.codex.jwt_practice.user.domain.valueObjects.FullName;
import dev.codex.jwt_practice.user.domain.valueObjects.RoleId;
import dev.codex.jwt_practice.user.domain.valueObjects.UserId;
import lombok.Getter;

/**
 * User
 */
@Entity
@Table(name = "users")

@Getter
public class User extends AbstractEntity<UserId> implements UserDetails {

    @EmbeddedId
    @GeneratedValue
    @AttributeOverride(name = "value", column = @Column(name = "id"))
    private UserId id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "firstName", column = @Column(name = "first_name")),
            @AttributeOverride(name = "lastName", column = @Column(name = "last_name"))
    })
    private FullName fullName;

    @Column(name = "email", unique = true)
    private String email;

    private String password;

    private RoleId roleId;

    User() {
    }

    public User(FullName fullName, String email, String password, UUID roleId) {
        this.id = new UserId();
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.roleId = new RoleId(roleId);
    }

    public User setId(UUID id) {
        this.id = new UserId(id);
        return this;
    }

    public User setFullName(FullName fullName) {
        this.fullName = fullName;
        return this;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public User setRole(RoleId roleId) {
        this.roleId = roleId;
        return this;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(getRoleId().toString());
        return List.of(authority);
    }

    @Override
    public String getUsername() {
        return email;
    }
}
