package com.api.pipa.dtos;

import com.api.pipa.entities.Enderecos;

public record ResponsavelRecordDto (Long id, String nome, String cpf, Enderecos endereco) {
}
