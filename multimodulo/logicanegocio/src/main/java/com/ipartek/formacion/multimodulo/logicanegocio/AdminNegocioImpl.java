package com.ipartek.formacion.multimodulo.logicanegocio;

import java.util.logging.Level;

import com.ipartek.formacion.bibliotecas.Fabrica;
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
		
		if(producto.getCategoria() == null) {
			producto.setCategoria(Categoria.builder().id(1L).build());
		}
		
		dao.insertar(producto);
	}

	@Override
	public void modificarProducto(Producto producto) {
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
