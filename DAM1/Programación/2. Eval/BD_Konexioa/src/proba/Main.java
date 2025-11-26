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
			kontsultak.mostrarDepartamentos();
			System.out.println();

			kontsultak.mostrarEmpleadosDepartamento10();
			System.out.println();

			kontsultak.mostrarEmpleadoSalarioMasAlto();
			System.out.println();

			kontsultak.insertarEmpleado(1001, "PEREZ", "VENDEDOR", 7698, "1991-12-03", 1500, null, 30);
			System.out.println();

			kontsultak.actualizarSalarioEmpleado(1001, 1700);
			System.out.println();

			kontsultak.eliminarEmpleado(1001);
			System.out.println();
		} else {
			System.out.println("No se pudo establecer la conexión con la base de datos.");
		}

		System.out.println();

		// Desconectar de la base de datos
		dbConnection.disconnect();
	}
}
