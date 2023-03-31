package com.project.SecurityJWT.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idContacto", nullable = false)
    private Long id;

    private String nombre;

    @Column(name="fechaDeNacimiento")
    private LocalDate fechaNacimiento;

    private String teléfono;
    private String email;


}
