package com.ipartek.formacion.ejemploconsolamaven;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AppTest {
	@Test
	void dosSumarCincoDebeDevolverSiete() {
		var resultado = App.sumar(2, 5);
		
		assertEquals(7, resultado);
	}
}
