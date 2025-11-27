package controlador;

import java.util.Scanner;

import gestor.GestorJugadores;
import modelo.Jugador;

public class plantillaAPP {

	public static void main(String[] args) {

		// CREAR ARRAY DEL OBJETO EN EL GESTOR -> CREAR GESTOR EN EL MAIN
		Scanner sc = new Scanner(System.in);

		GestorJugadores Athletic = new GestorJugadores();

		Athletic.leerPlantilla();

		Athletic.verJugadores();
		
		System.out.println("---------------------------------");
		
		Athletic.ordenarJugadoresPorDorsal();
		
		System.out.println("---------------------------------");
		
		Athletic.verJugadores();

		int ope = 0;
		do {

			System.out.println("Elige una opción");
			System.out.println("1: Inscribir jugador");
			System.out.println("2: Buscar un jugador por dorsal");
			System.out.println("3: Buscar jugador por nombre");
			System.out.println("4: Borrar a un jugador");
			System.out.println("5 Cambiar datos");
			System.out.println("6 Jugadores por posición");
			System.out.println("7 Salir sin guardar");
			System.out.println("8 Salir y guardar");
			// TODO HACER EN UN MÉTODO
			String sope = sc.next();

			try {
				ope = Integer.parseInt(sope);
			} catch (Exception e) {
				System.out.println("Elige un número adecuado");
			}

			switch (ope) {

			case 1:

				int dorsal;
				do {
					System.out.println("Escribe el dorsal:");
					dorsal = sc.nextInt();
					if (Athletic.posicionPorDorsal(dorsal) != -1) {
						System.out.println("El dorsal ya está en uso");
					}
				} while (Athletic.posicionPorDorsal(dorsal) != -1);
				System.out.println("Escribe el nombre");
				String nombre = sc.next();
				System.out.println("Escribe la posición");
				String posición = sc.next();
				System.out.println("Y por último, escribe el sueldo");
				float sueldo = sc.nextFloat();

				boolean inscrito = Athletic.inscribirJugador(dorsal, nombre, posición, sueldo);

				if (inscrito) {
					System.out.println("Jugador inscrito");
				} else {
					System.out.println("Plantilla llena");
				}

				break;

			case 2:

				System.out.println("Introduce el dorsal a buscar:");
				int dorsalBuscar = sc.nextInt();

				Athletic.buscarJugadorDorsal(dorsalBuscar);

				break;

			case 3:

				System.out.println("Introduce el nombre a buscar:");
				String nombreBuscar = sc.next();

				Athletic.buscarJugadorNombre(nombreBuscar);

				break;

			case 4:

				Athletic.verJugadores();
				System.out.println("Elige el dorsal del jugador que quieras eliminar");
				int elegir = Athletic.parseoInt(sc.next());
				Athletic.borrarJugador(elegir);
				System.out.println("------------------");
				Athletic.verJugadores();

				break;

			case 5:
				System.out.println("Elige el dorsal un jugador para editar");
				int editar = sc.nextInt();
				if (Athletic.posicionPorDorsal(editar) != -1) {
					System.out.println("Elige qué quieres editar:\n1. Dorsal\n2. Nombre\n3. Posición\n4. Sueldo");
					int opeEditar = sc.nextInt();

					switch (opeEditar) {

					case 1:
						System.out.println("Elige el nuevo dorsal");
						int nuevoDorsal = Athletic.parseoInt(sc.next());
						Athletic.cambiarDorsal(editar, nuevoDorsal);
						break;

					case 2:
						System.out.println("Elige el nuevo nombre:");
						String nuevoNombre = sc.next();
						Athletic.cambiarNombre(editar, nuevoNombre);
						break;

					case 3:
						System.out.println("Elige una nueva posición");
						String nuevaPosicion = sc.next();
						Athletic.cambiarPosicion(editar, nuevaPosicion);
						break;

					case 4:
						System.out.println("Elige un nuevo sueldo");
						float nuevoSueldo = sc.nextFloat();
						Athletic.cambiarSueldo(editar, nuevoSueldo);
						break;
					}
				}
				break;

			case 6:
				System.out.println("Escoge la posición: portero, defensa, mediocentro o delantero:");
				String posi = sc.next();

				Jugador[] jugPos = Athletic.buscarJugadoresPosicion(posi);
				for (int i = 0; i < jugPos.length; i++) {
					if (jugPos[i] != null) {
						System.out.println(jugPos[i].toString());
					}
				}
				break;

			case 7:
				System.out.println("Saliendo sin guardar");

				break;

			case 8:
				System.out.println("Guardando...");
				Athletic.guardarPlantilla();
				break;

			default:
				System.out.println("Elige un número entre el 1 y el 6, por favor");
			}

		} while (ope != 8 && ope != 7);

		Athletic.verJugadores();
		sc.close();
	}

}
