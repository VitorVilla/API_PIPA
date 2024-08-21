package com.api.pipa.dtos;

import java.util.List;

public record PostRecordDto(String titulo, String descricao, Long categoria_id, List<Long> tagIds) {
}
