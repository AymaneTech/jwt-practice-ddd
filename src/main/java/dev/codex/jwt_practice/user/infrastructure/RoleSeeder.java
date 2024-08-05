package dev.codex.jwt_practice.user.infrastructure;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Component;

import dev.codex.jwt_practice.common.seeder.Seeder;
import dev.codex.jwt_practice.user.domain.entities.Role;
import dev.codex.jwt_practice.user.domain.repositories.RoleRepository;

@Component
public class RoleSeeder extends Seeder<Role, RoleRepository> {
    public RoleSeeder(RoleRepository repository, ObjectMapper objectMapper) {
        super(repository, "roles", objectMapper, Role.class);
    }
}
