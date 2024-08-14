package com.api.pipa.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.sql.Timestamp;

@Table(name = "controle_diario")
@Entity(name =  "ControleDiario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ControlesDiarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Timestamp data;
    private String lanche;
    private String almoco;
    private String lanche_tarde;
    private String jantar;
    private String mamadeira;
    private String mamadeira2;
    private String mamadeira3;
    private String evacuacao;
    private boolean xixi;
    private boolean banho;
    private Time horario;
    private String dose;
    private double febre;
    private String nome;
    private String titulo;

    @ManyToOne
    Alunos aluno;

}

