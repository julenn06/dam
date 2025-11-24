package ariketa01_D;

public class Metodoak_D {

	public static void gehitu(String[] ikasleak, String[] moduluak, double[][] notak) {

		for (int i = 0; i < ikasleak.length; i++) {
			System.out.println("Ikaslea: " + ikasleak[i]);

			for (int j = 0; j < moduluak.length; j++) {
				System.out.println("  Modulua: " + moduluak[j] + " - Nota: " + notak[i][j]);
			}
		}
	}
}
