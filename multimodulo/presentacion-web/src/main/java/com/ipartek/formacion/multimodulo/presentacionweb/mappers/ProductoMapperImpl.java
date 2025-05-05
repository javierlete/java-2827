package com.ipartek.formacion.multimodulo.presentacionweb.mappers;

import com.ipartek.formacion.multimodulo.entidades.Producto;
import com.ipartek.formacion.multimodulo.presentacionweb.dtos.ProductoDto;

public class ProductoMapperImpl implements ProductoMapper {

	@Override
	public ProductoDto aDto(Producto producto) {
		return new ProductoDto(producto.getId(), producto.getNombre(), producto.getPrecio(), producto.getDescripcion());
	}

}
