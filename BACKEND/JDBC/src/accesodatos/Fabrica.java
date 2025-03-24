package accesodatos;

public class Fabrica {
	private Fabrica() {
	}

	public static CategoriaDao getCategoriaDao() {
		return new CategoriaDaoMySql(System.getenv("JDBC_URL"), System.getenv("JDBC_USER"), System.getenv("JDBC_PASS"));
	}

	public static ProductoDao getProductoDao() {
		return new ProductoDaoMySql(System.getenv("JDBC_URL"), System.getenv("JDBC_USER"), System.getenv("JDBC_PASS"));
	}
}
