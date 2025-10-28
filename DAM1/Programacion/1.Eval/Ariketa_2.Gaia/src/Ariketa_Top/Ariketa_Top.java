package Ariketa_Top;

import java.util.Scanner;

public class Ariketa_Top {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int zbk = 0;
		int batura = 0;
		int min = 0;
		int max = 0;
		int kont = 0;
		float media = 0;
		System.out.println("Sartu zenbaki bat: ");
		zbk = sc.nextInt();
		
		if (zbk >= 0) {
			min = zbk;
		}
		while (zbk >= 0) {
			batura = batura + zbk;
			kont = kont + 1;

			
			if (zbk > max) {
				max = zbk;
			}
			
			
			if (zbk < min) {
				min = zbk;
		}
			System.out.println("Sartu zenbaki bat");
			zbk = sc.nextInt();
			media = batura/kont;
		}
		

		System.out.println("Batura: " + batura +". Zbk txikiena: " + min + ". Zbk handiena " + max + "." + " Media: " + media);

		
		sc.close();
	}
}