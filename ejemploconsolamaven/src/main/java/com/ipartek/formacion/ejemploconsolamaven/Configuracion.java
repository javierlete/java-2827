package com.ipartek.formacion.ejemploconsolamaven;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuracion {
	private String nombre;
	
	public Configuracion(String fichero) throws FileNotFoundException {
		try {
			Properties props = new Properties();
			props.load(Configuracion.class.getClassLoader().getResourceAsStream(fichero));
			
			nombre = props.getProperty("nombre");
			
			if(nombre == null) {
				nombre = "Anónimo";
			}
		} catch (Exception e) {
			throw new FileNotFoundException("No se ha podido cargar el fichero");
		}
	}
	
	public String getNombre() throws IOException {
		return nombre;
	}
}
