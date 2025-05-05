package com.ipartek.formacion.multimodulo.logicanegocio;

import java.util.Collection;

import com.ipartek.formacion.bibliotecas.Fabrica;
import com.ipartek.formacion.multimodulo.accesodatos.CategoriaDao;
import com.ipartek.formacion.multimodulo.accesodatos.ProductoDao;
import com.ipartek.formacion.multimodulo.entidades.Categoria;
import com.ipartek.formacion.multimodulo.entidades.Producto;

public class AnonimoNegocioImpl implements AnonimoNegocio {

	private static final ProductoDao productoDao = (ProductoDao) Fabrica.getObject("dao.producto");
	private static final CategoriaDao categoriaDao = (CategoriaDao) Fabrica.getObject("dao.categoria");

	@Override
	public Iterable<Producto> listarProductos() {
		return productoDao.obtenerTodos();
	}

	@Override
	public Producto buscarProductoPorId(Long id) {
		return productoDao.obtenerPorId(id);
	}

	@Override
	public Iterable<Categoria> listarCategorias() {
		var categorias = categoriaDao.obtenerTodos();
		
		if(categorias instanceof Collection<Categoria> coleccion) {
			return coleccion.stream().filter(categoria -> categoria.getId() != 1L).toList();
		}
		
		throw new LogicaNegocioException("Las categorías no se pueden filtrar por un stream");
	}

	@Override
	public Categoria detalleCategoria(Long id) {
		return categoriaDao.obtenerPorId(id);
	}

	@Override
	public Iterable<Producto> productosDeCategoria(Long idCategoria) {
		return productoDao.buscarPorCategoria(idCategoria);
	}

}
