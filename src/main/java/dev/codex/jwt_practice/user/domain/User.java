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
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import dev.codex.jwt_practice.common.models.AbstractEntity;
import dev.codex.jwt_practice.user.domain.valueObjects.Email;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private UserId id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "firstName", column = @Column(name = "first_name")),
            @AttributeOverride(name = "lastName", column = @Column(name = "last_name"))
    })
    private FullName fullName;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "email"))
    private Email email;

    private String password;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "role_id"))
    private RoleId roleId;

    public User setId() {
        this.id = new UserId(29292);
        return this;
    }

    public User setFullName(String firstName, String lastName) {
        this.fullName = new FullName(firstName, lastName);
        return this;
    }

    public User setEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public User setRoleId(UUID roleId) {
        this.roleId = new RoleId(roleId);
        return this;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(roleId.value().toString());
        return List.of(authority);
    }

    @Override
    public String getUsername() {
        return email.value();
    }
}
