package basesdedatos;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

public class BasesDeDatos {
	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		
		String url = "jdbc:mysql://localhost:3306/2827_tienda";
		String user = "root";
		String pass = "1234";

		String sqlSelect = "SELECT * FROM productos";
		String sqlSelectId = "SELECT * FROM productos WHERE id=?";
		String sqlInsert = "INSERT INTO productos (nombre, precio, caducidad, descripcion) VALUES (?,?,?,?)";
		
		@SuppressWarnings("unused")
		String sqlUpdate = "UPDATE productos SET nombre=?, precio=?, caducidad=?, descripcion=? WHERE id=?";
		
		@SuppressWarnings("unused")
		String sqlDelete = "DELETE FROM productos WHERE id=?";

		System.out.println("Conectando a la base de datos");

		Connection con = DriverManager.getConnection(url, user, pass);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sqlSelect);

		System.out.println("TODOS");
		System.out.println("=====");
		
		while (rs.next()) {
			System.out.println(rs.getString("id"));
			System.out.println(rs.getString("nombre"));
			System.out.println(rs.getString("precio"));
			System.out.println(rs.getString("caducidad"));
			System.out.println(rs.getString("descripcion"));
		}
		
		System.out.print("Dime el id: ");
		
		String id = sc.nextLine();
		
		PreparedStatement pst = con.prepareStatement(sqlSelectId);
		
		pst.setLong(1, Long.parseLong(id));
		
		rs = pst.executeQuery();
		
		System.out.println("UNO");
		System.out.println("===");
		
		while (rs.next()) {
			System.out.println(rs.getString("id"));
			System.out.println(rs.getString("nombre"));
			System.out.println(rs.getString("precio"));
			System.out.println(rs.getString("caducidad"));
			System.out.println(rs.getString("descripcion"));
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
		
		pst = con.prepareStatement(sqlInsert);
		
		pst.setString(1, nombre);
		pst.setBigDecimal(2, precio);
		pst.setDate(3, java.sql.Date.valueOf(caducidad));
		pst.setString(4, descripcion);
		
		int numeroRegistrosModificados = pst.executeUpdate();
		
		System.out.println(numeroRegistrosModificados);
		
		sc.close();
	}
}
