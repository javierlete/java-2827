package com.ipartek.formacion.springapp.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ipartek.formacion.springapp.entidades.Producto;
import com.ipartek.formacion.springapp.servicios.AdminService;

import lombok.AllArgsConstructor;

@AllArgsConstructor

@RestController
@RequestMapping("/api/v2/productos")
public class ProductoRest {
	private AdminService servicio;
	
	@GetMapping
	public Iterable<Producto> get() {
		return servicio.listarProductos();
	}
	
	@GetMapping("{id}")
	public Producto get(@PathVariable Long id) {
		var producto = servicio.buscarProductoPorId(id);
		
		if(producto == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		return producto;
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Producto post(@RequestBody Producto producto) {
		servicio.anyadirProducto(producto);
		return producto;
	}
	
	@PutMapping("{id}")
	public Producto put(@PathVariable Long id, @RequestBody Producto producto) {
		servicio.modificarProducto(producto);
		return producto;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		servicio.borrarProducto(id);
	}
}
