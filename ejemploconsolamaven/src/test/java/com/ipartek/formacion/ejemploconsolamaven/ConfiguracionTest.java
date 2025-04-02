package com.ipartek.formacion.ejemploconsolamaven;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConfiguracionTest {
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		// Creación de una tabla de pruebas
	}

	@BeforeEach
	void setUp() throws Exception {
		// Creación de los registros de pruebas
	}

	@AfterEach
	void tearDown() throws Exception {
		// Borrado de los registros de pruebas
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		// Borrado de la tabla de pruebas
	}

	@Test
	void testGetNombre() throws IOException {
		Configuracion configBien = new Configuracion("configuracion.properties");
		String nombre = configBien.getNombre();
		
		assertEquals("Javier", nombre);
		
		assertThrows(FileNotFoundException.class, () -> new Configuracion("noexiste"));
	}

}
