package pruebas;

import java.math.BigDecimal;
import java.time.LocalDate;

import entidades.Producto;
import entidades.ProductoPerecedero;

public class ProductoPrueba {
	public static void main(String[] args) {
		Producto.setMaximoNombre(15);

		Producto p = new Producto();

		p.setId(12341234L);
		p.setNombre("Portátil");

		System.out.println(p.getId());
		System.out.println(p.getNombre());

		Producto p2 = new ProductoPerecedero(1L, "Naranjas", new BigDecimal(12), LocalDate.now(), "Mola");

		System.out.println(p2.getNombre());

		if (p2 instanceof ProductoPerecedero pa2) {
			System.out.println(pa2.getCaducidad());
		}
		
		mostrarProducto(p2);

		Producto p3 = new Producto("Ratón", new BigDecimal(12), null);

		mostrarProducto(p3);

		Producto p4 = new Producto("Alfombrilla", BigDecimal.ONE);

		mostrarProducto(p4);

		Producto pr1 = new Producto();
		Producto pr2 = new Producto();

		System.out.println(pr1 == pr2); // ¿Son el mismo?
		System.out.println(pr1.equals(pr2)); // ¿Son iguales?

		if (pr1 instanceof ProductoPerecedero) { // NOSONAR
			ProductoPerecedero falso = (ProductoPerecedero) pr1;

			System.out.println(falso.isCaducado());
		}
	}

	private static void mostrarProducto(Producto producto) {
		System.out.println(producto);
	}
}
