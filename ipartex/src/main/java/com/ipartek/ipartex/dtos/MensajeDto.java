package com.ipartek.ipartex.dtos;

import java.time.LocalDateTime;

public record MensajeDto(Long id, String texto, LocalDateTime fecha, Long usuarioId, String usuarioNombre) {
	
}
