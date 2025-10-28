package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EquipoDAO {

	private static Connection konexioa;

	/*
	 * public EquipoDAO (Connection konexioa) { this.konexioa = konexioa; }
	 */

	public void setConnection(Connection konexioa) {
		EquipoDAO.konexioa = konexioa;
	}

	public ArrayList<Equipo> cargarEquipos() {
		ArrayList<Equipo> equipos = new ArrayList<Equipo>();
		String consulta = "SELECT * FROM Equipo";
		try {

			PreparedStatement stmt = konexioa.prepareStatement(consulta);
			ResultSet rs = stmt.executeQuery(consulta);
			while (rs.next()) {

				int idEquipo = rs.getInt("idEquipo");
				String nombreEquipo = rs.getString("nombreEquipo");
				String ciudad = rs.getString("ciudad");
				String estadio = rs.getString("estadio");
				int fundacion = rs.getInt("fundacion");

				Equipo equipo = new Equipo(idEquipo, nombreEquipo, ciudad, estadio, fundacion);
				equipos.add(equipo);
			}
		} catch (SQLException e) {
			System.err.println("Errorea agentzien kontsulta exekutatzerakoan: " + e.getMessage());
		}

		return equipos;
	}

	public void crearEquipo(Equipo equipo) {
		String consulta = "Insert into Equipo (nombreEquipo, ciudad, estadio, fundacion) Values (?, ?, ?, ?)";

		try {

			PreparedStatement stmt = konexioa.prepareStatement(consulta);
			// Establecer los parámetros
			stmt.setString(1, equipo.getNombre());
			stmt.setString(2, equipo.getCiudad());
			stmt.setString(3, equipo.getEstadio());
			stmt.setInt(4, equipo.getFundacion());

			stmt.executeUpdate();
			System.out.println("Freelancer berri bat gehitu da: " + equipo.getNombre());
		} catch (SQLException e) {
			System.out.println("Errorea langilea gehitzerakoan: " + e.getMessage());
		}
	}

	public void eliminarEquipo(String equipoBorrar) {
		String consulta = "Delete from Equipo where idEquipo = (Select idEquipo from Equipo where nombreEquipo = ?)";

		try {

			PreparedStatement stmt = konexioa.prepareStatement(consulta);
			stmt.setString(1, equipoBorrar);
			int rowsAffected = stmt.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Freelancer ezabatu da: " + equipoBorrar);
			} else {
				System.out.println("Ez da aurkitu Freelancer izen horrekin: " + equipoBorrar);
			}
		} catch (SQLException e) {
			System.out.println("Errorea freelancer-a ezabatzerakoan: " + e.getMessage());
		}
	}

}
