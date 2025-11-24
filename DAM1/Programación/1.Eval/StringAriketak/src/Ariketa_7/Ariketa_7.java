package Ariketa_7;

import java.util.Scanner;

public class Ariketa_7 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String hitzak = "";
		int kont = 1;
		
		System.out.println("Idatzi hitz bat: ");
		hitzak = sc.nextLine();
		
		for (int i = 0; i < hitzak.length();i++) {
			if (hitzak.charAt(i)==' ') {
				kont++;
			}
	}
		System.out.println(kont);
		
		sc.close();
}
}