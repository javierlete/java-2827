package bibliotecas;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import accesodatos.AccesoDatosException;

public class Fabrica {
	private Fabrica() {
	}

	private static Properties props; 
	
	static {
		try {
			props = new Properties();
			props.load(Fabrica.class.getClassLoader().getResourceAsStream("basesdedatos.properties"));
		} catch (IOException e) {
			throw new AccesoDatosException("No se ha podido leer el fichero de configuración", e);
		}
	}

	public static Object getObject(String nombre) {
		try {
			Class<?> clase = Class.forName(props.getProperty(nombre));
			Constructor<?> constructor3String = clase.getConstructor(String.class, String.class, String.class);
			return constructor3String.newInstance(System.getenv("JDBC_URL"), System.getenv("JDBC_USER"), System.getenv("JDBC_PASS"));
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha podido crear el DAO " + nombre);
		}
	}
}
