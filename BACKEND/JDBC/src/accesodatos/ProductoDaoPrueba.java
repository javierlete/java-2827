package accesodatos;

import java.math.BigDecimal;
import java.time.LocalDate;

import entidades.Producto;

public class ProductoDaoPrueba {
	public static void main(String[] args) {
		var dao = new ProductoDao(System.getenv("JDBC_URL"), System.getenv("JDBC_USER"),
				System.getenv("JDBC_PASS"));
		
		dao.insertar(new Producto("Nuevo", new BigDecimal(1234)));
		dao.insertar(new Producto("Patatas", new BigDecimal(12), LocalDate.of(2025, 5, 5)));
		
		var productos = dao.obtenerProductos();
		
		for(Producto producto: productos) {
			System.out.println(producto);
		}
		
		dao.modificar(new Producto(1L, "Modificado", new BigDecimal(4321), LocalDate.now(), "Prueba"));
		
		dao.borrar(2L);
		
		for(Producto producto: dao.obtenerProductos()) {
			System.out.println(producto);
		}
		
		System.out.println(dao.obtenerPorId(3L));
	}
}
