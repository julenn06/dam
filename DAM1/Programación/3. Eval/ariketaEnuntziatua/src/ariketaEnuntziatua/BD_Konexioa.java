package ariketaEnuntziatua;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BD_Konexioa {
	private static final String URL = "jdbc:mysql://localhost:3307/ariketaenuntziatua";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	private Connection konexioa;

	public void conectar() {
		try {
			if (konexioa == null || konexioa.isClosed()) {
				konexioa = DriverManager.getConnection(URL, USER, PASSWORD);
				System.out.println("Konexioa Egokia Datu Basearekin.");
			}
		} catch (SQLException e) {
			System.err.println("Errorea datu Basearekin Konektatzean: " + e.getMessage());
		}
	}

	public Connection getConnection() {
		if (konexioa == null) {
			System.err.println("Konexioa ez da Hasi, deitu conectar() lehenago");
		}
		return konexioa;
	}

	public void disconnect() {
		try {
			if (konexioa != null && !konexioa.isClosed()) {
				konexioa.close();
				System.out.println("Konexioa itxita era Egokian.");
			}
		} catch (SQLException e) {
			System.err.println("Errorea Konexioa Ixtean: " + e.getMessage());
		}
	}
}