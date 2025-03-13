package entidades;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProductoPrueba {
	public static void main(String[] args) {
		Producto p = new Producto();

		p.setId(12341234L);
		p.setNombre("Portátil");

		System.out.println(p.getId());
		System.out.println(p.getNombre());

		Producto p2 = new Producto(1L, "Teclado", new BigDecimal(1234), LocalDate.now(), "Mola");

		mostrarProducto(p2);
		
		Producto p3 = new Producto("Ratón", new BigDecimal(12), null, null);

		mostrarProducto(p3);
		
		Producto p4 = new Producto("Alfombrilla", BigDecimal.ONE);
		
		mostrarProducto(p4);
		
		System.out.println(p2.isCaducado());
		
		Producto pr1 = new Producto();
		Producto pr2 = new Producto();
		
		System.out.println(pr1 == pr2); // ¿Son el mismo?
		System.out.println(pr1.equals(pr2)); // ¿Son iguales?
	}

	private static void mostrarProducto(Producto producto) {
		System.out.println(producto);
	}
}
