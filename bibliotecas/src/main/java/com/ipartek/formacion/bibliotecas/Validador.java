package com.ipartek.formacion.bibliotecas;

import java.util.HashMap;
import java.util.Map;

import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;

public class Validador {
	private Validador() {
	}

	private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

	public static Map<String, String> validar(Object objeto) {
		var constraintViolations = factory.getValidator().validate(objeto);

		var errores = new HashMap<String, String>();

		constraintViolations.stream().forEach(cv -> errores.put(cv.getPropertyPath().toString(), cv.getMessage()));

		return errores;
	}
}
