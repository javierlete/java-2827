package com.ipartek.formacion.multimodulo.logicanegocio;

import com.ipartek.formacion.bibliotecas.Fabrica;
import com.ipartek.formacion.multimodulo.accesodatos.ProductoDao;
import com.ipartek.formacion.multimodulo.entidades.Producto;

public class AnonimoNegocioImpl implements AnonimoNegocio {

	private static final ProductoDao dao = (ProductoDao) Fabrica.getObject("dao.producto");

	@Override
	public Iterable<Producto> listarProductos() {
		return dao.obtenerTodos();
	}

}
