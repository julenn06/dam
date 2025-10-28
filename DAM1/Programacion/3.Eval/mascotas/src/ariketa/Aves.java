package ariketa;

abstract class Aves extends Mascotas {
	protected String pico;
	protected boolean vuela;

	public Aves(String nombre, int edad, String estado, String fechaNacimiento, String pico, boolean vuela) {
		super(nombre, edad, estado, fechaNacimiento);
		this.pico = pico;
		this.vuela = vuela;
	}

	public abstract void volar();
}