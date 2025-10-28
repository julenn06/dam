package erabilgarriak;

import static org.junit.Assert.*;
import org.junit.Test;

public class ErabilgarriakTest {

	// ====================================//
	@Test
	public void sumarTest2pos() {
		int esperotakoa = 5;
		int jasotakoa = Erabilgarriak.sumar(2, 3);
		assertEquals(esperotakoa, jasotakoa);
	}

	@Test
	public void sumarTest2neg() {
		int esperotakoa = -27;
		int jasotakoa = Erabilgarriak.sumar(-9, -18);
		assertEquals(esperotakoa, jasotakoa);
	}

	@Test
	public void sumarTest1pos1neg() {
		assertEquals(5, Erabilgarriak.sumar(-2, 7));
	}

//=========================================//
	@Test
	public void restarTest2pos() {
		int esperotakoa = -1;
		int jasotakoa = Erabilgarriak.restar(2, 3);
		assertEquals(esperotakoa, jasotakoa);
	}

	@Test
	public void restarTest2neg() {
		int esperotakoa = 9;
		int jasotakoa = Erabilgarriak.restar(-9, -18);
		assertEquals(esperotakoa, jasotakoa);
	}

	@Test
	public void restarTest1pos1neg() {
		assertEquals(-9, Erabilgarriak.restar(-2, 7));
	}

//====================================//
	@Test
	public void multiplicarTest2pos() {
		int esperotakoa = 6;
		int jasotakoa = Erabilgarriak.multiplicar(2, 3);
		assertEquals(esperotakoa, jasotakoa);
	}

	@Test
	public void multiplicarTest2neg() {
		int esperotakoa = 6;
		int jasotakoa = Erabilgarriak.multiplicar(-2, -3);
		assertEquals(esperotakoa, jasotakoa);
	}

	@Test
	public void multiplicarTest1pos1neg() {
		assertEquals(-14, Erabilgarriak.multiplicar(-2, 7));
	}

//=========================================//
	@Test
	public void dividirTest2pos() {
		int esperotakoa = 6;
		int jasotakoa = (int) Erabilgarriak.dividir(18, 3);
		assertEquals(esperotakoa, jasotakoa);
	}

	@Test
	public void dividirTest2neg() {
		int esperotakoa = 2;
		int jasotakoa = (int) Erabilgarriak.dividir(-6, -3);
		assertEquals(esperotakoa, jasotakoa);
	}

	@Test
	public void dividirTest1pos1neg() {
		assertEquals(0, Erabilgarriak.multiplicar(4, 0));
	}

	// ==================================//
	@Test
	public void esParTestTrue() {
		assertTrue(Erabilgarriak.esPar(6));
	}

	@Test
	public void esParFalse() {
		assertFalse(Erabilgarriak.esPar(7));
	}

}