package com.ipartek.formacion.multimodulo.presentacionweb.rest;

import java.util.ArrayList;

import com.ipartek.formacion.multimodulo.entidades.Categoria;
import com.ipartek.formacion.multimodulo.logicanegocio.AdminNegocio;
import com.ipartek.formacion.multimodulo.logicanegocio.AdminNegocioImpl;
import com.ipartek.formacion.multimodulo.presentacionweb.dtos.ProductoDto;
import com.ipartek.formacion.multimodulo.presentacionweb.mappers.ProductoMapper;
import com.ipartek.formacion.multimodulo.presentacionweb.mappers.ProductoMapperImpl;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/categorias")
public class CategoriaRest {
	private static final AdminNegocio NEGOCIO = new AdminNegocioImpl();
	private static final ProductoMapper mapeador = new ProductoMapperImpl();

	@GET
	public Iterable<Categoria> getCategorias() {
		return NEGOCIO.listarCategorias();
	}

	@GET
	@Path("/{id}")
	public Categoria getCategoria(@PathParam("id") Long id) {
		var categoria = NEGOCIO.detalleCategoria(id);

		if (categoria == null) {
			throw new NotFoundException("No se ha encontrado el id " + id);
		}

		return categoria;
	}

	@GET
	@Path("/{id}/productos")
	public Iterable<ProductoDto> getProductosCategoria(@PathParam("id") Long id) {
		var productos = NEGOCIO.productosDeCategoria(id);
		
		var resultado = new ArrayList<ProductoDto>();
		
		for(var producto: productos) {
			resultado.add(mapeador.aDto(producto));
		}
		
		return resultado;
	}
}
