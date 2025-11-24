package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import DAO.HerrialdeaDAO;
import Konexioa.ConnectDB;
import modeloa.Herrialdea;

public class HerrialdeaDAOTest {

	ConnectDB konexioa = new ConnectDB();
	ArrayList<Herrialdea> bidaiak = new ArrayList<>();

	/**
	 * Test honek lortuHerrialdeGuztiak metodoa probatzen du. Konexioa egokia
	 * denean, herrialde guztiak lortu behar dira eta emaitzak ez dela null
	 * balidatzen du.
	 */
	@Test
	public void testlortuHerrialdeGuztiakOK() {
		konexioa.conectar();
		Connection conn = konexioa.getConnection();
		HerrialdeaDAO herrialdeaDAO = new HerrialdeaDAO();
		herrialdeaDAO.setConnection(conn);

		ArrayList<Herrialdea> herrialdea = new ArrayList<Herrialdea>();

		herrialdea = herrialdeaDAO.lortuHerrialdeGuztiak();

		assertNotNull(herrialdea);
	}

	/**
	 * Test honek lortuHerrialdeGuztiak metodoa probatzen du, baina konexioa itxita
	 * dagoenean. Horrela, emaitza hutsik egongo dela balidatuko du.
	 */
	@Test
	public void testlortuHerrialdeGuztiakKO() {
		konexioa.conectar();
		Connection conn = konexioa.getConnection();
		HerrialdeaDAO herrialdeaDAO = new HerrialdeaDAO();
		herrialdeaDAO.setConnection(conn);

		try {
			conn.close();
			ArrayList<Herrialdea> herrialdea = herrialdeaDAO.lortuHerrialdeGuztiak();
			assertTrue(herrialdea.isEmpty());
		} catch (SQLException e) {
		}

	}

	/**
	 * Test honek lortuID metodoa probatzen du, konexioa egonkorra denean. Herrialde
	 * baten ID lortu behar da eta emaitza ez dela null balidatzen du.
	 */
	@Test
	public void testlortuIDOK() {
		konexioa.conectar();
		Connection conn = konexioa.getConnection();
		HerrialdeaDAO herrialdeaDAO = new HerrialdeaDAO();
		herrialdeaDAO.setConnection(conn);

		String emaitza = herrialdeaDAO.lortuID("AAAA");

		assertNotNull(emaitza);
	}

	/**
	 * Test honek lortuID metodoa probatzen du, baina konexioa itxita dagoenean.
	 * Horrela, lortutako ID hutsik egongo dela balidatuko du.
	 */
	@Test
	public void testlortuIDKO() {
		konexioa.conectar();
		Connection conn = konexioa.getConnection();
		HerrialdeaDAO herrialdeaDAO = new HerrialdeaDAO();
		herrialdeaDAO.setConnection(conn);
		try {
			conn.close();
			String herrialdea = herrialdeaDAO.lortuID("AAAA");
			assertEquals(herrialdea, "");
		} catch (SQLException e) {

		}

	}

}