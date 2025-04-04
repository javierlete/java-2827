package com.ipartek.formacion.multimodulo.presentacion.consola;

import java.util.Scanner;

import com.ipartek.formacion.multimodulo.entidades.Producto;
import com.ipartek.formacion.multimodulo.logicanegocio.AnonimoNegocio;
import com.ipartek.formacion.multimodulo.logicanegocio.AnonimoNegocioImpl;

public class App {
	private static final AnonimoNegocio NEGOCIO = new AnonimoNegocioImpl();
	private static final Scanner SC = new Scanner(System.in);
	
    public static void main(String[] args) {
    	boolean salir = false;
		
    	do {
			menu();
			int opcion = pedirOpcion();
			procesar(opcion);
			
			if(opcion == 0) {
				salir = true;
			}
		} while (!salir);
    }

	private static void menu() {
		System.out.println("""
				1. Listado
				
				0. Salir
				""");
	}

	private static int pedirOpcion() {
		return pedirEntero("Dime la opción deseada");
	}

	private static int pedirEntero(String mensaje) {
		System.out.print(mensaje + ": ");
		
		return SC.nextInt();
	}

	private static void procesar(int opcion) {
		switch(opcion) {
		case 1 -> listado();
		case 0 -> System.out.println("Gracias por tu visita");
		default -> System.out.println("No se reconoce la opción " + opcion);
		}
	}

	private static void listado() {
		for(Producto p: NEGOCIO.listarProductos()) {
			System.out.println(p);
		}
	}
}
