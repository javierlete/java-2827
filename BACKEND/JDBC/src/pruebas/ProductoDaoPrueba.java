package pruebas;

import java.math.BigDecimal;

import accesodatos.ProductoDao;
import bibliotecas.Fabrica;
import entidades.Categoria;
import entidades.Producto;

public class ProductoDaoPrueba {
	public static void main(String[] args) {
		ProductoDao dao = (ProductoDao) Fabrica.getObject("dao.producto");
		
//		dao.insertar(new Producto(null, "Nuevo con categoría", new BigDecimal(1234), null, null, new Categoria(1L, null, null))); // NOSONAR
//		dao.insertar(new Producto("Patatas", new BigDecimal(12), LocalDate.of(2025, 5, 5))); // NOSONAR
		
//		var productos = dao.obtenerProductos(); // NOSONAR
//		
//		for(Producto producto: productos) { // NOSONAR
//			System.out.println(producto.getNombre()); // NOSONAR
//			System.out.println(producto.getCategoria().getNombre()); // NOSONAR
//		} // NOSONAR
		
		dao.modificar(new Producto(7L, "Modificado con categoria", new BigDecimal(1234), null, new Categoria(2L, null, null)));
//		dao.modificar(new Producto(1L, "Modificado", new BigDecimal(4321), LocalDate.now(), "Prueba")); // NOSONAR
		
//		dao.borrar(2L); // NOSONAR
		
		for(Producto producto: dao.obtenerTodos()) {
			System.out.println(producto);
		}
		
//		System.out.println(dao.obtenerPorId(3L)); // NOSONAR
	}
}
