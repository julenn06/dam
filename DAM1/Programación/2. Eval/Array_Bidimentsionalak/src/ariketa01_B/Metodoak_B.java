package ariketa01_B;

public class Metodoak_B {

	public static void kargatuTaula(int IKASLEAK, int MODULUAK, double[][] notak) {

		for (int x = 0; x < notak.length; x++) {
			for (int y = 0; y < notak[x].length; y++) {

				System.out.print(" | ");
				System.out.print(notak[x][y]);
				System.out.print(" | ");

			}
			System.out.println();

		}
	}
}
