package com.api.pipa.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Table(name = "alunos")
@Entity(name = "Aluno")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Alunos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;

    @ManyToOne
    Responsaveis responsavel;

    @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY)
    private Set<ControlesDiarios> controlesDiarios =  new HashSet<>();

}
