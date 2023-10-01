package com.colegioeducativo.colegio.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="alumnos")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Alumno extends Persona{
    @Getter @Setter @Column(name="anioLectivo", nullable = false, length = 50)
    private String anioLectivo;
}
