package modeloa;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class JUnitTest {
	private TxakurKontenedorea kontenedorea;
	private Txakurra txakur1;
	private Txakurra txakur2;

	@Before
	public void setUp() {
		kontenedorea = new TxakurKontenedorea(5);
		txakur1 = new Txakurra("Fido", 3, "Labrador");
		txakur2 = new Txakurra("Rex", 2, "Pastor Alemán");
	}

	@Test
	public void testGehituTxakurra() {
		TxakurKontenedorea kontenedorea = new TxakurKontenedorea(2);
		Txakurra txakur1 = new Txakurra("Luna", 3, "Labrador");
		Txakurra txakur2 = new Txakurra("Rocky", 5, "Bulldog");

		assertTrue(kontenedorea.gehituTxakurra(txakur1));
		assertTrue(kontenedorea.gehituTxakurra(txakur2));

		Txakurra txakur3 = new Txakurra("Max", 2, "Poodle");
		assertFalse(kontenedorea.gehituTxakurra(txakur3));
	}

	@Test
	public void testBilatuIzenez() {
		kontenedorea.gehituTxakurra(txakur1);
		kontenedorea.gehituTxakurra(txakur2);

		assertEquals(txakur1, kontenedorea.bilatuIzenez("Fido"));
		assertEquals(txakur2, kontenedorea.bilatuIzenez("Rex"));
		assertNull(kontenedorea.bilatuIzenez("Max"));
	}

	@Test
	public void testEguneratuTxakurra() {
		kontenedorea.gehituTxakurra(txakur1);

		assertTrue(kontenedorea.eguneratuTxakurra("Fido", 4, "Golden Retriever"));
		assertEquals(4, txakur1.getAdina());
		assertEquals("Golden Retriever", txakur1.getArraza());

		assertFalse(kontenedorea.eguneratuTxakurra("Max", 2, "Bulldog"));
	}

	@Test
	public void testEzabatuTxakurra() {
		kontenedorea.gehituTxakurra(txakur1);
		kontenedorea.gehituTxakurra(txakur2);

		assertTrue(kontenedorea.ezabatuTxakurra("Fido"));
		assertNull(kontenedorea.bilatuIzenez("Fido"));

		assertFalse(kontenedorea.ezabatuTxakurra("Max"));
	}
}
