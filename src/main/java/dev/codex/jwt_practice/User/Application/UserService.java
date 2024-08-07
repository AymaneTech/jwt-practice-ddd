package dev.codex.jwt_practice.User.Application;

import dev.codex.jwt_practice.Authentication.Application.DTOs.Requests.RegisterRequest;
import dev.codex.jwt_practice.User.Domain.User;

/**
 * UserService
 */
public interface UserService {

    User findByEmail(final String email);

    User save(final RegisterRequest request);
}
