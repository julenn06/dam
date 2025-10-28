package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modeloa.Bidaia;
import modeloa.Zerbitzua;

public class BidaiaDAO {

	private static Connection konexioa;

	public void setConnection(Connection konexioa) {
		BidaiaDAO.konexioa = konexioa;
	}

	static ZerbitzuakDAO zerbitzuaDAO = new ZerbitzuakDAO();

	// Metodo honek agentziaren IDa erabiliz, bidaia guztiak eskuratzea ahalbidetzen
	// du. Datu-basean dagoen 'Bidaia' taulatik 'izenaBidaia', 'deskribapenaBidaia',
	// 'dataIrteera', 'dataAmaiera', 'iraupena', 'KodHerrialdea', 'izenaAgentzia',
	// 'deskribapenaBidaiMota' eta 'Zerbitzuak' informazioa jasotzen ditu.
	// Bidaia bakoitza 'Bidaia' objektu batean bildu eta ArrayList batean gorde
	// egiten da. Azkenik, ArrayList hori itzultzen da.
	public ArrayList<Bidaia> lortuBidaiAgentzia(int erabiltzailezbk) {
		ArrayList<Bidaia> bidaiak = new ArrayList<>();
		String sql = "SELECT IDBidaia, izenaBidaia, dataAmaiera, dataIrteera, deskribapenaBidaia, b.KodHerrialdea, a.izenaAgentzia, b.IDAgentzia, b.kodBidaiaMota, m.deskribapenaBidaiMota, DATEDIFF(dataAmaiera, dataIrteera) AS iraupena FROM Bidaia b JOIN bidaia_mota m ON b.kodBidaiaMota = m.kodBidaiaMota JOIN agentzia a ON b.IDAgentzia = a.IDAgentzia where a.IDAgentzia ="
				+ erabiltzailezbk;

		try (Statement stmt = konexioa.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				String identifikatzailea = rs.getString("IDBidaia");
				String izena = rs.getString("izenaBidaia");
				String deskribapena = rs.getString("deskribapenaBidaia");
				String dataIrteera = rs.getString("dataIrteera");
				String dataAmaiera = rs.getString("dataAmaiera");
				int iraupena = rs.getInt("iraupena");
				String helmuga = rs.getString("KodHerrialdea");
				String agentzia = rs.getString("izenaAgentzia");
				String bidaiaMota = rs.getString("deskribapenaBidaiMota");

				ArrayList<Zerbitzua> zerbitzuak = zerbitzuaDAO.lortuZerbitzuBidaia(identifikatzailea);

				Bidaia bidaia = new Bidaia(identifikatzailea, izena, deskribapena, bidaiaMota, dataIrteera, dataAmaiera,
						iraupena, helmuga, zerbitzuak, agentzia);
				bidaiak.add(bidaia);

				bidaia.setZerbitzuak(zerbitzuak);
			}
		} catch (SQLException e) {
			System.err.println("Errorea bidaiak kontsultatzerakoan: " + e.getMessage());
		}

		return bidaiak;
	}

	// Metodo honek 'IDBidaia' parametro gisa hartzen du eta bidaiaren datuak
	// datu-basean ezabatzen ditu. SQL 'DELETE' komandoa erabiliz, 'Bidaia' taulatik
	// ezabatzen da bidaiaren informazioa. Erroreak kudeatzeko 'SQLException'
	// erabiliko da.
	public void ezabatuBidaiDB(String IDBidaia) {

		String sql = "DELETE FROM bidaia WHERE IDbidaia =" + IDBidaia + ";";

		try (Statement stmt = konexioa.createStatement()) {
			int lerroAldaketa = stmt.executeUpdate(sql);

			if (lerroAldaketa > 0) {
				System.out.println("Bidaia ezabatuta");
			} else {

			}
		} catch (SQLException e) {
			System.err.println("Errorea konektatzen: " + e.getMessage());
		}
	}

	// Metodo honek 'Bidaia' objektu bat jasotzen du eta datu-basean 'Bidaia'
	// taulatik datuak sartzen ditu. SQL 'INSERT' komandoa erabiliz, datuak
	// datu-basean gehitzen dira. Metodoak boolean balio bat itzultzen du, 'true'
	// sarrera egin bada eta 'false' beste kasuetan.
	public static boolean sartuBidaia(Bidaia bidaia) {
		String sql = "INSERT INTO Bidaia (izenaBidaia, deskribapenaBidaia, dataIrteera, dataAmaiera, IDAgentzia, kodBidaiaMota, kodHerrialdea) "
				+ "VALUES ('" + bidaia.getIzena() + "', '" + bidaia.getDeskribapena() + "', '" + bidaia.getDataIrteera()
				+ "', '" + bidaia.getDataAmaiera() + "', '" + bidaia.getAgentzia() + "', '" + bidaia.getBidaiaMota()
				+ "', '" + bidaia.getHelmuga() + "');";

		try (Statement stmt = konexioa.createStatement()) {
			int filasAfectadas = stmt.executeUpdate(sql); // SQL kontsulta exekutatzen da

			return filasAfectadas > 0; // 'true' itzultzen da sarrera egin bada
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error al insertar Bidaia: " + e.getMessage());
			return false;
		}
	}

}
