package com.colegioeducativo.colegio.dao;

import com.colegioeducativo.colegio.models.Alumno;

import java.util.List;

public interface AlumnoDao {
    List<Alumno> getAlumnos();

    void registrarAlumno(Alumno alumno);
}
