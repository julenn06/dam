package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modeloa.Aireportua;

public class AireportuaDAO {

	private Connection konexioa;

	public void setConnection(Connection konexioa) {
		this.konexioa = konexioa;
	}

	// Metodo honek aireportu guztiak eskuratzen ditu.
	// Datu-baseko 'aireportua' taulatik 'kodAireportua' eta 'hiria' zutabeak
	// jasotzen ditu. Emaitzak 'Aireportua' objektu bihurtzen dira eta ArrayList
	// batean gorde egiten dira. Azkenik, aireportu guztiak dituen ArrayList hori
	// itzultzen da.
	public List<Aireportua> lortuAireportuGuztiak() {
		List<Aireportua> aireportuak = new ArrayList<>();
		String kontsulta = "SELECT kodAireportua, hiria FROM aireportua";
		try (Statement stmt = konexioa.createStatement(); ResultSet rs = stmt.executeQuery(kontsulta)) {
			while (rs.next()) {
				String kodAireportua = rs.getString("kodAireportua");
				String hiria = rs.getString("hiria");
				Aireportua aireportua = new Aireportua(kodAireportua, hiria); // Aireportua objektua sortzen da
				aireportuak.add(aireportua); // Aireportua lista batean gehitzen da
			}
		} catch (SQLException e) {
			System.err.println("Errorea aireportuen kontsulta exekutatzerakoan: " + e.getMessage());
		}

		return aireportuak; // Aireportuen lista itzultzen da
	}
}
