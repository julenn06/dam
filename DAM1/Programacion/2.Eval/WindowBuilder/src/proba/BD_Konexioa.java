package proba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BD_Konexioa {
	private static final String URL = "jdbc:mysql://localhost:3307/db_progprueba"; // Cambia los valores según tu configuración
	private static final String USER = "root"; // Usuario de tu base de datos
	private static final String PASSWORD = ""; // Contraseña de tu base de datos
	private Connection connection; // Conexión a la base de datos

	// Método para conectar a la base de datos
	public void connect() {
		try {
			if (connection == null || connection.isClosed()) {
				connection = DriverManager.getConnection(URL, USER, PASSWORD);
				System.out.println("Conexión exitosa a la base de datos.");
			}
		} catch (SQLException e) {
			System.err.println("Error al conectar a la base de datos: " + e.getMessage());
		}
	}

	// Método para obtener la conexión
	public Connection getConnection() {
		if (connection == null) {
			System.err.println("La conexión no está establecida. Llama a connect() primero.");
		}
		return connection;
	}

	// Método para desconectar de la base de datos
	public void disconnect() {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
				System.out.println("Conexión cerrada correctamente.");
			}
		} catch (SQLException e) {
			System.err.println("Error al cerrar la conexión: " + e.getMessage());
		}
	}

	// Método para verificar si la conexión está activa
	public boolean isConnected() {
		try {
			return connection != null && !connection.isClosed();
		} catch (SQLException e) {
			System.err.println("Error al verificar la conexión: " + e.getMessage());
			return false;
		}
	}
}
