package com.ipartek.formacion.multimodulo.presentacionweb.mappers;

import com.ipartek.formacion.multimodulo.entidades.Producto;
import com.ipartek.formacion.multimodulo.presentacionweb.dtos.ProductoDto;

public interface ProductoMapper {
	ProductoDto aDto(Producto producto);
}
