package DAO;

import java.sql.*;
import java.util.ArrayList;

import Konexioa.ConnectDB;
import modeloa.*;

public class HerrialdeaDAO {

	private static Connection konexioa;
	ConnectDB conexion = new ConnectDB();

	public void setConnection(Connection konexioa) {
		HerrialdeaDAO.konexioa = konexioa;
	}

	// Metodo honek herrialde guztiak datu-basean kontsultatuz lortzen ditu.
	// 'Herrialdea' taulatik 'kodHerrialdea' eta 'deskribapena' eskuratuz,
	// 'Herrialdea' objektu berri bat sortzen da eta ArrayList batean gorde egiten
	// da. Azkenik, ArrayList hori itzultzen da.
	public ArrayList<Herrialdea> lortuHerrialdeGuztiak() {
		ArrayList<Herrialdea> herrialdeak = new ArrayList<>();
		String sql = "SELECT kodHerrialdea, deskribapena FROM Herrialdea";

		try (Statement stmt = konexioa.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				String kodea = rs.getString("kodHerrialdea");
				String deskribapena = rs.getString("deskribapena");
				Herrialdea herrialdea = new Herrialdea(kodea, deskribapena);
				herrialdeak.add(herrialdea);
			}
		} catch (SQLException e) {
			System.err.println("Errorea herrialdeak kontsultatzerakoan: " + e.getMessage());
		}
		return herrialdeak;
	}

	// Metodo honek 'herrialdea' parametroa hartzen du eta 'Herrialdea' taulatik
	// 'kodHerrialdea' eskuratzea egiten du. SQL kontsultaren bidez, herrialdearen
	// kodea bilatzen du eta itzultzen du.
	public String lortuID(String herrialdea) {
		String sql = "SELECT kodHerrialdea, deskribapena FROM Herrialdea";
		String herrialdeKodea = "";

		try (Statement stmt = konexioa.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				if (herrialdea.equals(rs.getString("deskribapena"))) {
					herrialdeKodea = rs.getString("kodHerrialdea");
				}
			}
		} catch (SQLException z) {
			System.err.println("Errorea herrialdea berreskuratzen: " + z.getMessage());
		}

		return herrialdeKodea;
	}
}
