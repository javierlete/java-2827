package com.ipartek.formacion.springapp.servicios;

import com.ipartek.formacion.springapp.entidades.Categoria;
import com.ipartek.formacion.springapp.entidades.Producto;

public interface AnonimoService {
	Iterable<Producto> listarProductos();

	Producto buscarProductoPorId(Long id);

	Iterable<Categoria> listarCategorias();
	
	Categoria detalleCategoria(Long id);
	
	Iterable<Producto> productosDeCategoria(Long idCategoria);
}
