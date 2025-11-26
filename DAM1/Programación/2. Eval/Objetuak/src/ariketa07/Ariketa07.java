package ariketa07;

import java.util.Scanner;

public class Ariketa07 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Objetuak pertsonak[] = new Objetuak[100];
		int aukera = 0;
		String izena = "";
		String sexua = "E";
		int adina = 0;
		double altuera = 0;
		double pisua = 0;
		int kont = 0;

		do {
			aukera = Metodoak.menua(sc, aukera);

			switch (aukera) {
			case 1:
				kont = Metodoak.lehenengoKasua(sc, izena, sexua, adina, altuera, pisua, kont, pertsonak);
				break;
			case 2:
				Metodoak.datuakProzesatu(kont, pertsonak);
				break;
			}
		} while (aukera != 0);

		sc.close();
	}

}
