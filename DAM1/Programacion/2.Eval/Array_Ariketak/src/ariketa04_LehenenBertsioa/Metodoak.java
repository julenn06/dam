package ariketa04_LehenenBertsioa;

import java.util.Scanner;

public class Metodoak {

	private static String[] izena = new String[10];
	private static String[] abizena1 = new String[10];
	private static String[] abizena2 = new String[10];
	private static int[] nota = new int[10];
	private static int kont = 0;
	private static double batazbestekoa = 0;

	public static void arrayakBete(Scanner sc) {
		int notak = 0;

		boolean notaegokia = true;

		do {
			System.out.println("Ikaslearen izena: ");
			izena[kont] = sc.next();

			System.out.println("Ikaslearen lehenengo abizena: ");
			abizena1[kont] = sc.next();

			System.out.println("Ikaslearen bigarren abizena: ");
			abizena2[kont] = sc.next();

			do {
				try {
					System.out.println("Ikaslearen nota: ");
					notak = sc.nextInt();
					if (notak >= 0 && notak <= 10) {
						nota[kont] = notak;
						notaegokia = true;
					} else {
						System.out.println("Nota 0 eta 10 artean egon behar da: ");
						notaegokia = false;
					}
				} catch (Exception e) {
					System.out.println("Nota 0 eta 10 artean egon behar da: ");
					notaegokia = false;
					sc.next();

				}
			} while (notaegokia == false);

			kont++;
		} while (kont < izena.length);
	}

	public static void zerrendaErakutsi() {

		for (int i = 0; i < izena.length; i++) {
			System.out.println("Izena: " + izena[i] + " Lehenengo Abizena: " + abizena1[i] + " Bigarren Abizena: "
					+ abizena2[i] + " Nota: " + nota[i]);
		}

	}

	public static void batazBestekoa() {
		int totala = 0;
		for (int i = 0; i < nota.length; i++) {
			totala = totala + nota[i];
		}
		batazbestekoa = totala / kont;
		System.out.println();
		System.out.println("Klasearen batazbestekoa: " + batazbestekoa);
	}

	public static void notaAltuagoak() {
		System.out.println("Batazbesteko baino nota handiagoa duten pertsonak: ");
		for (int i = 0; i < izena.length; i++) {
			if (nota[i] > batazbestekoa) {
				System.out.println(izena[i]);
			}
		}

	}

}
