package com.api.pipa.entities;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "categorias")
@Entity(name =  "Categoria")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Categorias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;

    @OneToOne
    @JoinColumn(name = "imagem_id")
    Imagens imagem;

}
