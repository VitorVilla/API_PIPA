package com.api.pipa.dtos;

import com.api.pipa.entities.Alunos;

import java.sql.Time;
import java.sql.Timestamp;

public record ControleDiarioRecordDto(Long id,
                                      Timestamp data,
                                      String lanche,
                                      String almoco,
                                      String lancheTarde,
                                      String jantar,
                                      String mamadeira,
                                      String mamadeira2,
                                      String mamadeira3,
                                      String evacuacao,
                                      boolean xixi,
                                      boolean banho,
                                      Time horario,
                                      String dose,
                                      double febre,
                                      Alunos aluno) {
}
