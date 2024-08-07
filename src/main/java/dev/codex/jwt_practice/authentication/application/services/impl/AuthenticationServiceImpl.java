package dev.codex.jwt_practice.authentication.application.services.impl;

import dev.codex.jwt_practice.authentication.application.dtos.requests.AuthRequest;
import dev.codex.jwt_practice.authentication.application.dtos.requests.LoginRequest;
import dev.codex.jwt_practice.authentication.application.dtos.requests.RegisterRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.codex.jwt_practice.authentication.application.dtos.responses.AuthenticationResponse;
import dev.codex.jwt_practice.authentication.application.services.AuthenticationService;
import dev.codex.jwt_practice.authentication.application.services.JWTService;
import dev.codex.jwt_practice.user.application.services.UserService;
import dev.codex.jwt_practice.user.domain.User;
import lombok.RequiredArgsConstructor;

/**
 * AuthenticationServiceImpl
 */
@Service
@RequiredArgsConstructor
class AuthenticationServiceImpl implements AuthenticationService {

    private final UserService userService;
    private final JWTService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        final User user = userService.save(request);
        return handleAuthentication(user, request);
    }

    public AuthenticationResponse login(LoginRequest request) {
        final User user = userService.findByEmail(request.email());
        return handleAuthentication(user, request);
    }

    private AuthenticationResponse handleAuthentication(User user, AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()));
        final String token = jwtService.generateToken(user);
        return new AuthenticationResponse(token);
    }
}
