package accesodatos;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
		try {
			Class<?> clase = Class.forName(productoDao);
			Constructor<?> constructor3String = clase.getConstructor(String.class, String.class, String.class);
			return (ProductoDao)constructor3String.newInstance(System.getenv("JDBC_URL"), System.getenv("JDBC_USER"), System.getenv("JDBC_PASS"));
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha podido crear el DAO " + productoDao);
		}
	}
}
