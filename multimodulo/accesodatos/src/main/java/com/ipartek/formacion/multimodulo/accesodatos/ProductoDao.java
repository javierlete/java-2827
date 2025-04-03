package com.ipartek.formacion.multimodulo.accesodatos;

import java.math.BigDecimal;

import com.ipartek.formacion.bibliotecas.Dao;
import com.ipartek.formacion.multimodulo.entidades.Producto;

public interface ProductoDao extends Dao<Producto> {
	Iterable<Producto> buscarPorNombre(String nombre);
	Iterable<Producto> buscarPorPrecio(BigDecimal minimo, BigDecimal maximo);
}
