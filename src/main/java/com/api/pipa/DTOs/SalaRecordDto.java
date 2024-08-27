package com.api.pipa.dtos;

import java.util.Set;

public record SalaRecordDto(String nome, Set<Long> id_aluno, Set<Long> id_professor) {
}
