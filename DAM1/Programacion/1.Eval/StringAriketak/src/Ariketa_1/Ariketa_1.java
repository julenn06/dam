package Ariketa_1;

import java.util.Scanner;

public class Ariketa_1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String hitza = "";

		System.out.println("Idatzi hitz bat");
		hitza = sc.nextLine();

		System.out.println(hitza.length());

		System.out.println(hitza.charAt(6));

		int x = (hitza.indexOf('x'));

		if (x == -1) {
			System.out.println("Karakter hau ez da aurkitu");
		} else {
			System.out.println(hitza.indexOf('x'));
		}

		System.out.println(hitza.toUpperCase());

		sc.close();
	}

}