package email_ariketa;

import java.util.Scanner;

public class Metodoak {

	public static void Menu() {
		System.out.println("1. Zenbat Email ditut?");
		System.out.println("2. Email-a postontzira gehitu");
		System.out.println("3. Email-ak irakurri gabe");
		System.out.println("4. Email-ak irakurri gabe erakutsi");
		System.out.println("5. Poztontziaren email bat irakurri");
		System.out.println("6. Email bat ezabatu");
		System.out.println("7. Atera");

	}

	public static int emailKopurua(Email[] k1, int kont) {

		for (int i = 0; i < k1.length; i++) {
			if (k1[i] != null) {
				kont++;
			}
		}
		return kont;

	}

	public static void gehitu(Email[] k1, Scanner sc) {
		for (int i = 0; i < k1.length; i++) {
			if (k1[i] == null) {

				k1[i] = new Email("", "", "", false);

				System.out.print("Sartu norentzat: ");
				k1[i].setNorentzat(sc.next());

				System.out.print("Sartu gaia: ");
				k1[i].setGaia(sc.next());

				System.out.print("Sartu gorputza: ");
				k1[i].setGorputza(sc.next());

				k1[i].setIrakurria(false);

				System.out.println("Email berria gehitu da.");
				System.out.println();
				return;
			}
		}

		System.out.println("Postontzia beteta dago.");
	}

	public static boolean irakurriGabe(Email[] k1) {
		for (int i = 0; i < k1.length; i++) {
			if (k1[i] != null && !k1[i].getIrakurria()) {
				return false;
			}
		}
		return true;
	}

	public static String erakutsiLehenaIrakurriGabe(Email[] k1) {
		for (int i = 0; i < k1.length; i++) {
			if (k1[i] != null && k1[i].getIrakurria() == false) {
				k1[i].setIrakurria(true);
				return "Norena: " + k1[i].getNorentzat() + " Gaia: " + k1[i].getGaia() + " Gorputza: "
						+ k1[i].getGorputza();
			}
		}
		return "Email guztiak irakurrita daude";

	}

	public static String erakutsi(int emailIrakurri, Email[] k1) {
		if (k1[emailIrakurri] == null) {
			return "Ez dago email bat posizio horretan";
		}

		return "Norena: " + k1[emailIrakurri].getNorentzat() + " Gaia: " + k1[emailIrakurri].getGaia() + " Gorputza: "
				+ k1[emailIrakurri].getGorputza();

	}

	public static void ezabatu(int emailEzabatu, Email[] k1) {
		if (k1[emailEzabatu] != null) {
			for (int i = emailEzabatu; i < k1.length - 1; i++) {
				k1[i] = k1[i + 1];
			}

			k1[k1.length - 1] = null;

			System.out.println("Email-a ezabatu da.");
		} else {
			System.out.println("Ez daude email-a pozizio horretan.");
		}
	}

}
