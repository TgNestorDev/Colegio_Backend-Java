package com.colegioeducativo.colegio.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="profesores")
@PrimaryKeyJoinColumn(referencedColumnName = "id")

public class Profesor extends Persona{
    @Getter @Setter @Column(name="cargo", nullable = false, length = 50)
    private String cargo;
}
