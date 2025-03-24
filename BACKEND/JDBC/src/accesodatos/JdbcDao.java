package accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class JdbcDao<T> {

	protected String jdbcUrl;
	protected String jdbcUsuario;
	protected String jdbcPassword;
	
	protected static final String DRIVER_MYSQL = "com.mysql.cj.jdbc.Driver"; 
	protected static final String DRIVER_SQLITE = "org.sqlite.JDBC";

	protected JdbcDao(String jdbcUrl, String jdbcUsuario, String jdbcPassword, String jdbcDriver) {
		super();
		this.jdbcUrl = jdbcUrl;
		this.jdbcUsuario = jdbcUsuario;
		this.jdbcPassword = jdbcPassword;
		
		try {
			Class.forName(jdbcDriver);
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha encontrado el driver de base de datos");
		}
	}

	protected Connection obtenerConexion() {
		try {
			return DriverManager.getConnection(jdbcUrl, jdbcUsuario, jdbcPassword);
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido conectar a la base de datos", e);
		}
	}
	
	protected abstract T filaAObjeto(ResultSet rs) throws SQLException;
	protected abstract void objetoAFila(T objeto, PreparedStatement pst) throws SQLException;

}