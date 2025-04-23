package com.ipartek.formacion.multimodulo.logicanegocio;

import java.util.logging.Level;

import com.ipartek.formacion.bibliotecas.Fabrica;
import com.ipartek.formacion.bibliotecas.Validador;
import com.ipartek.formacion.multimodulo.accesodatos.ProductoDao;
import com.ipartek.formacion.multimodulo.entidades.Categoria;
import com.ipartek.formacion.multimodulo.entidades.Producto;

import lombok.extern.java.Log;

@Log
public class AdminNegocioImpl extends AnonimoNegocioImpl implements AdminNegocio {
	private static final ProductoDao dao = (ProductoDao) Fabrica.getObject("dao.producto");
	
	@Override
	public void anyadirProducto(Producto producto) {
		log.log(Level.INFO, "Se va a añadir un producto {0}", producto);

		var errores = Validador.validar(producto);
		
		if(errores.size() > 0) {
			log.log(Level.SEVERE, "Los datos del producto a añadir tienen errores: {0}", errores);
			throw new LogicaNegocioException("No se admiten productos con errores");
		}
		
		if(producto.getCategoria() == null) {
			producto.setCategoria(Categoria.builder().id(1L).build());
		}
		
		dao.insertar(producto);
	}

	@Override
	public void modificarProducto(Producto producto) {
		log.log(Level.INFO, "Se va a modificar el producto {0}", producto);
		
		var errores = Validador.validar(producto);
		
		if(errores.size() > 0) {
			log.log(Level.SEVERE, "Los datos del producto a modificar tienen errores {0}", errores);
			throw new LogicaNegocioException("No se admiten productos con errores");
		}
		
		if(producto.getCategoria() == null) {
			producto.setCategoria(Categoria.builder().id(1L).build());
		}
		
		dao.modificar(producto);
	}

	@Override
	public void borrarProducto(Long id) {
		dao.borrar(id);
	}
	
}
