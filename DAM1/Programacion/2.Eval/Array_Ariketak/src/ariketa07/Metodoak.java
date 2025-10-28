package ariketa07;

public class Metodoak {

	public static int[] taulaKargatu(int zenbat, int zbk[], int zbkmax) {
		System.out.println("");
		for (int i = 0; i < zenbat; i++) {
			zbk[i] = (int) (Math.random() * zbkmax);
			System.out.print(zbk[i] + " ");
		}
		System.out.println();

		return zbk;

	}

	public static int[] zeroakMugitu(int zenbat, int zbk[]) {
		int aux = 0;
		for (int i = 0; i < zenbat - 1; i++) {
			for (int j = 0; j < zenbat - 1; j++) {

				if (zbk[j] == 0) {

					aux = zbk[j];
					zbk[j] = zbk[j + 1];
					zbk[j + 1] = aux;

				}
			}
		}

		return zbk;

	}

	public static void arrayInprimatu(int zenbat, int zbk[]) {
		for (int i = 0; i < zenbat; i++) {
			System.out.print(zbk[i] + " ");
		}
	}
}