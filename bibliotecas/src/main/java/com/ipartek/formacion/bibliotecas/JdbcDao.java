package com.ipartek.formacion.bibliotecas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public abstract class JdbcDao<T extends Identificable> implements Dao<T> {

	private static final String ERROR_GENERICO = "Error en la consulta";

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
			throw new AccesoDatosException("No se ha encontrado el driver de base de datos", e);
		}
	}

	private Connection obtenerConexion() {
		try {
			return DriverManager.getConnection(jdbcUrl, jdbcUsuario, jdbcPassword);
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido conectar a la base de datos", e);
		}
	}

	protected abstract T filaAObjeto(ResultSet rs) throws SQLException;

	protected abstract void objetoAFila(T objeto, PreparedStatement pst) throws SQLException;

	public Iterable<T> ejecutarSql(String sql, Function<PreparedStatement, Iterable<T>> sentencias) {
		try (var con = obtenerConexion(); var pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
			return sentencias.apply(pst);
		} catch (SQLException e) {
			throw new AccesoDatosException(ERROR_GENERICO, e);
		}
	}
	
	public T ejecutarSqlDeUno(String sql, Function<PreparedStatement, Iterable<T>> sentencias) {
		var resultado = ejecutarSql(sql, sentencias);
		return resultado.iterator().hasNext()? resultado.iterator().next(): null;
	}
	
	public T consultaDeUno(String sql, Object... datos) {
		var resultado = consulta(sql, datos);
		var iterador = resultado.iterator();

		if (iterador.hasNext()) {
			return iterador.next();
		} else {
			return null;
		}
	}

	public Iterable<T> consulta(String sql, Object... datos) {
		return ejecutarSql(sql, pst -> {
			try {
				int i = 1;

				for (Object dato : datos) {
					pst.setObject(i++, dato);
				}

				var rs = pst.executeQuery();
				var objetos = new ArrayList<T>();

				while (rs.next()) {
					var objeto = filaAObjeto(rs);

					objetos.add(objeto);
				}

				return objetos;
			} catch (SQLException e) {
				throw new AccesoDatosException(ERROR_GENERICO, e);
			}
		});
	}

	public T cambio(String sql, T objeto) {
		return ejecutarSqlDeUno(sql, pst -> {
			try {
				objetoAFila(objeto, pst);

				pst.executeUpdate();
				
				var rsClaves = pst.getGeneratedKeys();
				
				if(rsClaves.next()) {
					Long idAutogenerado = rsClaves.getLong(1);
					
					objeto.setId(idAutogenerado);
				}

				return List.of(objeto);
			} catch (SQLException e) {
				throw new AccesoDatosException(ERROR_GENERICO, e);
			}
		});

	}

	public void cambioPorId(String sql, Long id) {
		ejecutarSql(sql, pst -> {
			try {
				pst.setLong(1, id);
				
				pst.executeUpdate();
				
				return null;
			} catch (SQLException e) {
				throw new AccesoDatosException(ERROR_GENERICO, e);
			}
		});
	}
}