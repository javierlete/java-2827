package com.ipartek.formacion.springapp.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.springapp.entidades.Producto;
import com.ipartek.formacion.springapp.servicios.AdminService;

import lombok.AllArgsConstructor;

@AllArgsConstructor

@Controller
@RequestMapping("/admin")
public class AdminController {
	private AdminService servicio;

	@GetMapping("/productos")
	public String productos(Model modelo) {
		modelo.addAttribute("productos", servicio.listarProductos());

		return "admin/productos";
	}

	@GetMapping("/producto")
	public String producto(Producto producto) {
		return "admin/producto";
	}

	@GetMapping("/producto/{id}")
	public String productoPorId(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("producto", servicio.buscarProductoPorId(id));

		return "admin/producto";
	}

	@PostMapping("/producto")
	public String guardarProducto(Producto producto) {
		if (producto.getId() == null) {
			servicio.anyadirProducto(producto);
		} else {
			servicio.modificarProducto(producto);
		}

		return "redirect:/admin/productos";
	}
	
	@GetMapping("/producto/{id}/borrar")
	public String borrarProducto(@PathVariable Long id) {
		servicio.borrarProducto(id);
		
		return "redirect:/admin/productos";
	}
}
