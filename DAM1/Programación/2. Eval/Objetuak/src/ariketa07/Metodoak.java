package ariketa07;

import java.util.Scanner;

public class Metodoak {

	public static int menua(Scanner sc, int aukera) {
		do {
			System.out.println("Menu nagusia");
			System.out.println();
			System.out.println("1.- Ikasleen datuak kargatzea");
			System.out.println("2.- Datuak prozesatzea");
			System.out.println("3.- Ikasleen datuak erakustea");
			System.out.println("4.- Ikasle Baten datuak erakustea");
			System.out.println("0.- Amaiera");
			try {
				aukera = sc.nextInt();
			} catch (Exception e) {
				System.out.println("Aukera egoki bat aukeratu");
				aukera = -1;
				sc.next();
			}
		} while (aukera == -1);
		return aukera;

	}

	public static int lehenengoKasua(Scanner sc, String izena, String sexua, int adina, double altuera, double pisua,
			int kont, Objetuak pertsonak[]) {

		Objetuak p1 = new Objetuak(izena, sexua, adina, altuera, pisua);

		System.out.println("Izena: ");
		izena = sc.next();
		p1.setIzena(izena);

		System.out.println("Sexua: ");
		sexua = sc.next();
		p1.setSexua(sexua);

		do {
			System.out.println("Adina: ");
			adina = sc.nextInt();
			if (adina < 18) {
				System.out.println("Ez duzu adin egokia");
				adina = -1;
			}
		} while (adina == -1);
		p1.setAdina(adina);

		do {
			System.out.println("Altuera: ");
			altuera = sc.nextDouble();
			if (altuera < 0 || altuera > 2.5) {
				System.out.println("Ez daukazu altuera egokia");
				altuera = -1;
			}
		} while (altuera == -1);
		p1.setAltuera(altuera);

		do {
			System.out.println("Pisua: ");
			pisua = sc.nextDouble();
			if (pisua < 0 || pisua > 150) {
				System.out.println("Ez daukazu pisu egokia");
				pisua = -1;
			}
		} while (pisua == -1);
		p1.setPisua(pisua);

		pertsonak[kont] = p1;

		kont++;
		for (int i = 0; i < kont; i++) {
			System.out.println(pertsonak[i]);
		}
		return kont;

	}

	public static void datuakProzesatu(int kont, Objetuak pertsonak[]) {
		for (int i = 0; i < kont; i++) {
			System.out.println(pertsonak[i]);
		}
	}
}