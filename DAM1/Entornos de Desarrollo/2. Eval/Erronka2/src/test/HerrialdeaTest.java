package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import modeloa.Herrialdea;

public class HerrialdeaTest {

	private Herrialdea herrialdea;

	/**
	 * SetUp metodoa erabiltzen da test bakoitza aurretik prestatzeko. Herrialdea
	 * objektu bat eraikitzen da "ES" kodearekin eta "Espainia" izenarekin.
	 */
	@Before
	public void setUp() {
		herrialdea = new Herrialdea("ES", "Espainia");
	}

	/**
	 * Test honek Herrialdea klaseko getKodea metodoa probatzen du. Egiaztatzen da
	 * emaitza zuzena dela.
	 */
	@Test
	public void testGetKodea() {
		assertEquals("ES", herrialdea.getKodea());
	}

	/**
	 * Test honek Herrialdea klaseko setKodea metodoa probatzen du. Aldaketa egin
	 * dela behar bezala.
	 */
	@Test
	public void testSetKodea() {
		herrialdea.setKodea("FR");
		assertEquals("FR", herrialdea.getKodea());
	}

	/**
	 * Test honek Herrialdea klaseko getHerrialdea metodoa probatzen du.
	 * Herrialdearen izena zuzenean eskatzen da eta egiaztatzen da emaitza zuzena
	 * dena.
	 */
	@Test
	public void testGetHerrialdea() {
		assertEquals("Espainia", herrialdea.getHerrialdea());
	}

	/**
	 * Test honek Herrialdea klaseko setHerrialdea metodoa probatzen du.
	 * Herrialdearen izena aldatzen da eta egiaztatzen da aldaketa egin dela behar
	 * bezala.
	 */
	@Test
	public void testSetHerrialdea() {
		herrialdea.setHerrialdea("Frantzia");
		assertEquals("Frantzia", herrialdea.getHerrialdea());
	}

	/**
	 * Test honek Herrialdea klaseko toString metodoa probatzen du. ToString
	 * metodoak Herrialdea objektuaren egoera zuzena itzuli behar du, eta
	 * egiaztatzen da itzulitako balioa espero dena dela.
	 */
	@Test
	public void testToString() {
		String expected = "Herrialdea [kodea=ES, herrialdea=Espainia]";
		assertEquals(expected, herrialdea.toString());
	}

}
