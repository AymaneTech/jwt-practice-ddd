package dev.codex.jwt_practice.authentication.services;

import dev.codex.jwt_practice.authentication.dtos.requests.LoginRequest;
import dev.codex.jwt_practice.authentication.dtos.requests.RegisterRequest;
import dev.codex.jwt_practice.authentication.dtos.responses.AuthenticationResponse;

/**
 * AuthenticationService
 */
public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse login(LoginRequest request);
}
