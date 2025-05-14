package com.ipartek.formacion.springapp.config;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class CodificacionesConfigurationTest {
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Test
	void passwords() {
		String original = "javier";
		String codificada = passwordEncoder.encode(original);
		
		System.out.println(codificada);
		
		assertTrue(passwordEncoder.matches(original, codificada));
		
		original = "pepe";
		codificada = passwordEncoder.encode(original);

		System.out.println(codificada);
		
		assertTrue(passwordEncoder.matches(original, codificada));

	}
}
