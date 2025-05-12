package com.ipartek.formacion.springapp.controladores;

import java.util.logging.Level;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.springapp.entidades.Producto;
import com.ipartek.formacion.springapp.servicios.AdminService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@AllArgsConstructor
@Log
@Controller
@RequestMapping("/admin")
public class AdminController {
	private static final String REDIRECT_ADMIN_PRODUCTOS = "redirect:/admin/productos";
	private static final String ADMIN_PRODUCTOS = "admin/productos";
	private static final String ADMIN_PRODUCTO = "admin/producto";
	
	private AdminService servicio;

	@GetMapping("/productos")
	public String productos(Model modelo) {
		modelo.addAttribute("productos", servicio.listarProductos());

		return ADMIN_PRODUCTOS;
	}

	@GetMapping("/producto")
	public String producto(Producto producto) {
		return ADMIN_PRODUCTO;
	}

	@GetMapping("/producto/{id}")
	public String productoPorId(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("producto", servicio.buscarProductoPorId(id));

		return ADMIN_PRODUCTO;
	}

	@PostMapping("/producto")
	public String guardarProducto(@Valid Producto producto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			log.log(Level.FINE, "El producto introducido estaba mal: {0}", bindingResult);
			return ADMIN_PRODUCTO;
		}
		
		if (producto.getId() == null) {
			servicio.anyadirProducto(producto);
		} else {
			servicio.modificarProducto(producto);
		}

		return REDIRECT_ADMIN_PRODUCTOS;
	}
	
	@GetMapping("/producto/{id}/borrar")
	public String borrarProducto(@PathVariable Long id) {
		servicio.borrarProducto(id);
		
		return REDIRECT_ADMIN_PRODUCTOS;
	}
}
