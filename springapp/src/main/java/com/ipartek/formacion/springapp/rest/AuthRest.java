package com.ipartek.formacion.springapp.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.springapp.entidades.Usuario;
import com.ipartek.formacion.springapp.servicios.AuthService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/auth")
public class AuthRest {
    private final AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
        return "\"" + authService.login(usuario) + "\"";
    }

    @PostMapping("/registrar")
    public String registrar(@RequestBody Usuario usuario) {
        return "\"" + authService.register(usuario) + "\"";
    }
}
