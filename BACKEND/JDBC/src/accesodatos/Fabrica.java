package accesodatos;

import java.io.IOException;
import java.util.Properties;

public class Fabrica {
	private Fabrica() {
	}

	private static String productoDao;

	static {
		try {
			Properties props = new Properties();
			props.load(Fabrica.class.getClassLoader().getResourceAsStream("basesdedatos.properties"));
			
			productoDao = props.getProperty("dao.producto");
		} catch (IOException e) {
			throw new AccesoDatosException("No se ha podido leer el fichero de configuración", e);
		}
	}

	public static CategoriaDao getCategoriaDao() {
		return new CategoriaDaoMySql(System.getenv("JDBC_URL"), System.getenv("JDBC_USER"), System.getenv("JDBC_PASS"));
	}

	public static ProductoDao getProductoDao() {
		return switch (productoDao) {
		case "mysql" ->
			new ProductoDaoMySql(System.getenv("JDBC_URL"), System.getenv("JDBC_USER"), System.getenv("JDBC_PASS"));
		case "fake" -> new ProductoDaoFake();
		default -> null;
		};
	}
}
