package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import modelo.LibZerrenda;
import modelo.Liburua;

public class TestLibZerrenda {

	private Liburua liburua;
	private Liburua liburua2;
	private Liburua liburua3;
	LibZerrenda lib = new LibZerrenda();

	@Before
	public void setUp() {
		liburua = new Liburua("izenburua", "11111111", "Julen");
		liburua2 = new Liburua("izenburua2", "22222222", "Julen");
		liburua3 = new Liburua("izenburua3", "33333333", "Julen");
		lib.gehitu(liburua);
		lib.gehitu(liburua2);
		lib.gehitu(liburua3);
	}

	@Test
	public void testGehituOK() {
		lib.gehitu(liburua);
	}

	@Test
	public void testbetetaOK() {
		Liburua liburua2 = new Liburua("izenburua", "11111111", "Julen");
		lib.gehitu(liburua2);
		Liburua liburua3 = new Liburua("izenburua", "11111111", "Julen");
		lib.gehitu(liburua3);
		Liburua liburua4 = new Liburua("izenburua", "11111111", "Julen");
		lib.gehitu(liburua4);
		boolean emaitza = lib.beteta();
		assertTrue(emaitza);
	}

	@Test
	public void testbetetaKO() {
		boolean emaitza = lib.beteta();
		assertNotNull(emaitza);
	}

	@Test
	public void testezabatuOK() {
		Liburua liburua2 = new Liburua("izenburua", "11111111", "Julen");
		lib.gehitu(liburua2);
		Liburua liburua3 = new Liburua("izenburua", "11111111", "Julen");
		lib.gehitu(liburua3);
		boolean emaitza = lib.ezabatu("11111111");
		assertTrue(emaitza);
	}

	@Test
	public void testezabatuKO() {
		boolean emaitza = lib.ezabatu("aaaaaaaa");
		assertFalse(emaitza);
	}

	@Test
	public void testbilatuisbnKO() {
		int emaitza = lib.bilatuisbn("aaaaaaaa");

		assertEquals(-1, emaitza);
	}

	@Test
	public void testbilatutitOK() {
		int emaitza = lib.bilatutit("izenburua3");
		assertEquals(2, emaitza);
	}
	
	@Test
	public void testbilatutitOK2() {
		int emaitza = lib.bilatutit("izenburua");
		assertEquals(0, emaitza);
	}
	
	@Test
	public void testeskuratuOK() {
		Liburua emaitza = lib.eskuratu(1);
		assertEquals(liburua2, emaitza);
	}
	
	@Test
	public void testeskuratuKO() {
		Liburua emaitza = lib.eskuratu(5);
		assertNull(emaitza);
	}
	
	@Test
	public void testeskuratuKO2() {
		Liburua emaitza = lib.eskuratu(-5);
		assertNull(emaitza);
	}
}
