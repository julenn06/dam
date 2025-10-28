package ariketa01_F;

public class Metodoak_F {

	public static void gehitu(String[] ikasleak, String[] moduluak, double[][] notak) {

		for (int i = 0; i < ikasleak.length; i++) {
			double media = 0;
			System.out.print(ikasleak[i] + "\t");

			for (int j = 0; j < moduluak.length; j++) {
				media = media + notak[i][j];

			}
			media = media / moduluak.length;
			System.out.printf("%.2f\n", media);
		}
	}
}
