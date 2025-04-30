package com.ipartek.formacion.bibliotecas;

import java.util.function.Function;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaDao<T> {
	private Class<T> tipo;

	public JpaDao(Class<T> tipo, String unidadDePersistencia) {
		entityManagerFactory = Persistence.createEntityManagerFactory(unidadDePersistencia);
		this.tipo = tipo;
	}

	private final EntityManagerFactory entityManagerFactory;

	private <G> G enTransaccion(Function<EntityManager, G> codigo) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			G resultado = codigo.apply(entityManager);
			transaction.commit();

			return resultado;
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			throw new AccesoDatosException("Error en la operación de JPA", e);
		} finally {
			entityManager.close();
		}
	}

	public Iterable<T> consultaVarios(String jpql, Object... argumentos) {
		return enTransaccion(em -> {
			var consulta = em.createQuery(jpql, tipo);

			int posicion = 1;

			for (var argumento : argumentos) {
				consulta.setParameter(posicion++, argumento);
			}

			return consulta.getResultList();
		});
	}

	public T consultaUno(String jpql, Object... argumentos) {
		return enTransaccion(em -> {
			var consulta = em.createQuery(jpql, tipo);

			int posicion = 1;

			for (var argumento : argumentos) {
				consulta.setParameter(posicion++, argumento);
			}

			return consulta.getSingleResultOrNull();
		});
	}

	public int cambio(String jpql, Object... argumentos) {
		return enTransaccion(em -> {
			var consulta = em.createQuery(jpql, tipo);

			int posicion = 1;

			for (var argumento : argumentos) {
				consulta.setParameter(posicion++, argumento);
			}

			return consulta.executeUpdate();
		});
	}

	public Iterable<T> buscarTodos() {
		return enTransaccion(em -> em.createQuery("from " + tipo.getSimpleName(), tipo).getResultList());
	}

	public T buscarPorId(Long id) {
		return enTransaccion(em -> em.find(tipo, id));
	}

	public T insertar(T objeto) {
		return enTransaccion(em -> {
			em.persist(objeto);
			return objeto;
		});
	}

	public T modificar(T objeto) {
		return enTransaccion(em -> {
			em.merge(objeto);
			return objeto;
		});
	}

	public void borrar(Long id) {
		enTransaccion(em -> {
			em.remove(em.find(tipo, id));
			return null;
		});
	}
}
