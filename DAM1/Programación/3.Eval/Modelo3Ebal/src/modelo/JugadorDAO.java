package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class JugadorDAO {

	private static Connection konexioa;

	/*
	 * public EquipoDAO (Connection konexioa) { this.konexioa = konexioa; }
	 */

	public void setConnection(Connection konexioa) {
		JugadorDAO.konexioa = konexioa;
	}

	public ArrayList<Jugador> cargarJugadores() {
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		String consulta = "SELECT * FROM Jugador";
		try {

			PreparedStatement stmt = konexioa.prepareStatement(consulta);
			ResultSet rs = stmt.executeQuery(consulta);
			while (rs.next()) {

				int idJugador = rs.getInt("idJugador");
				String nombreJugador = rs.getString("nombreJugador");
				int dorsal = rs.getInt("dorsal");
				String posicion = rs.getString("posicion");
				int idEquipo = rs.getInt("idEquipo");
				Date fechaFichaje = rs.getDate("fechaFichaje");
				Double sueldoMes = rs.getDouble("sueldoMes");

				Jugador j1 = new Jugador(idJugador, nombreJugador, dorsal, Posicion.valueOf(posicion), idEquipo,
						fechaFichaje, sueldoMes);
				jugadores.add(j1);
			}
		} catch (SQLException e) {
			System.err.println("Errorea agentzien kontsulta exekutatzerakoan: " + e.getMessage());
		}

		return jugadores;
	}

	public void eliminarJugador(String nombreEquipo, String nombreJugador) {
		String consulta = "Delete from Jugador where idEquipo = (Select idEquipo from Equipo where nombreEquipo = ?) and nombreJugador = ?";

		try {

			PreparedStatement stmt = konexioa.prepareStatement(consulta);
			stmt.setString(1, nombreEquipo);
			stmt.setString(2, nombreJugador);
			int rowsAffected = stmt.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Se ha borrado el jugador " + nombreJugador);
			} else {
				System.out.println("Ez da aurkitu Freelancer izen horrekin: " + nombreJugador);
			}
		} catch (SQLException e) {
			System.out.println("Errorea freelancer-a ezabatzerakoan: " + e.getMessage());
		}
	}

	public void crearJugador(Jugador jugador) {
		String consulta = "Insert into Jugador (nombreJugador, dorsal, posicion, idEquipo, fechaFichaje, sueldoMes) Values (?, ?, ?, ?, ?, ?)";

		try {

			PreparedStatement stmt = konexioa.prepareStatement(consulta);
			// Establecer los parámetros
			stmt.setString(1, jugador.getNombre());
			stmt.setInt(2, jugador.getDorsal());
			stmt.setString(3, jugador.getPosicion().name());
			stmt.setInt(4, jugador.getIdEquipo());
			stmt.setDate(5, (java.sql.Date) jugador.getFechaFichaje());
			stmt.setDouble(6, jugador.getSueldoMes());

			stmt.executeUpdate();
			System.out.println("Jokalari berri bat gehitu da: " + jugador.getNombre());
		} catch (SQLException e) {
			System.out.println("Errorea langilea gehitzerakoan: " + e.getMessage());
		}
	}

	public void buscarPorDorsal(int dorsal) {
		String consulta = "Select * from Jugador where dorsal = ?";

		try {
			PreparedStatement stmt = konexioa.prepareStatement(consulta);
			stmt.setInt(1, dorsal);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				// Extraemos los datos del ResultSet
				int idJugador = rs.getInt("idJugador");
				String nombreJugador = rs.getString("nombreJugador");
				int dorsalJugador = rs.getInt("dorsal");
				String posicion = rs.getString("posicion");
				int idEquipo = rs.getInt("idEquipo");
				java.sql.Date fechaFichaje = rs.getDate("fechaFichaje");
				double sueldoMes = rs.getDouble("sueldoMes");

				// Imprimimos los datos en formato legible
				System.out.println("Datos del jugador:");
				System.out.println("ID: " + idJugador);
				System.out.println("Nombre: " + nombreJugador);
				System.out.println("Dorsal: " + dorsalJugador);
				System.out.println("Posición: " + posicion);
				System.out.println("ID Equipo: " + idEquipo);
				System.out.println("Fecha de Fichaje: " + fechaFichaje);
				System.out.println("Sueldo Mensual: " + sueldoMes);
			} else {
				System.out.println("No se encontró ningún jugador con el dorsal " + dorsal);
			}

		} catch (SQLException e) {
			System.out.println("Error al buscar el jugador: " + e.getMessage());
		}
	}

	public Jugador buscarPorDorsalObjeto(int dorsal) {
		String consulta = "SELECT * FROM Jugador WHERE dorsal = ?";
		Jugador jugador = null; // Inicializamos como null por si no encontramos el jugador

		try {
			PreparedStatement stmt = konexioa.prepareStatement(consulta);
			stmt.setInt(1, dorsal);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				// Extraemos los datos del ResultSet
				int idJugador = rs.getInt("idJugador");
				String nombreJugador = rs.getString("nombreJugador");
				String posicion = rs.getString("posicion");
				int idEquipo = rs.getInt("idEquipo");
				java.sql.Date fechaFichaje = rs.getDate("fechaFichaje");
				double sueldoMes = rs.getDouble("sueldoMes");

				// Creamos el objeto Jugador
				jugador = new Jugador(idJugador, nombreJugador, dorsal, Posicion.valueOf(posicion), idEquipo,
						fechaFichaje, sueldoMes);
			} else {
				System.out.println("No se encontró ningún jugador con el dorsal " + dorsal);
			}

		} catch (SQLException e) {
			System.out.println("Error al buscar el jugador: " + e.getMessage());
		}

		return jugador;
	}
}
