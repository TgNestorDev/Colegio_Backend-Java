package com.colegioeducativo.colegio.dao;

import com.colegioeducativo.colegio.models.Persona;

public interface LoginDao {
    boolean verificarDatos(Persona persona);
}
