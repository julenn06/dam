package azterketaTxuleta;

public abstract class Personas {
	protected String nombre;
	protected String apellido;
	protected int edad;
	protected int aula;

	public Personas(String nombre, String apellido, int edad, int aula) throws AdinaBalidatu {
		this.nombre = nombre;
		this.apellido = apellido;
		if (edad < 18) {
			throw new AdinaBalidatu("Adin nagusia izan behar da");
		} else {
			this.edad = edad;
		}
		this.aula = aula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getAula() {
		return aula;
	}

	public void setAula(int aula) {
		this.aula = aula;
	}

	public abstract String getHorario();
}
