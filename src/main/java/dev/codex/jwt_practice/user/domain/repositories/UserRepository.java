package dev.codex.jwt_practice.user.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.codex.jwt_practice.user.domain.User;
import dev.codex.jwt_practice.user.domain.valueObjects.Email;
import dev.codex.jwt_practice.user.domain.valueObjects.UserId;

/**
 * UserRepository
 */
@Repository
public interface UserRepository extends JpaRepository<User, UserId> {

    Optional<User> findByEmail(Email email);

}
