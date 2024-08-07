package dev.codex.jwt_practice.authentication.application.services;

import dev.codex.jwt_practice.authentication.application.dtos.requests.LoginRequest;
import dev.codex.jwt_practice.authentication.application.dtos.requests.RegisterRequest;
import dev.codex.jwt_practice.authentication.application.dtos.responses.AuthenticationResponse;

/**
 * AuthenticationService
 */
public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse login(LoginRequest request);
}
