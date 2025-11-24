package Ariketa_10;

import java.util.Scanner;

public class Ariketa_DoWhile {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int kontadorea = 0;

		System.out.println("Sartu zxenbaki bat:");
		int zbk = sc.nextInt();

		do {
			System.out.println(zbk * kontadorea);
			kontadorea++;
		} while (kontadorea <= 10);

		sc.close();
	}

}
