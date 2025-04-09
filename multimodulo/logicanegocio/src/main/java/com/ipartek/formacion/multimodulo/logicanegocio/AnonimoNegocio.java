package com.ipartek.formacion.multimodulo.logicanegocio;

import com.ipartek.formacion.multimodulo.entidades.Categoria;
import com.ipartek.formacion.multimodulo.entidades.Producto;

public interface AnonimoNegocio {
	Iterable<Producto> listarProductos();

	Producto buscarPorId(Long id);

	Iterable<Categoria> listarCategorias();
}
