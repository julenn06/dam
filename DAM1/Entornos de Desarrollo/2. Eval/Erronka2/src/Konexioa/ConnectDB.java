package Konexioa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static final String URL = "jdbc:mysql://localhost:3307/db_bidaiak"; // Cambia los valores según tu configuración
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

/*package Konexioa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

    // Datos de la conexión
    private static final String URL = "jdbc:mysql://localhost:3306/db_bidaiak";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";
    private Connection konexioa;

    // Método para obtener la conexión
    public static Connection conectar() {
        try {
           
        	if (konexioa == null || konexioa.isC)
            // Establecer la con exión
            konexioa = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error en la conexión: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador JDBC: " + e.getMessage());
        }
        return konexioa;
    }

    // Método principal para probar la conexión
    public static void main(String[] args) {
        Connection conexion = conectar();
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexión cerrada correctamente.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}*/
