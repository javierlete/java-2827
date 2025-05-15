package com.ipartek.formacion.springapp.controladores;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.springapp.servicios.AnonimoService;

@Controller
@RequestMapping("/")
public class PublicoController {
	@Value("${rutas.imagenes.url}")
	private String imagenes;
	
	private AnonimoService servicio;
	
	public PublicoController(AnonimoService servicio) {
		this.servicio = servicio;
	}
	
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
