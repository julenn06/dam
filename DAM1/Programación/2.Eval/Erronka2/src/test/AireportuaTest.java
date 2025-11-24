package test;

import static org.junit.Assert.*;

import org.junit.Test;

import modeloa.Aireportua;

public class AireportuaTest {

	private Aireportua aireportua1 = new Aireportua("124", "AeropuertoTest");

	/**
	 * Aireportuaren konstruktorea probatzen du, identifikatzailea eta izena
	 * zuzenean egiaztatzen ditu.
	 */
	@Test
	public void testConstructor() {
		assertEquals("124", aireportua1.getIdentifikatzailea());
		assertEquals("AeropuertoTest", aireportua1.getIzena());
	}

	/**
	 * Aireportuaren identifikatzailea eskatzen eta ezartzen duen metodoa probatzen
	 * du. Aldaketa zuzena egiaztatzen du.
	 */
	@Test
	public void testGetSetIdentifikatzailea() {
		aireportua1.setIdentifikatzailea("456");
		assertEquals("456", aireportua1.getIdentifikatzailea());
	}

	/**
	 * Aireportuaren izena eskatzen eta ezartzen duen metodoa probatzen du. Aldaketa
	 * zuzena egiaztatzen du.
	 */
	@Test
	public void testGetSetIzena() {
		aireportua1.setIzena("Nuevo Aeropuerto");
		assertEquals("Nuevo Aeropuerto", aireportua1.getIzena());
	}

	/**
	 * Aireportuaren toString metodoa probatzen du, eta bere forma egokia
	 * egiaztatzen du.
	 */
	@Test
	public void testToString() {
		String expectedString = "Aireportua [identifikatzailea=124, izena=AeropuertoTest]";
		assertEquals(expectedString, aireportua1.toString());
	}

	/**
	 * Aireportuaren toString metodoa probatzen du, aldaketa egin ondoren, egokia
	 * dela egiaztatzen du.
	 */
	@Test
	public void testToStringAfterSet() {
		aireportua1.setIdentifikatzailea("789");
		aireportua1.setIzena("Aeropuerto Modificado");
		String expectedString = "Aireportua [identifikatzailea=789, izena=Aeropuerto Modificado]";
		assertEquals(expectedString, aireportua1.toString());
	}
}
