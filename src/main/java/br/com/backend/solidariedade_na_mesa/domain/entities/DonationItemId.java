package br.com.backend.solidariedade_na_mesa.domain.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class DonationItemId {

    @ManyToOne
    @JoinColumn(name = "donation_id")
    private DonationEntity donation;

    @ManyToOne
    @JoinColumn(name = "basket_id")
    private BasketEntity basket;
}
