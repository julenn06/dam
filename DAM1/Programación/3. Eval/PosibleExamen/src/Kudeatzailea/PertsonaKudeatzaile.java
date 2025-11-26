package Kudeatzailea;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Kontroladorea.Konexioa;
import Modeloa.Freelancer;
import Modeloa.Langilea;
import Modeloa.Pertsona;

public class PertsonaKudeatzaile {

	public ArrayList<Pertsona> getAllPertsonak() {
		ArrayList<Pertsona> pertsonaList = new ArrayList<>();
		String queryLangileak = "SELECT * FROM Langileak";
		String queryFreelancerak = "SELECT * FROM Freelancerak";

		try (Connection conn = Konexioa.getConnection(); Statement stmt = conn.createStatement()) {

			// Obtener Langileak
			ResultSet rsLangileak = stmt.executeQuery(queryLangileak);
			while (rsLangileak.next()) {
				int id = rsLangileak.getInt("id");
				String izena = rsLangileak.getString("izena");
				int adina = rsLangileak.getInt("adina");
				String kargua = rsLangileak.getString("kargua");
				double oinarrizkoSoltada = rsLangileak.getDouble("oinarrizkoSoltada");
				int antzinatasuna = rsLangileak.getInt("antzinatasuna");

				Langilea langile = new Langilea(id, izena, adina, kargua, oinarrizkoSoltada, antzinatasuna);
				pertsonaList.add(langile);
			}

			// Obtener Freelancerak
			ResultSet rsFreelancerak = stmt.executeQuery(queryFreelancerak);
			while (rsFreelancerak.next()) {
				int id = rsFreelancerak.getInt("id");
				String izena = rsFreelancerak.getString("izena");
				int adina = rsFreelancerak.getInt("adina");
				double lanorduak = rsFreelancerak.getDouble("lanorduak");
				double ordainsariaOrduko = rsFreelancerak.getDouble("ordainsariaOrduko");

				Freelancer freelancer = new Freelancer(id, izena, adina, lanorduak, ordainsariaOrduko);
				pertsonaList.add(freelancer);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pertsonaList;
	}

	public void deleteLangileak(String izena) {
		String query = "DELETE FROM Langileak WHERE izena = ?";

		try (Connection conn = Konexioa.getConnection();

				PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, izena);
			int rowsAffected = stmt.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Langile ezabatu da: " + izena);
			} else {
				System.out.println("Ez da aurkitu Langile izen horrekin: " + izena);
			}
		} catch (SQLException e) {
			System.out.println("Errorea langilea ezabatzerakoan: " + e.getMessage());
		}
	}

	public void deleteFreelancerak(String izena) {
		String query = "DELETE FROM Freelancerak WHERE izena = ?";

		try (Connection conn = Konexioa.getConnection();

				PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, izena);
			int rowsAffected = stmt.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Freelancer ezabatu da: " + izena);
			} else {
				System.out.println("Ez da aurkitu Freelancer izen horrekin: " + izena);
			}
		} catch (SQLException e) {
			System.out.println("Errorea freelancer-a ezabatzerakoan: " + e.getMessage());
		}
	}

	public void insertLangileak(Langilea langile) {
		String query = "INSERT INTO Langileak (izena, adina, kargua, oinarrizkoSoltada, antzinatasuna) VALUES (?, ?, ?, ?, ?)";

		try (Connection conn = Konexioa.getConnection();

				PreparedStatement stmt = conn.prepareStatement(query)) {
			// Establecer los parámetros
			stmt.setString(1, langile.getIzena());
			stmt.setInt(2, langile.getAdina());
			stmt.setString(3, langile.getKargua());
			stmt.setDouble(4, langile.getOinarrizkoSoldata());
			stmt.setInt(5, langile.getAntzinatasuna());

			// Ejecutar la sentencia SQL
			stmt.executeUpdate();
			System.out.println("Langile berri bat gehitu da: " + langile.getIzena());
		} catch (SQLException e) {
			System.out.println("Errorea langilea gehitzerakoan: " + e.getMessage());
		}
	}

	public void insertFreelancer(Freelancer freelancer) {
		String query = "INSERT INTO freelancerak (izena, adina, lanorduak, ordainsariaOrduko) VALUES (?, ?, ?, ?)";

		try (Connection conn = Konexioa.getConnection();

				PreparedStatement stmt = conn.prepareStatement(query)) {
			// Establecer los parámetros
			stmt.setString(1, freelancer.getIzena());
			stmt.setInt(2, freelancer.getAdina());
			stmt.setDouble(3, freelancer.getLanorduak());
			stmt.setDouble(4, freelancer.getOrdainsariaOrduko());

			// Ejecutar la sentencia SQL
			stmt.executeUpdate();
			System.out.println("Freelancer berri bat gehitu da: " + freelancer.getIzena());
		} catch (SQLException e) {
			System.out.println("Errorea langilea gehitzerakoan: " + e.getMessage());
		}
	}

	public void eguneratuIzena(int id, String izenaBerria) {

		String query = "UPDATE Langileak SET izena = ? WHERE id = ?";

		try (Connection conn = Konexioa.getConnection();

				PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, izenaBerria);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			System.out.println("Langilearen izena eguneratu da");
		} catch (SQLException e) {
			System.out.println("Errorea langilea eguneratzen: " + e.getMessage());
		}
	}

	public void eguneratuAdina(int id, int adinaBerria) {

		String query = "UPDATE Langileak SET adina = ? WHERE id = ?";

		try (Connection conn = Konexioa.getConnection();

				PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, adinaBerria);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			System.out.println("Langilearen adina eguneratu da");
		} catch (SQLException e) {
			System.out.println("Errorea langilea eguneratzen: " + e.getMessage());
		}
	}

	public void eguneratuKargua(int id, String karguBerria) {

		String query = "UPDATE Langileak SET kargua = ? WHERE id = ?";

		try (Connection conn = Konexioa.getConnection();

				PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, karguBerria);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			System.out.println("Langilearen kargua eguneratu da");
		} catch (SQLException e) {
			System.out.println("Errorea langilea eguneratzen: " + e.getMessage());
		}
	}

	public void eguneratuSoldata(int id, Double soldataBerria) {

		String query = "UPDATE Langileak SET oinarrizkoSoltada = ? WHERE id = ?";

		try (Connection conn = Konexioa.getConnection();

				PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setDouble(1, soldataBerria);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			System.out.println("Langilearen oinarrizko soldata eguneratu da");
		} catch (SQLException e) {
			System.out.println("Errorea langilea eguneratzen: " + e.getMessage());
		}
	}

	public void eguneratuAntzinatasuna(int id, int antzinatasunaBerria) {

		String query = "UPDATE Langileak SET oinarrizkoSoltada = ? WHERE id = ?";

		try (Connection conn = Konexioa.getConnection();

				PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, antzinatasunaBerria);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			System.out.println("Langilearen antzinatasuna eguneratu da");
		} catch (SQLException e) {
			System.out.println("Errorea langilea eguneratzen: " + e.getMessage());
		}
	}

	public void eguneratuFIzena(int id, String izenaBerria) {

		String query = "UPDATE Freelancerak SET izena = ? WHERE id = ?";

		try (Connection conn = Konexioa.getConnection();

				PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, izenaBerria);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			System.out.println("Freelancer-aren izena eguneratu da");
		} catch (SQLException e) {
			System.out.println("Errorea Freelancer-a eguneratzen: " + e.getMessage());
		}
	}

	public void eguneratuFAdina(int id, int adinaBerria) {

		String query = "UPDATE Freelancerak SET adina = ? WHERE id = ?";

		try (Connection conn = Konexioa.getConnection();

				PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, adinaBerria);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			System.out.println("Freelancer-aren adina eguneratu da");
		} catch (SQLException e) {
			System.out.println("Errorea freelancer-a eguneratzen: " + e.getMessage());
		}
	}

	public void eguneratuFLanorduak(int id, int lanorduBerria) {

		String query = "UPDATE Freelancerak SET lanorduak = ? WHERE id = ?";

		try (Connection conn = Konexioa.getConnection();

				PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, lanorduBerria);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			System.out.println("Freelancer-aren lanordua eguneratu da");
		} catch (SQLException e) {
			System.out.println("Errorea Freelancer-a eguneratzen: " + e.getMessage());
		}
	}

	public void eguneratuFOrdainsariaOrduko(int id, Double ordainsariBerria) {

		String query = "UPDATE Freelancerak SET ordainsariaOrduko = ? WHERE id = ?";

		try (Connection conn = Konexioa.getConnection();

				PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setDouble(1, ordainsariBerria);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			System.out.println("Freelancer-aren ordainsaria orduko eguneratu da");
		} catch (SQLException e) {
			System.out.println("Errorea Freelancer-a eguneratzen: " + e.getMessage());
		}
	}
}
