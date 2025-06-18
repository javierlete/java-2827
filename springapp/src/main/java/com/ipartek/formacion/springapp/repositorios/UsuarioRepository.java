package com.ipartek.formacion.springapp.repositorios;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.springapp.entidades.Usuario;

@RepositoryRestResource(collectionResourceRel = "usuarios", path = "usuarios")
public interface UsuarioRepository extends CrudRepository<Usuario, Long>, PagingAndSortingRepository<Usuario, Long> {
	Optional<Usuario> findByEmail(String email);
}
