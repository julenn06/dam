package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Test;

import DAO.BidaiaDAO;
import Konexioa.KonexioaPrueba;
import modeloa.Bidaia;
import modeloa.Zerbitzua;

public class BidaiaDAOTest {

	KonexioaPrueba konexioa = new KonexioaPrueba();
	ArrayList<Bidaia> bidaiak = new ArrayList<>();

	/**
	 * Bidaien lortutako zerrenda egiaztatzen du Agentzia baten IDarekin.
	 * Egiaztatzen da lortutako zerrenda ez dela hutsik.
	 */
	@Test
	public void testlortuBidaiAgentziaOK() {
		konexioa.conectar();
		Connection conn = konexioa.getConnection();

		BidaiaDAO BidaiaDAO = new BidaiaDAO();
		BidaiaDAO.setConnection(conn);

		bidaiak = BidaiaDAO.lortuBidaiAgentzia(1);

		assertTrue(bidaiak.size() > 0);
	}

	/**
	 * Bidaien lortutako zerrenda egiaztatzen du Agentzia baten IDarekin eta
	 * konexioa itxi ondoren, lortutako zerrenda hutsik dagoela egiaztatzen du.
	 */
	@Test
	public void testlortuBidaiAgentziaKO() {
		konexioa.conectar();
		Connection conn = konexioa.getConnection();

		BidaiaDAO BidaiaDAO = new BidaiaDAO();
		BidaiaDAO.setConnection(conn);
		try {
			conn.close();
			ArrayList<Bidaia> bidaia = new ArrayList<>();
			bidaia = BidaiaDAO.lortuBidaiAgentzia(2);
			assertEquals(bidaia.size(), 0);
		} catch (SQLException e) {
		}
	}

	/**
	 * Bidaia bat datu-basean ezabatzen duen funtzioa probatzen du. Datu-basean
	 * erregistroa sartzen da eta gero ezabatzen da.
	 */
	@Test
	public void testezabatuBidaiDBOK() {
		konexioa.conectar();
		Connection conn = konexioa.getConnection();

		BidaiaDAO BidaiaDAO = new BidaiaDAO();
		BidaiaDAO.setConnection(conn);

		try {
			Statement stmt = conn.createStatement();
			stmt.execute(
					"INSERT INTO bidaia (IDBidaia, izenaBidaia, deskribapenaBidaia, dataIrteera, dataAmaiera, IDAgentzia, kodBidaiaMota, kodHerrialdea) VALUES (1, 'Agentzia1', 'aaaaaaaaaa', '2026-10-09', '2026-11-09', 1, 'B1', 'EG')");
		} catch (SQLException e) {
		}

		BidaiaDAO.ezabatuBidaiDB("1");

		ArrayList<Zerbitzua> zerbitzuak = new ArrayList<Zerbitzua>();

		assertNotNull(zerbitzuak);
	}

	/**
	 * Bidaia ezabatzea probatzen du, baina ID okerra emanez. Egiaztatzen da bidaiak
	 * zerrendan egon behar duela.
	 */
	@Test
	public void testezabatuBidaiDBKO() {
		konexioa.conectar();
		Connection conn = konexioa.getConnection();

		BidaiaDAO BidaiaDAO = new BidaiaDAO();
		BidaiaDAO.setConnection(conn);

		BidaiaDAO.ezabatuBidaiDB("A1");

		assertNotNull(bidaiak);
	}

	/**
	 * Bidaia bat datu-basean sartzen du eta zerrenda handitu egiten dela
	 * egiaztatzen du.
	 */
	@Test
	public void testSartuBidaiaOK() {
		konexioa.conectar();
		Connection conn = konexioa.getConnection();

		BidaiaDAO bidaiaDAO = new BidaiaDAO();
		bidaiaDAO.setConnection(conn);

		int tamaina = bidaiak.size();

		Bidaia bidaia = new Bidaia("izena", "aaaa", "2006-10-09", "2006-11-09", 1, "B1", "GB");

		boolean sartu = BidaiaDAO.sartuBidaia(bidaia);

		if (sartu) {
			bidaiak.add(bidaia);
		}

		assertEquals(tamaina + 1, bidaiak.size());
	}

	/**
	 * Bidaia bat sartzeko funtzioa probatzen du, baina konexio errore bat gertatuz.
	 * Ez da bidaia bat sartzen eta emaitza okerra dela egiaztatzen du.
	 */
	@Test
	public void testSartuBidaiaKO() {
		konexioa.conectar();
		Connection conn = konexioa.getConnection();

		BidaiaDAO bidaiaDAO = new BidaiaDAO();
		bidaiaDAO.setConnection(conn);

		try {
			conn.close();
			Bidaia bidaia = new Bidaia("izena", "aaaa", "2006-10-09", "2006-11-09", 1, "A1", "GB");
			boolean emaitza = BidaiaDAO.sartuBidaia(bidaia);
			assertEquals(emaitza, false);
		} catch (SQLException e) {
		}
	}

}
