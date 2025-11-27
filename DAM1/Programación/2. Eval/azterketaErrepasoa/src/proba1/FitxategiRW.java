package proba1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
File oFile = new File(izena);
System.out.println("Buscando archivo en: " + oFile.getAbsolutePath());
*/
public class FitxategiRW {

	public void proba() {
		File oFile = new File("Plantilla.txt");

		try (BufferedReader br = new BufferedReader(new FileReader(oFile))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
		} catch (FileNotFoundException fn) {
			System.out.println("Ez da fitxategia aurkitzen");
		} catch (IOException io) {
			System.out.println("I/O errorea");
		}
	}

	public Futbolista[] fitxategiaKargatu(String izena, Futbolista[] f) {

		int zenbat = 0;

		try {
			File oFile = new File(izena);
			BufferedReader oBufferedReader = new BufferedReader(new FileReader(oFile));
			String katea;

			while ((katea = oBufferedReader.readLine()) != null && zenbat < 25) {
				String[] datos = katea.split(";");

				if (datos.length >= 2) {
					String nombre = datos[0];
					int edad = Integer.parseInt(datos[1]);

					f[zenbat] = new Futbolista(nombre, edad);
					zenbat++;
				}
			}
			oBufferedReader.close();
		} catch (FileNotFoundException fn) {
			System.out.println("Ez da fitxategia aurkitzen.");
			return null; // Si no hay archivo, devolvemos null
		} catch (IOException io) {
			System.out.println("I/O errorea.");
			return null;
		}

		if (zenbat > 0) {
			return f;
		} else {
			return null;
		}

	}

	public void fitxategiaIrakurri(String izena, Futbolista[] f) {
		Futbolista[] jugadores = fitxategiaKargatu(izena, f);

		if (jugadores != null) {
			System.out.println("Futbolari guztiak:");
			for (Futbolista jugador : jugadores) {
				if (jugador != null) {
					jugador.ikusiJokalariak();
				}
			}
		} else {
			System.out.println("Ez dago daturik.");
		}
	}

	public Futbolista datuakSortu(Scanner sc, Futbolista[] f) {
		String izena = "";
		int adina = 0;
		System.out.println("Izena:");
		izena = sc.next();
		System.out.println("Adina:");
		adina = sc.nextInt();

		// Verificamos si ya hay espacio en el array
		for (int i = 0; i < f.length; i++) {
			if (f[i] == null) {
				Futbolista fNuevo = new Futbolista(izena, adina);
				f[i] = fNuevo; // Añadimos el nuevo jugador al primer espacio vacío
				System.out.println("Futbolista " + izena + " gehitu da.");
				return fNuevo;
			}
		}

		// Si no hay espacio, mostramos un mensaje
		System.out.println("Ez dago lekurik jokalari gehiago gehitzeko.");
		return null; // Si el array está lleno, no se añade el nuevo futbolista
	}

	public void EscribirFichTexto(Futbolista sartu, String fitxategia) {
		File oFile = new File(fitxategia);
		try (FileWriter oFileWriter = new FileWriter(oFile, true)) {

			String futbolista = sartu.toString();
			oFileWriter.write(System.lineSeparator());
			oFileWriter.write(futbolista);

		} catch (FileNotFoundException fn) {
			System.out.println("Ez da fitxategia aurkitzen");
		} catch (IOException io) {
			System.out.println("I/O errorea");
		}
	}

	public void bilatuIzenarekin(Scanner sc, Futbolista[] jugadores) {
		System.out.print("Sartu jokalariaren izena bilatzeko: ");
		String jokalaria = sc.next();
		boolean aurkituta = false;

		for (Futbolista jugador : jugadores) {
			if (jugador != null && jugador.getNombre().equalsIgnoreCase(jokalaria)) {
				jugador.ikusiJokalariak();
				aurkituta = true;
			}
		}

		if (!aurkituta) {
			System.out.println("Ez da aurkitu: " + jokalaria);
		}

	}

	public void bilatuBikoiztuak(Futbolista[] jugadores) {
		for (int i = 0; i < jugadores.length; i++) {
			if (jugadores[i] != null) {
				String nombre = jugadores[i].getNombre();
				for (int j = i + 1; j < jugadores.length; j++) {
					if (jugadores[j] != null && jugadores[j].getNombre().equalsIgnoreCase(nombre)) {
						System.out.println(nombre + " jokalaria bi aldiz edo gehiago ateratzen da");
						break; // Ya hemos encontrado el duplicado, no necesitamos seguir buscando.
					}
				}
			}
		}
	}

	public void ezabatuLerroa(Scanner sc, Futbolista[] f, String fitxategia) {
		String izena = fitxategia;
		String futbolistaIzena = "";

		fitxategiaIrakurri(izena, f);

		System.out.println();
		System.out.println("Zein futbolista ezabatu nahi duzu?");
		futbolistaIzena = sc.next();

		File oFile = new File(izena);
		File tempFile = new File("temp_" + izena);

		try (BufferedReader br = new BufferedReader(new FileReader(oFile));
				BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

			String linea;
			boolean aurkituta = false;
			boolean isFirstLine = true; // Para controlar el formato del archivo

			while ((linea = br.readLine()) != null) {
				String[] datos = linea.split(";");
				if (datos.length > 0 && datos[0].equalsIgnoreCase(futbolistaIzena)) {
					aurkituta = true; // Se encontró el jugador, no lo escribimos en el nuevo archivo
					continue;
				}

				if (!linea.trim().isEmpty()) { // Evitar escribir líneas vacías
					if (!isFirstLine) {
						bw.newLine(); // Agregar salto de línea SOLO si no es la primera línea
					}
					bw.write(linea);
					isFirstLine = false;
				}
			}

			if (!aurkituta) {
				System.out.println("Ez da aurkitu jokalaria: " + futbolistaIzena);
			} else {
				System.out.println("Jokalaria ezabatuta: " + futbolistaIzena);
			}

		} catch (IOException e) {
			System.out.println("I/O errorea.");
		}

		// Reemplazar el archivo original por el temporal
		if (oFile.delete()) {
			tempFile.renameTo(oFile);
		} else {
			System.out.println("Fitxategia ez da eguneratu.");
		}
	}

	public void jokalariGuztiak(Futbolista[] jugadores) {
		if (jugadores == null || jugadores.length == 0) {
			System.out.println("Ez dago futbolaririk fitxategian.");
			return;
		}
		System.out.println();
		System.out.println("Futbolari guztiak:");
		boolean daudeJokalariak = false;

		for (Futbolista jugador : jugadores) {
			if (jugador != null) {
				jugador.ikusiJokalariak();
				daudeJokalariak = true;
			}
		}

		if (!daudeJokalariak) {
			System.out.println("Ez daude futbolaririk zerrendan.");
		}
	}

	public void sortuFitxategia(Scanner sc) {
		System.out.println("Nola deituko da zure fitxategia? (.txt barik)");
		String izena = sc.next();
		File archivo = new File(izena + ".txt");
		if (archivo.exists()) {
			System.out.println(izena + ".txt" + " fitxategia ba zegoen sortuta.");
		} else {
			try {
				if (archivo.createNewFile()) {
					System.out.println(izena + ".txt" + " fitxategia sortu da");
				} else {
					System.out.println("Ezin izan fitxategia sortu");
				}
			} catch (IOException e) {
				System.out.println("Errorea fitxategia sortzean: " + e.getMessage());
			}
		}
	}

	public void ezabatuFitxategia(Scanner sc) {
		System.out.println("Idatzi ezabatu nahi duzun Fitxategia:");
		String fitxategiIzena = sc.next();

		File fitxategia = new File(fitxategiIzena);

		if (!fitxategia.exists()) {
			System.out.println("⚠ Fitxategia ez da existitzen: " + fitxategiIzena);
			return;
		}

		if (fitxategia.delete()) {
			System.out.println("Fitxategia ondo ezabatu da: " + fitxategiIzena);
		} else {
			System.out.println("Fitxategia ez da ezabatu: " + fitxategiIzena);
		}
	}

	public void ordenarPorNombre(Futbolista[] jugadores, String archivo) {
		for (int i = 0; i < jugadores.length - 1; i++) {
			for (int j = 0; j < jugadores.length - 1 - i; j++) {
				if (jugadores[j] != null && jugadores[j + 1] != null) {
					// Comparamos los nombres en orden alfabético
					if (jugadores[j].getNombre().compareToIgnoreCase(jugadores[j + 1].getNombre()) > 0) {
						// Intercambiamos los jugadores
						Futbolista temp = jugadores[j];
						jugadores[j] = jugadores[j + 1];
						jugadores[j + 1] = temp;
					}
				}
			}
		}
		// Guardar los datos ordenados de nuevo en el archivo
		guardarEnArchivo(archivo, jugadores);
	}

	public void ordenarPorEdad(Futbolista[] jugadores, String archivo) {
		for (int i = 0; i < jugadores.length - 1; i++) {
			for (int j = 0; j < jugadores.length - 1 - i; j++) {
				if (jugadores[j] != null && jugadores[j + 1] != null) {
					// Comparamos las edades
					if (jugadores[j].getEdad() > jugadores[j + 1].getEdad()) {
						// Intercambiamos los futbolistas
						Futbolista temp = jugadores[j];
						jugadores[j] = jugadores[j + 1];
						jugadores[j + 1] = temp;
					}
				}
			}
		}
		// Guardar los datos ordenados de nuevo en el archivo
		guardarEnArchivo(archivo, jugadores);
	}

	public void editarFutbolista(Futbolista[] jugadores, Scanner sc, String archivo) {
		// Mostrar todas las filas con los futbolistas
		System.out.println("Futbolari guztiak:");
		for (int i = 0; i < jugadores.length; i++) {
			if (jugadores[i] != null) {
				System.out.println((i + 1) + ". " + jugadores[i].getNombre() + " - Edad: " + jugadores[i].getEdad());
			}
		}

		// Pedir al usuario que elija el futbolista a editar
		System.out.print("Editatu nahi duzun futbolistaren zenbakia sartu (1-" + jugadores.length + "): ");
		int futbolistaIndex = sc.nextInt() - 1;

		// Verificar si la opción es válida
		if (futbolistaIndex >= 0 && futbolistaIndex < jugadores.length && jugadores[futbolistaIndex] != null) {
			Futbolista jugador = jugadores[futbolistaIndex];

			// Mostrar los datos actuales del futbolista
			System.out.println("Futbolista hautatua: " + jugador.getNombre() + " - Adina: " + jugador.getEdad());

			// Pedir nuevos datos
			System.out.print("Sartu futbolistaren izen berria: ");
			String nuevoNombre = sc.next();
			System.out.print("Sartu futbolistaren adina berria: ");
			int nuevaEdad = sc.nextInt();

			// Actualizamos el futbolista con los nuevos datos
			jugador.setNombre(nuevoNombre);
			jugador.setEdad(nuevaEdad);

			System.out.println("Futbolista eguneratua: " + jugador.getNombre() + " - Adina: " + jugador.getEdad());

			// Guardar los datos actualizados en el archivo
			guardarEnArchivo(archivo, jugadores);
		} else {
			System.out.println("Ez da futbolista hori aurkitu.");
		}
	}

	public void guardarEnArchivo(String archivo, Futbolista[] jugadores) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
			int contador = 0;

			// Primero contar cuántos jugadores no son nulos
			for (Futbolista jugador : jugadores) {
				if (jugador != null) {
					contador++;
				}
			}

			// Ahora escribir los jugadores en el archivo
			for (int i = 0; i < jugadores.length; i++) {
				if (jugadores[i] != null) {
					bw.write(jugadores[i].getNombre() + ";" + jugadores[i].getEdad());

					// Si no es el último jugador, añadimos un salto de línea
					if (contador > 1) {
						bw.newLine();
						contador--;
					}
				}
			}
			System.out.println("Fitxategia ondo eguneratua.");
		} catch (IOException e) {
			System.out.println("I/O errorea: " + e.getMessage());
		}
	}

	public void mostrarFutbolistasPorEdad(Futbolista[] jugadores, Scanner sc) {
		System.out.println("Zein adina baino handiago diren jokalariak ikusi nahi dituzu?");
		int edadMinima = sc.nextInt();
		System.out.println("Futbolistak " + edadMinima + " urte baino gehiago dituztenak:");

		boolean hayJugadores = false;

		for (Futbolista jugador : jugadores) {
			if (jugador != null && jugador.getEdad() >= edadMinima) {
				System.out.println(jugador.getNombre() + " - Adina: " + jugador.getEdad());
				hayJugadores = true;
			}
		}

		if (!hayJugadores) {
			System.out.println("Ez dago futbolistarik " + edadMinima + " urtetik gora.");
		}
	}

}
