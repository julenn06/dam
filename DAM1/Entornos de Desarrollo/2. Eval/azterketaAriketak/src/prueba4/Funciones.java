package prueba4;

public class Funciones {

	// Comparar las edades y devuelve la diferencia en días
	public int compararEdad(Personas persona1, Personas persona2) {
		if (persona1 == null || persona2 == null) {
			return -1;
		}
		return Math.abs(persona1.getEdad() - persona2.getEdad());
	}

	// Verifica si dos personas tienen el mismo nombre y apellido
	public boolean tieneMismoNombreYApellido(Personas persona1, Personas persona2) {
		if (persona1 == null || persona2 == null) {
			return false;
		}
		return persona1.getNombre().equals(persona2.getNombre())
				&& persona1.getApellido().equals(persona2.getApellido());
	}

	// Verifica si la persona1 es mayor de edad que la persona2
	public boolean esMayorQue(Personas persona1, Personas persona2) {
		if (persona1 == null || persona2 == null) {
			return false;
		}
		return persona1.getEdad() > persona2.getEdad();
	}

	// Genera un saludo personalizado para otra persona
	public String[] generarSaludoParaOtraPersona(Personas persona1, Personas persona2) {
		if (persona1 == null || persona2 == null) {
			return new String[] { "Error: persona no válida" };
		}

		String saludo = "¡Hola, " + persona2.getNombre() + " " + persona2.getApellido() + "!";
		return new String[] { saludo };
	}

	// Verifica si la persona2 es mayor de edad
	public boolean esMayorDeEdad(Personas persona2) {
		if (persona2 == null) {
			return false;
		}
		return persona2.getEdad() >= 18;
	}

	// Compara las edades de dos personas y retorna la mayor edad
	public int obtenerEdadMayor(Personas persona1, Personas persona2) {
		if (persona1 == null || persona2 == null) {
			return -1;
		}
		return Math.max(persona1.getEdad(), persona2.getEdad());
	}

	// Concatena el nombre de persona1 con el nombre de persona2
	public String[] concatenarNombres(Personas persona1, Personas persona2) {
		if (persona1 == null || persona2 == null) {
			return new String[] { "Error: persona no válida" };
		}
		String nombresConcatenados = persona1.getNombre() + " " + persona2.getNombre();
		return new String[] { nombresConcatenados };
	}

	// Verifica si persona1 tiene el mismo nombre que persona2
	public boolean tieneMismoNombre(Personas persona1, Personas persona2) {
		if (persona1 == null || persona2 == null) {
			return false;
		}
		return persona1.getNombre().equals(persona2.getNombre());
	}

}