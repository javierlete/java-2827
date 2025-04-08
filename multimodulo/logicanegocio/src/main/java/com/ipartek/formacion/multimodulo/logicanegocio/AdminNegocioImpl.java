package com.ipartek.formacion.multimodulo.logicanegocio;

import com.ipartek.formacion.multimodulo.entidades.Producto;

public class AdminNegocioImpl implements AdminNegocio {

	@Override
	public void anyadirProducto(Producto producto) {
		System.out.println("AÑADIR: " + producto);
	}

	@Override
	public void modificarProducto(Producto producto) {
		System.out.println("MODIFICAR: " + producto);
	}
	
}
