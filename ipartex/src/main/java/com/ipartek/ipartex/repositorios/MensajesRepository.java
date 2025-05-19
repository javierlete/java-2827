package com.ipartek.ipartex.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.ipartek.ipartex.entidades.Mensaje;

public interface MensajesRepository extends CrudRepository<Mensaje, Long> {
	Iterable<Mensaje> findAllByOrderByFechaDesc();
}
