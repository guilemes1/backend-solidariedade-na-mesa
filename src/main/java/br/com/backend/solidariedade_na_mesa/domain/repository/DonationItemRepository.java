package br.com.backend.solidariedade_na_mesa.domain.repository;

import br.com.backend.solidariedade_na_mesa.domain.entities.DonationItemEntity;
import br.com.backend.solidariedade_na_mesa.domain.entities.DonationItemId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationItemRepository extends JpaRepository<DonationItemEntity, DonationItemId> {
}
