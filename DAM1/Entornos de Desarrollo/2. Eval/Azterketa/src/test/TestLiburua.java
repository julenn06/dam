package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import modelo.Liburua;

public class TestLiburua {
	private Liburua liburua;
	private Liburua hutsik;

	@Before
	public void setUp() {
		hutsik = new Liburua();
		liburua = new Liburua("izenburua", "11111111", "Julen");
	}

	@Test
	public void testgetIzenburua() {
		assertEquals("izenburua", liburua.getizenburua());
	}

	@Test
	public void testsetIzenburua() {
		liburua.setizenburua("berria");
		assertEquals("berria", liburua.getizenburua());
	}

	@Test
	public void testgetIsbn() {
		assertEquals("11111111", liburua.getisbn());
	}

	@Test
	public void testsetIsbn() {
		liburua.setisbn("22222222");
		assertEquals("22222222", liburua.getisbn());
	}

	@Test
	public void testgetIdazlea() {
		assertEquals("Julen", liburua.getidazlea());
	}

	@Test
	public void testsetIdazlea() {
		hutsik.setidazlea("Oier");
		assertEquals("Oier", hutsik.getidazlea());
	}

	@Test
	public void testToString() {
		String emaitza = "Liburua [izenburua=" + "izenburua" + ", isbn=" + "11111111" + ", idazlea=" + "Julen" + "]";
		assertEquals(emaitza, liburua.toString());
	}

	@Test
	public void testEquals() {
		boolean emaitza = liburua.equals(liburua);
		assertTrue(emaitza);
	}
}
