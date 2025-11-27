package modelo;

public abstract class Entidad {

	protected int id;
	protected String nombre;

	public Entidad(String nombre) {
		this.nombre = nombre;
	}

	public Entidad(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
