package com.colegioeducativo.colegio.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class TokenM {
    @Getter @Setter
    private String token;
    @Getter @Setter
    private boolean estado;
}
