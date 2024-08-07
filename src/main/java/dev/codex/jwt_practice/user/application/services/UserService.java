package dev.codex.jwt_practice.user.application.services;

import dev.codex.jwt_practice.authentication.application.dtos.requests.RegisterRequest;
import dev.codex.jwt_practice.user.domain.User;

/**
 * UserService
 */
public interface UserService {

    User findByEmail(final String email);

    User save(final RegisterRequest request);
}
