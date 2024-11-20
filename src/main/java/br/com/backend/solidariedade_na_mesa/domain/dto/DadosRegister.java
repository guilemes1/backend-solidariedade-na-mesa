package br.com.backend.solidariedade_na_mesa.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosRegister(@NotBlank String fullName,
                            @NotBlank String login,
                            @NotBlank String senha,
                            @NotBlank String confirmarSenha) {
}
