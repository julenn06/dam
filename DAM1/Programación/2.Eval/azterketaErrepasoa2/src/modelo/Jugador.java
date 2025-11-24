package modelo;

public class Jugador {

	private int dorsal;
	private String nombre;
	private String posición;
	private float sueldo;

	public Jugador(int dorsal, String nombre, String posición, float sueldo) {
		this.dorsal = dorsal;
		this.nombre = nombre;
		this.posición = posición;
		this.sueldo = sueldo;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPosición() {
		return posición;
	}

	public void setPosición(String posición) {
		this.posición = posición;
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	@Override
	public String toString() {
		return dorsal + ";" + nombre + ";" + posición + ";" + sueldo;
	}

}
