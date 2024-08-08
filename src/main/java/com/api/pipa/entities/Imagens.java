package com.api.pipa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Table(name = "imagens")
@Entity(name =  "Imagem")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Imagens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imagem;
    private Timestamp data;

    @ManyToMany (mappedBy = "imagens", fetch = FetchType.LAZY)
    private Set<Posts> posts = new HashSet<>();
}
