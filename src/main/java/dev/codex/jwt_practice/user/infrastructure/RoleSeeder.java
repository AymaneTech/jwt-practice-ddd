package dev.codex.jwt_practice.user.infrastructure;

import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dev.codex.jwt_practice.user.domain.entities.Role;
import dev.codex.jwt_practice.user.domain.repositories.RoleRepository;

@Component
public class RoleSeeder implements CommandLineRunner {

    private final RoleRepository repository;

    public RoleSeeder(RoleRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        if (repository.count() != 0) {
            return;
        }
        List<Role> roles = List.of(
                new Role("ADMIN"),
                new Role("USER"),
                new Role("AGENT")
        );
        repository.saveAll(roles);
    }
}
