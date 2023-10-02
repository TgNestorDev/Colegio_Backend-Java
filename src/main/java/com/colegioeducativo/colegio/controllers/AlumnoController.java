package com.colegioeducativo.colegio.controllers;
import com.colegioeducativo.colegio.dao.AlumnoDao;
import com.colegioeducativo.colegio.models.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlumnoController {
    @Autowired
    private AlumnoDao alumnoDao;

    @GetMapping(value = "api/alumnos")
    public ResponseEntity<List<Alumno>> getAlumnos(){
        return new ResponseEntity<>(alumnoDao.getAlumnos(), HttpStatus.OK);
    }

    @PostMapping(value = "api/alumnos")
    public ResponseEntity postAlumno(@RequestBody Alumno alumno){
        alumnoDao.registrarAlumno(alumno);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @DeleteMapping(value = "api/alumnos/{id}")
    public ResponseEntity deleteAlumno(@PathVariable Long id){
        alumnoDao.eliminarAlumno(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
