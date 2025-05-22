package com.ipartek.ipartex.servicios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ipartek.ipartex.dtos.MensajeDto;
import com.ipartek.ipartex.entidades.Mensaje;
import com.ipartek.ipartex.entidades.Usuario;

public interface AnonimoService {
	Page<Mensaje> listarMensajes(int tamano);
	
	Usuario registrarUsuario(Usuario usuario);

	Page<MensajeDto> listarMensajesPaginados(Pageable pageable);
}
