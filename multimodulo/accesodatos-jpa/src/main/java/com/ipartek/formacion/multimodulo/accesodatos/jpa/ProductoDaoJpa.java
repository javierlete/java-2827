package com.ipartek.formacion.multimodulo.accesodatos.jpa;

import java.math.BigDecimal;

import com.ipartek.formacion.bibliotecas.AccesoDatosException;
import com.ipartek.formacion.bibliotecas.JpaDao;
import com.ipartek.formacion.multimodulo.accesodatos.ProductoDao;
import com.ipartek.formacion.multimodulo.entidades.Producto;

public class ProductoDaoJpa implements ProductoDao {

	private static final JpaDao JPA = new JpaDao("com.ipartek.formacion.multimodulo.entidades");

	public ProductoDaoJpa(String noUsado1, String noUsado2, String noUsado3) {
	}

	@Override
	public Iterable<Producto> obtenerTodos() {
		return JPA.enTransaccion(em -> em.createQuery("from Producto", Producto.class).getResultList());
	}

	@Override
	public Producto obtenerPorId(Long id) {
		return JPA.enTransaccion(em -> em.find(Producto.class, id));
	}

	@Override
	public Producto insertar(Producto producto) {
		return JPA.enTransaccion(em -> {
			em.persist(producto);
			return producto;
		});
	}

	@Override
	public Producto modificar(Producto producto) {
		return JPA.enTransaccion(em -> {
			em.merge(producto);
			return producto;
		});
	}

	@Override
	public void borrar(Long id) {
		JPA.enTransaccion(em -> {
			em.remove(em.find(Producto.class, id));
			return null;
		});
	}

	@Override
	public Iterable<Producto> buscarPorCategoria(Long idCategoria) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	@Override
	public Iterable<Producto> buscarPorNombre(String nombre) {
		return JPA.enTransaccion(em -> em.createQuery("from Producto p where p.nombre like :nombre", Producto.class)
					.setParameter("nombre", "%" + nombre + "%").getResultList());
	}

	@Override
	public Iterable<Producto> buscarPorPrecio(BigDecimal minimo, BigDecimal maximo) {
		return JPA.enTransaccion(em -> em
					.createQuery("from Producto p where p.precio between :minimo and :maximo", Producto.class)
					.setParameter("minimo", minimo).setParameter("maximo", maximo).getResultList());
	}

}
