package com.ipartek.formacion.multimodulo.accesodatos.jpa;

import java.math.BigDecimal;
import java.util.List;

import com.ipartek.formacion.bibliotecas.AccesoDatosException;
import com.ipartek.formacion.multimodulo.accesodatos.ProductoDao;
import com.ipartek.formacion.multimodulo.entidades.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ProductoDaoJpa implements ProductoDao {

	private static final EntityManagerFactory FABRICA = Persistence
			.createEntityManagerFactory("com.ipartek.formacion.multimodulo.entidades");

	public ProductoDaoJpa(String noUsado1, String noUsado2, String noUsado3) {
	}

	@Override
	public Iterable<Producto> obtenerTodos() {
		EntityTransaction t = null;
		EntityManager em = null;
		
		try {
			em = FABRICA.createEntityManager();
			t = em.getTransaction();
			t.begin();

			List<Producto> productos = em.createQuery("from Producto", Producto.class).getResultList();

			t.commit();

			return productos;
		} catch (Exception e) {
			if (t != null && t.isActive()) {
				t.rollback();
			}

			throw new AccesoDatosException("No se ha podido hacer la consulta", e);
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public Producto obtenerPorId(Long id) {
		EntityTransaction t = null;
		try (EntityManager em = FABRICA.createEntityManager()) {
			t = em.getTransaction();
			t.begin();

			Producto producto = em.find(Producto.class, id);

			t.commit();

			return producto;
		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}

			throw new AccesoDatosException("No se ha podido hacer la consulta", e);
		}
	}

	@Override
	public Producto insertar(Producto producto) {
		EntityTransaction t = null;
		try (EntityManager em = FABRICA.createEntityManager()) {
			t = em.getTransaction();
			t.begin();

			em.persist(producto);

			t.commit();

			return producto;
		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}

			throw new AccesoDatosException("No se ha podido hacer la consulta", e);
		}
	}

	@Override
	public Producto modificar(Producto producto) {
		EntityTransaction t = null;
		try (EntityManager em = FABRICA.createEntityManager()) {
			t = em.getTransaction();
			t.begin();

			em.merge(producto);

			t.commit();

			return producto;
		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}

			throw new AccesoDatosException("No se ha podido hacer la consulta", e);
		}
	}

	@Override
	public void borrar(Long id) {
		EntityTransaction t = null;
		try (EntityManager em = FABRICA.createEntityManager()) {
			t = em.getTransaction();
			t.begin();

			em.remove(em.find(Producto.class, id));

			t.commit();
		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}

			throw new AccesoDatosException("No se ha podido hacer la consulta", e);
		}
	}

	@Override
	public Iterable<Producto> buscarPorCategoria(Long idCategoria) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	@Override
	public Iterable<Producto> buscarPorNombre(String nombre) {
		EntityTransaction t = null;
		try (EntityManager em = FABRICA.createEntityManager()) {
			t = em.getTransaction();
			t.begin();

			List<Producto> productos = em.createQuery("from Producto p where p.nombre like :nombre", Producto.class)
					.setParameter("nombre", "%" + nombre + "%").getResultList();

			t.commit();

			return productos;
		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}

			throw new AccesoDatosException("No se ha podido hacer la consulta", e);
		}
	}

	@Override
	public Iterable<Producto> buscarPorPrecio(BigDecimal minimo, BigDecimal maximo) {
		EntityTransaction t = null;
		try (EntityManager em = FABRICA.createEntityManager()) {
			t = em.getTransaction();
			t.begin();

			List<Producto> productos = em
					.createQuery("from Producto p where p.precio between :minimo and :maximo", Producto.class)
					.setParameter("minimo", minimo).setParameter("maximo", maximo).getResultList();

			t.commit();

			return productos;
		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}

			throw new AccesoDatosException("No se ha podido hacer la consulta", e);
		}
	}

}
