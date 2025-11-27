package Ariketa_10;

import java.util.Scanner;

public class Ariketa_for {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int zbk = 0;

		System.out.println("Sartu zenbaki bat:");
		zbk = sc.nextInt();

		for (int kontadorea = 1; kontadorea <= 10; kontadorea++) {
			System.out.println(kontadorea * zbk);

		}

		sc.close();
	}

}
