package com.ipartek.formacion.springapp.servicios;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AnonimoServiceTest {
	@Autowired
	private AnonimoService servicio;

	@Test
	void listarProductosTest() {
		for (var p : servicio.listarProductos()) {
			System.out.println(p);
		}

		assertTrue(true);
	}
}
