package br.com.backend.solidariedade_na_mesa.domain.controller;

import br.com.backend.solidariedade_na_mesa.domain.dto.CreateDonationDto;
import br.com.backend.solidariedade_na_mesa.domain.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping(path = "/donations")
public class DonationController {

    @Autowired
    private DonationService donationService;

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody CreateDonationDto dto) {

        var order = donationService.createDonation(dto);

        return ResponseEntity.created(URI.create("/donations/" + order.getDonationId())).build();
    }
}
