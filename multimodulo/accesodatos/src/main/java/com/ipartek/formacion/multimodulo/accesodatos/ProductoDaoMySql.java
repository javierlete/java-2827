package com.ipartek.formacion.multimodulo.accesodatos;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ipartek.formacion.bibliotecas.JdbcDao;
import com.ipartek.formacion.multimodulo.entidades.Categoria;
import com.ipartek.formacion.multimodulo.entidades.Producto;
import com.ipartek.formacion.multimodulo.entidades.ProductoPerecedero;

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
		return consulta(SQL_SELECT);
	}

	@Override
	public Producto obtenerPorId(Long id) {
		return consultaDeUno(SQL_SELECT_ID, id);
	}

	@Override
	public Iterable<Producto> buscarPorNombre(String nombre) {
		return consulta(SQL_SELECT_NOMBRE, "%" + nombre + "%");
	}

	@Override
	public Iterable<Producto> buscarPorPrecio(BigDecimal minimo, BigDecimal maximo) {
		return consulta(SQL_SELECT_PRECIO, minimo, maximo);
	}

	@Override
	public Producto insertar(Producto producto) {
		return cambio(SQL_INSERT, producto);
	}

	@Override
	public Producto modificar(Producto producto) {
		return cambio(SQL_UPDATE, producto);
	}

	@Override
	public void borrar(Long id) {
		cambioPorId(SQL_DELETE, id);
	}

	@Override
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

	@Override
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
