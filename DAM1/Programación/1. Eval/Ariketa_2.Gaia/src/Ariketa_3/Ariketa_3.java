package Ariketa_3;

import java.util.Scanner;

public class Ariketa_3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int nota = 0;

		System.out.println("sartu zure nota: ");
		nota = sc.nextInt();

		if (nota >= 1 && nota <= 2) {
			System.out.println("Gutxiegi");
		} else if (nota >= 3 && nota <= 4) {
			System.out.println("Gutxi");
		} else if (nota == 5) {
			System.out.println("Nahiko");
		} else if (nota == 6) {
			System.out.println("Ondo");
		} else if (nota >= 7 && nota <= 8) {
			System.out.println("Oso ondo");
		} else if (nota >= 9 && nota <= 10) {
			System.out.println("Bikain");
		} else {
			System.out.println("Error");
		}

		sc.close();

	}

}