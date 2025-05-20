package com.ipartek.ipartex.servicios;

import com.ipartek.ipartex.entidades.Usuario;

public interface AutenticadoService {
	Usuario buscarPorEmail(String email);
}
