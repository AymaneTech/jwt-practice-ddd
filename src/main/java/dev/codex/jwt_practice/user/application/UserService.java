package dev.codex.jwt_practice.user.application;

import dev.codex.jwt_practice.user.domain.User;

/**
 * UserService
 */
public interface UserService {

    User findByEmail(String email);
}
