package Ariketa_15;

import java.util.Scanner;

public class Ariketa_15 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int zbk = 0;
		float a = 0;
		float b = 0;

		do {
			System.out.println();
			System.out.println("Gehiketa: 1");
			System.out.println("Kenketa: 2");
			System.out.println("Biderketa: 3");
			System.out.println("Zatiketa: 4");
			System.out.println("Atera: 5");
			System.out.println();
			System.out.println("Sartu Zenbakia:");
			zbk = sc.nextInt();

			if (zbk >= 1 && zbk <= 4) {
				System.out.println("Sartu Lehenengo Zenbakia:");
				a = sc.nextInt();
				System.out.println("Sartu Bigarren Zenbakia:");
				b = sc.nextInt();
			}
			switch (zbk) {

			case 1:
				System.out.println(a + b);
				break;
			case 2:
				System.out.println(a - b);
				break;
			case 3:
				System.out.println(a * b);
				break;
			case 4:
				if (b == 0) {
					System.out.println("Ezin duzu zatitu zati 0");
					break;
				} else {
					System.out.println(a / b);
					break;
				}
			case 5:
				System.out.println("Agur");
				// System.exit(0);
			}

		} while (zbk != 5);

		sc.close();

	}
}
