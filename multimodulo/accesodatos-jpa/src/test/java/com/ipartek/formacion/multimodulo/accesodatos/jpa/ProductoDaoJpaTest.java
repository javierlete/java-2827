package com.ipartek.formacion.multimodulo.accesodatos.jpa;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.ipartek.formacion.bibliotecas.Fabrica;
import com.ipartek.formacion.multimodulo.entidades.Categoria;
import com.ipartek.formacion.multimodulo.entidades.Producto;
import com.ipartek.formacion.multimodulo.entidades.ProductoPerecedero;

class ProductoDaoJpaTest {

	@Test
	void testObtenerTodos() {
		var daoProducto = (ProductoDaoJpa)Fabrica.getObject("dao.producto");
		
		daoProducto.obtenerTodos().forEach(System.out::println);
		
		assertTrue(true);
	}
	
	@Test
	void testObtenerPorId() {
		var daoProducto = (ProductoDaoJpa)Fabrica.getObject("dao.producto");
		
		var producto = daoProducto.obtenerPorId(2L);
		
		System.out.println(producto);
		
		assertTrue(true);
	}
	
	@Test
	void testInsertar() {
//		var daoCategoria = (CategoriaDaoJpa)Fabrica.getObject("dao.categoria"); // NOSONAR
		var daoProducto = (ProductoDaoJpa)Fabrica.getObject("dao.producto");
		
//		var categoria = daoCategoria.insertar(Categoria.builder().nombre("Categoria de prueba").build()); // NOSONAR
		
//		var categoria = daoCategoria.obtenerPorId(1L); // NOSONAR
		
		var categoria = Categoria.builder().id(1L).build();
		
		var producto = Producto.builder()
				.nombre("Prueba")
				.precio(new BigDecimal("1234"))
				.categoria(categoria).build();
		
		daoProducto.insertar(producto);
		
		var productoPerecedero = ProductoPerecedero.builder().nombre("Perecedero 2").precio(new BigDecimal("4321")).caducidad(LocalDate.of(2026, 1,2)).build();
		
		daoProducto.insertar(productoPerecedero);
		
		assertTrue(true);
	}

}
