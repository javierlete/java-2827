package accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Categoria;
import entidades.Producto;

public class ProductoDao {
	private String jdbcUrl;
	private String jdbcUsuario;
	private String jdbcPassword;

	private static final String SQL_SELECT = """
        SELECT 
            p.id, p.nombre, p.precio, p.caducidad, p.descripcion, p.categorias_id, 
            c.id, c.nombre, c.descripcion 
        FROM productos p
        JOIN categorias c ON categorias_id = c.id
        """;
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE p.id=?";
	
	private static final String SQL_INSERT = "INSERT INTO productos (nombre, precio, caducidad, descripcion, categorias_id) VALUES (?,?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE productos SET nombre=?, precio=?, caducidad=?, descripcion=?, categorias_id=? WHERE id=?";
	private static final String SQL_DELETE = "DELETE FROM productos WHERE id=?";

	static {
		try {
			Class.forName(System.getenv("JDBC_DRIVER"));
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha encontrado el driver de base de datos");
		}
	}

	public ProductoDao(String jdbcUrl, String jdbcUsuario, String jdbcPassword) {
		super();
		this.jdbcUrl = jdbcUrl;
		this.jdbcUsuario = jdbcUsuario;
		this.jdbcPassword = jdbcPassword;
	}

	public Iterable<Producto> obtenerProductos() {
		try (var con = obtenerConexion(); var pst = con.prepareStatement(SQL_SELECT); var rs = pst.executeQuery()) {
			var productos = new ArrayList<Producto>();

			while (rs.next()) {
				var producto = filaAProducto(rs);

				productos.add(producto);
			}

			return productos;
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en la consulta de todos los productos", e);
		}
	}

	public Producto obtenerPorId(Long id) {
		try (var con = obtenerConexion(); var pst = con.prepareStatement(SQL_SELECT_ID);) {
			pst.setLong(1, id);

			var rs = pst.executeQuery();

			Producto producto = null;

			if (rs.next()) {
				producto = filaAProducto(rs);
			}

			return producto;
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en la consulta del producto por id " + id, e);
		}
	}

	public Producto insertar(Producto producto) {
		try (var con = obtenerConexion(); var pst = con.prepareStatement(SQL_INSERT);) {
			productoAFila(producto, pst);

			pst.executeUpdate();

			return producto;
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en la inserción de producto " + producto, e);
		}
	}

	public Producto modificar(Producto producto) {
		try (var con = obtenerConexion(); var pst = con.prepareStatement(SQL_UPDATE);) {
			productoAFila(producto, pst);

			pst.executeUpdate();

			return producto;
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en la modificación del producto " + producto, e);
		}
	}

	public void borrar(Long id) {
		try (var con = obtenerConexion(); var pst = con.prepareStatement(SQL_DELETE);) {
			pst.setLong(1, id);

			pst.executeUpdate();
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en el borrado del producto id " + id, e);
		}
	}

	private Connection obtenerConexion() throws SQLException {
		try {
			return DriverManager.getConnection(jdbcUrl, jdbcUsuario, jdbcPassword);
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido conectar a la base de datos", e);
		}
	}

	private Producto filaAProducto(ResultSet rs) throws SQLException {
		var id = rs.getLong("p.id");
		var nombre = rs.getString("p.nombre");
		var precio = rs.getBigDecimal("p.precio");
		var caducidadDate = rs.getDate("p.caducidad");
		var caducidad = caducidadDate == null ? null : caducidadDate.toLocalDate();
		var descripcion = rs.getString("p.descripcion");

		var cId = rs.getLong("c.id");
		var cNombre = rs.getString("c.nombre");
		var cDescripcion = rs.getString("c.descripcion");
		
		var categoria = new Categoria(cId, cNombre, cDescripcion);
		
		var producto = new Producto(id, nombre, precio, caducidad, descripcion, categoria); // TODO NOSONAR
		return producto;
	}

	private void productoAFila(Producto producto, PreparedStatement pst) throws SQLException {
		pst.setString(1, producto.getNombre());
		pst.setBigDecimal(2, producto.getPrecio());
		pst.setDate(3, producto.getCaducidad() == null ? null : java.sql.Date.valueOf(producto.getCaducidad()));
		pst.setString(4, producto.getDescripcion());
		pst.setLong(5, producto.getCategoria().getId());

		if (producto.getId() != null) {
			pst.setLong(6, producto.getId());
		}
	}
}
