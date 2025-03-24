package pruebas;

import accesodatos.CategoriaDao;
import accesodatos.Fabrica;
import entidades.Categoria;

public class CategoriaDaoPrueba {
	public static void main(String[] args) {
		CategoriaDao dao = Fabrica.getCategoriaDao();
		
		System.out.println(System.getenv("JDBC_PASS"));
		
		dao.insertar(new Categoria(null, "Nueva", "Categoría nueva para demostrar un DAO"));
		
		for(Categoria categoria: dao.obtenerTodos()) {
			System.out.println(categoria);
		}
	}
}
