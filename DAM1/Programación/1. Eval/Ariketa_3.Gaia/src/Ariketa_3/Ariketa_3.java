package Ariketa_3;

import java.util.Scanner;

public class Ariketa_3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int zbk1 = 0;
		int zbk2 = 0;
		boolean handia = false;

		System.out.println("Sartu lehenengo zenbakia");
		zbk1 = sc.nextInt();
		System.out.println("Sartu bigarren zenbakia");
		zbk2 = sc.nextInt();

		handia = Max.handiagoaDa(zbk1, zbk2);

		if (handia == false) {
			System.out.println(zbk1 + " handiagoa da " + zbk2 + " baino.");
		} else {
			System.out.println(zbk2 + " handiagoa da " + zbk1 + " baino.");
		}
		sc.close();

	}
}
