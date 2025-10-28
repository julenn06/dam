package practicas_no_entiendo;

import java.util.Scanner;

public class Que_hace_el_indexOf {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String prueba = "ayuda";

		String letra = "a";

		int aux = prueba.indexOf(letra);

		if (aux == -1) {
			System.out.println("No se ha encontrado el caracter");
		} else {
			System.out.println("Si se ha encontrado el caracter");
			System.out.println("se ha encontrado en la posicion: " + prueba.indexOf(letra));
		}

		sc.close();
	}

}
