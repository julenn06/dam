package utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private static final String URL = "jdbc:mysql://localhost:3306/db_liga";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	public Connection conn;

	public void conectar() {
		try {
			if (conn == null || conn.isClosed()) {
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				System.out.println("Conectado con éxito");
			}
		} catch (SQLException e) {
			System.err.println("Error al conectad a la BBDD: " + e.getMessage());
		}
	}

	public Connection getConnection() {
		if (conn == null) {
			System.err.println("No se ha seteado la conexión");
		}
		return conn;
	}

	public void disconnect() {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
				System.out.println("Conexión cerrada exitosamente.");
			}
		} catch (SQLException e) {
			System.err.println("Error al cerrar la conexión: " + e.getMessage());
		}
	}

	public boolean isConnected() {
		try {
			return conn != null && !conn.isClosed();
		} catch (SQLException e) {
			System.err.println("Error al verificar la conexión: " + e.getMessage());
			return false;
		}
	}

}
