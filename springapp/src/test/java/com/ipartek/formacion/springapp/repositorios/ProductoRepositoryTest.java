package com.ipartek.formacion.springapp.repositorios;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ipartek.formacion.springapp.entidades.Categoria;
import com.ipartek.formacion.springapp.entidades.Producto;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductoRepositoryTest {
	@Autowired
	private ProductoRepository repo;
	
	@Autowired
	private CategoriaRepository repoCategoria;
	
	@Test	
	void basicas() {
		System.out.println("INICIO DE PRUEBAS");
		
		repo.save(Producto.builder().nombre("Prueba1").precio(new BigDecimal("1234")).build());
		
		var categoria = repoCategoria.save(Categoria.builder().nombre("Categoría 1").build());
		
		var producto = Producto.builder().nombre("Prueba2").precio(new BigDecimal("2234")).build();

		producto.setCategoria(categoria);
		
		repo.save(producto);
		
		System.out.println("Buscar por categoria " + categoria.getId());
		
		for(var p: repo.findByCategoriaId(categoria.getId())) {
			System.out.println(p);
		}
		
		System.out.println("Buscar por precio entre 2000 y 3000");
		
		for(var p: repo.findByPrecioBetween(new BigDecimal("2000"), new BigDecimal("3000"))) {
			System.out.println(p);
		}
		
		assertTrue(true);
	}
}
