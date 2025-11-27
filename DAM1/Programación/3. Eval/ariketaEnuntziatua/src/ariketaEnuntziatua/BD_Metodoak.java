package ariketaEnuntziatua;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BD_Metodoak {

	BD_Konexioa konexioa = new BD_Konexioa();

	public void langileaSartu(Langilea langilea) {
		konexioa.conectar();

		String sql = "INSERT INTO langilea (id, izena, adina, kargua, oinarrizkoSoldata, antzinatasuna) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";

		try {

			Connection conn = konexioa.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, langilea.getId());
			pstmt.setString(2, langilea.getIzena());
			pstmt.setInt(3, langilea.getAdina());
			pstmt.setString(4, langilea.getKargua());
			pstmt.setDouble(5, langilea.getOinarrizkoSoldata());
			pstmt.setInt(6, langilea.getAntzinatasuna());

			int rowsAffected = pstmt.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Langilea Datu Basean Sartuta.");
			} else {
				System.out.println("Errorea Langilea Sartzean.");
			}
		} catch (SQLException e) {
			System.out.println("Errorea Langilea Sartzean: " + e.getMessage());
		}
	}

	public void freelancerSartu(FreeLancer freelancer) {
		konexioa.conectar();

		String sql = "INSERT INTO freelancer (id, izena, adina, lanorduak, ordainSariakOrduko)"
				+ "VALUES (?, ?, ?, ?, ?)";

		try {

			Connection conn = konexioa.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, freelancer.getId());
			pstmt.setString(2, freelancer.getIzena());
			pstmt.setInt(3, freelancer.getAdina());
			pstmt.setInt(4, freelancer.getLanorduak());
			pstmt.setDouble(5, freelancer.getOrdainSariaOrduko());

			int rowsAffected = pstmt.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Freelancer Datu Basean Sartuta.");
			} else {
				System.out.println("Errorea Freelancer Sartzean.");
			}
		} catch (SQLException e) {
			System.out.println("Errorea Freelancer Sartzean: " + e.getMessage());
		}
	}

	public void langileakIkusi(Langilea langileak) {
		konexioa.conectar();

		String sql = "SELECT * FROM langilea";

		try {

			Connection conn = konexioa.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("Langileak Datu Basean:");
				do {
					int id = rs.getInt("id");
					String izena = rs.getString("izena");
					int adina = rs.getInt("adina");
					String kargua = rs.getString("kargua");
					double oinarrizkoSoldata = rs.getDouble("oinarrizkoSoldata");
					int antzinatasuna = rs.getInt("antzinatasuna");

					System.out.println("ID: " + id + ", Izena: " + izena + ", Adina: " + adina + ", Kargua: " + kargua
							+ ", Oinarrizko Soldata: " + oinarrizkoSoldata + ", Antzinatasuna: " + antzinatasuna
							+ ", Soldata: " + langileak.soldata(oinarrizkoSoldata, antzinatasuna));
				} while (rs.next());
			} else {
				System.out.println("Ez daude Langilerik datu basean.");
			}
		} catch (SQLException e) {
			System.out.println("Errorea langileak ikustean: " + e.getMessage());
		}
	}

	public void freelancerIkusi() {
		konexioa.conectar();

		String sql = "SELECT * FROM freelancer";

		try {

			Connection conn = konexioa.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println("Freelancer Datu Basean:");
				do {
					int id = rs.getInt("id");
					String izena = rs.getString("izena");
					int adina = rs.getInt("adina");
					int lanorduak = rs.getInt("lanorduak");
					double ordainSariakOrduko = rs.getDouble("ordainSariakOrduko");

					System.out.println("ID: " + id + ", Izena: " + izena + ", Adina: " + adina + ", Lan Orduak: "
							+ lanorduak + ", Ordain Sariak Orduko: " + ordainSariakOrduko);
				} while (rs.next());
			} else {
				System.out.println("Ez daude Freelancer datu basean.");
			}
		} catch (SQLException e) {
			System.out.println("Errorea freelancer ikustean: " + e.getMessage());
		}
	}

	public void langileBatIkusi(String izenaLangile) {
		konexioa.conectar();

		String sql = "SELECT * FROM langilea where izena = ?";

		try {

			Connection conn = konexioa.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, izenaLangile);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println("Langilea Datu Basean:");
				do {
					int id = rs.getInt("id");
					String izena = rs.getString("izena");
					int adina = rs.getInt("adina");
					String kargua = rs.getString("kargua");
					double oinarrizkoSoldata = rs.getDouble("oinarrizkoSoldata");
					int antzinatasuna = rs.getInt("antzinatasuna");

					System.out.println("ID: " + id + ", Izena: " + izena + ", Adina: " + adina + ", Kargua: " + kargua
							+ ", Oinarrizko Soldata: " + oinarrizkoSoldata + ", Antzinatasuna: " + antzinatasuna);
				} while (rs.next());
			} else {
				System.out.println("Ez daude Langilerik datu basean.");
			}
		} catch (SQLException e) {
			System.out.println("Errorea langilea ikustean: " + e.getMessage());
		}
	}

	public void langileaEguneratu(Langilea langilea, String izenaLangile) {
		konexioa.conectar();

		String sqlSelect = "SELECT * FROM langilea WHERE izena = ?";

		try {
			Connection conn = konexioa.getConnection();
			PreparedStatement pstmtSelect = conn.prepareStatement(sqlSelect);
			pstmtSelect.setString(1, izenaLangile);

			ResultSet rs = pstmtSelect.executeQuery();

			if (rs.next()) {

				String sqlUpdate = "UPDATE langilea SET izena = ?, adina = ?, kargua = ?, oinarrizkoSoldata = ?, antzinatasuna = ? WHERE izena = ?";
				PreparedStatement pstmtUpdate = conn.prepareStatement(sqlUpdate);

				pstmtUpdate.setString(1, langilea.getIzena());
				pstmtUpdate.setInt(2, langilea.getAdina());
				pstmtUpdate.setString(3, langilea.getKargua());
				pstmtUpdate.setDouble(4, langilea.getOinarrizkoSoldata());
				pstmtUpdate.setInt(5, langilea.getAntzinatasuna());
				pstmtUpdate.setString(6, izenaLangile);

				int rowsAffected = pstmtUpdate.executeUpdate();
				if (rowsAffected > 0) {
					System.out.println("Langilea Datu Basean Eguneratuta.");
				} else {
					System.out.println("Errorea Langilea Eguneratzean.");
				}

			} else {
				System.out.println("Ez daude Langileak datu basean izen honekin: " + izenaLangile);
			}
		} catch (SQLException e) {
			System.out.println("Errorea Langilea Eguneratzean: " + e.getMessage());
		}
	}

	public void freelancerBatIkusi(String izenaFreelancer) {
		konexioa.conectar();

		String sql = "SELECT * FROM freelancer where izena = ?";

		try {

			Connection conn = konexioa.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, izenaFreelancer);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println("FreeLancer Datu Basean:");
				do {
					int id = rs.getInt("id");
					String izena = rs.getString("izena");
					int adina = rs.getInt("adina");
					int lanorduak = rs.getInt("lanorduak");
					double ordainSariakOrduko = rs.getDouble("ordainSariakOrduko");

					System.out.println("ID: " + id + ", Izena: " + izena + ", Adina: " + adina + ", Lan Orduak: "
							+ lanorduak + ", Ordain Sariak Orduko: " + ordainSariakOrduko);
				} while (rs.next());
			} else {
				System.out.println("Ez daude Freelancer datu izen honekin: " + izenaFreelancer);
			}
		} catch (SQLException e) {
			System.out.println("Errorea Freelancer ikustean: " + e.getMessage());
		}
	}

	public void freelancerEguneratu(FreeLancer freelancer, String izenaFreelancer) {
		konexioa.conectar();

		String sqlSelect = "SELECT * FROM freelancer WHERE izena = ?";

		try {
			Connection conn = konexioa.getConnection();
			PreparedStatement pstmtSelect = conn.prepareStatement(sqlSelect);
			pstmtSelect.setString(1, izenaFreelancer);

			ResultSet rs = pstmtSelect.executeQuery();

			if (rs.next()) {

				String sqlUpdate = "UPDATE freelancer SET izena = ?, adina = ?, lanorduak = ?, ordainSariakOrduko = ? WHERE izena = ?";
				PreparedStatement pstmtUpdate = conn.prepareStatement(sqlUpdate);

				pstmtUpdate.setString(1, freelancer.getIzena());
				pstmtUpdate.setInt(2, freelancer.getAdina());
				pstmtUpdate.setInt(3, freelancer.getLanorduak());
				pstmtUpdate.setDouble(4, freelancer.getOrdainSariaOrduko());
				pstmtUpdate.setString(5, izenaFreelancer);

				int rowsAffected = pstmtUpdate.executeUpdate();
				if (rowsAffected > 0) {
					System.out.println("FreeLancer Datu Basean Eguneratuta.");
				} else {
					System.out.println("Errorea FreeLancer Eguneratzean.");
				}

			} else {
				System.out.println("Ez daude FreeLancer datu basean izen honekin: " + freelancer);
			}
		} catch (SQLException e) {
			System.out.println("Errorea FreeLancer Eguneratzean: " + e.getMessage());
		}
	}

	public void langileBatEzabatu(String izenaLangile) {
		konexioa.conectar();

		String sql = "DELETE FROM langilea WHERE izena = ?";

		try {
			Connection conn = konexioa.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, izenaLangile);

			int rowsAffected = pstmt.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Langilea Datu Basetik Ezabatuta.");
			} else {
				System.out.println("Ez da langilerik aurkitu izen honekin: " + izenaLangile);
			}
		} catch (SQLException e) {
			System.out.println("Errorea langilea ezabatzean: " + e.getMessage());
		}
	}

	public void freeancerBatEzabatu(String izenaFrelancer) {
		konexioa.conectar();

		String sql = "DELETE FROM freelancer WHERE izena = ?";

		try {
			Connection conn = konexioa.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, izenaFrelancer);

			int rowsAffected = pstmt.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Freelancer Datu Basetik Ezabatuta.");
			} else {
				System.out.println("Ez da Freelancer aurkitu izenarekin: " + izenaFrelancer);
			}
		} catch (SQLException e) {
			System.out.println("Errorea Freelancer ezabatzean: " + e.getMessage());
		}
	}
}