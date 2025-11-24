package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import DAO.AgentziaDAO;
import Konexioa.KonexioaPrueba;
import modeloa.Agentzia;

public class AgentziaDAOTest {

	private AgentziaDAO agentziaDAO = new AgentziaDAO();
	ArrayList<Agentzia> agentziak = new ArrayList<Agentzia>();

	KonexioaPrueba konexioa = new KonexioaPrueba();
	Connection conn;

	/**
	 * SetUp metodoa erabiltzen da test bakoitza aurretik prestatzen. Konexioa
	 * martxan jartzen da eta `conn` konektatutako datu basearekin hasten da.
	 */
	@Before
	public void kontsultaBainoLehen() {
		konexioa.conectar();
		conn = konexioa.getConnection();
	}

	/**
	 * After metodoa erabiltzen da test bakoitzaren ostean funtzio bat egiteko.
	 * Konexioa itxi egiten da.
	 */
	@After
	public void kontsultaOndoren() {
		konexioa.disconnect();
	}

	/**
	 * Datu-basearekin konexioa ezarri eta agentzia guztiak lortzen ditu. Agentzia
	 * kopurua lehen lortutako kopurua baino handiagoa dela egiaztatzen du.
	 */
	@Test
	public void testLortuAgentziaGuztiakOK() {

		agentziaDAO.setConnection(conn);

		int emaitza = agentziak.size();

		agentziak = agentziaDAO.lortuAgentziaGuztiak();

		assertTrue(emaitza < agentziak.size());
	}

	/**
	 * Datu-basearekin konexioa ezarri eta ondoren konexioa ixten du. Konexioa itxi
	 * egiten du eta agentzia guztiak lortzea saiatzen da, errorea harrapatzen dela
	 * egiaztatzeko. Lortutako agentzia kopurua 0 dela egiaztatzen du.
	 */
	@Test
	public void testLortuAgentziaGuztiakKO() {

		try {
			conn.close();
			agentziaDAO.setConnection(conn);
			ArrayList<Agentzia> agentziak = agentziaDAO.lortuAgentziaGuztiak();
			assertEquals(agentziak.size(), 0);
		} catch (SQLException e) {
		}

	}

	/**
	 * Datu-basearekin konexioa ezarri eta erabiltzailearen izena lortzen du.
	 * Lortutako izena espero denarekin bat datorrela egiaztatzen du.
	 */
	@Test
	public void testLortuErabiltzaileakOK() {

		agentziaDAO.setConnection(conn);

		String emaitza = agentziaDAO.lortuErabiltzailea("admin");

		assertEquals(emaitza, "admin");
	}

	/**
	 * Datu-basearekin konexioa ezarri eta ondoren konexioa ixten du. Konexioa itxi
	 * egiten du eta erabiltzailearen izena lortzea saiatzen da, errorea harrapatzen
	 * dela egiaztatzeko. Lortutako emaitza null dela egiaztatzen du.
	 */
	@Test
	public void testLortuErabiltzaileakKO() {
		String agentziaErabiltzailea = "admin";

		try {
			conn.close();
			agentziaDAO.setConnection(conn);
			String emaitza = agentziaDAO.lortuErabiltzailea(agentziaErabiltzailea);
			assertEquals(emaitza, null);
		} catch (SQLException e) {
		}

	}

	/**
	 * Erabiltzaile bat ez dagoenaren izena bilatzen du. Lortutako emaitza null dela
	 * egiaztatzen du.
	 */
	@Test
	public void testLortuErabiltzaileakKO2() {

		String agentziaErabiltzailea = "proba";

		agentziaDAO.setConnection(conn);

		String agentziakS = agentziaDAO.lortuErabiltzailea(agentziaErabiltzailea);

		assertNull(agentziakS);
	}

	/**
	 * Datu-basearekin konexioa ezarri eta erabiltzailearen pasahitza lortzen du.
	 * Lortutako pasahitza espero denarekin bat datorrela egiaztatzen du.
	 */
	@Test
	public void testLortuPasahitzakOK() {

		agentziaDAO.setConnection(conn);

		String emaitza = agentziaDAO.lortuPasahitza("admin");

		assertEquals(emaitza, "admin");
	}

	/**
	 * Erabiltzaile bat ez dagoenaren pasahitza bilatzen du. Lortutako emaitza null
	 * dela egiaztatzen du.
	 */
	@Test
	public void testLortuPasahitzakKO() {

		String agentziaErabiltzailea = "proba";

		agentziaDAO.setConnection(conn);

		String agentziakS = agentziaDAO.lortuPasahitza(agentziaErabiltzailea);

		assertNull(agentziakS);
	}

	/**
	 * Datu-basearekin konexioa ezarri eta ondoren konexioa ixten du. Konexioa itxi
	 * egiten du eta pasahitza lortzea saiatzen da, errorea harrapatzen dela
	 * egiaztatzeko. Lortutako emaitza null dela egiaztatzen du.
	 */
	@Test
	public void testLortuPasahitzakKO2() {
		String agentziaErabiltzailea = "admin";

		try {
			conn.close();
			agentziaDAO.setConnection(conn);
			String emaitza = agentziaDAO.lortuPasahitza(agentziaErabiltzailea);
			assertEquals(emaitza, null);
		} catch (SQLException e) {
		}
	}

	/**
	 * Datu-basearekin konexioa ezarri eta erabiltzailearen IDa lortzen du.
	 * Lortutako IDa espero denarekin bat datorrela egiaztatzen du.
	 */
	@Test
	public void testLortuIDOK() {

		agentziaDAO.setConnection(conn);

		int emaitza = agentziaDAO.lortuID("admin");

		assertEquals(emaitza, 1);
	}

	/**
	 * Erabiltzaile bat ez dagoenaren IDa bilatzen du. Lortutako emaitza -1 dela
	 * egiaztatzen du.
	 */
	@Test
	public void testLortuIDKO() {

		String agentziaErabiltzailea = "proba";
		int emaitza = -1;

		agentziaDAO.setConnection(conn);

		int agentziakS = agentziaDAO.lortuID(agentziaErabiltzailea);

		assertEquals(agentziakS, emaitza);
	}

	/**
	 * Datu-basearekin konexioa ezarri eta ondoren konexioa ixten du. Konexioa itxi
	 * egiten du eta IDa lortzea saiatzen da, errorea harrapatzen dela egiaztatzeko.
	 */
	@Test
	public void testLortuIDKO2() {

		String agentziaErabiltzailea = "admin";

		try {
			conn.close();
			agentziaDAO.setConnection(conn);
			int agentziakS = agentziaDAO.lortuID(agentziaErabiltzailea);
			assertEquals(agentziakS, -1);
		} catch (SQLException e) {
		}
	}

	/**
	 * Datu-basearekin konexioa ezarri eta agentzia berri bat sartzen du. Sarrera
	 * izan duela egiaztatzen du.
	 */
	@Test
	public void testSartuAgentziaOK() {

		Agentzia erabiltzailea = new Agentzia("izena", "logoa", "3c3c3c", "L1", "A1", "12345",
				"erabiltzaile00007000000"); // Erabiltzailea aldatu testa exekutatzeko
		boolean agentziaB = true;

		agentziaDAO.setConnection(conn);

		agentziaB = agentziaDAO.sartuAgentzia(erabiltzailea);

		assertNotNull(agentziaB);

	}

	/**
	 * Datu-basearekin konexioa ezarri eta agentzia bat sartzen saiatzen da, baina
	 * sarrera huts egiten du. Espero den emaitza false dela egiaztatzen du.
	 */
	@Test
	public void testSartuAgentziaKO() {

		Agentzia erabiltzailea = new Agentzia("izena", "logoa", "3c3c3c", "L1", "12345", "erabiltzaile007", "A1");
		boolean agentziaB = true;

		agentziaDAO.setConnection(conn);

		agentziaB = agentziaDAO.sartuAgentzia(erabiltzailea);

		assertEquals(agentziaB, false);

	}

}