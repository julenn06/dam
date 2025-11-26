package ariketa04_BigarrenBertsioa;

import java.util.Scanner;

public class Ariketa04 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String[] izena = new String[10];
		int[] nota = new int[10];

		izena = Metodoak.arrayIzenakKargatu(sc, izena);

		nota = Metodoak.arrayNotakKargatu(sc, nota);

		Metodoak.datuGuztiakAurkeztu(izena, nota);

		Metodoak.datuakKalkulatu(izena, nota);

		sc.close();
	}

}
