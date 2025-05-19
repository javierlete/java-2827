package com.ipartek.ipartex.servicios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ipartek.ipartex.entidades.Mensaje;
import com.ipartek.ipartex.repositorios.MensajesRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AnonimoServiceImpl implements AnonimoService {
	private MensajesRepository repo;
	
	@Override
	public Page<Mensaje> listarMensajes(int tamano) {
		Pageable pageable = PageRequest.of(0, tamano, Sort.by(Sort.Direction.DESC, "fecha"));
		return repo.listadoMensajes(pageable);
	}

}
