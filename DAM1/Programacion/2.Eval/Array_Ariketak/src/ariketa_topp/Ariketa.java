package ariketa_topp;

import java.util.Scanner;

public class Ariketa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int aukera = 0;

		int[] array = new int[10];

		Metodoak.arrayaBete(array);

		do {
			for (int i = 0; i < array.length; i++) {
				System.out.println(array[i]);
			}
			aukera = Metodoak.menu(sc, aukera);

			switch (aukera) {
			case 1:
				Metodoak.sartuBalioa(sc, array);
				break;

			case 2:
				Metodoak.balioaAurkitu(sc, array);
				break;

			case 3:
				Metodoak.balioaEzabatu(sc, array);
				break;
			}

		} while (aukera != 4);
		sc.close();

	}

}
