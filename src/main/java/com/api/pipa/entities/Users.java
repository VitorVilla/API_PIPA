package com.api.pipa.entities;


import jakarta.persistence.*;
import lombok.*;

@Table (name = "users")
@Entity (name =  "User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Users {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private boolean isAdmin;


}
