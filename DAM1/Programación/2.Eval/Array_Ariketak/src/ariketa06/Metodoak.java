package ariketa06;

public class Metodoak {

	public static int[] arraySortu(int zenbat, int[] zbk) {

		for (int i = 0; i < zenbat; i++) {
			zbk[i] = (int) (Math.random() * 100) + 1;
			System.out.println(zbk[i]);
			System.out.println();
		}
		return zbk;
	}

	public static int[] alderantzikatuArray(int[] zbk) {

		int kont = 0;
		int zenbakia;
		for (int i = zbk.length - 1; i >= (zbk.length - 1) / 2; i--) {

			zenbakia = zbk[i];

			zbk[i] = zbk[kont];
			zbk[kont] = zenbakia;
			kont++;
		}

		return zbk;
	}

	public static void arrayInprimatu(int[] alderantziz) {
		for (int i = 0; i < alderantziz.length; i++) {
			System.out.println(alderantziz[i]);
		}
	}
}