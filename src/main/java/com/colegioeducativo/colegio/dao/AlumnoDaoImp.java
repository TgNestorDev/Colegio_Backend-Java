package com.colegioeducativo.colegio.dao;

import com.colegioeducativo.colegio.models.Alumno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AlumnoDaoImp implements AlumnoDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Alumno> getAlumnos() {
        String query="FROM Alumno";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void registrarAlumno(Alumno alumno) {
        entityManager.merge(alumno);
    }
}
