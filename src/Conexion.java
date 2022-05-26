import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class conexion {

	Connection conexion = null;

	private static final String URL = "jdbc:mysql://localhost:3306/tfg";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";

	public Connection conectarSQL() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Conexion Establecida");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error de Conexion" + e.getMessage());
		}
		return conexion;
	}
}
