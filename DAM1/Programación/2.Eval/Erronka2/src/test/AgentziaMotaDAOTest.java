package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import DAO.AgentziaMotaDAO;
import Konexioa.KonexioaPrueba;
import modeloa.AgentziaMota;

public class AgentziaMotaDAOTest {

	KonexioaPrueba konexioa = new KonexioaPrueba();

	private AgentziaMotaDAO agentziaMotaDAO = new AgentziaMotaDAO();
	ArrayList<AgentziaMota> agentziak = new ArrayList<AgentziaMota>();

	/**
	 * Datu-basearekin konexioa ezarri eta agentzia motak lortzen ditu. Lortutako
	 * agentzia moten kopurua espero denaren berdina dela egiaztatzen du.
	 */
	@Test
	public void testLortuAgentziaGuztiakOK() {

		konexioa.conectar();
		Connection conn = konexioa.getConnection();

		agentziaMotaDAO.setConnection(conn);

		int emaitza = agentziak.size();

		agentziak = agentziaMotaDAO.lortuAgentziaMotak();

		assertTrue(emaitza < agentziak.size());
	}

	/**
	 * Datu-basearekin konexioa ezarri eta konexioa itxi ondoren agentzia motak
	 * lortzen saiatzen da. Errorea harrapatzen dela egiaztatzen du.
	 */
	@Test
	public void testLortuAgentziaGuztiakKO() {

		konexioa.conectar();
		Connection conn = konexioa.getConnection();
		try {
			conn.close();
			agentziaMotaDAO.setConnection(conn);
			ArrayList<AgentziaMota> agentziak = agentziaMotaDAO.lortuAgentziaMotak();
			assertEquals(agentziak.size(), 0);
		} catch (SQLException e) {
		}
	}
}
