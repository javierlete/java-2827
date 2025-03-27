package pruebas;

import accesodatos.CategoriaDao;
import bibliotecas.Fabrica;
import entidades.Categoria;

public class CategoriaDaoPrueba {
	public static void main(String[] args) {
		CategoriaDao dao = (CategoriaDao) Fabrica.getObject("dao.categoria");
		
		System.out.println(System.getenv("JDBC_PASS"));
		
		dao.insertar(new Categoria(null, "Nueva", "Categoría nueva para demostrar un DAO"));
		
		for(Categoria categoria: dao.obtenerTodos()) {
			System.out.println(categoria);
		}
	}
}
