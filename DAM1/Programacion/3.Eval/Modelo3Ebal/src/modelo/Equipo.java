package modelo;

public class Equipo extends Entidad {

	protected String ciudad;
	protected String estadio;
	protected int fundacion;

	public Equipo(int id, String nombre, String ciudad, String estadio, int fundacion) {
		super(id, nombre);
		this.ciudad = ciudad;
		this.estadio = estadio;
		this.fundacion = fundacion;
	}

	public Equipo(String nombre, String ciudad, String estadio, int fundacion) {
		super(nombre);
		this.ciudad = ciudad;
		this.estadio = estadio;
		this.fundacion = fundacion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEstadio() {
		return estadio;
	}

	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}

	public int getFundacion() {
		return fundacion;
	}

	public void setFundacion(int fundacion) {
		this.fundacion = fundacion;
	}

	@Override
	public String toString() {
		return "Equipo [id=" + id + ", nombre=" + nombre + ", ciudad=" + ciudad + ", estadio=" + estadio
				+ ", fundacion=" + fundacion + "]";
	}

}
