package br.com.backend.solidariedade_na_mesa.domain.repository;

import br.com.backend.solidariedade_na_mesa.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    UserDetails findByLogin(String email);
}
