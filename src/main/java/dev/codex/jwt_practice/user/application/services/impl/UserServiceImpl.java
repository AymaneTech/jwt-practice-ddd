package dev.codex.jwt_practice.user.application.services.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.codex.jwt_practice.authentication.application.dtos.requests.RegisterRequest;
import dev.codex.jwt_practice.user.application.services.UserService;
import dev.codex.jwt_practice.user.domain.User;
import dev.codex.jwt_practice.user.domain.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

/**
 * UserServiceImpl
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public User findByEmail(final String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User save(final RegisterRequest request) {
        return repository.save(
                new User(
                        request.fullName(),
                        request.email(),
                        passwordEncoder.encode(request.password()),
                        request.roleId()));
    }
}
