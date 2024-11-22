package br.com.backend.solidariedade_na_mesa.domain.exception;

public class CreateDonationException extends RuntimeException {
    public CreateDonationException(String message) {
        super(message);
    }
}
