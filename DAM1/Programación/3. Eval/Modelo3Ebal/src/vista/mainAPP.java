package vista;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.Equipo;
import modelo.EquipoDAO;
import modelo.Jugador;
import modelo.JugadorDAO;
import modelo.Posicion;
import utilidades.Conexion;

public class mainAPP {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Conexion conexion = new Conexion();
		conexion.conectar();

		EquipoDAO equipos = new EquipoDAO();
		JugadorDAO jugadores = new JugadorDAO();

		equipos.setConnection(conexion.conn);
		jugadores.setConnection(conexion.conn);

		Jugador j1 = new Jugador("Kerman Mendez", 6, Posicion.valueOf("MDP"), 4, "2021-07-01", (double) 24000);
		jugadores.crearJugador(j1);

		/*
		 * Equipo barricada = new Equipo("La Barricada", "Bilbao", "Kremlin", 2024);
		 * 
		 * equipos.crearEquipo(barricada);
		 */

		ArrayList<Equipo> equipoLista = new ArrayList<Equipo>();
		ArrayList<Jugador> jugadorLista = new ArrayList<Jugador>();

		equipoLista = equipos.cargarEquipos();
		jugadorLista = jugadores.cargarJugadores();

		jugadores.eliminarJugador("Athletic Club", "Kerman Mendez");

		for (Equipo equipo : equipoLista) {
			System.out.println(equipo.toString());
		}

		for (Jugador jugador : jugadorLista) {
			System.out.println(jugador.toString());
		}

		equipoLista = equipos.cargarEquipos();
		jugadorLista = jugadores.cargarJugadores();

		for (Equipo equipo : equipoLista) {
			System.out.println(equipo.toString());
		}

		for (Jugador jugador : jugadorLista) {
			System.out.println(jugador.toString());
		}

		sc.close();
	}

}
