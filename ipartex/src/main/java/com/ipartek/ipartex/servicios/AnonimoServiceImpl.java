package com.ipartek.ipartex.servicios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ipartek.ipartex.entidades.Mensaje;
import com.ipartek.ipartex.entidades.Usuario;
import com.ipartek.ipartex.repositorios.MensajesRepository;
import com.ipartek.ipartex.repositorios.UsuariosRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AnonimoServiceImpl implements AnonimoService {
	private MensajesRepository mensajesRepository;
	private UsuariosRepository usuariosRepository;
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Page<Mensaje> listarMensajes(int tamano) {
		Pageable pageable = PageRequest.of(0, tamano, Sort.by(Sort.Direction.DESC, "fecha"));
		return mensajesRepository.listadoMensajes(pageable);
	}

	@Override
	public Usuario registrarUsuario(Usuario usuario) {
		var password = usuario.getPassword();
		var passwordCodificada = passwordEncoder.encode(password);

		usuario.setPassword(passwordCodificada);
		
		return usuariosRepository.save(usuario);
	}

}
