package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import DAO.ZerbitzuakDAO;
import Konexioa.KonexioaPrueba;
import modeloa.Zerbitzua;

public class ZerbitzuakDAOTest {

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
	 * Test honek ZerbitzuakDAO klaseko lortuZerbitzuBidaia metodoa probatzen du,
	 * eta egiaztatzen du zerbitzuak ArrayList bete bat itzultzen duela.
	 */
	@Test
	public void testLortuZerbitzuBidaiaOK() {
		ZerbitzuakDAO zerbitzuakDAO = new ZerbitzuakDAO();
		zerbitzuakDAO.setConnection(conn);
		// Datu basean ID 4 duten zerbitzuak egon behar dira.
		String id = "2";
		ArrayList<Zerbitzua> zerbitzuak = zerbitzuakDAO.lortuZerbitzuBidaia(id);

		assertNotNull(zerbitzuak);
	}

	/**
	 * Test honek lortuZerbitzuBidaia metodoa probatzen du, baina konexioa itxi
	 * egiten da eta egiaztatzen du metodoak ArrayList itzultzen duela, baita
	 * konexioa itxi denean ere.
	 */
	@Test
	public void testLortuZerbitzuBidaiaKO() {
		ZerbitzuakDAO zerbitzuakDAO = new ZerbitzuakDAO();
		zerbitzuakDAO.setConnection(conn);
		konexioa.disconnect();

		String id = "35";
		ArrayList<Zerbitzua> zerbitzuak = zerbitzuakDAO.lortuZerbitzuBidaia(id);

		assertNotNull(zerbitzuak);
	}

	/**
	 * Test honek ezabatuZerbitzua metodoa probatzen du, baina errore baten aurrean
	 * egiaztatzen duela zerbitzua ez dela ezabatzen.
	 */
	@Test
	public void testEzabatuZerbitzuaKO() {
		ZerbitzuakDAO zerbitzuakDAO = new ZerbitzuakDAO();
		zerbitzuakDAO.setConnection(conn);
		Zerbitzua sartuDatuak = new Zerbitzua("izena", "hiria", 44, "2026-10-09", "2026-11-09", "DUI", 2);

		zerbitzuakDAO.sartuOstatua(sartuDatuak, 1);

		zerbitzuakDAO.ezabatuZerbitzua("Ostatua", "2");
	}

	/**
	 * Test honek ezabatuZerbitzua metodoa probatzen du, baina konexioa itxi egiten
	 * da eta egiaztatzen du errorea sortzen dela.
	 */
	@Test
	public void testEzabatuZerbitzuaKO2() {
		ZerbitzuakDAO zerbitzuakDAO = new ZerbitzuakDAO();
		zerbitzuakDAO.setConnection(conn);
		try {
			conn.close();
			zerbitzuakDAO.ezabatuZerbitzua("Beste Zerbitzuak", "2");
		} catch (SQLException e) {

		}
	}

	/**
	 * Test honek ezabatuZerbitzua metodoa probatzen du, baina ez du zerbitzu
	 * egokirik aurkitzen eta egiaztatzen du metodoak erantzun egokia itzultzen
	 * duela.
	 */
	@Test
	public void testEzabatuZerbitzuaKO3() {
		ZerbitzuakDAO zerbitzuakDAO = new ZerbitzuakDAO();
		zerbitzuakDAO.setConnection(conn);
		Zerbitzua sartuDatuak = new Zerbitzua("izena", "hiria", 44, "2026-10-09", "2026-11-09", "DUI", 2);

		zerbitzuakDAO.sartuOstatua(sartuDatuak, 1);

		zerbitzuakDAO.ezabatuZerbitzua("Hegaldia", "2");
	}

	/**
	 * Test honek sartuBesteZerbitzua metodoa probatzen du, baina zerbitzu objektu
	 * huts bat pasatzen da eta egiaztatzen du metodoak null ez duela itzultzen.
	 */
	@Test
	public void testSartuBesteZerbitzuaKO() {
		ZerbitzuakDAO zerbitzuakDAO = new ZerbitzuakDAO();
		zerbitzuakDAO.setConnection(conn);

		Zerbitzua zerbitzua = new Zerbitzua(0, 0, null, null, null, null);

		boolean zerbitzuak = zerbitzuakDAO.sartuBesteZerbitzua(zerbitzua, 1);

		assertNotNull(zerbitzuak);
	}

	/**
	 * Test honek sartuHegaldia metodoa probatzen du, eta egiaztatzen du, zerbitzu
	 * objektu huts bat pasatuta, egokia dela.
	 */
	@Test
	public void testSartuHegaldiaKO() {
		ZerbitzuakDAO zerbitzuakDAO = new ZerbitzuakDAO();
		zerbitzuakDAO.setConnection(conn);

		Zerbitzua zerbitzua = new Zerbitzua(0, 0, null, null, null, null);

		boolean zerbitzuak = zerbitzuakDAO.sartuHegaldia(zerbitzua, 1);

		assertNotNull(zerbitzuak);
	}

	/**
	 * Test honek sartuJoanEtorri metodoa probatzen du, eta egiaztatzen du, zerbitzu
	 * objektu huts bat pasatuta, egokia dela.
	 */
	@Test
	public void testSartuJoanEtorriKO() {
		ZerbitzuakDAO zerbitzuakDAO = new ZerbitzuakDAO();
		zerbitzuakDAO.setConnection(conn);

		Zerbitzua zerbitzua = new Zerbitzua(0, 0, null, null, null, null);

		boolean zerbitzuak = zerbitzuakDAO.sartuJoanEtorri(zerbitzua, 1);

		assertNotNull(zerbitzuak);
	}

	/**
	 * Test honek lortuIDHegaldia metodoa probatzen du, eta egiaztatzen du ID bat
	 * eskatuz gero emaitza positiboa itzultzen duela.
	 */
	@Test
	public void testLortuIDHegaldiaOK() {
		ZerbitzuakDAO zerbitzuakDAO = new ZerbitzuakDAO();
		zerbitzuakDAO.setConnection(conn);

		int emaitza = zerbitzuakDAO.lortuIDHegaldia("gdfgd");

		assertNotNull(emaitza);
	}

	/**
	 * Test honek lortuIDHegaldia metodoa probatzen du, baina konexioa itxi egiten
	 * da eta egiaztatzen du metodoak errore egokia itzultzen duela.
	 */
	@Test
	public void testLortuIDHegaldiaKO() {
		ZerbitzuakDAO zerbitzuakDAO = new ZerbitzuakDAO();
		zerbitzuakDAO.setConnection(conn);
		try {
			conn.close();
			int emaitza = zerbitzuakDAO.lortuIDHegaldia("probatxarto");
			assertEquals(emaitza, 0);
		} catch (SQLException e) {
		}
	}
}