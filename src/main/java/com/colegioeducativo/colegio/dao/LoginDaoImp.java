package com.colegioeducativo.colegio.dao;

import com.colegioeducativo.colegio.models.Persona;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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
        String query="FROM Persona WHERE usuario= :usuario";
        List<Persona> lista= entityManager.createQuery(query)
                .setParameter("usuario",persona.getUsuario())
                .getResultList();

        if (lista.isEmpty()){
            return false;
        }
        String contraCodificada=lista.get(0).getContrasenia();
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        return argon2.verify(contraCodificada, persona.getContrasenia());
    }
}
