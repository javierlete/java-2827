package com.ipartek.ipartex.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ipartek.ipartex.entidades.Mensaje;

public interface MensajesRepository extends CrudRepository<Mensaje, Long> {
	@Query("from Mensaje m join fetch m.autor order by m.fecha desc")
	Iterable<Mensaje> listadoMensajes();
}
