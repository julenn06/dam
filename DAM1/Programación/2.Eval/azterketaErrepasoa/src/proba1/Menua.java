package proba1;

import java.util.Scanner;

public class Menua {

	public int menua(int aukera, Scanner sc) {
		try {
			System.out.println();
			System.out.println("Zer egin nahi duzu?");
			System.out.println("1. Gehitu Datuak");
			System.out.println("2. Ezabatu Datuak");
			System.out.println("3. Irakurri Datuak");
			System.out.println("4. Bilatu Izenarekin");
			System.out.println("5. Bilatu bat baino gehiago daudenak");
			System.out.println("6. Jokalariaren Datuak Aldatu");
			System.out.println("7. Adinagatik Bilatu");
			System.out.println("8. Sortu Fitxategia");
			System.out.println("9. Ezabatu Fitxategia");
			System.out.println("10. Ordenatu datuak izenarekin");
			System.out.println("11. Ordenatu datuak adinarekin");
			System.out.println("12. Irten");
			aukera = sc.nextInt();
			if (aukera < 1 || aukera > 12) {
				System.out.println("Sartu Zenbaki Egoki Bat");
			}
		} catch (Exception e) {
			System.out.println();
			System.out.println("Sartu Zenbaki Bat");
			System.out.println();
			aukera = -1;
			sc.next();
		}
		return aukera;
	}

}
