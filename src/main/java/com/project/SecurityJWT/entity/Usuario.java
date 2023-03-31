package com.project.SecurityJWT.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario", nullable = false)
    private Long id;

    private String nombre;
    private String email;
    private String password;


}
