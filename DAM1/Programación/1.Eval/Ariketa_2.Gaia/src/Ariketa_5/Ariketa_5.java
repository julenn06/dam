package Ariketa_5;

import java.util.Scanner;

public class Ariketa_5 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int nota = 0;

		System.out.println("sartu zure nota: ");
		nota = sc.nextInt();

		switch (nota) {

		case 1:
		case 2:
			System.out.println("GUTXIEGI");
			break;
		case 3:
		case 4:
			System.out.println("GUTXI");
			break;
		case 5:
			System.out.println("NAHIKO");
			break;
		case 6:
			System.out.println("ONDO");
			break;
		case 7:
		case 8:
			System.out.println("OSO ONDO");
			break;
		case 9:
		case 10:
			System.out.println("BIKAIN");
			break;
		default:
			System.out.println("Datu Okerra");
		}

		sc.close();

	}

}
