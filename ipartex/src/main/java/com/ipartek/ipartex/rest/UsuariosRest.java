package com.ipartek.ipartex.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.ipartex.entidades.Usuario;
import com.ipartek.ipartex.servicios.AnonimoService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping({"/api/v2/usuarios", "/api/v2/usuarios/"})
@AllArgsConstructor
public class UsuariosRest {
	private final AnonimoService anonimoService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario postUsuario(@RequestBody Usuario usuario) {
		return anonimoService.registrarUsuario(usuario);
	}
}
