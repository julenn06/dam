package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import DAO.BidaiMotaDAO;
import Konexioa.ConnectDB;
import modeloa.BidaiMota;

public class BidaiaMotaDAOTest {

	ConnectDB konexioa = new ConnectDB();
	ArrayList<BidaiMota> bidaiak = new ArrayList<>();

	/**
	 * Test honek BidaiMota funtzioak objektuen zerrenda itzultzen duela egiaztatzen
	 * du, funtzioa behar bezala funtzionatzen badu.
	 */
	@Test
	public void testLortuBidaiMotakOK() {
		konexioa.conectar();
		Connection conn = konexioa.getConnection();
		BidaiMotaDAO bidaiMotaDAO = new BidaiMotaDAO();
		bidaiMotaDAO.setConnection(conn);

		ArrayList<BidaiMota> bidaiak = bidaiMotaDAO.lortuBidaiMotak();

		assertNotNull(bidaiak);
	}

	/**
	 * Test honek zerrenda huts bat itzultzen duela egiaztatzen du, konexioa itxi
	 * ondoren.
	 */
	@Test
	public void testLortuBidaiMotakKO() {
		konexioa.conectar();
		Connection conn = konexioa.getConnection();
		BidaiMotaDAO bidaiMotaDAO = new BidaiMotaDAO();
		bidaiMotaDAO.setConnection(conn);

		try {
			conn.close();
			List<BidaiMota> bidaiMotak = bidaiMotaDAO.lortuBidaiMotak();

			assertTrue(bidaiMotak.isEmpty());
		} catch (SQLException e) {
		}
	}

	/**
	 * Test honek funtzionamendua egiaztatzen du, bidai mota baten izena
	 * "Ezkongaiak" emanez.
	 */
	@Test
	public void testlortuIDOK() {
		konexioa.conectar();
		Connection conn = konexioa.getConnection();
		BidaiMotaDAO bidaiMotaDAO = new BidaiMotaDAO();
		bidaiMotaDAO.setConnection(conn);

		String bidaiak = bidaiMotaDAO.lortuID("Ezkongaiak");

		assertNotNull(bidaiak);
	}

	/**
	 * Test honek funtzioak hutsik itzultzen duela egiaztatzen du, "Ezkongaiak"
	 * izena emanez eta konexioa itxi ondoren.
	 */
	@Test
	public void testlortuIDKO() {
		konexioa.conectar();
		Connection conn = konexioa.getConnection();
		BidaiMotaDAO bidaiMotaDAO = new BidaiMotaDAO();
		bidaiMotaDAO.setConnection(conn);

		try {
			conn.close();
			String emaitza = bidaiMotaDAO.lortuID("Ezkongaiak");
			assertEquals(emaitza, "");
		} catch (SQLException e) {
		}
	}
}
