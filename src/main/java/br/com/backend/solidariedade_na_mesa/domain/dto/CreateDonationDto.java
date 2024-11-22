package br.com.backend.solidariedade_na_mesa.domain.dto;

import java.util.List;
import java.util.UUID;

public record CreateDonationDto(UUID userId,
                                List<DonationItemDto> items
                                ) {
}
