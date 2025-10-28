package Ariketa_1;

import java.util.Scanner;

public class Ariketa_1 {

	public static void main(String[] args) {

		int zbk = 0;
		boolean bikoiti = false;

		Scanner sc = new Scanner(System.in);

		System.out.println("Sartu zbk");
		zbk = sc.nextInt();

		bikoiti = eragiketa.bikoitiaDa(zbk);
		if (bikoiti) {
			System.out.println("Bikoiti");
		} else {
			System.out.println("Bakoiti");
		}
		sc.close();
	}
}
