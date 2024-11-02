package com.api.pipa.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Getter(onMethod = @__({@JsonIgnore}))
    Responsaveis responsavel;

    @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY)
    @Getter(onMethod = @__({@JsonIgnore}))
    private Set<ControlesDiarios> controlesDiarios =  new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "sala_id")
    @Getter(onMethod = @__({@JsonIgnore}))
    private Salas sala;

}
