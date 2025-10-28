package utilidades;

public class ErrorFecha extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Constructor sin parámetros
	public ErrorFecha() {
		super("La fecha proporcionada no es válida.");
	}

	// Constructor con un mensaje personalizado
	public ErrorFecha(String mensaje) {
		super(mensaje);
	}
}