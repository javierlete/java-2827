package com.ipartek.formacion.multimodulo.logicanegocio;

import java.util.List;

import com.ipartek.formacion.bibliotecas.Fabrica;
import com.ipartek.formacion.multimodulo.accesodatos.ProductoDao;
import com.ipartek.formacion.multimodulo.entidades.Categoria;
import com.ipartek.formacion.multimodulo.entidades.Producto;

public class AnonimoNegocioImpl implements AnonimoNegocio {

	private static final ProductoDao dao = (ProductoDao) Fabrica.getObject("dao.producto");

	@Override
	public Iterable<Producto> listarProductos() {
		return dao.obtenerTodos();
	}

	@Override
	public Producto buscarPorId(Long id) {
		return dao.obtenerPorId(id);
	}

	@Override
	public Iterable<Categoria> listarCategorias() {
		return List.of(
				new Categoria(1L, "Electrónica", ""),
				new Categoria(2L, "Informática", "")
		);
	}

}
