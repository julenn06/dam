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

	public void mostrarDepartamentos() {
		String kontsulta = "SELECT * FROM departamentos";
		try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(kontsulta)) {

			System.out.println("Departamenduen Edukia:");
			while (rs.next()) {
				int deptZbk = rs.getInt("dept_no");
				String izena = rs.getString("dnombre");
				String kokapena = rs.getString("loc");
				System.out.println("Dept Zbk: " + deptZbk + ", Izena: " + izena + ", Kokapena: " + kokapena);
			}
		} catch (SQLException e) {
			System.err.println("Errorea departamentuen kontsulta exekutatzerakoan: " + e.getMessage());
		}
	}

	public void mostrarEmpleadosDepartamento10() {
		String kontsulta = "SELECT apellido, oficio, salario FROM empleados WHERE dept_no = 10";
		try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(kontsulta)) {

			System.out.println("10. Departamentuko langileak:");
			while (rs.next()) {
				String abizenak = rs.getString("apellido");
				String ofizioa = rs.getString("oficio");
				float soldata = rs.getFloat("salario");
				System.out.println("Abizenak: " + abizenak + ", Ofizioa: " + ofizioa + ", Soldata: " + soldata);
			}
		} catch (SQLException e) {
			System.err.println("Errorea langileen kontsulta exekutatzerakoan: " + e.getMessage());
		}
	}

	public void mostrarEmpleadoSalarioMasAlto() {
		String kontsulta = "SELECT apellido, salario, dept_no FROM empleados ORDER BY salario DESC LIMIT 1";
		try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(kontsulta)) {

			if (rs.next()) {
				String abizenak = rs.getString("apellido");
				float soldata = rs.getFloat("salario");
				int deptNo = rs.getInt("dept_no");
				System.out.println("Soldata handiena duen langilea:");
				System.out.println("Abizenak: " + abizenak + ", Soldata: " + soldata + ", Departamentua: " + deptNo);
			}
		} catch (SQLException e) {
			System.err
					.println("Errorea soldata handiena duen langilearen kontsulta exekutatzerakoan: " + e.getMessage());
		}
	}

	public void insertarEmpleado(int empNo, String apellido, String oficio, int dir, String fechaAlt, float salario,
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

	public void actualizarSalarioEmpleado(int empNo, float nuevoSalario) {
		String consulta = "UPDATE empleados SET salario = ? WHERE emp_no = ?";
		try (PreparedStatement pstmt = connection.prepareStatement(consulta)) {
			pstmt.setFloat(1, nuevoSalario);
			pstmt.setInt(2, empNo);
			pstmt.executeUpdate();
			System.out.println("Salario actualizado correctamente.");
		} catch (SQLException e) {
			System.err.println("Error al actualizar el salario: " + e.getMessage());
		}
	}

	public void eliminarEmpleado(int empNo) {
		String consulta = "DELETE FROM empleados WHERE emp_no = ?";
		try (PreparedStatement pstmt = connection.prepareStatement(consulta)) {
			pstmt.setInt(1, empNo);
			pstmt.executeUpdate();
			System.out.println("Empleado eliminado correctamente.");
		} catch (SQLException e) {
			System.err.println("Error al eliminar el empleado: " + e.getMessage());
		}
	}
}