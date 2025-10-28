package Ariketa_10;

import java.util.Scanner;

public class Ariketa_while {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int kontadorea = 1;

		System.out.println("sartu zenbaki ba:");
		int zenbakia = sc.nextInt();

		while (kontadorea <= 10) {

			System.out.println(zenbakia * kontadorea);
			kontadorea++;
		}

		sc.close();

	}
}