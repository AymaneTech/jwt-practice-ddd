package dev.codex.jwt_practice.user.application.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.codex.jwt_practice.authentication.dtos.requests.RegisterRequest;
import dev.codex.jwt_practice.user.application.UserService;
import dev.codex.jwt_practice.user.domain.User;
import dev.codex.jwt_practice.user.domain.entities.Role;
import dev.codex.jwt_practice.user.domain.repositories.RoleRepository;
import dev.codex.jwt_practice.user.domain.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

/**
 * UserServiceImpl
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public User findByEmail(final String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User save(final RegisterRequest request) {
        Role role = roleRepository.findById(request.roleId())
                .orElseThrow(() -> new RuntimeException("Role not found"));

        return repository.save(
                new User()
                        .setFullName(request.fullName())
                        .setEmail(request.email())
                        .setPassword(passwordEncoder.encode(request.password()))
                        .setRole(role));
    }
}
