package com.ipartek.ipartex.servicios;

import com.ipartek.ipartex.entidades.Mensaje;

public interface AnonimoService {
	Iterable<Mensaje> listarMensajes();
}
