package com.ipartek.formacion.springapp.servicios;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ipartek.formacion.springapp.entidades.Producto;

@SpringBootTest
class AdminServiceTest {
	@Autowired
	private AdminService servicio;
	
	@Test
	void anyadirProductoTest() {
		servicio.anyadirProducto(Producto.builder().nombre("Prueba").precio(new BigDecimal("1234")).build());
		
		assertTrue(true);
	}
}
