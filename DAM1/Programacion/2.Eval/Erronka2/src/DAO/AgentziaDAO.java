package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modeloa.Agentzia;

public class AgentziaDAO {

	private static Connection konexioa;

	public void setConnection(Connection konexioa) {
		AgentziaDAO.konexioa = konexioa;
	}

	// Metodo honek agentzia guztiak lortzen ditu datu-basean dauden agentzia
	// guztiak eskuratuz.
	// Query bat exekutatzen du agentzia taulako zutabe guztiak aukeratzeko.
	// Behin emaitzak jasota, agentzia bakoitza Agentzia objektu bat bihurtzen da
	// eta ArrayList batean gorde egiten da. Azkenik, ArrayList hori itzultzen da.
	public ArrayList<Agentzia> lortuAgentziaGuztiak() {
		ArrayList<Agentzia> agentziak = new ArrayList<>();
		String kontsulta = "SELECT IDAgentzia, izenaAgentzia, logoa, kolorea, Erabiltzaile, Pasahitza, kodAgMota, kodLangKop FROM agentzia";
		try (Statement stmt = konexioa.createStatement(); ResultSet rs = stmt.executeQuery(kontsulta)) {
			while (rs.next()) {
				int idAgentzia = rs.getInt("IDAgentzia");
				String izenaAgentzia = rs.getString("izenaAgentzia");
				String logoAgentzia = rs.getString("logoa");
				String koloreAgentzia = rs.getString("kolorea");
				String erabiltzailea = rs.getString("Erabiltzaile");
				String pasahitza = rs.getString("Pasahitza");
				String kodAgentzia = rs.getString("kodAgMota");
				String kodLangKop = rs.getString("kodLangKop");
				Agentzia agentzia = new Agentzia(idAgentzia, izenaAgentzia, logoAgentzia, koloreAgentzia, erabiltzailea,
						pasahitza, kodAgentzia, kodLangKop, null);
				agentziak.add(agentzia);
			}
		} catch (SQLException e) {
			System.err.println("Errorea agentzien kontsulta exekutatzerakoan: " + e.getMessage());
		}

		return agentziak;
	}

	// Metodo honek datu-basean zein erabiltzaile dagoen bilatzen du.
	// Erabiltzailea parametro gisa jasotzen du eta query bat exekutatzen du
	// 'agentzia' taulako 'Erabiltzaile' zutabean bilatzeko. Erabiltzailea aurkitzen
	// badu, haren izena itzultzen du, bestela null itzultzen du.
	public String lortuErabiltzailea(String erabiltzailea) {

		String sql = "SELECT Erabiltzaile FROM agentzia WHERE Erabiltzaile = ?";

		try (PreparedStatement ps = konexioa.prepareStatement(sql)) {
			ps.setString(1, erabiltzailea);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return rs.getString("Erabiltzaile");
			} else {
				return null;
			}

		} catch (SQLException e) {
			System.err.println("Error al consultar la base de datos: " + e.getMessage());
			return null;
		}
	}

	// Metodo honek datu-basean pasahitza bilatzen du erabiltzailea emanda.
	// Erabiltzailea aurkitu ez bada, null itzultzen du.
	public String lortuPasahitza(String erabiltzailea) {

		String sql = "SELECT Erabiltzaile, Pasahitza FROM agentzia WHERE Erabiltzaile = ?";

		try (PreparedStatement ps = konexioa.prepareStatement(sql)) {
			ps.setString(1, erabiltzailea);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return rs.getString("Pasahitza");
			} else {
				return null;
			}

		} catch (SQLException e) {
			System.err.println("Error al consultar la base de datos: " + e.getMessage());
			return null;
		}
	}

	// Metodo honek erabiltzailearen ID-a bilatzen du agentzia taulan.
	// Datu-basean erabiltzailea badago, haren ID-a itzultzen du,
	// bestela -1 itzultzen du.
	public int lortuID(String erabiltzailea) {

		String sql = "SELECT IDAgentzia FROM agentzia WHERE Erabiltzaile = ?";

		try (PreparedStatement ps = konexioa.prepareStatement(sql)) {
			ps.setString(1, erabiltzailea);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return rs.getInt("IDAgentzia");
			} else {
				return -1;
			}

		} catch (SQLException e) {
			System.err.println("Error al consultar la base de datos: " + e.getMessage());
			return -1;
		}
	}

	// Metodo honek agentzia berri bat datu-basean sartzen du.
	// Parametro gisa jasotako Agentzia objektua erabiliz, INSERT query bat
	// exekutatzen du, agentzia informazioa datu-basean gorde ahal izateko.
	// Inserzioa egin bada, true itzultzen du, bestela false.
	public boolean sartuAgentzia(Agentzia agentzia) {
		String sql = "INSERT INTO Agentzia (izenaAgentzia, logoa, kolorea, Pasahitza, Erabiltzaile, kodAgMota, kodLangKop) "
				+ "VALUES ('" + agentzia.getIzena() + "', '" + agentzia.getLogoa() + "', '" + agentzia.getMarkaKolorea()
				+ "', '" + agentzia.getPasahitza() + "', '" + agentzia.getErabiltzaile() + "', '"
				+ agentzia.getAgentziaMota() + "', '" + agentzia.getLangileKopurua() + "');";

		try (Statement stmt = konexioa.createStatement()) {
			int filasAfectadas = stmt.executeUpdate(sql);

			return filasAfectadas > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error al insertar Agentzia: " + e.getMessage());
			return false;
		}

	}
}
