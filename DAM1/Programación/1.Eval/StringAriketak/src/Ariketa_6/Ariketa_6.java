package Ariketa_6;

import java.util.Scanner;

public class Ariketa_6 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String hitza = "";

		System.out.println("sartu hitz bat:");
		hitza = sc.nextLine();

		String inverso = new StringBuilder(hitza).reverse().toString();

		if (hitza.equals(inverso)) {
			System.out.println("Hitz hau palindromoa da");
		} else {
			System.out.println("Hitz hau ez da palindromoa");
		}
		sc.close();
	}

}
