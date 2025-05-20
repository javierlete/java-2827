package com.ipartek.ipartex.servicios;
import com.ipartek.ipartex.repositorios.UsuariosRepository;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import com.ipartek.ipartex.entidades.Usuario;

@Service

@AllArgsConstructor
public class AutenticadoServiceImpl implements AutenticadoService {

    private final UsuariosRepository usuariosRepository;

	@Override
	public Usuario buscarPorEmail(String email) {
		return usuariosRepository.findByEmail(email);
	}

}
