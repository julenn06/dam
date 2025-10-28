package Ariketa_11;

import java.util.Scanner;

public class Ariketa_11 {

	public static void main(String[] args) {

		int bakoiti = 0;
		int bikoiti = 0;

		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= 5; i++) {
			System.out.printf("Sartu bost zenbaki: ");
			int zbk = sc.nextInt();

			if (zbk % 2 == 0) {
				bikoiti++;

			} else {
				bakoiti++;
			}
		}
		sc.close();
		System.out.printf("Bakoiti guztiak " + bakoiti + " dira eta bikoiti guztiak " + bikoiti + " dira.");
	}
}