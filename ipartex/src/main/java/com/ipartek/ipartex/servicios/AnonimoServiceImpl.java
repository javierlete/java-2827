package com.ipartek.ipartex.servicios;

import org.springframework.stereotype.Service;

import com.ipartek.ipartex.entidades.Mensaje;
import com.ipartek.ipartex.repositorios.MensajesRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AnonimoServiceImpl implements AnonimoService {
	private MensajesRepository repo;
	
	@Override
	public Iterable<Mensaje> listarMensajes() {
		return repo.listadoMensajes();
	}

}
