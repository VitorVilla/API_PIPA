package com.api.pipa.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "professores")
@Entity(name = "Professor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Professores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 100)
    private String senha;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @Getter(onMethod = @__({@JsonIgnore}))
    private Users user;

    @ManyToOne
    @JoinColumn(name = "sala_id")
    @Getter(onMethod = @__({@JsonIgnore}))
    private Salas sala;

}
