package bases;

import java.util.ArrayList;
import java.util.Iterator;

public class ForEachTraducido {
	public static void main(String[] args) {
		var lista = new ArrayList<String>();
		
		lista.add("Uno");
		lista.add("Dos");
		
		for(var elemento: lista) {
			System.out.println(elemento);
		}
		
		Iterator<String> iterator = lista.iterator();
		
		while(iterator.hasNext()) {
			String elemento = iterator.next();
			System.out.println(elemento);
		}
	}
}
