package proba;

public class Main {

	public static void main(String[] args) {
		BD_Konexioa dbConnection = new BD_Konexioa(); // Instancia de conexión a la base de datos
		Kontsultak kontsultak = new Kontsultak(); // Instancia para realizar consultas

		// Conectar a la base de datos
		dbConnection.connect();

		// Verificar si la conexión está activa
		if (dbConnection.isConnected()) {
			System.out.println("La conexión está activa.");
			System.out.println();

			// Pasar la conexión a la clase Kontsultak
			kontsultak.setConnection(dbConnection.getConnection());

			// Llamar a los métodos de consulta
			kontsultak.cargarBD();
			System.out.println();

		} else {
			System.out.println("No se pudo establecer la conexión con la base de datos.");
		}

		System.out.println();

		// Desconectar de la base de datos
		dbConnection.disconnect();
	}
}
