package prueba1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ClaudiaTeses {
	private Funciones ff;
	private int[] aa;

	@Before
	public void setUp() {
		ff = new Funciones();
		aa = new int[4];
		aa[0] = 1;
		aa[1] = 2;
		aa[2] = 3;
		aa[3] = 4;
	}

	@Test
	public void testzenbakiarenEremuaOK() {
		assertEquals(-1, ff.zenbakiarenEremua(-5));
	}

	@Test
	public void testzenbakiarenEremuaKO() {
		assertEquals(25, ff.zenbakiarenEremua(5));
	}

	@Test
	public void testzerrendaHutsikOK() {
		assertTrue(ff.zerrendaHutsik(0));
	}

	@Test
	public void testzerrendaHutsikKO() {
		assertFalse(ff.zerrendaHutsik(5));
	}

	@Test
	public void testbatezBestekoaOK() {
		assertEquals(0, ff.batezBestekoa(aa, 0), 0.1);
	}

	@Test
	public void testbatezBestekoaKO() {
		assertEquals(2.5, ff.batezBestekoa(aa, 4), 0.1);
	}

	@Test
	public void testisAdultOK() {
		assertTrue(ff.isAdult(18));
	}
	
	@Test
	public void testisAdultKO() {
		assertFalse(ff.isAdult(0));
	}
	
	@Test
	public void testaddIfPositiveOK() {
		assertEquals(7, ff.addIfPositive(2, 5));
	}
	
	@Test
	public void testaddIfPositiveKOO() {
		assertEquals(0, ff.addIfPositive(2, 0));
	}
	
	@Test
	public void testaddIfPositiveKO() {
		assertEquals(0, ff.addIfPositive(0, 5));
	}
	
	@Test
	public void testaddIfPositiveKOOO() {
		assertEquals(0, ff.addIfPositive(0, -5));
	}
	
}
