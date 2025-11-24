package proba1;

public class Futbolista {
	private String nombre;
	private int edad;

	public Futbolista(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;

	}

	public Futbolista(String nombre, Futbolista[] f) {
		boolean aurkituta = false;

		for (Futbolista futbolista : f) {
			if (futbolista != null && futbolista.getNombre().equalsIgnoreCase(nombre)) {
				this.nombre = futbolista.getNombre();
				this.edad = futbolista.getEdad();

				aurkituta = true;
				break;
			}
		}

		if (!aurkituta) { // Ez badu ezer aurkitu defektuzko datuak jarriko ditu
			this.nombre = nombre;
			this.edad = 18;

		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void ikusiJokalariak() {
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		return nombre + ";" + edad + ";";
	}
}