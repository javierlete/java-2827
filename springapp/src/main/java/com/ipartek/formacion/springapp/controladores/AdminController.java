package com.ipartek.formacion.springapp.controladores;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.ipartek.formacion.springapp.entidades.Producto;
import com.ipartek.formacion.springapp.servicios.AdminService;

import jakarta.validation.Valid;
import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Value("${rutas.imagenes.url}")
	private String urlImagenes;
	
	@Value("${rutas.imagenes.fisica}")
	private String rutaImagenes;
	
	private static final String REDIRECT_ADMIN_PRODUCTOS = "redirect:/admin/productos";
	private static final String ADMIN_PRODUCTOS = "admin/productos";
	private static final String ADMIN_PRODUCTO = "admin/producto";
	
	private AdminService servicio;

	public AdminController(AdminService servicio) {
		this.servicio = servicio;
	}
	
	@GetMapping("/productos")
	public String productos(Model modelo) {
		modelo.addAttribute("productos", servicio.listarProductos());

		return ADMIN_PRODUCTOS;
	}

	@GetMapping("/producto")
	public String producto(Producto producto, Model modelo) {
		modelo.addAttribute("categorias", servicio.listarCategorias());
		return ADMIN_PRODUCTO;
	}

	@GetMapping("/producto/{id}")
	public String productoPorId(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("producto", servicio.buscarProductoPorId(id));
		modelo.addAttribute("categorias", servicio.listarCategorias());
		
		return ADMIN_PRODUCTO;
	}

	@PostMapping("/producto")
	public String guardarProducto(@Valid Producto producto, BindingResult bindingResult, MultipartFile imagen) throws IOException {
		if(bindingResult.hasErrors()) {
			log.log(Level.FINE, "El producto introducido estaba mal: {0}", bindingResult);
			return ADMIN_PRODUCTO;
		}
		
		if (producto.getId() == null) {
			servicio.anyadirProducto(producto);
		} else {
			servicio.modificarProducto(producto);
		}

		var pathImagenes = java.nio.file.Path.of(rutaImagenes);
		
		if (!Files.exists(pathImagenes)) {
            Files.createDirectories(pathImagenes);
        }
		
		Files.copy(imagen.getInputStream(), java.nio.file.Path.of(rutaImagenes, producto.getId() + ".jpg"), StandardCopyOption.REPLACE_EXISTING);
		
		return REDIRECT_ADMIN_PRODUCTOS;
	}
	
	@GetMapping("/producto/{id}/borrar")
	public String borrarProducto(@PathVariable Long id) {
		servicio.borrarProducto(id);
		
		return REDIRECT_ADMIN_PRODUCTOS;
	}
}
