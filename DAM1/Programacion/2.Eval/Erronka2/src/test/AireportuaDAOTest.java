package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import DAO.AireportuaDAO;
import Konexioa.KonexioaPrueba;
import modeloa.Aireportua;

public class AireportuaDAOTest {

	KonexioaPrueba konexioa = new KonexioaPrueba();

	List<Aireportua> aireportua = new ArrayList<Aireportua>();

	/**
	 * Aireportuen datuak lortzen ditu eta lortutako kopurua espero denarekin bat
	 * datorrela egiaztatzen du.
	 */
	@Test
	public void testlortuAireportuGuztiakOK() {

		konexioa.conectar();
		Connection conn = konexioa.getConnection();

		AireportuaDAO aireportuaDAO = new AireportuaDAO();
		aireportuaDAO.setConnection(conn);

		int emaitza = aireportua.size();

		aireportua = aireportuaDAO.lortuAireportuGuztiak();

		assertTrue(emaitza < aireportua.size());
	}

	/**
	 * Aireportuen datuak lortzen saiatzen da konexioa itxi ondoren eta errorea
	 * behar bezala kudeatzen dela egiaztatzen du.
	 */
	@Test
	public void testlortuAireportuGuztiakKO() {

		konexioa.conectar();
		Connection conn = konexioa.getConnection();
		try {
			conn.close();
			AireportuaDAO aireportuaDAO = new AireportuaDAO();
			aireportuaDAO.setConnection(conn);
			aireportua = aireportuaDAO.lortuAireportuGuztiak();
			assertEquals(aireportua.size(), 0);
		} catch (SQLException e) {
		}
	}
}