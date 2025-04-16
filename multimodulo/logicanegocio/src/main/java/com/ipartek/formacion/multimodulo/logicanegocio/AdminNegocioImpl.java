package com.ipartek.formacion.multimodulo.logicanegocio;

import com.ipartek.formacion.bibliotecas.Fabrica;
import com.ipartek.formacion.multimodulo.accesodatos.ProductoDao;
import com.ipartek.formacion.multimodulo.entidades.Categoria;
import com.ipartek.formacion.multimodulo.entidades.Producto;

public class AdminNegocioImpl extends AnonimoNegocioImpl implements AdminNegocio {
	private static final ProductoDao dao = (ProductoDao) Fabrica.getObject("dao.producto");
	
	@Override
	public void anyadirProducto(Producto producto) {
		if(producto.getCategoria() == null) {
			producto.setCategoria(new Categoria(1L, null, null));
		}
		
		dao.insertar(producto);
	}

	@Override
	public void modificarProducto(Producto producto) {
		if(producto.getCategoria() == null) {
			producto.setCategoria(new Categoria(1L, null, null));
		}
		
		dao.modificar(producto);
	}

	@Override
	public void borrarProducto(Long id) {
		dao.borrar(id);
	}
	
}
