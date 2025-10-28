package Ariketa02;

import java.lang.reflect.Array;
import java.util.Arrays;

public class metodoak {

	static int[] aux;

	public static int sortuZenbakia(int zbk) {

		int[] array = new int[zbk];

		for (int i = 0; i < zbk; i++) {
			array[i] = (int) (Math.random() * 100) + 1;
		}
		System.out.println("100 zenbaki: " + Arrays.toString(array));
		aux = array;
		return zbk;

	}

	public static int taulakargatu(int zbk) {
		System.out.println();
		System.out.println("Lehenengo 20 zenbakiak: ");
		for (int i = 0; i < 20; i++) {
			System.out.print(aux[i] + ", ");
		}
		return zbk;
	}

	public static int bikoitiakbatu(int zbk) {
		int bakoiti = 0;
		for (int i = 0; i < Array.getLength(aux); i++) {
			if (aux[i] % 2 == 0) {
				bakoiti = bakoiti + aux[i];
			}
		}
		System.out.println();
		System.out.println();
		System.out.println("Bakoitien gehiketa: " + bakoiti);
		return zbk;
	}

	public static int bakoitiabatu(int zbk) {
		int bikoiti = 0;
		for (int i = 0; i < Array.getLength(aux); i++) {
			if (aux[i] % 2 != 0) {
				bikoiti = bikoiti + aux[i];
			}
		}
		System.out.println();
		System.out.println("Bikoitien gehiketa: " + bikoiti);
		return zbk;
	}
}