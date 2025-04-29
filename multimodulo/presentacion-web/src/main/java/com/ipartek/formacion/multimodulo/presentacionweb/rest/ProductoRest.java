package com.ipartek.formacion.multimodulo.presentacionweb.rest;

import com.ipartek.formacion.multimodulo.entidades.Producto;
import com.ipartek.formacion.multimodulo.logicanegocio.AdminNegocio;
import com.ipartek.formacion.multimodulo.logicanegocio.AdminNegocioImpl;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

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
		var producto= NEGOCIO.buscarPorId(id);
		
		if(producto == null) {
			throw new NotFoundException("No se ha encontrado el id " + id);
		}
		
		return producto;
	}
	
	@POST
	public Response postProducto(Producto producto) {
		NEGOCIO.anyadirProducto(producto);
		
		return Response.status(Response.Status.CREATED).entity(producto).build();
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
