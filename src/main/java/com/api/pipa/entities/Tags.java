package com.api.pipa.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Table (name = "tags")
@Entity (name =  "Tag")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Tags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;

    @ManyToMany (mappedBy = "tags", fetch = FetchType.LAZY)
    @Getter(onMethod = @__({@JsonIgnore}))
    private Set<Posts> posts = new HashSet<>();
}
