package com.ipartek.formacion.springapp.servicios;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;

import com.ipartek.formacion.springapp.entidades.Producto;

import jakarta.validation.Valid;

@Validated
public interface AdminService extends AnonimoService {
	
	@PreAuthorize("hasRole('ADMINISTRADOR')")
	void anyadirProducto(@Valid Producto producto);
	
	@PreAuthorize("hasRole('ADMINISTRADOR')")
	void modificarProducto(@Valid Producto producto);
	
	@PreAuthorize("hasRole('ADMINISTRADOR')")
	void borrarProducto(Long id);

}
