package com.colegioeducativo.colegio.controllers;

import com.colegioeducativo.colegio.dao.AlumnoDao;
import com.colegioeducativo.colegio.models.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlumnoController {
    @Autowired
    private AlumnoDao alumnoDao;

    @RequestMapping(value = "api/alumnos", method = RequestMethod.GET)
    public List<Alumno> getAlumnos(){
        return alumnoDao.getAlumnos();
    }

    @RequestMapping(value = "api/alumnos", method = RequestMethod.POST)
    public void postAlumno(@RequestBody Alumno alumno){
        alumnoDao.registrarAlumno(alumno);
    }
    @RequestMapping(value = "api/alumnos/{id}", method = RequestMethod.DELETE)
    public void deleteAlumno(@PathVariable Long id){
        alumnoDao.eliminarAlumno(id);
    }
}
