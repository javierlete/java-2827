package bases;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Colecciones {
	public static void main(String[] args) {
		listas(); // NOSONAR
		conjuntos(); // NOSONAR
		mapas(); // NOSONAR
	}

	public static void listas() {
		List<String> lista = new LinkedList<>(); // new ArrayList<>(); // NOSONAR
	
		lista.add("Patata");
		lista.add("Uno");
		lista.add("Tes");
		
		lista.remove(0);
		lista.add(1, "Dos");
		lista.set(2, "Tres");
		
		System.out.println(lista.get(1));
		
		for (String dato : lista) {
			System.out.println(dato);
		}
		
		List<String> lista2 = List.of("A", "C", "B", "C", "D");
		
		lista2.forEach(System.out::println);
	}

	private static void conjuntos() {
		Set<String> conjunto = new HashSet<>(); // NOSONAR
	
		conjunto.add("Cero");
		conjunto.add("Uno");
		conjunto.add("Dos");
		conjunto.add("Uno");
		
		for (String dato : conjunto) {
			System.out.println(dato);
		}
		
		Set<String> conjunto2 = Set.of("A", "B", "C");
		
		conjunto2.forEach(System.out::println);
	}

	private static void mapas() {
		Map<String, Integer> numeros = new HashMap<>();
		
		numeros.put("Uno", 1);
		numeros.put("Dos", 2);
		
		System.out.println(numeros.get("Uno"));
		
		for(String clave: numeros.keySet()) { // NOSONAR
			System.out.printf("%s: %s%n", clave, numeros.get(clave)); // NOSONAR
		}
		
		for(Integer valor: numeros.values()) {
			System.out.println(valor);
		}
		
		for(Entry<String, Integer> par: numeros.entrySet()) {
			System.out.printf("%s: %s%n", par.getKey(), par.getValue());
		}
		
		numeros.forEach((clave, valor) -> System.out.printf("%s: %s%n", clave, valor));
	}
	public static void jerarquiaBasica() {
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
		coleccion.stream().map(e -> e.length()).reduce((longitud, acumulado) -> acumulado + longitud)
				.ifPresent(System.out::println);

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
