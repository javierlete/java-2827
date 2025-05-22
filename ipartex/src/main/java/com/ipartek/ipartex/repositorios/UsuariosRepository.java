package com.ipartek.ipartex.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.ipartex.entidades.Usuario;

@RepositoryRestResource(collectionResourceRel = "usuarios", path = "usuarios")
public interface UsuariosRepository extends CrudRepository<Usuario, Long> {
	Usuario findByEmail(String email);
}
