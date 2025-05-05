package com.ipartek.formacion.multimodulo.accesodatos.jpa;

import java.math.BigDecimal;

import com.ipartek.formacion.bibliotecas.JpaDao;
import com.ipartek.formacion.multimodulo.accesodatos.ProductoDao;
import com.ipartek.formacion.multimodulo.entidades.Producto;

public class ProductoDaoJpa implements ProductoDao {

	private static final JpaDao<Producto> JPA = new JpaDao<>(Producto.class,
			"com.ipartek.formacion.multimodulo.entidades");

	public ProductoDaoJpa(String noUsado1, String noUsado2, String noUsado3) {
	}

	@Override
	public Iterable<Producto> obtenerTodos() {
		return JPA.consultaVarios("from Producto p join fetch p.categoria");
	}

	@Override
	public Producto obtenerPorId(Long id) {
		return JPA.consultaUno("from Producto p join fetch p.categoria where p.id = ?1", id);
	}

	@Override
	public Producto insertar(Producto producto) {
		return JPA.insertar(producto);
	}

	@Override
	public Producto modificar(Producto producto) {
		return JPA.modificar(producto);
	}

	@Override
	public void borrar(Long id) {
		JPA.borrar(id);
	}

	@Override
	public Iterable<Producto> buscarPorCategoria(Long idCategoria) {
		return JPA.consultaVarios("from Producto p where p.categoria.id = ?1", idCategoria);
	}

	@Override
	public Iterable<Producto> buscarPorNombre(String nombre) {
		return JPA.consultaVarios("from Producto p where p.nombre like ?1", "%" + nombre + "%");
	}

	@Override
	public Iterable<Producto> buscarPorPrecio(BigDecimal minimo, BigDecimal maximo) {
		return JPA.consultaVarios("from Producto p where p.precio between ?1 and ?2", minimo, maximo);
	}

}
