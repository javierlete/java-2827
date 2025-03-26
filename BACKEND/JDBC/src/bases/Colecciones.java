package bases;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Colecciones {
	public static void main(String[] args) {
		List<String> lista = List.of("Uno", "Dos", "Tres");

		lista.forEach(System.out::println);

		Collection<String> coleccion = lista;

		System.out.print("filter: ");
		coleccion.stream().filter(e -> e.contains("o")).forEach(System.out::print);
		System.out.println();
		
		System.out.print("map: ");
		coleccion.stream().map(String::toUpperCase).forEach(System.out::print);
		System.out.println();
		
		System.out.print("reduce: ");
		coleccion.stream().map(e -> e.length()).reduce((longitud, acumulado) -> acumulado + longitud).ifPresent(System.out::println);
		
		Iterable<String> iterable = coleccion;

		Iterator<String> iterator = iterable.iterator();

		while (iterator.hasNext()) {
			String texto = iterator.next();
			System.out.println(texto);
		}

		for (String texto : iterable) {
			System.out.println(texto);
		}

		iterable.forEach(s -> System.out.println(s)); // NOSONAR
		iterable.forEach(System.out::println);
	}
}
