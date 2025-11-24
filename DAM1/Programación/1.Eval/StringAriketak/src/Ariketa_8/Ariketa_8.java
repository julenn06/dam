package Ariketa_8;

import java.util.Scanner;

public class Ariketa_8 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String hitzak = "";
		int kont = 0;
		
		System.out.println("Idatzi hitz bat: ");
		hitzak = sc.nextLine();
		
		char letra = hitzak.charAt(0);
		
		
		System.out.println(letra);
	
			
		for (int i = 0; i < hitzak.length();i++) {
			if (hitzak.charAt(i)==' ' + 1) {
				kont++;
			}
			System.out.println(kont);
	}
			
		
sc.close();	
}
}
