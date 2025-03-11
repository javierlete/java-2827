package accesodatos;

import java.util.ArrayList;

import entidades.Producto;

public class ProductoDaoPrueba {
	public static void main(String[] args) {
		ProductoDao dao = new ProductoDao(System.getenv("JDBC_URL"), System.getenv("JDBC_USER"),
				System.getenv("JDBC_PASS"));
		
		ArrayList<Producto> productos = dao.obtenerProductos();
		
		for(Producto producto: productos) {
			System.out.println(producto);
		}
	}
}
