package com.ipartek.formacion.multimodulo.presentacionweb.dtos;

import java.math.BigDecimal;

public record ProductoDto(Long id, String nombre, BigDecimal precio, String descripcion) {

}
