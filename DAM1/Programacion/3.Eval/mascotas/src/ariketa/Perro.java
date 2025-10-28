package ariketa;

class Perro extends Mascotas {
	private String raza;
	private boolean pulgas;

	public Perro(String nombre, int edad, String estado, String fechaNacimiento, String raza, boolean pulgas) {
		super(nombre, edad, estado, fechaNacimiento);
		this.raza = raza;
		this.pulgas = pulgas;
	}

	public void muestra() {
		System.out.print("Perro: " + nombre + ", Raza: " + raza + ", Pulgas: ");
		if (pulgas) {
			System.out.println("Si");
		} else {
			System.out.println("No");
		}
	}

	public void habla() {
		System.out.println(nombre + " dice: Guau Guau");
	}
}