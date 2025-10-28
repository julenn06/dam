package Ariketa_3;

import java.util.Scanner;

public class Ariketa_3 {

	public static void main(String[] args) {
		String hitza = "";
		Scanner sc = new Scanner(System.in);

		System.out.println("Sartu testua: ");
		hitza = sc.nextLine();

		for (int i = hitza.length() - 1; i >= 0; i--) {

			System.out.print(hitza.charAt(i));

		}
		sc.close();
	}

}