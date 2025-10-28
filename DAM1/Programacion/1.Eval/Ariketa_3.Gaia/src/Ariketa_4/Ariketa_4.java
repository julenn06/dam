package Ariketa_4;

import java.util.Scanner;

public class Ariketa_4 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int zbk = 0;
		boolean lehena = true;
		int zenbat;
		int kontlehena = 0;

		System.out.println("Sartu zenbaki bat");
		zbk = sc.nextInt();

		lehena = eragiketa.lehenaDa(zbk);

		if (lehena) {
			System.out.println("Zenbaki hau lehena da");
		}

		else {
			System.out.println("Zenbaki hau ez da lehena");
		}

		System.out.println("Sartu zbk bat");
		zenbat = sc.nextInt();
		while (kontlehena <= zenbat) {
			if (eragiketa.lehenaDa(zbk)) {
				kontlehena++;
				System.out.println(zbk);
			}
		}

		sc.close();
	}
}
