package dev.codex.jwt_practice.user.application.impl;

import org.springframework.stereotype.Service;

import dev.codex.jwt_practice.user.application.UserService;
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

    public User findByEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

}
