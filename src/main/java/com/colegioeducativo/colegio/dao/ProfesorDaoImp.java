package com.colegioeducativo.colegio.dao;

import com.colegioeducativo.colegio.models.Profesor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProfesorDaoImp implements ProfesorDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Profesor> getProfesores() {
        String query="FROM Profesor";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void registrarProfesor(Profesor profesor) {
        entityManager.merge(profesor);
    }

    @Override
    public void eliminarProfesor(Long id) {
        Profesor profesor= entityManager.find(Profesor.class, id);
        entityManager.remove(profesor);
    }
}
