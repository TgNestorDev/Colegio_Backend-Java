package com.colegioeducativo.colegio.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="personas")
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name="id")
    private Long id;
    @Getter @Setter @Column(name="nombre", nullable = false, length = 25)
    private String nombre;
    @Getter @Setter @Column(name="apellido", nullable = false, length = 25)
    private String apellido;
    @Getter @Setter @Column(name="cedula", nullable = false, length = 10)
    private String cedula;
    @Getter @Setter @Column(name="correo", nullable = true, length = 50)
    private String correo;
    @Getter @Setter @Column(name="celular", nullable = false, length = 10)
    private String celular;
    @Getter @Setter @Column(name="usuario", nullable = false, length = 50)
    private String usuario;
    @Getter @Setter @Column(name="contrasenia", nullable = false, length = 255)
    private String contrasenia;
}
