package com.ipartek.ipartex.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.ipartex.servicios.AnonimoService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class PublicoController {
	private AnonimoService servicio;
	
	@GetMapping
	public String mensajes(Model modelo) {
		modelo.addAttribute("mensajes", servicio.listarMensajes());
		
		return "index";
	}
}
