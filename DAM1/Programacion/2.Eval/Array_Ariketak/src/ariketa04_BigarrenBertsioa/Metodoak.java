package ariketa04_BigarrenBertsioa;

import java.util.Scanner;

public class Metodoak {

	private static int kont = 0;

	public static String[] arrayIzenakKargatu(Scanner sc, String[] izena) {

		do {
			System.out.println("Ikaslearen izena: ");
			izena[kont] = sc.next();

			kont++;
		} while (kont < izena.length);

		return izena;
	}

	public static int[] arrayNotakKargatu(Scanner sc, int[] nota) {
		kont = 0;
		int notak = 0;
		boolean notaegokia = true;
		System.out.println();
		System.out.println("Notak: ");
		do {
			do {
				try {
					System.out.println("Ikaslearen nota: ");
					notak = sc.nextInt();
					notaegokia = true;
				} catch (Exception e) {
					System.out.println("Nota 0 eta 10 artean egon behar da: ");
					notaegokia = false;
					sc.next();
				}

			} while (notaegokia == false);

			if (notak >= 0 && notak <= 10) {
				nota[kont] = notak;
			} else {
				System.out.println("Nota 0 eta 10 artean egon behar da: ");
			}

			kont++;
		} while (kont < nota.length);

		return nota;
	}

	public static void datuGuztiakAurkeztu(String[] izena, int[] nota) {

		for (int i = 0; i < izena.length; i++) {
			System.out.println("Izena: " + izena[i] + " Nota: " + nota[i]);
		}

	}

	public static void datuakKalkulatu(String[] izena, int[] nota) {
		double batazbestekoa = 0;
		int totala = 0;
		String izenamax = "";
		int notamax = 0;
		String izenamin = "";
		int notamin = Integer.MAX_VALUE;
		for (int i = 0; i < nota.length; i++) {
			totala = totala + nota[i];
			if (nota[i] >= notamax) {
				izenamax = izena[i];
				notamax = nota[i];
			}
			if (nota[i] <= notamin) {
				izenamin = izena[i];
				notamin = nota[i];
			}
		}
		batazbestekoa = totala / kont;
		System.out.println();
		System.out.println("Klasearen batazbestekoa: " + batazbestekoa);
		System.out.println();
		System.out.println("Nota Altuena: " + izenamax + " -- " + notamax);
		System.out.println();
		System.out.println("Nota Txikiena: " + izenamin + " -- " + notamin);
	}

}
