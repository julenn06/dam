package modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Jugador extends Entidad implements InterfazJugador {

	protected int dorsal;
	protected Posicion posicion;
	protected int idEquipo;
	protected Date fechaFichaje;
	protected Double sueldoMes;

	public Jugador(String nombre, int dorsal, Posicion posicion, int idEquipo, String fechaFichaje, Double sueldoMes) {
		super(nombre);
		this.dorsal = dorsal;
		this.posicion = posicion;
		this.idEquipo = idEquipo;
		this.sueldoMes = sueldoMes;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Formato esperado de la fecha
			java.util.Date date = sdf.parse(fechaFichaje); // Convertimos a java.util.Date
			this.fechaFichaje = new java.sql.Date(date.getTime()); // Convertimos a java.sql.Date
		} catch (ParseException e) {
			e.printStackTrace();
			this.fechaFichaje = null; // Si hay un error, asignamos null
		}
	}

	public Jugador(int id, String nombre, int dorsal, Posicion posicion, int idEquipo, Date fechaFichaje2,
			Double sueldoMes) {
		super(id, nombre);
		this.dorsal = dorsal;
		this.posicion = posicion;
		this.idEquipo = idEquipo;
		this.fechaFichaje = fechaFichaje2;
		this.sueldoMes = sueldoMes;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	public int getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}

	public Date getFechaFichaje() {
		return fechaFichaje;
	}

	public void setFechaFichaje(Date fechaFichaje) {
		this.fechaFichaje = fechaFichaje;
	}

	public Double getSueldoMes() {
		return sueldoMes;
	}

	public void setSueldoMes(Double sueldoMes) {
		this.sueldoMes = sueldoMes;
	}

	@Override
	public String toString() {
		return "Jugador [id=" + id + ", nombre=" + nombre + ", dorsal=" + dorsal + ", posicion=" + posicion
				+ ", idEquipo=" + idEquipo + ", fechaFichaje=" + fechaFichaje + ", sueldoMes=" + sueldoMes + "]";
	}

	public Double sueldoTotal(Jugador jugador) {

		Double sueldoTotal;

		sueldoTotal = jugador.getSueldoMes() * 12;

		return sueldoTotal;
	}

}
