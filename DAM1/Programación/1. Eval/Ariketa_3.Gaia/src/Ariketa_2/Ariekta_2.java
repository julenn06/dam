package Ariketa_2;

import java.util.Scanner;

import Ariketa_1.eragiketa;

public class Ariekta_2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int zbk = 0;
		boolean bikoiti = false;
		int bik = 0;
		int bak = 0;

		for (int i = 0; i < 10; i++) {
			System.out.println("Sartu zbk bat");
			zbk = sc.nextInt();
			bikoiti = eragiketa.bikoitiaDa(zbk);

			if (bikoiti == false) {
				bak++;
			} else {
				bik++;
			}
		}

		System.out.println("Bakoiti: " + bak);

		System.out.println("Bikoiti: " + bik);

		sc.close();
	}
}