package com.ipartek.ipartex.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MaquetaController {
	@GetMapping("/maqueta/{plantilla}")
	public String plantilla(@PathVariable String plantilla) {
		return plantilla;
	}
}
