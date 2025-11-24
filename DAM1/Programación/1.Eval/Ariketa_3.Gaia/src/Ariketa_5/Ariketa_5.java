package Ariketa_5;

import java.util.Scanner;

public class Ariketa_5 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int zbk = 0;
		double a = 0;
		double b = 0;
		boolean kanpora = true;
		do {
			System.out.println("1. Batu ");
			System.out.println("2. Kendu ");
			System.out.println("3. Biderkatu ");
			System.out.println("4. Zatitu ");
			System.out.println("5 Atera ");
			zbk = sc.nextInt();

			if (zbk == 5) {
				kanpora = false;
				continue;
			}

			System.out.println("Sartu lehenengo zenbakia: ");
			a = sc.nextInt();
			System.out.println("Sartu bigarren zenbakia: ");
			b = sc.nextInt();

			switch (zbk) {
			case 1:
				System.out.println(eragiketa.batura(a, b));
				break;
			case 2:
				System.out.println(eragiketa.kendu(a, b));
				break;
			case 3:
				System.out.println(eragiketa.biderkatu(a, b));
				break;
			case 4:
				System.out.println(eragiketa.zatitu(a, b));
				break;
			}
		} while (kanpora == true);
		sc.close();
	}
}
