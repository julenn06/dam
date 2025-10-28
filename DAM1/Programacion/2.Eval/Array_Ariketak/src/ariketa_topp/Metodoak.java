package ariketa_topp;

import java.util.Scanner;

public class Metodoak {

	public static void arrayaBete(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = -1;
		}
	}

	public static int menu(Scanner sc, int aukera) {
		try {
			System.out.println("1. Sartu balioa");
			System.out.println("2. Aurkitu balioa");
			System.out.println("3. Ezabatu balioa");
			System.out.println("4. Atera");
			aukera = sc.nextInt();
		} catch (Exception e) {
			System.out.println("Balio egoki bat sartu");
			sc.next();
		}
		return aukera;
	}

	public static void sartuBalioa(Scanner sc, int[] array) {
		int zbk = 0;
		try {
			System.out.println("Sartu zenbaki bat: ");
			zbk = sc.nextInt();
		} catch (Exception e) {
			System.out.println("Sartu balio egoki bat");
			sc.next();
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] == zbk || zbk < 0) {
				System.out.println("Zenbakia ezin da gehitu");
				System.out.println();
				return;
			} else if (array[i] == -1) {
				array[i] = zbk;
				return;
			}
		}
	}

	public static void balioaAurkitu(Scanner sc, int[] array) {
		int aukera = 0;
		boolean badago = false;
		try {
			System.out.println("Sartu aurkitu nahi duzun zenbakia: ");
			aukera = sc.nextInt();
		} catch (Exception e) {
			System.out.println("Balio egoki bat sartu");
			sc.next();
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] == aukera) {
				badago = true;
				break;
			} else {
				badago = false;
			}
		}

		if (badago == true) {
			System.out.println(aukera + " Zenbakia badago");
		} else {
			System.out.println(aukera + " Zenbakia ez dago.");
		}

	}

	public static void balioaEzabatu(Scanner sc, int[] array) {
		int aukera = 0;
		try {
			System.out.println("Sartu aurkitu nahi duzun zenbakia: ");
			aukera = sc.nextInt();
		} catch (Exception e) {
			System.out.println("Balio egoki bat sartu");
			sc.next();
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] == aukera) {
				array[i] = -1;
				for (int z = aukera; z < array.length - 1; z++) {
					array[z - 1] = array[z];
				}
				return;
			}
		}

		System.out.println("Zenbaki hau ez dago");
		return;

	}

}
