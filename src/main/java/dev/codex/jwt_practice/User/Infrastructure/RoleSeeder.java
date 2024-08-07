package dev.codex.jwt_practice.User.Infrastructure;

import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dev.codex.jwt_practice.User.Domain.Entities.Role;
import dev.codex.jwt_practice.User.Domain.Repositories.RoleRepository;

@Component
public class RoleSeeder implements CommandLineRunner {

    private final ObjectMapper objectMapper;
    private final RoleRepository repository;

    public RoleSeeder(RoleRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) {
        if (repository.count() == 0) {
            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/roles.json")) {
                TypeReference<List<Role>> typeReference = new TypeReference<List<Role>>() {
                    @Override
                    public java.lang.reflect.Type getType() {
                        return objectMapper.getTypeFactory().constructCollectionType(List.class, Role.class);
                    }
                };
                List<Role> entities = objectMapper.readValue(inputStream, typeReference);
                repository.saveAll(entities);
            } catch (Exception e) {
                System.err
                        .println("Error occurred during seeding database using commandline runner: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

}
