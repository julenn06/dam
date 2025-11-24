package Ariketa_2;

import java.util.Scanner;

public class Ariketa_2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int kont = 0;
		String hitza = "";

		System.out.println("Idatzi hitz bat: ");
		hitza = sc.nextLine();

		for (int i = 0; i < hitza.length(); i++) {
			if (hitza.charAt(i) == 'a') {
				kont++;
			}

		}

		System.out.println(kont);

		sc.close();
	}
}