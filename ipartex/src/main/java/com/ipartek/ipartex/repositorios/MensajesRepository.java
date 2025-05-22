package com.ipartek.ipartex.repositorios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.ipartek.ipartex.entidades.Mensaje;

@RepositoryRestResource(collectionResourceRel = "mensajes", path="mensajes")
public interface MensajesRepository extends CrudRepository<Mensaje, Long>, PagingAndSortingRepository<Mensaje, Long> {
	@RestResource(exported = false)
	@Query("from Mensaje m join fetch m.autor order by m.fecha desc")
	Iterable<Mensaje> listadoMensajes();
	
	@Query("from Mensaje m join fetch m.autor order by m.fecha desc")
	Page<Mensaje> listadoMensajes(Pageable pageable);
}
