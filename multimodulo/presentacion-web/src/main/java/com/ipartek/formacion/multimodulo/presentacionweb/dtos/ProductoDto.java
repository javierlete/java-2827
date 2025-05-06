package com.ipartek.formacion.multimodulo.presentacionweb.dtos;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ProductoDto {
	private Long id;
	private String nombre;
	private BigDecimal precio;
	private String descripcion;
}
