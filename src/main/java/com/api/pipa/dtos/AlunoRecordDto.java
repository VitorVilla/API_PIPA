package com.api.pipa.dtos;

import com.api.pipa.entities.Responsaveis;

public record AlunoRecordDto(Long id, String nome, String cpf, Long responsavel_id) {
}
