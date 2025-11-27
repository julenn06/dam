package ariketa01_H;

public class Metodoak_H {

	public static void gehitu(String[] ikasleak, String[] moduluak, double[][] notak) {

		System.out.print("\t");
		for (String modulua : moduluak) {
			System.out.print(modulua + "\t");
		}
		System.out.println("Media");

		for (int i = 0; i < ikasleak.length; i++) {
			System.out.print(ikasleak[i] + "\t");

			double suma = 0;
			for (int j = 0; j < moduluak.length; j++) {
				System.out.print(notak[i][j] + "\t");
				suma += notak[i][j];
			}
			double mediaEstudiante = suma / moduluak.length;
			System.out.printf("%.2f\n", mediaEstudiante);
		}

		System.out.print("Media\t");
		for (int j = 0; j < moduluak.length; j++) {
			double suma = 0;
			for (int i = 0; i < ikasleak.length; i++) {
				suma += notak[i][j];
			}
			double mediaModulo = suma / ikasleak.length;
			System.out.printf("%.2f\t", mediaModulo);
		}
	}
}
