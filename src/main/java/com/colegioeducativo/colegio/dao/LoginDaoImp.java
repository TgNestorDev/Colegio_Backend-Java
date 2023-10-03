package com.colegioeducativo.colegio.dao;

import com.colegioeducativo.colegio.models.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class LoginDaoImp implements LoginDao{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public boolean verificarDatos(Persona persona) {
        String query="FROM Persona WHERE usuario= :usuario AND contrasenia= :contrasenia";
        List<Persona> lista= entityManager.createQuery(query)
                .setParameter("usuario",persona.getUsuario())
                .setParameter("contrasenia",persona.getContrasenia())
                .getResultList();
        return !lista.isEmpty();
    }
}
