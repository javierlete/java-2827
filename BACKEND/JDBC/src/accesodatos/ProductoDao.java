package accesodatos;

import java.math.BigDecimal;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
			
			while(rs.next()) {
				var id = rs.getLong("id");
				var nombre = rs.getString("nombre");
				var precio = rs.getBigDecimal("precio");
				var caducidad = rs.getDate("caducidad").toLocalDate();
				var descripcion = rs.getString("descripcion");
				
				var producto = new Producto(id, nombre, precio, caducidad, descripcion);
				
				productos.add(producto);
			}
			
			return productos;
		} catch (SQLException e) {
			throw new RuntimeException("Ha habido un error en la consulta", e);
		}
	}

	public Producto obtenerPorId(Long id) {
		return null;
	}

	public Producto insertar(Producto producto) {
		return null;
	}

	public Producto modificar(Producto producto) {
		return null;
	}

	public void borrar(Long id) {

	}
}
