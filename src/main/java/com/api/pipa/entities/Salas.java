package com.api.pipa.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Table(name = "salas")
@Entity(name = "Sala")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Salas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aluno", referencedColumnName = "id")
    private Set<Alunos> alunos =  new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_professor", referencedColumnName = "id")
    private Set<Professores> professores =  new HashSet<>();

}
