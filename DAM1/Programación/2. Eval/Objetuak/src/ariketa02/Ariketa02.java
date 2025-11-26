package ariketa02;

import java.util.Scanner;

public class Ariketa02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String izena = "";
		String abizena = "";
		int adina = 0;
		boolean ezkondua = true;
		String NAN = "";

		Objetuak p1 = new Objetuak(izena, abizena, adina, ezkondua, NAN);

		Objetuak p2 = new Objetuak(izena, abizena, adina, ezkondua, NAN);

		Metodoak.DatuakBete(p1, p2, sc);

		Metodoak.datuakErakutsi(p1, p2);

		Metodoak.zaharrena(p1, p2);

		sc.close();
	}

}