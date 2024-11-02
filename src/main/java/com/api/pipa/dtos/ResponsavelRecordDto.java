package com.api.pipa.dtos;

import com.api.pipa.entities.Enderecos;

public record ResponsavelRecordDto (String nome, String cpf, Enderecos endereco, Long id_usuario, String email, String senha) {
}
