package accesodatos;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Categoria;
import entidades.Producto;
import entidades.ProductoPerecedero;

class ProductoDaoMySql extends JdbcDao<Producto> implements ProductoDao {
	private static final String SQL_SELECT = """
			SELECT
			    p.id AS p_id, p.nombre AS p_nombre, p.precio AS p_precio, p.caducidad AS p_caducidad, p.descripcion AS p_descripcion, p.categorias_id AS p_categorias_id,
			    c.id AS c_id, c.nombre AS c_nombre, c.descripcion AS c_descripcion
			FROM productos p
			JOIN categorias c ON categorias_id = c.id
			""";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE p.id=?";
	private static final String SQL_SELECT_NOMBRE = SQL_SELECT + " WHERE p.nombre LIKE ?";
	private static final String SQL_SELECT_PRECIO = SQL_SELECT + " WHERE p.precio BETWEEN ? AND ?";

	private static final String SQL_INSERT = "INSERT INTO productos (nombre, precio, caducidad, descripcion, categorias_id) VALUES (?,?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE productos SET nombre=?, precio=?, caducidad=?, descripcion=?, categorias_id=? WHERE id=?";
	private static final String SQL_DELETE = "DELETE FROM productos WHERE id=?";

	public ProductoDaoMySql(String jdbcUrl, String jdbcUsuario, String jdbcPassword) {
		super(jdbcUrl, jdbcUsuario, jdbcPassword, DRIVER_MYSQL);
	}

	@Override
	public Iterable<Producto> obtenerTodos() {
		try (var con = obtenerConexion(); var pst = con.prepareStatement(SQL_SELECT); var rs = pst.executeQuery()) {
			var productos = new ArrayList<Producto>();

			while (rs.next()) {
				var producto = filaAObjeto(rs);

				productos.add(producto);
			}

			return productos;
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en la consulta de todos los productos", e);
		}
	}

	@Override
	public Producto obtenerPorId(Long id) {
		try (var con = obtenerConexion(); var pst = con.prepareStatement(SQL_SELECT_ID);) {
			pst.setLong(1, id);

			var rs = pst.executeQuery();

			Producto producto = null;

			if (rs.next()) {
				producto = filaAObjeto(rs);
			}

			return producto;
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en la consulta del producto por id " + id, e);
		}
	}

	@Override
	public Iterable<Producto> buscarPorNombre(String nombre) {
		try (var con = obtenerConexion(); var pst = con.prepareStatement(SQL_SELECT_NOMBRE);) {
			pst.setString(1, "%" + nombre + "%");

			var rs = pst.executeQuery();
			var productos = new ArrayList<Producto>();

			while (rs.next()) {
				var producto = filaAObjeto(rs);

				productos.add(producto);
			}

			return productos;
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en la consulta de todos los productos por nombre " + nombre, e);
		}
	}

	@Override
	public Iterable<Producto> buscarPorPrecio(BigDecimal minimo, BigDecimal maximo) {
		try (var con = obtenerConexion(); var pst = con.prepareStatement(SQL_SELECT_PRECIO);) {
			pst.setBigDecimal(1, minimo);
			pst.setBigDecimal(2, maximo);

			var rs = pst.executeQuery();
			var productos = new ArrayList<Producto>();

			while (rs.next()) {
				var producto = filaAObjeto(rs);

				productos.add(producto);
			}

			return productos;
		} catch (SQLException e) {
			throw new AccesoDatosException(
					"Error en la consulta de todos los productos por precio entre " + minimo + " y " + maximo, e);
		}
	}

	@Override
	public Producto insertar(Producto producto) {
		try (var con = obtenerConexion(); var pst = con.prepareStatement(SQL_INSERT);) {
			objetoAFila(producto, pst);

			pst.executeUpdate();

			return producto;
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en la inserción de producto " + producto, e);
		}
	}

	@Override
	public Producto modificar(Producto producto) {
		try (var con = obtenerConexion(); var pst = con.prepareStatement(SQL_UPDATE);) {
			objetoAFila(producto, pst);

			pst.executeUpdate();

			return producto;
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en la modificación del producto " + producto, e);
		}
	}

	@Override
	public void borrar(Long id) {
		try (var con = obtenerConexion(); var pst = con.prepareStatement(SQL_DELETE);) {
			pst.setLong(1, id);

			pst.executeUpdate();
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en el borrado del producto id " + id, e);
		}
	}

	protected Producto filaAObjeto(ResultSet rs) throws SQLException {
		var id = rs.getLong("p_id");
		var nombre = rs.getString("p_nombre");
		var precio = rs.getBigDecimal("p_precio");
		var caducidadDate = rs.getDate("p_caducidad");
		var caducidad = caducidadDate == null ? null : caducidadDate.toLocalDate();
		var descripcion = rs.getString("p_descripcion");

		var cId = rs.getLong("c_id");
		var cNombre = rs.getString("c_nombre");
		var cDescripcion = rs.getString("c_descripcion");

		var categoria = new Categoria(cId, cNombre, cDescripcion);

		Producto producto;

		if (caducidad == null) {
			producto = new Producto(id, nombre, precio, descripcion, categoria);
		} else {
			producto = new ProductoPerecedero(id, nombre, precio, caducidad, descripcion, categoria);
		}
		
		return producto;
	}

	protected void objetoAFila(Producto producto, PreparedStatement pst) throws SQLException {
		pst.setString(1, producto.getNombre());
		pst.setBigDecimal(2, producto.getPrecio());

		if (producto instanceof ProductoPerecedero pp) {
			pst.setDate(3, java.sql.Date.valueOf(pp.getCaducidad()));
		} else {
			pst.setDate(3, null);
		}

		pst.setString(4, producto.getDescripcion());
		pst.setLong(5, producto.getCategoria().getId());

		if (producto.getId() != null) {
			pst.setLong(6, producto.getId());
		}
	}
}
