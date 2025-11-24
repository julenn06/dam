package Kontroladorea;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Konexioa {

	private static final String URL = "jdbc:mysql://localhost:3306/db_kudeaketa";
	private static final String USER = "root"; // Cambia esto con tu usuario
	private static final String PASSWORD = ""; // Cambia esto con tu contraseña

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
