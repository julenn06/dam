package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import modeloa.Agentzia;
import modeloa.Bidaia;

public class AgentziaTest {

	ArrayList<Bidaia> bidaiak = new ArrayList<>();
	Agentzia agentzia = new Agentzia(1, "TestAgentzia", "logo.png", "#FFFFFF", "50", "Turismo", "pass123",
			"erabiltzaile1", bidaiak);

	/**
	 * Agentziaren konstruktorea probatzen du, eta egiaztatzen du sartutako datuak
	 * behar bezala esleitzen direla getter bidez lortutako balioekin.
	 */
	@Test
	public void testConstructorAgentzia() {
		String[] emaitza = { "TestAgentzia", "logo.png", "#FFFFFF", "50", "Turismo", "pass123", "erabiltzaile1" };

		Agentzia agentzia = new Agentzia("TestAgentzia", "logo.png", "#FFFFFF", "50", "Turismo", "pass123",
				"erabiltzaile1");

		String[] emaitzaFinala = { agentzia.getIzena(), agentzia.getLogoa(), agentzia.getMarkaKolorea(),
				agentzia.getLangileKopurua(), agentzia.getAgentziaMota(), agentzia.getPasahitza(),
				agentzia.getErabiltzaile() };

		assertArrayEquals(emaitza, emaitzaFinala);
	}

	/**
	 * Agentziaren identifikatzailea lortzen du eta balio zuzena den egiaztatzen du.
	 */
	@Test
	public void testGetIdentifikatzailea() {
		assertEquals(1, agentzia.getIdentifikatzailea());
	}

	/**
	 * Agentziaren identifikatzailea ezartzen du eta egiaztatzen du aldaketa egin
	 * dela.
	 */
	@Test
	public void testSetIdentifikatzailea() {
		agentzia.setIdentifikatzailea(2);
		assertEquals(2, agentzia.getIdentifikatzailea());
	}

	/**
	 * Agentziaren izena lortzen du eta balio zuzena den egiaztatzen du.
	 */
	@Test
	public void testGetIzena() {
		assertEquals("TestAgentzia", agentzia.getIzena());
	}

	/**
	 * Agentziaren izena ezartzen du eta egiaztatzen du aldaketa egin dela.
	 */
	@Test
	public void testSetIzena() {
		agentzia.setIzena("NewAgentzia");
		assertEquals("NewAgentzia", agentzia.getIzena());
	}

	/**
	 * Agentziaren logoa lortzen du eta balio zuzena den egiaztatzen du.
	 */
	@Test
	public void testGetLogoa() {
		assertEquals("logo.png", agentzia.getLogoa());
	}

	/**
	 * Agentziaren logoa ezartzen du eta egiaztatzen du aldaketa egin dela.
	 */
	@Test
	public void testSetLogoa() {
		agentzia.setLogoa("newlogo.png");
		assertEquals("newlogo.png", agentzia.getLogoa());
	}

	/**
	 * Agentziaren marka kolorea lortzen du eta balio zuzena den egiaztatzen du.
	 */
	@Test
	public void testGetMarkaKolorea() {
		assertEquals("#FFFFFF", agentzia.getMarkaKolorea());
	}

	/**
	 * Agentziaren marka kolorea ezartzen du eta egiaztatzen du aldaketa egin dela.
	 */
	@Test
	public void testSetMarkaKolorea() {
		agentzia.setMarkaKolorea("#000000");
		assertEquals("#000000", agentzia.getMarkaKolorea());
	}

	/**
	 * Agentziaren langile kopurua lortzen du eta balio zuzena den egiaztatzen du.
	 */
	@Test
	public void testGetLangileKopurua() {
		assertEquals("50", agentzia.getLangileKopurua());
	}

	/**
	 * Agentziaren langile kopurua ezartzen du eta egiaztatzen du aldaketa egin
	 * dela.
	 */
	@Test
	public void testSetLangileKopurua() {
		agentzia.setLangileKopurua("100");
		assertEquals("100", agentzia.getLangileKopurua());
	}

	/**
	 * Agentziaren mota lortzen du eta balio zuzena den egiaztatzen du.
	 */
	@Test
	public void testGetAgentziaMota() {
		assertEquals("Turismo", agentzia.getAgentziaMota());
	}

	/**
	 * Agentziaren mota ezartzen du eta egiaztatzen du aldaketa egin dela.
	 */
	@Test
	public void testSetAgentziaMota() {
		agentzia.setAgentziaMota("Negocios");
		assertEquals("Negocios", agentzia.getAgentziaMota());
	}

	/**
	 * Agentziaren pasahitza lortzen du eta balio zuzena den egiaztatzen du.
	 */
	@Test
	public void testGetPasahitza() {
		assertEquals("pass123", agentzia.getPasahitza());
	}

	/**
	 * Agentziaren pasahitza ezartzen du eta egiaztatzen du aldaketa egin dela.
	 */
	@Test
	public void testSetPasahitza() {
		agentzia.setPasahitza("newpass");
		assertEquals("newpass", agentzia.getPasahitza());
	}

	/**
	 * Agentziaren erabiltzailea lortzen du eta balio zuzena den egiaztatzen du.
	 */
	@Test
	public void testGetErabiltzaile() {
		assertEquals("erabiltzaile1", agentzia.getErabiltzaile());
	}

	/**
	 * Agentziaren erabiltzailea ezartzen du eta egiaztatzen du aldaketa egin dela.
	 */
	@Test
	public void testSetErabiltzaile() {
		agentzia.setErabiltzaile("newuser");
		assertEquals("newuser", agentzia.getErabiltzaile());
	}

	/**
	 * Agentziaren toString metodoa egiaztatzen du, eta lortutako string-a espero
	 * denarekin alderatzen du.
	 */
	@Test
	public void testToString() {
		String expected = "Agentzia [identifikatzailea=1, izena=TestAgentzia, logoa=logo.png, markaKolorea=#FFFFFF, "
				+ "langileKopurua=50, agentziaMota=Turismo, pasahitza=pass123, erabiltzaile=erabiltzaile1]";
		assertEquals(expected, agentzia.toString());
	}
}
