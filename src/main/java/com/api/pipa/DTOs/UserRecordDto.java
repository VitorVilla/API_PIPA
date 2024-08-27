package com.api.pipa.dtos;

import com.api.pipa.entities.Enderecos;

public record UserRecordDto(String nome, String senha, String email, Enderecos endereco, boolean isProfessor, boolean isResponsavel,
                            boolean isAdmin, String cpf ) {
}
