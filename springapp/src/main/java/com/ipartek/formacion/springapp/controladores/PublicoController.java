package com.ipartek.formacion.springapp.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.springapp.servicios.AnonimoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor

@Controller
@RequestMapping("/")
public class PublicoController {
	private AnonimoService servicio;
	
	@GetMapping
	public String inicio(Model modelo) {
		var productos = servicio.listarProductos();
		
		modelo.addAttribute("productos", productos);
		
		return "index";
	}
	
	@GetMapping("detalle")
	public String detalle(Long id, Model modelo) {
		var producto = servicio.buscarProductoPorId(id);
		
		modelo.addAttribute("producto", producto);
		
		return "detalle";
	}
}
