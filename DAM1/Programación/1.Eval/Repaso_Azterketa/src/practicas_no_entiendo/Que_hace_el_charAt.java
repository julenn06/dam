package practicas_no_entiendo;

import java.util.Scanner;

public class Que_hace_el_charAt {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int kont = 0;
		int kontespacios = 0;

		String palabra = "";

		String prueba = "ayuda";

		// UpperCase o lowerCase para mayusculas y minusculas
		if (prueba.toUpperCase().charAt(0) == 'A' || prueba.toLowerCase().charAt(0) == 'a') {
			System.out.println("La primera letra es una A");
		} else {
			System.out.println("La primera letra no es una A");
		}

		for (int i = 0; i < prueba.length(); i++) {
			if (prueba.toUpperCase().charAt(i) == 'A' || prueba.toLowerCase().charAt(i) == 'a') {
				kont++;
			}
		}

		System.out.println("hay " + kont + " letras que son una A ");

		System.out.println();
		System.out.println("Escribe una palabra ");

		palabra = sc.nextLine();
		for (int i = 0; i < palabra.length(); i++) {
			if (palabra.charAt(i) == ' ') {
				kontespacios++;
			}
		}

		System.out.println("En esta palabra hay " + kontespacios + " espacios");

		// Quitar los espacios de la palabra
		String palabraSinEspacios = "";
		for (int i = 0; i < palabra.length(); i++) {
			if (palabra.charAt(i) == ' ') {
				palabraSinEspacios = palabra.replace(" ", "");
			}
		}

		System.out.println("Palabra sin espacios: " + palabraSinEspacios);

		// Comprobar si en una posicion es algun numero
		for (int i = 0; i < palabraSinEspacios.length(); i++) {
			char caracter = palabraSinEspacios.charAt(i);

			// Verificar si es un número
			if (Character.isDigit(caracter)) {
				System.out.println("El caracter en la posición " + i + " es un número: " + caracter);
			} else {
				System.out.println("El caracter en la posición " + i + " no es un número.");
			}
		}

		System.out.println();

		// Comprobar si en una posicion es alguna letra
		for (int i = 0; i < palabraSinEspacios.length(); i++) {
			char caracter = palabraSinEspacios.charAt(i);

			// Verificar si es un número
			if (Character.isLetter(caracter)) {
				System.out.println("El caracter en la posición " + i + " es una letra : " + caracter);
			} else {
				System.out.println("El caracter en la posición " + i + " no es una letra.");
			}
		}

		sc.close();
	}
}
