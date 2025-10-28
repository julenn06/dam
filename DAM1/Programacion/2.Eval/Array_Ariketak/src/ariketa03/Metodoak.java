package ariketa03;

public class Metodoak {

	public static int[] arrayzenbakiak(int zbk, int[] array) {

		for (int i = 0; i < zbk; i++) {
			array[i] = (int) (Math.random() * 9) + 1;
		}

		return array;
	}

	public static void taulaKargatu(int[] array, int balioMin, int balioMax) {
		balioMin = Integer.MAX_VALUE;

		for (int i = 0; i < array.length; i++) {
			if (balioMax < array[i]) {
				balioMax = array[i];
			}
			if (array[i] < balioMin) {
				balioMin = array[i];
			}
		}
		System.out.println();
		System.out.println("Balio Maximoa: " + balioMax);
		System.out.println("Balio Minimoa: " + balioMin);
		System.out.println();
	}

	public static void maiztasunaErakutsi(int[] array) {
		int kont1 = 0;
		int kont2 = 0;
		int kont3 = 0;
		int kont4 = 0;
		int kont5 = 0;
		int kont6 = 0;
		int kont7 = 0;
		int kont8 = 0;
		int kont9 = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] == 1) {
				kont1++;
			} else if (array[i] == 2) {
				kont2++;
			} else if (array[i] == 3) {
				kont3++;
			} else if (array[i] == 4) {
				kont4++;
			} else if (array[i] == 5) {
				kont5++;
			} else if (array[i] == 6) {
				kont6++;
			} else if (array[i] == 7) {
				kont7++;
			} else if (array[i] == 8) {
				kont8++;
			} else {
				kont9++;
			}
		}

		System.out.println("Zenbat aldiz 1 Zenbakia: " + kont1);
		System.out.println("Zenbat aldiz 2 Zenbakia: " + kont2);
		System.out.println("Zenbat aldiz 3 Zenbakia: " + kont3);
		System.out.println("Zenbat aldiz 4 Zenbakia: " + kont4);
		System.out.println("Zenbat aldiz 5 Zenbakia: " + kont5);
		System.out.println("Zenbat aldiz 6 Zenbakia: " + kont6);
		System.out.println("Zenbat aldiz 7 Zenbakia: " + kont7);
		System.out.println("Zenbat aldiz 8 Zenbakia: " + kont8);
		System.out.println("Zenbat aldiz 9 Zenbakia: " + kont9);

	}

	public static int[] arrayInprimatu(int[] array) {

		System.out.println();
		System.out.println("Arrayaren edukia: ");
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 9) + 1;
			System.out.print(array[i] + " ");
		}

		return array;
	}

}
