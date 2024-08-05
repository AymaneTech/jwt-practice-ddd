package dev.codex.jwt_practice.user.application;

import dev.codex.jwt_practice.authentication.dtos.requests.RegisterRequest;
import dev.codex.jwt_practice.user.domain.User;

/**
 * UserService
 */
public interface UserService {

    User findByEmail(final String email);

    User save(final RegisterRequest request);
}
