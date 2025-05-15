package com.ipartek.formacion.springapp.bibliotecas;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

import org.springframework.stereotype.Component;

@Component
public class Texto {
	private static final NumberFormat formateadorEuro = NumberFormat.getCurrencyInstance(Locale.of("es", "ES"));

	public String formatoEuro(BigDecimal numero) {
		return formateadorEuro.format(numero);
	}
}
