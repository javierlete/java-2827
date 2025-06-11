package com.ipartek.formacion.springapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.springapp.entidades.Categoria;
import com.ipartek.formacion.springapp.servicios.AnonimoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/v2/categorias")
public class CategoriaRest {
    private final AnonimoService servicio;

    @GetMapping
    public Iterable<Categoria> getCategorias() {
        return servicio.listarCategorias();
    }
}
