package Ariketa_10;

import java.util.Scanner;

public class Ariketa_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int zbk1 = 0;
		int zbk2 = 0;
		int zbk3 = 0;

		System.out.println("Sartu lehenengo zenbakia: ");
		zbk1 = sc.nextInt();

		System.out.println("Sartu bigarren zenbakia: ");
		zbk2 = sc.nextInt();

		System.out.println("Sartu hirugarren zenbakia: ");
		zbk3 = sc.nextInt();

		int handiena = zbk1;

		int txikiena = zbk1;

		if (handiena < zbk2) {
			handiena = zbk2;
		}
		if (handiena < zbk3) {
			handiena = zbk3;
		}

		if (txikiena > zbk2) {
			txikiena = zbk2;
		}
		if (txikiena > zbk3) {
			txikiena = zbk3;
		}

		System.out.println("zenbaki handiena " + handiena + " da, eta zenbaki txikiena " + txikiena + " da");

		sc.close();

	}
}