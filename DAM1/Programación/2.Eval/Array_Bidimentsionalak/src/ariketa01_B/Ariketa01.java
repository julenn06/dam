package ariketa01_B;

import java.util.Scanner;

public class Ariketa01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		final int IKASLEAK = 4;
		final int MODULUAK = 3;
		double[][] notak = { { 5.2, 3.2, 6.7 }, { 5.3, 6.5, 3.4 }, { 2.3, 5.8, 9.7 }, { 2.4, 5.5, 7.4 } };

		Metodoak_B.kargatuTaula(IKASLEAK, MODULUAK, notak);

		sc.close();
	}
}
