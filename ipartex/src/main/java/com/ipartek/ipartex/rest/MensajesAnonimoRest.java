package com.ipartek.ipartex.rest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.ipartex.dtos.MensajeDto;
import com.ipartek.ipartex.servicios.AnonimoService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v2")
@AllArgsConstructor
public class MensajesAnonimoRest {
	private final AnonimoService anonimoService;
	
	@GetMapping({"/mensajes", "/mensajes/"})
	public Page<MensajeDto> listadoMensajes(Pageable pageable) {
		return anonimoService.listarMensajesPaginados(pageable);
	}
}
