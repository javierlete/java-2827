package com.ipartek.ipartex.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ipartek.ipartex.servicios.AnonimoService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class PublicoController {
	private AnonimoService servicio;
	
	public static final int TAMANO_PAGINA = 10;
	
	@GetMapping
	public String mensajes(Model modelo, @RequestParam(defaultValue = "10") int tamano) {
		modelo.addAttribute("mensajes", servicio.listarMensajes(tamano));
		modelo.addAttribute("tamano", tamano);
		modelo.addAttribute("tamano_mas", tamano + TAMANO_PAGINA);
		
		return "index";
	}
}
