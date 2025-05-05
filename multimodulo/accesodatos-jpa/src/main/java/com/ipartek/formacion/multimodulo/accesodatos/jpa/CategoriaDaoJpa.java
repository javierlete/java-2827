package com.ipartek.formacion.multimodulo.accesodatos.jpa;

import com.ipartek.formacion.bibliotecas.JpaDao;
import com.ipartek.formacion.multimodulo.accesodatos.CategoriaDao;
import com.ipartek.formacion.multimodulo.entidades.Categoria;

public class CategoriaDaoJpa implements CategoriaDao {
	
	private static final JpaDao<Categoria> JPA = new JpaDao<>(Categoria.class,
			"com.ipartek.formacion.multimodulo.entidades");
	
	public CategoriaDaoJpa(String noUsado1, String noUsado2, String noUsado3) {
	}
	
	@Override
	public Iterable<Categoria> obtenerTodos() {
		return JPA.buscarTodos();
	}

	@Override
	public Categoria obtenerPorId(Long id) {
		return JPA.buscarPorId(id);
	}

	@Override
	public Categoria insertar(Categoria categoria) {
		return JPA.insertar(categoria);
	}

	@Override
	public Categoria modificar(Categoria categoria) {
		return JPA.modificar(categoria);
	}

	@Override
	public void borrar(Long id) {
		JPA.borrar(id);
	}
}
