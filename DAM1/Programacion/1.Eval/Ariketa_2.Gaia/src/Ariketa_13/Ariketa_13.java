package Ariketa_13;

import java.util.Scanner;

public class Ariketa_13 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int notak = 0;
		int max = 0;
		int min = 0;

		for (int kontadorea = 1; kontadorea <= 10; kontadorea++) {

			System.out.println("Sartu zure nota");
			notak = sc.nextInt();

			if (notak >= 7) {
				max = max + 1;
			} else {
				min = min + 1;
			}
		}

		System.out.println("Zenbat pertsona 7 edo gehiago: " + max + ". Zenbat pertsona 7 baino gutxiago: " + min);

		sc.close();
	}
}