package com.ipartek.formacion.multimodulo.presentacionweb.mappers;

import org.modelmapper.ModelMapper;

import com.ipartek.formacion.multimodulo.entidades.Producto;
import com.ipartek.formacion.multimodulo.presentacionweb.dtos.ProductoDto;

public class ProductoMapperImpl implements ProductoMapper {
	private static final ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public ProductoDto aDto(Producto producto) {
		return modelMapper.map(producto, ProductoDto.class);
	}

}
