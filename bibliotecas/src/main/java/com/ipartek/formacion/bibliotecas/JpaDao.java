package com.ipartek.formacion.bibliotecas;

import java.util.function.Function;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaDao {
	public JpaDao(String unidadDePersistencia) {
		entityManagerFactory = Persistence.createEntityManagerFactory(unidadDePersistencia);
	}

	private final EntityManagerFactory entityManagerFactory;

	public <T> T enTransaccion(Function<EntityManager, T> codigo) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			T resultado = codigo.apply(entityManager);
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
}
