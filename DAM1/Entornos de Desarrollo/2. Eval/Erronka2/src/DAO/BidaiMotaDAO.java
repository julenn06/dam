package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Konexioa.ConnectDB;

import modeloa.BidaiMota;

public class BidaiMotaDAO {

	private static Connection konexioa;
	ConnectDB conexion = new ConnectDB();

	public void setConnection(Connection konexioa) {
		BidaiMotaDAO.konexioa = konexioa;
	}

	// Metodo honek bidaia motak datu-basean kontsultatzen ditu.
	// 'bidaia_mota' taulatik 'kodBidaiaMota' eta 'deskribapenaBidaiMota' eskuratuz,
	// 'BidaiMota' objektu berri bat sortzen da eta ArrayList batean gorde egiten
	// da. Azkenik, ArrayList hori itzultzen da.
	public ArrayList<BidaiMota> lortuBidaiMotak() {

		ArrayList<BidaiMota> bidaiMotak = new ArrayList<BidaiMota>();

		String kontsulta = "SELECT kodBidaiaMota, deskribapenaBidaiMota from bidaia_mota;";
		try (Statement stmt = konexioa.createStatement(); ResultSet rs = stmt.executeQuery(kontsulta)) {
			while (rs.next()) {
				String kodBidaiaMota = rs.getString("kodBidaiaMota");
				String deskribapenaBidaiMota = rs.getString("deskribapenaBidaiMota");
				BidaiMota bidaiMota = new BidaiMota(kodBidaiaMota, deskribapenaBidaiMota);
				bidaiMotak.add(bidaiMota);
			}
		} catch (SQLException e) {
			System.err.println("Errorea agentzien kontsulta exekutatzerakoan: " + e.getMessage());
		}
		return bidaiMotak;
	}

	// Metodo honek 'bidaiMota' parametro bidez hartzen du eta 'bidaia_mota'
	// taulatik 'deskribapenaBidaiMota' kodea eskuratzea egiten du. SQL kontsultaren
	// bidez, id-a (kodea) bilatzen da eta itzultzen da.
	public String lortuID(String bidaiMota) {
		String sql = "SELECT kodBidaiaMota, deskribapenaBidaiMota FROM bidaia_mota";
		String motaKodea = "";

		try (Statement stmt = konexioa.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				if (bidaiMota.equals(rs.getString("deskribapenaBidaiMota"))) {
					motaKodea = rs.getString("kodBidaiaMota");
				}
			}
		} catch (SQLException z) {
			System.err.println("Errorea bidai motak berreskuratzen: " + z.getMessage());
		}

		return motaKodea;
	}
}
