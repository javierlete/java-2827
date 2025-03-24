package bases;

import java.util.ArrayList;

public class ForEachTraducido {
	public static void main(String[] args) {
		var lista = new ArrayList<String>();
		
		lista.add("Uno");
		lista.add("Dos");
		
		for(var elemento: lista) {
			System.out.println(elemento);
		}
		
		var iterator = lista.iterator();
		
		while(iterator.hasNext()) {
			var elemento = iterator.next();
			System.out.println(elemento);
		}
	}
}
