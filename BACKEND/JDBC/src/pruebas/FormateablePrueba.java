package pruebas;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entidades.Categoria;
import entidades.Formateable;
import entidades.Producto;
import entidades.ProductoPerecedero;

public class FormateablePrueba {
	public static void main(String[] args) {
		List<Formateable> formateables = new ArrayList<>();
		
		formateables.add(new Categoria(1L, "Categoría de prueba", "La descripción de la categoría"));
		formateables.add(new Producto(1L, "Producto chuperchuli", new BigDecimal(123), "KTCPLPA"));
		formateables.add(new ProductoPerecedero(2L, "Naranjas", new BigDecimal(3), LocalDate.now(), null));
		
		for(Formateable f: formateables) {
			System.out.println(f.formatear());
		}
	}
}
