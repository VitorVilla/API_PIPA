package com.api.pipa.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Table(name = "posts")
@Entity(name = "Post")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;

    @ManyToMany
    @JoinTable(
            name = "post_imagens",
            joinColumns = @JoinColumn (name = "post_id"),
            inverseJoinColumns = @JoinColumn (name = "imagem_id"))
    private Set<Imagens> imagens =  new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    Categorias categoria;

    @ManyToMany
    @JoinTable(
            name = "post_tags",
            joinColumns = @JoinColumn (name = "post_id"),
            inverseJoinColumns = @JoinColumn (name = "tag_id"))
    private Set<Tags> tags =  new HashSet<>();
}
