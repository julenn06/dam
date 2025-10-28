package proba;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kontsultak {

	private Connection connection; // Variable para almacenar la conexión

	// Método para establecer la conexión desde otra clase
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public void cargarBD() {
		String kontsulta = "SELECT * FROM personas";
		try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(kontsulta)) {

			System.out.println("Mezuak:");
			while (rs.next()) {
				String izena = rs.getString("izena");
				String abizena = rs.getString("abizena");
				int telefonoa = rs.getInt("telefonoa");
				System.out.println("Izena: " + izena + ", Abizena: " + abizena + ", Telefonoa: " + telefonoa);
			}
		} catch (SQLException e) {
			System.err.println("Errorea departamentuen kontsulta exekutatzerakoan: " + e.getMessage());
		}
	}

	public void guardarBD(int empNo, String apellido, String oficio, int dir, String fechaAlt, float salario,
			Float comision, int deptNo) {
		String consulta = "INSERT INTO empleados (emp_no, apellido, oficio, dir, fecha_alt, salario, comision, dept_no) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement pstmt = connection.prepareStatement(consulta)) {
			pstmt.setInt(1, empNo);
			pstmt.setString(2, apellido);
			pstmt.setString(3, oficio);
			pstmt.setInt(4, dir);
			pstmt.setString(5, fechaAlt);
			pstmt.setFloat(6, salario);
			pstmt.setObject(7, comision); // Puede ser null
			pstmt.setInt(8, deptNo);
			pstmt.executeUpdate();
			System.out.println("Empleado insertado correctamente.");
		} catch (SQLException e) {
			System.err.println("Error al insertar el empleado: " + e.getMessage());
		}
	}
}