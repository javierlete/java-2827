package com.ipartek.formacion.multimodulo.presentacionweb.rest;

import com.ipartek.formacion.multimodulo.entidades.Producto;
import com.ipartek.formacion.multimodulo.logicanegocio.AdminNegocio;
import com.ipartek.formacion.multimodulo.logicanegocio.AdminNegocioImpl;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/productos")
public class ProductoRest {
	private static final AdminNegocio NEGOCIO = new AdminNegocioImpl();
	
	@GET
	public Iterable<Producto> getProductos() {
		return NEGOCIO.listarProductos(); 
	}
	
	@GET
	@Path("/{id}")
	public Producto getProducto(@PathParam("id") Long id) {
		return NEGOCIO.buscarPorId(id);
	}
	
	@POST
	public Producto postProducto(Producto producto) {
		NEGOCIO.anyadirProducto(producto);
		
		return producto;
	}
	
	@PUT
	@Path("/{id}")
	public Producto putProducto(@PathParam("id") Long id, Producto producto) {
		NEGOCIO.modificarProducto(producto);
		
		return producto;
	}
	
	@DELETE
	@Path("/{id}")
	public void deleteProducto(@PathParam("id") Long id) {
		NEGOCIO.borrarProducto(id);
	}
	
}
