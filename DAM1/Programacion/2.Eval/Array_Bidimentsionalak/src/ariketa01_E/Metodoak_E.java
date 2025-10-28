package ariketa01_E;

public class Metodoak_E {

	public static void gehitu(String[] ikasleak, String[] moduluak, double[][] notak) {

		System.out.print("\t");
		for (String modulua : moduluak) {
			System.out.print(modulua + "\t");
		}
		System.out.println();

		for (int i = 0; i < ikasleak.length; i++) {
			System.out.print(ikasleak[i] + "\t");

			for (int j = 0; j < moduluak.length; j++) {
				System.out.print(notak[i][j] + "\t");
			}

			System.out.println();
		}
	}
}
