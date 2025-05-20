package com.ipartek.ipartex.servicios;
import com.ipartek.ipartex.repositorios.MensajesRepository;
import com.ipartek.ipartex.repositorios.UsuariosRepository;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import com.ipartek.ipartex.entidades.Mensaje;
import com.ipartek.ipartex.entidades.Usuario;

@Service

@AllArgsConstructor
public class AutenticadoServiceImpl implements AutenticadoService {

    private final MensajesRepository mensajesRepository;
    private final UsuariosRepository usuariosRepository;

	@Override
	public Usuario buscarPorEmail(String email) {
		return usuariosRepository.findByEmail(email);
	}

	@Override
	public Mensaje enviarMensaje(Mensaje mensaje) {
		System.out.println(mensaje);
		
		var mensajeRecibido = mensajesRepository.save(mensaje);
		
		System.out.println(mensajeRecibido);
		
		return mensajeRecibido;
	}

}
