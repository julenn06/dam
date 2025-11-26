package prueba1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestFunciones {

	private int[] zenbakiak;
	private int kontagailua;
	private Funciones funciones = new Funciones();

	@Before
	public void setUp() {
		zenbakiak = new int[5];
		kontagailua = 0;
	}

	@Test
	public void test1OK() {
		boolean emaitza = funciones.gehituZenbakia(zenbakiak, 10, kontagailua);
		assertTrue(emaitza);
	}

	@Test
	public void test1KO() {
		kontagailua = 5;
		boolean emaitza = funciones.gehituZenbakia(zenbakiak, 10, kontagailua);
		assertFalse(emaitza);
	}

	@Test
	public void test2OK() {
		kontagailua = 5;
		zenbakiak[0] = 0;
		zenbakiak[1] = 1;
		zenbakiak[2] = 2;
		zenbakiak[3] = 3;
		zenbakiak[4] = 4;
		boolean emaitza = funciones.bilatuZenbakia(zenbakiak, 3, kontagailua);
		assertTrue(emaitza);
	}

	@Test
	public void test2KO() {
		kontagailua = 5;
		boolean emaitza = funciones.bilatuZenbakia(zenbakiak, 10, kontagailua);
		assertFalse(emaitza);
	}

	@Test
	public void test3OK() {
		kontagailua = 5;
		zenbakiak[0] = 0;
		zenbakiak[1] = 1;
		zenbakiak[2] = 2;
		zenbakiak[3] = 3;
		zenbakiak[4] = 4;
		boolean emaitza = funciones.eguneratuZenbakia(zenbakiak, 3, 4, kontagailua);
		assertTrue(emaitza);
	}

	@Test
	public void test3KO() {
		kontagailua = 5;
		boolean emaitza = funciones.eguneratuZenbakia(zenbakiak, 10, kontagailua, kontagailua);
		assertFalse(emaitza);
	}

	@Test
	public void test4OK() {
		kontagailua = 5;
		zenbakiak[0] = 0;
		zenbakiak[1] = 1;
		zenbakiak[2] = 2;
		zenbakiak[3] = 3;
		zenbakiak[4] = 4;
		boolean emaitza = funciones.kenduZenbakia(zenbakiak, 3, kontagailua);
		assertTrue(emaitza);
	}

	@Test
	public void test4KO() {
		kontagailua = 5;
		boolean emaitza = funciones.kenduZenbakia(zenbakiak, 10, kontagailua);
		assertFalse(emaitza);
	}

	@Test
	public void test5OK() {
		assertTrue(funciones.zenbakiaPositiboaDa(10));
	}

	@Test
	public void test5KO() {
		assertFalse(funciones.zenbakiaPositiboaDa(-10));
	}

	@Test
	public void test6OK() {
		assertEquals(funciones.bikoiztuZenbakia(10), 20);
	}

	@Test
	public void test7OK() {
		int emaitza = funciones.zenbakiarenEremua(-10);
		assertEquals(emaitza, -1);
	}

	@Test
	public void test7KO() {
		int emaitza = funciones.zenbakiarenEremua(10);
		assertEquals(emaitza, 100);
	}

	@Test
	public void test8OK() {
		assertTrue(funciones.zerrendaHutsik(kontagailua));
	}
	
	@Test
	public void test8KO() {
		assertFalse(funciones.zerrendaHutsik(4));
	}

	@Test
	public void test9OK() {
		double emaitza = funciones.batezBestekoa(zenbakiak, kontagailua);
		assertEquals(0.0, emaitza, 0.0001);
	}

	@Test
	public void test9KO() {
		kontagailua = 4;
		double emaitza = funciones.batezBestekoa(zenbakiak, kontagailua);
		assertEquals(0.0, emaitza, 0.0001);
	}
}
