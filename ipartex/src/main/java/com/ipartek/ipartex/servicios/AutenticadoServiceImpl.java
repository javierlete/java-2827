package com.ipartek.ipartex.servicios;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ipartek.ipartex.entidades.Mensaje;
import com.ipartek.ipartex.entidades.Usuario;
import com.ipartek.ipartex.repositorios.MensajesRepository;
import com.ipartek.ipartex.repositorios.UsuariosRepository;

@Service
public class AutenticadoServiceImpl extends AnonimoServiceImpl implements AutenticadoService {

	public AutenticadoServiceImpl(MensajesRepository mensajesRepository, UsuariosRepository usuariosRepository,
			PasswordEncoder passwordEncoder) {
		super(mensajesRepository, usuariosRepository, passwordEncoder);
	}

	@Override
	public Usuario buscarPorEmail(String email) {
		return usuariosRepository.findByEmail(email);
	}

	@Override
	public Mensaje enviarMensaje(Mensaje mensaje) {
		return mensajesRepository.save(mensaje);
	}

}
