package dev.codex.jwt_practice.Common.Seeder;

import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class Seeder<Entity, Repository extends JpaRepository<Entity, Long>> implements CommandLineRunner {
    private final ObjectMapper objectMapper;
    private final Repository repository;
    private final String fileName;
    private final Class<Entity> entityType;

    public Seeder(Repository repository, String fileName, ObjectMapper objectMapper, Class<Entity> entityType) {
        this.repository = repository;
        this.fileName = fileName;
        this.objectMapper = objectMapper;
        this.entityType = entityType;
    }

    @Override
    public void run(String... args) {
        if (repository.count() == 0) {
            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/" + fileName + ".json")) {
                System.out.println("the file name is: " + fileName); 
                TypeReference<List<Entity>> typeReference = new TypeReference<List<Entity>>() {
                    @Override
                    public java.lang.reflect.Type getType() {
                        return objectMapper.getTypeFactory().constructCollectionType(List.class, entityType);
                    }
                };
                List<Entity> entities = objectMapper.readValue(inputStream, typeReference);
                repository.saveAll(entities);
            } catch (Exception e) {
                System.err.println("Error occurred during seeding database using commandline runner: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
