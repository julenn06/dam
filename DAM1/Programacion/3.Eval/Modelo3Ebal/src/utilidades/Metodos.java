package utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Metodos {

	// Método que valida si un String es una fecha válida
	public static boolean esFechaValida(String input, String formato) throws ErrorFecha {
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		sdf.setLenient(false); // Desactivar el modo leniente para evitar fechas como 31/02/2021

		try {
			sdf.parse(input); // Intentamos convertir el input a una fecha
			return true; // Si la conversión es exitosa, es una fecha válida
		} catch (ParseException e) {
			throw new ErrorFecha("Fecha inválida: " + input); // Lanza la excepción personalizada con el mensaje
		}
	}

}
