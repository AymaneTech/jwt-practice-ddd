package dev.codex.jwt_practice.user.application.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.codex.jwt_practice.authentication.dtos.requests.RegisterRequest;
import dev.codex.jwt_practice.user.application.UserService;
import dev.codex.jwt_practice.user.domain.User;
import dev.codex.jwt_practice.user.domain.repositories.UserRepository;
import dev.codex.jwt_practice.user.domain.valueObjects.Email;
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
        return repository.findByEmail(new Email(email))
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User save(final RegisterRequest request) {
        return repository.save(
                new User()
                        .setId()
                        .setFullName(request.firstName(), request.lastName())
                        .setEmail(request.email())
                        .setPassword(passwordEncoder.encode(request.password()))
                        .setRoleId(request.roleId()));
    }
}
