package com.ipartek.ipartex.servicios;

import org.springframework.data.domain.Page;

import com.ipartek.ipartex.entidades.Mensaje;

public interface AnonimoService {
	Page<Mensaje> listarMensajes(int tamano);
}
