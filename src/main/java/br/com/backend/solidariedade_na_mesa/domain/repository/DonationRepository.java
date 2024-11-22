package br.com.backend.solidariedade_na_mesa.domain.repository;

import br.com.backend.solidariedade_na_mesa.domain.entities.DonationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationRepository extends JpaRepository<DonationEntity, Long> {
}
