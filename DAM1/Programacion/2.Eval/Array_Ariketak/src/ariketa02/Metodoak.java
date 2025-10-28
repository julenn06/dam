package ariketa02;

public class Metodoak {

	public static int sortuZenbakia() {

		int zenbakia = 0;

		for (int i = 0; i < 1; i++) {
			zenbakia = (int) (Math.random() * 100) + 1;
		}
		System.out.println("Zenbakia: " + zenbakia);

		return zenbakia;

	}

	public static int[] taulakargatu(int zbk, int[] array) {
		System.out.println();
		System.out.println("Lehenengo 20 zenbakiak: ");
		for (int i = 0; i < array.length; i++) {
			array[i] = sortuZenbakia();
		}
		return array;
	}

	public static int bikoitiakbatu(int[] array) {
		int bakoiti = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 0) {
				bakoiti = bakoiti + array[i];
			}
		}
		System.out.println();
		System.out.println();
		System.out.println("Bakoitien gehiketa: " + bakoiti);
		return bakoiti;
	}

	public static int bakoitiabatu(int[] array) {
		int bikoiti = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 != 0) {
				bikoiti = bikoiti + array[i];
			}
		}
		System.out.println();
		System.out.println("Bikoitien gehiketa: " + bikoiti);
		return bikoiti;
	}
}