package practicas_no_entiendo;

import java.util.Scanner;

public class Que_hace_el_length {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String prueba = "ayuda";

		// Para recorrer cuantos caracteres de palabras hay
		System.out.println("Numero de letras: " + prueba.length());

		// Usandolo con el charAt un ejemplo
		for (int i = 0; i < prueba.length(); i++) {
			System.out.println(prueba.charAt(i));
		}

		sc.close();
	}
}