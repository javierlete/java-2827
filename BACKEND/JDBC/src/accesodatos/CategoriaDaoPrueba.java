package accesodatos;

import entidades.Categoria;

public class CategoriaDaoPrueba {
	public static void main(String[] args) {
		CategoriaDaoMySql dao = new CategoriaDaoMySql(System.getenv("JDBC_URL"), System.getenv("JDBC_USER"),
				System.getenv("JDBC_PASS"));
		System.out.println(System.getenv("JDBC_PASS"));
		
		dao.insertar(new Categoria(null, "Nueva", "Categoría nueva para demostrar un DAO"));
		
		for(Categoria categoria: dao.obtenerTodos()) {
			System.out.println(categoria);
		}
	}
}
