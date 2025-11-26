package azterketaTxuleta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Metodoak {

	public boolean soldataBalidatu(String soldataString) throws SoldataBalidatu {
		boolean error = false;

		try {
			double soldata = Double.parseDouble(soldataString);

			if (soldata <= 0) {
				throw new SoldataBalidatu("Soldata ezin da izan 0 edo gutxiago.");
			}
		} catch (NumberFormatException e) {
			System.out
					.println("Balidazio Errorea: Soldata behar bezala adierazi behar da (zenbaki bat izan behar da).");
			error = true;
		} catch (SoldataBalidatu e) {
			System.out.println("Balidazio Errorea: " + e.getMessage());
			error = true;

		}

		return error;
	}

	public void ikasleakIkusi(BD_Konexioa konexioa) {

		String sql = "SELECT * FROM alumnos";

		try {

			Connection conn = konexioa.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("Ikasleak Datu Basean:");
				do {
					int id = rs.getInt("id_alumno");
					String izena = rs.getString("nombre");
					String abizena = rs.getString("apellido");
					int adina = rs.getInt("edad");
					String kurtsoa = rs.getString("curso");
					int gela = rs.getInt("aula");
					String ordutegia = rs.getString("horario");

					System.out.println("ID: " + id + ", Izena: " + izena + ", Abizena: " + abizena + ", Adina: " + adina
							+ ", Kurtsoa: " + kurtsoa + ", Gela: " + gela + ", Ordutegia: " + ordutegia);
				} while (rs.next());
			} else {
				System.out.println("Ez daude Ikaslerik datu basean.");
			}
		} catch (SQLException e) {
			System.out.println("Errorea Ikasleak ikustean: " + e.getMessage());
		}
	}

	public void ikasleaEzabatuIzenaErabiltzen(BD_Konexioa konexioa, String izena) {

		String sql = "DELETE FROM alumnos WHERE nombre = ?";

		try {
			Connection conn = konexioa.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, izena);

			int rowsAffected = pstmt.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Ikaslea Datu Basetik Ezabatuta.");
			} else {
				System.out.println("Ez da ikaslea aurkitu izen honekin: " + izena);
			}
		} catch (SQLException e) {
			System.out.println("Errorea ikaslea ezabatzean: " + e.getMessage());
		}
	}

	public void ikasleaEzabatuIDErabiltzen(BD_Konexioa konexioa, int id) {

		String sql = "DELETE FROM alumnos WHERE id_alumno = ?";

		try {
			Connection conn = konexioa.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			int rowsAffected = pstmt.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Ikaslea Datu Basetik Ezabatuta.");
			} else {
				System.out.println("Ez da ikaslea aurkitu id honekin: " + id);
			}
		} catch (SQLException e) {
			System.out.println("Errorea ikaslea ezabatzean: " + e.getMessage());
		}
	}

	public void ikasleaBilatuIzenarekin(BD_Konexioa konexioa, String izenaikaslea) {
		String sql = "SELECT * FROM alumnos where nombre = ?";

		try {

			Connection conn = konexioa.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, izenaikaslea);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println("Ikaslea Datu Basean:");
				do {
					int id = rs.getInt("id_alumno");
					String izena = rs.getString("nombre");
					String abizena = rs.getString("apellido");
					int adina = rs.getInt("edad");
					String kurtsoa = rs.getString("curso");
					int gela = rs.getInt("aula");
					String ordutegia = rs.getString("horario");

					System.out.println("ID: " + id + ", Izena: " + izena + ", Abizena: " + abizena + ", Adina: " + adina
							+ ", Kurtsoa: " + kurtsoa + ", Gela: " + gela + ", Ordutegia: " + ordutegia);
				} while (rs.next());
			} else {
				System.out.println("Ez daude ikaslerik datu basean izen horrekin.");
			}
		} catch (SQLException e) {
			System.out.println("Errorea ikaslea ikustean: " + e.getMessage());
		}
	}

	public void ikaselakBilatuAdinarekin(BD_Konexioa konexioa, int adinaIkaslea) {
		String sql = "SELECT * FROM alumnos where edad = ?";

		try {

			Connection conn = konexioa.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, adinaIkaslea);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println("Ikaslea Datu Basean:");
				do {
					int id = rs.getInt("id_alumno");
					String izena = rs.getString("nombre");
					String abizena = rs.getString("apellido");
					int adina = rs.getInt("edad");
					String kurtsoa = rs.getString("curso");
					int gela = rs.getInt("aula");
					String ordutegia = rs.getString("horario");

					System.out.println("ID: " + id + ", Izena: " + izena + ", Abizena: " + abizena + ", Adina: " + adina
							+ ", Kurtsoa: " + kurtsoa + ", Gela: " + gela + ", Ordutegia: " + ordutegia);
				} while (rs.next());
			} else {
				System.out.println("Ez daude ikaslerik datu basean soldata horrekin edo gutxiago.");
			}
		} catch (SQLException e) {
			System.out.println("Errorea ikaslea ikustean: " + e.getMessage());
		}
	}

	public void irakasleakBilatuSoldatarekin(BD_Konexioa konexioa, double soldataIrakaslea) {

		String sql = "SELECT * FROM profesores where salario <= ?";

		try {

			Connection conn = konexioa.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, soldataIrakaslea);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println("Irakaslea Datu Basean:");
				do {
					int id = rs.getInt("id_profesor");
					String izena = rs.getString("nombre");
					String abizena = rs.getString("apellido");
					int adina = rs.getInt("edad");
					int gela = rs.getInt("aula");
					double soldata = rs.getDouble("salario");
					String ordutegia = rs.getString("horario");

					System.out.println("ID: " + id + ", Izena: " + izena + ", Abizena: " + abizena + ", Adina: " + adina
							+ ", Gela: " + gela + ", Soldata: " + soldata + ", Ordutegia: " + ordutegia);
				} while (rs.next());
			} else {
				System.out.println("Ez daude irakaslerik datu basean soldata horrekin edo gutxiago.");
			}
		} catch (SQLException e) {
			System.out.println("Errorea irakasleak ikustean: " + e.getMessage());
		}
	}

	public void ikasleakBilatuIrakaslearekinForma1(BD_Konexioa konexioa, String izenaIrakaslea) {
		boolean error = false;
		String sql = "SELECT aula FROM profesores WHERE nombre = ?";
		int gela = 0;

		try {
			Connection conn = konexioa.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, izenaIrakaslea);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				gela = rs.getInt("aula");

			} else {
				System.out.println("Ez daude irakaslerik datu basean izena horrekin.");
				error = true;
			}

		} catch (SQLException e) {
			System.out.println("Errorea irakaslea bilatzerakoan: " + e.getMessage());
			error = true;
		}

		if (!error) {
			sql = "SELECT * FROM alumnos WHERE aula = ?";

			try {
				Connection conn = konexioa.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, gela);
				ResultSet rs = pstmt.executeQuery();

				if (rs.next()) {
					System.out.println("Ikaslea Datu Basean:");
					do {
						int id = rs.getInt("id_alumno");
						String izena = rs.getString("nombre");
						String abizena = rs.getString("apellido");
						int adina = rs.getInt("edad");
						String kurtsoa = rs.getString("curso");
						String ordutegia = rs.getString("horario");

						System.out.println("ID: " + id + ", Izena: " + izena + ", Abizena: " + abizena + ", Adina: "
								+ adina + ", Kurtsoa: " + kurtsoa + ", Gela: " + gela + ", Ordutegia: " + ordutegia);
					} while (rs.next());
				} else {
					System.out.println("Ez daude ikaslerik datu basean gela horretan.");
				}

			} catch (SQLException e) {
				System.out.println("Errorea ikasleak bilatzerakoan: " + e.getMessage());
			}
		}
	}

	public void ikasleakBilatuIrakaslearekinForma2(BD_Konexioa konexioa, String izenaIrakaslea) {
		String sql = "SELECT * FROM alumnos a INNER JOIN profesores p ON p.aula = a.aula WHERE p.nombre = ?";
		int gela = 0;

		try {

			Connection conn = konexioa.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, izenaIrakaslea);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				do {
					int id = rs.getInt("id_alumno");
					String izena = rs.getString("nombre");
					String abizena = rs.getString("apellido");
					int adina = rs.getInt("edad");
					String kurtsoa = rs.getString("curso");
					gela = rs.getInt("aula");
					String ordutegia = rs.getString("horario");

					System.out.println("ID: " + id + ", Izena: " + izena + ", Abizena: " + abizena + ", Adina: " + adina
							+ ", Kurtsoa: " + kurtsoa + ", Gela: " + gela + ", Ordutegia: " + ordutegia);
				} while (rs.next());
			} else {
				System.out.println("Ez daude ikaslerik irakasle horrekin.");
			}

		} catch (SQLException e) {
			System.out.println("Errorea irakaslea bilatzerakoan: " + e.getMessage());
		}
	}

	public void soldataIgo(BD_Konexioa konexioa, double soldata) {
		String sql = "UPDATE profesores SET salario = salario * 1.2 WHERE salario <= ?";

		try {

			Connection conn = konexioa.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, soldata);

			int rowsAffected = pstmt.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Langileen soldata eguneratuta. Guztira: " + rowsAffected + " irakasle.");
			} else {
				System.out.println("Ez daude irakaslerik soldata horrekin edo gutxiagorekin.");
			}

		} catch (SQLException e) {
			System.out.println("Errorea soldata eguneratzean: " + e.getMessage());
		}
	}

	public void ikasleaGehitu(Ikasleak ikaslea, BD_Konexioa konexioa) {
		String sql = "INSERT INTO alumnos (nombre, apellido, edad, curso, aula, horario) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";

		try {

			Connection conn = konexioa.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, ikaslea.getNombre());
			pstmt.setString(2, ikaslea.getApellido());
			pstmt.setInt(3, ikaslea.getEdad());
			pstmt.setString(4, ikaslea.getCurso());
			pstmt.setDouble(5, ikaslea.getAula());
			pstmt.setString(6, ikaslea.getHorario());

			int rowsAffected = pstmt.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Ikaslea Datu Basean Sartuta.");
			} else {
				System.out.println("Errorea Ikaslea Sartzean.");
			}
		} catch (SQLException e) {
			System.out.println("Errorea Ikaslea Sartzean: " + e.getMessage());
		}
	}

	public void irakasleaGehitu(Irakasleak irakaslea, BD_Konexioa konexioa) {
		String sql = "INSERT INTO profesores (nombre, apellido, edad, aula, salario, horario) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";

		try {

			Connection conn = konexioa.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, irakaslea.getNombre());
			pstmt.setString(2, irakaslea.getApellido());
			pstmt.setInt(3, irakaslea.getEdad());
			pstmt.setInt(4, irakaslea.getAula());
			pstmt.setDouble(5, irakaslea.getSalario());
			pstmt.setString(6, irakaslea.getHorario());

			int rowsAffected = pstmt.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Irakaslea Datu Basean Sartuta.");
			} else {
				System.out.println("Errorea Irakaslea Sartzean.");
			}
		} catch (SQLException e) {
			System.out.println("Errorea Irakkaslea Sartzean: " + e.getMessage());
		}
	}

	public void irakasleaIkusi(BD_Konexioa konexioa, String izena, double soldata) {

		String sql = "SELECT * FROM profesores where nombre = ? and salario >= ?";

		try {

			Connection conn = konexioa.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, izena);
			pstmt.setDouble(2, soldata);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				do {
					int id = rs.getInt("id_profesor");
					izena = rs.getString("nombre");
					String abizena = rs.getString("apellido");
					int adina = rs.getInt("edad");
					String kurtsoa = rs.getString("aula");
					String ordutegia = rs.getString("horario");

					System.out.println("ID: " + id + ", Izena: " + izena + ", Abizena: " + abizena + ", Adina: " + adina
							+ ", Kurtsoa: " + kurtsoa + ", Soldata: " + soldata + ", Ordutegia: " + ordutegia);
				} while (rs.next());
			} else {
				System.out.println("Ez daude irakaslerik datu horrekin.");
			}

		} catch (SQLException e) {
			System.out.println("Errorea irakaslea bilatzerakoan: " + e.getMessage());
		}
	}
}