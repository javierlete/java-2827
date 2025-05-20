package com.ipartek.ipartex.servicios;

import com.ipartek.ipartex.entidades.Mensaje;
import com.ipartek.ipartex.entidades.Usuario;

public interface AutenticadoService {
	Usuario buscarPorEmail(String email);
	Mensaje enviarMensaje(Mensaje mensaje);
}
