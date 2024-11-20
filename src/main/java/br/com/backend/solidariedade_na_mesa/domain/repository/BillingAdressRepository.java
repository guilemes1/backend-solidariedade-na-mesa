package br.com.backend.solidariedade_na_mesa.domain.repository;

import br.com.backend.solidariedade_na_mesa.domain.entities.BillingAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingAdressRepository extends JpaRepository<BillingAddressEntity, Long> {
}
