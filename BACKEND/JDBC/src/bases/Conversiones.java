package bases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Conversiones {
	public static void main(String[] args) {
		String texto = "1234";
		
		int entero = Integer.parseInt(texto);
		
		System.out.println(entero * 2);
		
		texto = "s";
		
		boolean aceptado = texto.equals("s");
		
		System.out.println(aceptado);
		
		texto = "    Sí";
		
		char letra = texto.trim().charAt(0);
		
		System.out.println(letra);
		
		int dato = 1234;
		
		String conversion = String.valueOf(dato);
		
		System.out.println(conversion);
		
		LocalDate fecha = LocalDate.of(2025, 3, 12);
		
		String convertida = fecha.toString();
		
		System.out.println(convertida);
		
		DateTimeFormatter formatoFechaEspanol = DateTimeFormatter.ofPattern("d/MMMM/yyyy");

		String textoFecha = "2025-05-21";
		
		LocalDate fechaConvertida = LocalDate.parse(textoFecha);
		
		System.out.println(fechaConvertida.format(formatoFechaEspanol));
		
		textoFecha = "2/enero/2026";
		
		fechaConvertida = LocalDate.parse(textoFecha, formatoFechaEspanol);
		
		System.out.println(fechaConvertida);
	}
}
