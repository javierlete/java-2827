package accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Categoria;

public class CategoriaDaoMySql {
	private String jdbcUrl;
	private String jdbcUsuario;
	private String jdbcPassword;

	private static final String SQL_SELECT = """
			SELECT
			    id, nombre, descripcion
			FROM categorias
			""";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE id=?";

	private static final String SQL_INSERT = "INSERT INTO categorias (nombre, descripcion) VALUES (?,?)";
	private static final String SQL_UPDATE = "UPDATE categorias SET nombre=?, descripcion=? WHERE id=?";
	private static final String SQL_DELETE = "DELETE FROM categorias WHERE id=?";

	static {
		try {
			Class.forName(System.getenv("JDBC_DRIVER"));
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha encontrado el driver de base de datos");
		}
	}

	public CategoriaDaoMySql(String jdbcUrl, String jdbcUsuario, String jdbcPassword) {
		super();
		this.jdbcUrl = jdbcUrl;
		this.jdbcUsuario = jdbcUsuario;
		this.jdbcPassword = jdbcPassword;
	}

	public Iterable<Categoria> obtenerTodos() {
		try (var con = obtenerConexion(); var pst = con.prepareStatement(SQL_SELECT); var rs = pst.executeQuery()) {
			var categorias = new ArrayList<Categoria>();

			while (rs.next()) {
				var categoria = filaACategoria(rs);

				categorias.add(categoria);
			}

			return categorias;
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en la consulta de todos los registros", e);
		}
	}

	public Categoria obtenerPorId(Long id) {
		try (var con = obtenerConexion(); var pst = con.prepareStatement(SQL_SELECT_ID);) {
			pst.setLong(1, id);

			var rs = pst.executeQuery();

			Categoria categoria = null;

			if (rs.next()) {
				categoria = filaACategoria(rs);
			}

			return categoria;
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en la consulta del registro por id " + id, e);
		}
	}

	public Categoria insertar(Categoria categoria) {
		try (var con = obtenerConexion(); var pst = con.prepareStatement(SQL_INSERT);) {
			categoriaAFila(categoria, pst);

			pst.executeUpdate();

			return categoria;
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en la inserción del registro " + categoria, e);
		}
	}

	public Categoria modificar(Categoria categoria) {
		try (var con = obtenerConexion(); var pst = con.prepareStatement(SQL_UPDATE);) {
			categoriaAFila(categoria, pst);

			pst.executeUpdate();

			return categoria;
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en la modificación del registro " + categoria, e);
		}
	}

	public void borrar(Long id) {
		try (var con = obtenerConexion(); var pst = con.prepareStatement(SQL_DELETE);) {
			pst.setLong(1, id);

			pst.executeUpdate();
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en el borrado del registro id " + id, e);
		}
	}

	private Connection obtenerConexion() throws SQLException {
		try {
			return DriverManager.getConnection(jdbcUrl, jdbcUsuario, jdbcPassword);
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido conectar a la base de datos", e);
		}
	}

	private Categoria filaACategoria(ResultSet rs) throws SQLException {
		var id = rs.getLong("id");
		var nombre = rs.getString("nombre");
		var descripcion = rs.getString("descripcion");

		return new Categoria(id, nombre, descripcion);
	}

	private void categoriaAFila(Categoria categoria, PreparedStatement pst) throws SQLException {
		pst.setString(1, categoria.getNombre());
		pst.setString(2, categoria.getDescripcion());

		if (categoria.getId() != null) {
			pst.setLong(3, categoria.getId());
		}
	}
}
