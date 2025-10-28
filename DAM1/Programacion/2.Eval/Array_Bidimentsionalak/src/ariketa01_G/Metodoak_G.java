package ariketa01_G;

public class Metodoak_G {

	public static void gehitu(String[] ikasleak, String[] moduluak, double[][] notak) {

		for (int j = 0; j < moduluak.length; j++) {
			double media = 0;
			System.out.print(moduluak[j] + "\t");

			for (int i = 0; i < ikasleak.length; i++) {
				media = media + notak[i][j];
			}

			media = media / ikasleak.length;
			System.out.printf("%.2f\n", media);
		}
	}
}
