package com.colegioeducativo.colegio.dao;

import com.colegioeducativo.colegio.models.Profesor;

import java.util.List;

public interface ProfesorDao {
    List<Profesor> getProfesores();

    void registrarProfesor(Profesor profesor);
}
