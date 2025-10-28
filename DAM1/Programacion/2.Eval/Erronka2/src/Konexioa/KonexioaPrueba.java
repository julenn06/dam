package Konexioa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KonexioaPrueba {
    private static final String URL = "jdbc:mysql://localhost:3307/prueba"; // Cambia los valores según tu configuración
    private static final String USER = "root"; // Usuario de tu base de datos
    private static final String PASSWORD = ""; // Contraseña de tu base de datos
    private Connection konexioa; // Conexión a la base de datos

    // Método para conectar a la base de datos
    public void conectar() {
        try {
            if (konexioa == null || konexioa.isClosed()) {
            	konexioa = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conexión exitosa a la base de datos.");
            }
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    // Método para obtener la conexión
    public Connection getConnection() {
        if (konexioa == null) {
            System.err.println("La conexión no está establecida. Llama a connect() primero.");
        }
        return konexioa;
    }

    // Método para desconectar de la base de datos
    public void disconnect() {
        try {
            if (konexioa != null && !konexioa.isClosed()) {
            	konexioa.close();
                System.out.println("Conexión cerrada correctamente.");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
    
    // Método para verificar si la conexión está activa
    public boolean isConnected() {
        try {
            return konexioa != null && !konexioa.isClosed();
        } catch (SQLException e) {
            System.err.println("Error al verificar la conexión: " + e.getMessage());
            return false;
        }
    }
    
    }