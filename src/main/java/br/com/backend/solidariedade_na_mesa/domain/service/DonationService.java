package br.com.backend.solidariedade_na_mesa.domain.service;

import br.com.backend.solidariedade_na_mesa.domain.dto.CreateDonationDto;
import br.com.backend.solidariedade_na_mesa.domain.dto.DonationItemDto;
import br.com.backend.solidariedade_na_mesa.domain.entities.*;
import br.com.backend.solidariedade_na_mesa.domain.exception.CreateDonationException;
import br.com.backend.solidariedade_na_mesa.domain.repository.BasketRepository;
import br.com.backend.solidariedade_na_mesa.domain.repository.DonationItemRepository;
import br.com.backend.solidariedade_na_mesa.domain.repository.DonationRepository;
import br.com.backend.solidariedade_na_mesa.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DonationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private BasketRepository basketRepository;

    public DonationEntity createDonation(CreateDonationDto dto) {

        var donation = new DonationEntity();

        var user = validateUser(dto);                                //valida a existencia do usuario
        var donationItems = validateDonationItems(donation, dto);
        var total = calculateDonationTotal(donationItems);

        donation.setDonationDate(LocalDateTime.now());
        donation.setUser(user);
        donation.setItems(donationItems);
        donation.setTotal(total);

        return donationRepository.save(donation);

    }

    private UserEntity validateUser(CreateDonationDto dto) {
        return userRepository.findById(dto.userId())
                .orElseThrow(() -> new CreateDonationException("user not found"));
    }

    private List<DonationItemEntity> validateDonationItems(DonationEntity donation, CreateDonationDto dto) {

        if (dto.items().isEmpty()) {
            throw new CreateDonationException("donation items is empty");
        }

        return dto.items()
                .stream()
                .map(donationItemDto -> getDonationItem(donation, donationItemDto))
                .toList();
    }

    private DonationItemEntity getDonationItem(DonationEntity donation, DonationItemDto donationItemDto) {

        var donationItemEntity = new DonationItemEntity();
        var id = new DonationItemId();
        var basket = getBasket(donationItemDto.basketId());

        id.setDonation(donation);
        id.setBasket(basket);

        donationItemEntity.setId(id);
        donationItemEntity.setQuantity(donationItemDto.quantity());
        donationItemEntity.setSalePrice(basket.getPrice());

        return donationItemEntity;
    }

    private BasketEntity getBasket(Long basketId) {
        if (basketId == null) {
            throw new IllegalArgumentException("O ID do produto não pode ser nulo");
        }

        return basketRepository.findById(basketId)
                .orElseThrow(() -> new CreateDonationException("basket not found"));
    }

    private BigDecimal calculateDonationTotal(List<DonationItemEntity> items) {
        return items.stream()
                .map(i -> i.getSalePrice().multiply(BigDecimal.valueOf(i.getQuantity())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
