package dev.codex.jwt_practice.user.domain.repositories;

import dev.codex.jwt_practice.user.domain.valueObjects.RoleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.codex.jwt_practice.user.domain.entities.Role;

/**
 * RoleRepository
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, RoleId>{

    
}
