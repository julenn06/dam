package prueba2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestFunciones {

	private Funciones funciones = new Funciones();

	@Test
	public void test1OK() {
		int emaitza = funciones.addIfPositive(4, 3);
		assertEquals(7, emaitza);
	}

	@Test
	public void test1KO() {
		int emaitza = funciones.addIfPositive(-4, 3);
		assertEquals(0, emaitza);
	}

	@Test
	public void test2OK() {
		boolean emaitza = funciones.isEven(0);
		assertTrue(emaitza);
	}

	@Test
	public void test2KO() {
		boolean emaitza = funciones.isEven(1);
		assertFalse(emaitza);
	}

	@Test
	public void test3OK() {
		int[] zenbakiak = new int[5];
		zenbakiak[0] = 0;
		zenbakiak[1] = 1;
		zenbakiak[2] = 2;
		zenbakiak[3] = 3;
		zenbakiak[4] = 4;
		int[] emaitza = funciones.filterPositiveNumbers(zenbakiak);

		assertNotNull(emaitza);

	}

	@Test
	public void test4OK() {
		int emaitza = funciones.maxOfTwo(1, 0);
		assertEquals(1, emaitza);
	}

	@Test
	public void test4OK2() {
		int emaitza = funciones.maxOfTwo(0, 1);
		assertEquals(1, emaitza);
	}

	@Test
	public void test5OK() {
		boolean emaitza = funciones.isPalindrome("ala");
		assertTrue(emaitza);
	}

	@Test
	public void test5KO() {
		boolean emaitza = funciones.isPalindrome("prueba");
		assertFalse(emaitza);
	}

	@Test
	public void test6OK() {
		String[] hitzak = new String[3];
		hitzak[0] = "hitza1";
		hitzak[1] = "hitza2";
		hitzak[2] = "hitza3";
		String[] emaitza = funciones.filterStringsByLength(hitzak, 2);

		assertNotNull(emaitza);
	}

	@Test
	public void test6OK2() {
		String[] hitzak = new String[3];
		hitzak[0] = "hitza1";
		hitzak[1] = "hitza2";
		hitzak[2] = "hitza3";
		String[] emaitza = funciones.filterStringsByLength(hitzak, 10);

		assertNotNull(emaitza);
	}

	@Test
	public void test7OK() {
		int[] zenbakiak = new int[5];
		zenbakiak[0] = 0;
		zenbakiak[1] = 1;
		zenbakiak[2] = 2;
		zenbakiak[3] = 3;
		zenbakiak[4] = 4;
		int emaitza = funciones.countOccurrences(zenbakiak, 2);

		assertEquals(1, emaitza);
	}

	@Test
	public void test8OK() {
		int[] zenbakiak = new int[5];
		zenbakiak[0] = 0;
		zenbakiak[1] = 1;
		zenbakiak[2] = 2;
		zenbakiak[3] = 3;
		zenbakiak[4] = 0;
		boolean emaitza = funciones.hasDuplicate(zenbakiak);

		assertTrue(emaitza);
	}

	@Test
	public void test8KO() {
		int[] zenbakiak = new int[5];
		zenbakiak[0] = 0;
		zenbakiak[1] = 1;
		zenbakiak[2] = 2;
		zenbakiak[3] = 3;
		zenbakiak[4] = 4;
		boolean emaitza = funciones.hasDuplicate(zenbakiak);

		assertFalse(emaitza);
	}

	@Test
	public void test9OK() {
		int[] zenbakiak = new int[5];
		zenbakiak[0] = 1;
		zenbakiak[1] = 1;
		zenbakiak[2] = 2;
		zenbakiak[3] = 3;
		zenbakiak[4] = 4;
		int emaitza = funciones.sumArray(zenbakiak);

		assertEquals(11, emaitza);
	}

	@Test
	public void test9OK2() {
		int[] zenbakiak = new int[5];
		zenbakiak[0] = 0;
		zenbakiak[1] = 0;
		zenbakiak[2] = 2;
		zenbakiak[3] = 3;
		zenbakiak[4] = 4;
		int emaitza = funciones.sumArray(zenbakiak);

		assertEquals(9, emaitza);
	}

	@Test
	public void test10OK() {

		boolean emaitza = funciones.isAdult(20);

		assertTrue(emaitza);
	}

	@Test
	public void test10KO() {

		boolean emaitza = funciones.isAdult(14);

		assertFalse(emaitza);
	}
}
