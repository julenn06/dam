package ariketa;

class Gato extends Mascotas {
	private String color;
	private boolean peloLargo;

	public Gato(String nombre, int edad, String estado, String fechaNacimiento, String color, boolean peloLargo) {
		super(nombre, edad, estado, fechaNacimiento);
		this.color = color;
		this.peloLargo = peloLargo;
	}

	public void muestra() {
		System.out.print("Gato: " + nombre + ", Color: " + color + ", Pelo Largo: ");
		if (peloLargo) {
			System.out.println("Si");
		} else {
			System.out.println("No");
		}
	}

	public void habla() {
		System.out.println(nombre + " dice: Miau Miau");
	}
}