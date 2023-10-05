package com.colegioeducativo.colegio.controllers;
import com.colegioeducativo.colegio.dao.AlumnoDao;
import com.colegioeducativo.colegio.models.Alumno;
import com.colegioeducativo.colegio.security.JWTSecurity;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AlumnoController {
    @Autowired
    private AlumnoDao alumnoDao;

    @Autowired
    private JWTSecurity jwtSecurity;

    @GetMapping(value = "api/alumnos")
    public ResponseEntity<List<Alumno>> getAlumnos(@RequestHeader(value = "Authorization") String tokenR){

        if (!validarTokenDeFront(tokenR)){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(alumnoDao.getAlumnos(), HttpStatus.OK);
    }

    private boolean validarTokenDeFront(String token){
        String idUsuario=jwtSecurity.getKey(token); //con get key obtendo el id del usuario que contiene el token
        return idUsuario!=null;
    }
    /*sin token
    @GetMapping(value = "api/alumnos")
    public ResponseEntity<List<Alumno>> getAlumnos(){
        return new ResponseEntity<>(alumnoDao.getAlumnos(), HttpStatus.OK);
    }*/

    @PostMapping(value = "api/alumnos")
    public ResponseEntity postAlumno(@RequestBody Alumno alumno){
        Argon2 argon2= Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String codificado= argon2.hash(1, 1024, 1,alumno.getContrasenia());
        alumno.setContrasenia(codificado);
        alumnoDao.registrarAlumno(alumno);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @DeleteMapping(value = "api/alumnos/{id}")
    public ResponseEntity deleteAlumno(@PathVariable Long id){
        alumnoDao.eliminarAlumno(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
