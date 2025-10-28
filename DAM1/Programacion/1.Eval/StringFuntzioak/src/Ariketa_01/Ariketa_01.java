package Ariketa_01;

import java.util.Scanner;

public class Ariketa_01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int aux = 0;
		String zbk;
		int karakterea1;
		String karakterea2;
		String letra = "";
		String esaldia = "";
		boolean balidatu = true;

		do {
			do {
				System.out.println();
				System.out.println("1. Sartu Karaktereak");
				System.out.println("2. Letra bihurtu minuskulara");
				System.out.println("3. Letra bihurtu maiuskulara");
				System.out.println("4. Bihurtu esaldia minuskulara");
				System.out.println("5. Bihurtu esaldia maiuskulara");
				System.out.println("6. Irten");
				zbk = sc.next();
				balidatu = eragiketa.balidazioa(zbk);
			} while (balidatu == false);

			aux = Integer.parseInt(zbk);
			switch (aux) {
			case 1:

				System.out.println("Sartu zbk bat");
				karakterea1 = sc.nextInt();
				System.out.println("Sartu nahi duzuna");
				karakterea2 = sc.next();
				eragiketa.lerroa(karakterea1, karakterea2);
				break;

			case 2:

				do {
					balidatu = false;
					System.out.println("Sartu letra maiuskula bat");
					letra = sc.next();
					balidatu = eragiketa.letraMinuskula(letra);
				} while (balidatu == false);
				letra = letra.toLowerCase();
				System.out.println(letra);
				break;

			case 3:
				do {
					balidatu = false;
					System.out.println("Sartu letra minuskula bat");
					letra = sc.next();
					balidatu = eragiketa.letraMaiuskula(letra);
				} while (balidatu == false);
				letra = letra.toUpperCase();
				System.out.println(letra);
				break;
			case 4:
				do {
					balidatu = false;
					System.out.println("Bihurtu esaldia minuskulara");
					esaldia = sc.nextLine();
					balidatu = eragiketa.EsaldiMinuskula(esaldia);
				} while (balidatu == false);
				esaldia = esaldia.toLowerCase();
				System.out.println(esaldia);
				break;
			case 5:
				do {
					balidatu = false;
					System.out.println("Bihurtu esaldia maiuskulara");
					esaldia = sc.nextLine();
					balidatu = eragiketa.EsaldiMaiuskula(esaldia);
				} while (balidatu == false);
				esaldia = esaldia.toUpperCase();
				System.out.println(esaldia);
				break;
			case 6:
				balidatu = false;
				break;
			}

		} while (balidatu);

		sc.close();
	}

}