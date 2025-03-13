package accesodatos;

import entidades.Producto;

public class ProductoDaoPrueba {
	public static void main(String[] args) {
		var dao = new ProductoDao(System.getenv("JDBC_URL"), System.getenv("JDBC_USER"),
				System.getenv("JDBC_PASS"));
		
		var productos = dao.obtenerProductos();
		
		for(Producto producto: productos) {
			System.out.println(producto);
		}
	}
}
