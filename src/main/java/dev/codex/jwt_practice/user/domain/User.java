package dev.codex.jwt_practice.user.domain;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;

import dev.codex.jwt_practice.common.models.AbstractEntity;
import dev.codex.jwt_practice.user.domain.valueObjects.Email;
import dev.codex.jwt_practice.user.domain.valueObjects.FullName;
import dev.codex.jwt_practice.user.domain.valueObjects.UserId;
import lombok.Getter;
import lombok.Setter;

/**
 * User
 */
@Entity
@Table(name = "users")

@Getter
@Setter
public class User extends AbstractEntity<UserId> {

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

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "email"))
    private Email email;

    private String password;

}
