package com.ipartek.formacion.multimodulo.accesodatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ipartek.formacion.bibliotecas.JdbcDao;
import com.ipartek.formacion.multimodulo.entidades.Categoria;

class CategoriaDaoMySql extends JdbcDao<Categoria> implements CategoriaDao {
	private static final String SQL_SELECT = """
			SELECT
			    id, nombre, descripcion
			FROM categorias
			""";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE id=?";

	private static final String SQL_INSERT = "INSERT INTO categorias (nombre, descripcion) VALUES (?,?)";
	private static final String SQL_UPDATE = "UPDATE categorias SET nombre=?, descripcion=? WHERE id=?";
	private static final String SQL_DELETE = "DELETE FROM categorias WHERE id=?";

	public CategoriaDaoMySql(String jdbcUrl, String jdbcUsuario, String jdbcPassword) {
		super(jdbcUrl, jdbcUsuario, jdbcPassword, DRIVER_MYSQL);
	}

	@Override
	public Iterable<Categoria> obtenerTodos() {
		return consulta(SQL_SELECT);
	}

	@Override
	public Categoria obtenerPorId(Long id) {
		return consultaDeUno(SQL_SELECT_ID, id);
	}

	@Override
	public Categoria insertar(Categoria categoria) {
		return cambio(SQL_INSERT, categoria);
	}

	@Override
	public Categoria modificar(Categoria categoria) {
		return cambio(SQL_UPDATE, categoria);
	}

	@Override
	public void borrar(Long id) {
		cambioPorId(SQL_DELETE, id);
	}

	@Override
	protected Categoria filaAObjeto(ResultSet rs) throws SQLException {
		var id = rs.getLong("id");
		var nombre = rs.getString("nombre");
		var descripcion = rs.getString("descripcion");

		return new Categoria(id, nombre, descripcion);
	}

	@Override
	protected void objetoAFila(Categoria categoria, PreparedStatement pst) throws SQLException {
		pst.setString(1, categoria.getNombre());
		pst.setString(2, categoria.getDescripcion());

		if (categoria.getId() != null) {
			pst.setLong(3, categoria.getId());
		}
	}
}
