package prueba3;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestPersonas {

	private Personas personas;

	@Before
	public void before() {
		personas = new Personas("Julen", "Fernandez", 18);
	}

	@Test
	public void testConstructor() {
		String[] emaitza = { "nombre", "apellido", "20" };
		Personas otraPersona = new Personas("nombre", "apellido", 20);
		String[] emaitzaFinal = { otraPersona.getNombre(), otraPersona.getApellido(),
				String.valueOf(otraPersona.getEdad()) };
		assertArrayEquals(emaitza, emaitzaFinal);
	}

	@Test
	public void testgetIzena() {
		assertEquals("Julen", personas.getNombre());
	}

	@Test
	public void testsetIzena() {
		personas.setNombre("J");
		assertEquals("J", personas.getNombre());
	}

	@Test
	public void testgetApellido() {
		assertEquals("Fernandez", personas.getApellido());
	}

	@Test
	public void testsetApellido() {
		personas.setApellido("F");
		assertEquals("F", personas.getApellido());
	}

	@Test
	public void testgetEdad() {
		assertEquals(18, personas.getEdad());
	}

	@Test
	public void testsetEdad() {
		personas.setEdad(20);
		assertEquals(20, personas.getEdad());
	}

	@Test
	public void testToString() {
		String emaitza = "Persona{" + "nombre='" + "Julen" + '\'' + ", apellido='" + "Fernandez" + '\'' + ", edad=" + 18
				+ '}';

		assertEquals(emaitza, personas.toString());
	}
}
