package com.ipartek.formacion.ejemploconsolamaven;

import java.io.IOException;

public class App {
	public static void main(String[] args) throws IOException {
		Configuracion config = new Configuracion("configuracion.properties");
		
		System.out.println(sumar(5, 7));
		
		System.out.println(config.getNombre());
	}

	public static int sumar(int a, int b) {
		return a + b;
	}
}
