package basesdedatos;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

public class BasesDeDatos {
	public static void main(String[] args) throws SQLException {
//		ejemploCompleto(); // NOSONAR
		ejemploResultSetMetaData();
	}
	
	public static void ejemploResultSetMetaData() throws SQLException {
		String url = System.getenv("JDBC_URL");
		String user = System.getenv("JDBC_USER");
		String pass = System.getenv("JDBC_PASS");
		
		Connection con = DriverManager.getConnection(url, user, pass); // NOSONAR
		Statement st = con.createStatement();  // NOSONAR
		ResultSet rs = st.executeQuery("SELECT c.nombre AS c_nombre FROM categorias AS c");
		
		ResultSetMetaData rsmd = rs.getMetaData();
		
		System.out.println(rsmd.getSchemaName(1));
		System.out.println(rsmd.getCatalogName(1));
		System.out.println(rsmd.getTableName(1));
		
		for(int i = 1; i <= rsmd.getColumnCount(); i++) {
			System.out.print(rsmd.getColumnName(i) + " ");
			System.out.println(rsmd.getColumnLabel(i) + " ");
		}
		
		rs.next();
		
		System.out.println(rs.getString("c_nombre"));
	}
	
	public static void ejemploCompleto() throws ClassNotFoundException {
		Scanner sc = new Scanner(System.in);

		String url = System.getenv("JDBC_URL");
		String user = System.getenv("JDBC_USER");
		String pass = System.getenv("JDBC_PASS");

		System.out.println(user);
		System.out.println(pass);
		
		String sqlSelect = "SELECT id, nombre, precio, caducidad, descripcion FROM productos";
		String sqlSelectId = sqlSelect + " WHERE id=?";
		String sqlInsert = "INSERT INTO productos (nombre, precio, caducidad, descripcion) VALUES (?,?,?,?)";

		@SuppressWarnings("unused")
		String sqlUpdate = "UPDATE productos SET nombre=?, precio=?, caducidad=?, descripcion=? WHERE id=?";

		@SuppressWarnings("unused")
		String sqlDelete = "DELETE FROM productos WHERE id=?";

		System.out.println("Conectando a la base de datos");

		Class.forName(System.getenv("JDBC_DRIVER"));

		int numeroRegistrosModificados = 0;

		try (Connection con = DriverManager.getConnection(url, user, pass)) {
			try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sqlSelect);) {

				System.out.println("TODOS");
				System.out.println("=====");

				while (rs.next()) {
					System.out.println(rs.getLong("id"));
					System.out.println(rs.getString("nombre"));
					System.out.println(rs.getBigDecimal("precio"));
					System.out.println(rs.getDate("caducidad"));
					System.out.println(rs.getString("descripcion"));
				}
			}

			System.out.print("Dime el id: ");

			String id = sc.nextLine();

			try (PreparedStatement pst = con.prepareStatement(sqlSelectId)) {
				pst.setLong(1, Long.parseLong(id));

				ResultSet rs = pst.executeQuery();

				System.out.println("UNO");
				System.out.println("===");

				while (rs.next()) {
					System.out.println(rs.getLong("id"));
					System.out.println(rs.getString("nombre"));
					System.out.println(rs.getBigDecimal("precio"));
					System.out.println(rs.getDate("caducidad"));
					System.out.println(rs.getString("descripcion"));
				}

			}

			System.out.println("INSERTAR");
			System.out.println("========");

			System.out.print("Nombre: ");
			String nombre = sc.nextLine();

			System.out.print("Precio: ");
			BigDecimal precio = new BigDecimal(sc.nextLine());

			System.out.print("Caducidad: ");
			LocalDate caducidad = LocalDate.parse(sc.nextLine());

			System.out.print("Descripción: ");
			String descripcion = sc.nextLine();

			try (PreparedStatement pst = con.prepareStatement(sqlInsert)) {
				pst.setString(1, nombre);
				pst.setBigDecimal(2, precio);
				pst.setDate(3, java.sql.Date.valueOf(caducidad));
				pst.setString(4, descripcion);

				numeroRegistrosModificados = pst.executeUpdate();
			}
		} catch (NumberFormatException | SQLException e) {
			System.out.println("Ha habido un error en la conexión a la base de datos");
			e.printStackTrace();
		}

		System.out.println(numeroRegistrosModificados);

		sc.close();
	}
}
