package dev.codex.jwt_practice.Authentication.Application.Services;

import dev.codex.jwt_practice.Authentication.Application.DTOs.Requests.LoginRequest;
import dev.codex.jwt_practice.Authentication.Application.DTOs.Requests.RegisterRequest;
import dev.codex.jwt_practice.Authentication.Application.DTOs.Responses.AuthenticationResponse;

/**
 * AuthenticationService
 */
public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse login(LoginRequest request);
}
