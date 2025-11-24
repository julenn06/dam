package ariketa;

class Canario extends Aves {
	private String color;

	public Canario(String nombre, int edad, String estado, String fechaNacimiento, String pico, boolean vuela,
			String color) {
		super(nombre, edad, estado, fechaNacimiento, pico, vuela);
		this.color = color;
	}

	public void muestra() {
		System.out.println("Canario: " + nombre + ", Color: " + color);
	}

	public void habla() {
		System.out.println(nombre + " dice: Pio Pio");
	}

	public void volar() {
		if (vuela) {
			System.out.println(nombre + " puede volar");
		} else {
			System.out.println(nombre + " no puede volar");
		}
	}

}