package com.ipartek.formacion.springapp.servicios;

import org.springframework.validation.annotation.Validated;

import com.ipartek.formacion.springapp.entidades.Producto;

import jakarta.validation.Valid;

@Validated
public interface AdminService extends AnonimoService {

	void anyadirProducto(@Valid Producto producto);

	void modificarProducto(@Valid Producto producto);

	void borrarProducto(Long id);

}
