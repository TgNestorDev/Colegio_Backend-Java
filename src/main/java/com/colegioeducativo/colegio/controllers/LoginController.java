package com.colegioeducativo.colegio.controllers;

import com.colegioeducativo.colegio.dao.LoginDao;
import com.colegioeducativo.colegio.models.Persona;
import com.colegioeducativo.colegio.security.JWTSecurity;
import com.colegioeducativo.colegio.security.TokenM;
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

    @Autowired
    private JWTSecurity jwtSecurity;

    @Autowired
    private TokenM tokenM;

    @PostMapping(value = "api/login")
    public TokenM login(@RequestBody Persona persona){

        Persona usuarioLogueado= loginDao.datosDeUsuarioPorCredenciales(persona);
        if (usuarioLogueado!=null){
            String token= jwtSecurity.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getRol());
            tokenM.setToken(token);
            tokenM.setEstado(true);
            return tokenM;
        }
        tokenM.setToken(null);
        tokenM.setEstado(false);
        return tokenM;

    }
}
