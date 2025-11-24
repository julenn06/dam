package gestor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import modelo.Jugador;

public class GestorJugadores {

	private Jugador[] jugadores = new Jugador[10];
	private int contador = 0;
	File oFile = new File("plantilla.txt"); //TIENE QUE ESTAR A LA MISMA ALTURA DE SRC

	public Jugador[] leerPlantilla() {

		try {
			BufferedReader oBufferedReader = new BufferedReader(new FileReader(oFile));
			String katea;
			while ((katea = oBufferedReader.readLine()) != null) {
				String[] campos = katea.split(";");
				inscribirJugador(Integer.parseInt(campos[0]), campos[1], campos[2], Float.parseFloat(campos[3]));

				/*
				 * EN CASO DE NO USAR EL MÉTODO DE INSCRIBIR Jugador jugador = new
				 * Jugador(Integer.parseInt(campos[0]), campos[1], campos[2],
				 * Float.parseFloat(campos[3])); jugadores[contador] = jugador; contador++;
				 */
			}
			oBufferedReader.close();
		} catch (FileNotFoundException fn) {
			System.out.println("Ez da fitxategia aurkitzen");
		} catch (IOException io) {
			System.out.println("I/O errorea ");
		}
		return jugadores;

	}

	public void verJugadores() {

		for (int i = 0; i < jugadores.length; i++) {
			if (jugadores[i] != null) {
				System.out.println(jugadores[i].toString());
			}
		}
	}

	public boolean inscribirJugador(int dorsal, String nombre, String posición, float sueldo) {

		boolean inscrito = false;

		if (contador < 10) {
			Jugador nuevoJugador = new Jugador(dorsal, nombre, posición, sueldo);
			jugadores[contador] = nuevoJugador;
			contador++;
			inscrito = true;
		}
		return inscrito;
	}

	public int posicionPorDorsal(int dorsal) {

		int index = -1;

		for (int i = 0; i < contador; i++) {
			if (dorsal == jugadores[i].getDorsal()) {
				index = i;
			}
		}
		return index;
	}

	public void buscarJugadorDorsal(int dorsal) {

		boolean encontrado = false;

		for (int i = 0; i < contador; i++) {
			if (dorsal == jugadores[i].getDorsal()) {
				System.out.println(jugadores[i].toString());
				encontrado = true;
				break;
			}

		}

		if (encontrado == false) {
			System.out.println("Jugador no encontrado");
		}

	}

	public void buscarJugadorNombre(String nombre) {

		boolean encontrado = false;

		for (int i = 0; i < contador; i++) {
			if (jugadores[i].getNombre().equals(nombre)) {
				System.out.println(jugadores[i].toString());
				encontrado = true;
			}

		}

		if (encontrado == false) {
			System.out.println("Jugador no encontrado");
		}

	}

	public void borrarJugador(int dorsal) {

		if (dorsal != -1) {
			int borrar = posicionPorDorsal(dorsal);
	
			jugadores[borrar] = null;
	
			for (int i = borrar; i < contador; i++) {
				jugadores[i] = jugadores[i + 1];
				jugadores[contador] = null;
			}
			contador--;
		} else {
			System.out.println("Elige otro dorsal");
		}
	}

	public void guardarPlantilla() {
		try {
			BufferedWriter oBufferedWriter = new BufferedWriter(new FileWriter(oFile));
			for (int i = 0; i < contador; i++) {

				oBufferedWriter.write(jugadores[i].toString());
				oBufferedWriter.newLine();
			}
			oBufferedWriter.close();
		} catch (FileNotFoundException fn) {
			System.out.println("Ez da fitxategia aurkitzen");
		} catch (IOException io) {
			System.out.println("I/O errorea ");
		}
	}
	
	public void cambiarNombre(int dorsal, String nuevoNombre) {
		
		int pos = posicionPorDorsal(dorsal);
		jugadores[pos].setNombre(nuevoNombre);
	}
	
	public void cambiarDorsal(int dorsal, int nuevoDorsal) {
		
		if (posicionPorDorsal(nuevoDorsal)==-1) {
			int pos = posicionPorDorsal(dorsal);
			jugadores[pos].setDorsal(nuevoDorsal);
		} else {
			System.out.println("El dorsal está en uso");
		}
	}
	
	public void cambiarPosicion(int dorsal, String nuevaPosicion) {
		
		int pos = posicionPorDorsal(dorsal);
		jugadores[pos].setPosición(nuevaPosicion);
	}
	
	public void cambiarSueldo(int dorsal, float nuevoSueldo) {
		
		int pos = posicionPorDorsal(dorsal);
		jugadores[pos].setSueldo(nuevoSueldo);
	}
	
	public int parseoInt(String numero) {
		
		int parseado;
		try {
			parseado = Integer.parseInt(numero);

		} catch (Exception e) {
			System.out.println("No es un int");
			parseado = -1;
		}
		return parseado;
	}

	public Jugador[] buscarJugadoresPosicion(String posicion) {
		
		Jugador[] js = new Jugador[contador];

		boolean encontrado = false;
		int total = 0;

		for (int i = 0; i < contador; i++) {
			if (jugadores[i].getPosición().equals(posicion)) {
				js[total] = jugadores[i];
				total++;
				encontrado = true;
			}

		}

		if (encontrado == false) {
			System.out.println("No hay jugadores en esa posición");
		}
		
		return js;
	}
	
	public Jugador[] buscarJugadoresPorSueldoRango(float sueldoMin, float sueldoMax) {
		
		Jugador[] js = new Jugador[contador];

		boolean encontrado = false;
		int total = 0;

		for (int i = 0; i < contador; i++) {
			if (jugadores[i].getSueldo()>sueldoMin && jugadores[i].getSueldo()<sueldoMax) {
				js[total] = jugadores[i];
				total++;
				encontrado = true;
			}

		}

		if (encontrado == false) {
			System.out.println("No hay jugadores en esa posición");
		}
		
		return js;
	}
	
	public void ordenarJugadoresPorDorsal() {
		
		Jugador aux;

		boolean aldaketa_BE = true;
		
		while (aldaketa_BE == true) {
			aldaketa_BE = false;
			for (int i = 0; i < contador-1; i++) {
				if (jugadores[i].getDorsal() > jugadores[i + 1].getDorsal()) {
					aux = jugadores[i];
					jugadores[i] = jugadores[i + 1];
					jugadores[i + 1] = aux;
					aldaketa_BE = true;
				}
			}
		}
			
			
	}
}
