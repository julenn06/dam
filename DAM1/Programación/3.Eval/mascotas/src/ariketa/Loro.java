package ariketa;

class Loro extends Aves {
	private String origen;

	public Loro(String nombre, int edad, String estado, String fechaNacimiento, String pico, boolean vuela,
			String origen) {
		super(nombre, edad, estado, fechaNacimiento, pico, vuela);
		this.origen = origen;
	}

	public void muestra() {
		System.out.println("Loro: " + nombre + ", Origen: " + origen);
	}

	public void habla() {
		System.out.println(nombre + " dice: Holaa");
	}

	public void volar() {
		if (vuela) {
			System.out.println(nombre + " puede volar");
		} else {
			System.out.println(nombre + " no puede volar");
		}
	}

}