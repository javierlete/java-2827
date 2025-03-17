package accesodatos;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Producto;

public class ProductoDao {
	private String jdbcUrl;
	private String jdbcUsuario;
	private String jdbcPassword;

	private static final String SQL_SELECT = "SELECT id, nombre, precio, caducidad, descripcion FROM productos";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE id=?";
	private static final String SQL_INSERT = "INSERT INTO productos (nombre, precio, caducidad, descripcion) VALUES (?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE productos SET nombre=?, precio=?, caducidad=?, descripcion=? WHERE id=?";
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
		try (var con = DriverManager.getConnection(jdbcUrl, jdbcUsuario, jdbcPassword);
				var pst = con.prepareStatement(SQL_SELECT);
				var rs = pst.executeQuery()) {
			var productos = new ArrayList<Producto>();

			while (rs.next()) {
				var id = rs.getLong("id");
				var nombre = rs.getString("nombre");
				var precio = rs.getBigDecimal("precio");
				var caducidadDate = rs.getDate("caducidad");
				var caducidad = caducidadDate == null ? null : caducidadDate.toLocalDate();
				var descripcion = rs.getString("descripcion");

				var producto = new Producto(id, nombre, precio, caducidad, descripcion);

				productos.add(producto);
			}

			return productos;
		} catch (SQLException e) {
			throw new AccesoDatosException("Ha habido un error en la consulta de todos los productos", e);
		}
	}

	public Producto obtenerPorId(Long id) {
		try (var con = DriverManager.getConnection(jdbcUrl, jdbcUsuario, jdbcPassword);
				var pst = con.prepareStatement(SQL_SELECT_ID);) {
			pst.setLong(1, id);

			var rs = pst.executeQuery();

			Producto producto = null;

			if (rs.next()) {
				var nombre = rs.getString("nombre");
				var precio = rs.getBigDecimal("precio");
				var caducidadDate = rs.getDate("caducidad");
				var caducidad = caducidadDate == null ? null : caducidadDate.toLocalDate();
				var descripcion = rs.getString("descripcion");

				producto = new Producto(id, nombre, precio, caducidad, descripcion);
			}

			return producto;
		} catch (SQLException e) {
			throw new AccesoDatosException("Ha habido un error en la consulta del producto por id " + id, e);
		}
	}

	public Producto insertar(Producto producto) {
		try (var con = DriverManager.getConnection(jdbcUrl, jdbcUsuario, jdbcPassword);
				var pst = con.prepareStatement(SQL_INSERT);) {
			pst.setString(1, producto.getNombre());
			pst.setBigDecimal(2, producto.getPrecio());
			pst.setDate(3, producto.getCaducidad() == null ? null: java.sql.Date.valueOf(producto.getCaducidad()));
			pst.setString(4, producto.getDescripcion());

			pst.executeUpdate();

			return producto;
		} catch (SQLException e) {
			throw new AccesoDatosException("Ha habido un error en la inserción de producto " + producto, e);
		}
	}

	public Producto modificar(Producto producto) {
		try (var con = DriverManager.getConnection(jdbcUrl, jdbcUsuario, jdbcPassword);
				var pst = con.prepareStatement(SQL_UPDATE);) {
			pst.setString(1, producto.getNombre());
			pst.setBigDecimal(2, producto.getPrecio());
			pst.setDate(3, producto.getCaducidad() == null ? null: java.sql.Date.valueOf(producto.getCaducidad()));
			pst.setString(4, producto.getDescripcion());
			pst.setLong(5, producto.getId());

			pst.executeUpdate();

			return producto;
		} catch (SQLException e) {
			throw new AccesoDatosException("Ha habido un error en la modificación del producto " + producto, e);
		}
	}

	public void borrar(Long id) {
		try (var con = DriverManager.getConnection(jdbcUrl, jdbcUsuario, jdbcPassword);
				var pst = con.prepareStatement(SQL_DELETE);) {
			pst.setLong(1, id);

			pst.executeUpdate();
		} catch (SQLException e) {
			throw new AccesoDatosException("Ha habido un error en el borrado del producto id " + id, e);
		}
	}
}
