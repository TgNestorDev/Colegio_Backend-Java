package com.colegioeducativo.colegio.controllers;

import com.colegioeducativo.colegio.dao.LoginDao;
import com.colegioeducativo.colegio.models.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginDao loginDao;

    @PostMapping(value = "api/login")
    public boolean login(@RequestBody Persona persona){
        if (loginDao.verificarDatos(persona)){
            return  true;
        }
        return false;

    }
}
