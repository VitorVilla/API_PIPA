package com.api.pipa.dtos;

public record AlunoRecordDto(Long id, String nome, String cpf, Long responsavel_id, Long sala_id) {
}
