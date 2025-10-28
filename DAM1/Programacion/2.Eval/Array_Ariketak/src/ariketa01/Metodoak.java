package ariketa01;

import java.lang.reflect.Array;

public class Metodoak {

	static int[] aux;

	public static int[] arraySortu(int zbk) {
		int[] arrayBerria = new int[zbk];
		for (int i = 0; i < zbk; i++) {
			arrayBerria[i] = (int) (Math.random() * (35 - 18 + 1) + 18);
		}

		aux = arrayBerria;
		return arrayBerria;
	}

	public static double batazbestekoa(int[] array) {
		double aux = 0;
		for (int i = 0; i < array.length; i++) {
			aux = aux + array[i];
			System.out.print(array[i] + ", ");
		}
		System.out.println();
		System.out.println("Batazbestekoa: " + aux / 20 + " urte.");
		return array.length;
	}

	public static int[] adinaImprimatu(int zbk) {

		for (int i = 0; i < Array.getLength(aux); i++) {
			System.out.print(aux[i] + ", ");
		}

		return aux;
	}
}