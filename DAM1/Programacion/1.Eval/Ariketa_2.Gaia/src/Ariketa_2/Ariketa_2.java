package Ariketa_2;

import java.util.Scanner;

public class Ariketa_2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int adina = 0;

		System.out.println("Sartu zure adina: ");
		adina = sc.nextInt();

		if (adina >= 18) {

			System.out.println("Adin nagusia zara");
		} else {
			System.out.println("Adin txikikoa zara");
		}

		sc.close();
	}
}