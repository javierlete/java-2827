package com.ipartek.formacion.springapp.controladores;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.springapp.modelos.Carrito;
import com.ipartek.formacion.springapp.servicios.AnonimoService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

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

	@GetMapping("carrito")
	public String carrito(Long id, Carrito carrito) {
		if (id != null) {
			var producto = servicio.buscarProductoPorId(id);

			carrito.ponerLinea(Carrito.LineaCarrito.builder().producto(producto).cantidad(1).build());

			return "redirect:/carrito";
		}

		return "carrito";
	}

	@PostMapping("carrito")
	public String carrito(Carrito carrito, Long id, Integer cantidad, String mas, String menos) {
		var linea = carrito.getLineaPorId(id);

		if (mas != null) {
			linea.setCantidad(cantidad + 1);
		} else if (menos != null) {
			linea.setCantidad(cantidad - 1);
		} else {
			linea.setCantidad(cantidad);
		}
		
		return "redirect:/carrito";
	}
	
	@GetMapping("idioma")
	public String idioma(String codigo, HttpServletResponse response) {
		response.addCookie(new Cookie("idioma", codigo));
		
		return "redirect:/";
	}
}
