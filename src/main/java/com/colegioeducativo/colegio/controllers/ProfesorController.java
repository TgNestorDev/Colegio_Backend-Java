package com.colegioeducativo.colegio.controllers;

import com.colegioeducativo.colegio.dao.ProfesorDao;
import com.colegioeducativo.colegio.models.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProfesorController {
    @Autowired
    private ProfesorDao profesorDao;

    @RequestMapping(value = "api/profesores", method = RequestMethod.GET)
    public List<Profesor> getProfesores(){return profesorDao.getProfesores();}

    @RequestMapping(value = "api/profesores", method = RequestMethod.POST)
    public void postProfesor(@RequestBody Profesor profesor){
        profesorDao.registrarProfesor(profesor);
    }
}
