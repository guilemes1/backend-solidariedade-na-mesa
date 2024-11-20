package br.com.backend.solidariedade_na_mesa.domain.repository;

import br.com.backend.solidariedade_na_mesa.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserDetails findByLogin(String email);
}
