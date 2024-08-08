package com.api.pipa.DTOs;

import jakarta.validation.constraints.NotBlank;

public record DadosAlunos(
        @NotBlank
        String nome,
        @NotBlank
        String cpf
        ) {
}
