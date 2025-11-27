package Ariketa_8;

import java.util.Scanner;

public class Ariketa_8 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int zenbaki1 = 0, zenbaki2 = 0, zenbaki3 = 0;

		System.out.println("idatzi lehenengo zenbakia: ");
		zenbaki1 = sc.nextInt();

		System.out.println("idatzi bigarren zenbakia: ");
		zenbaki2 = sc.nextInt();

		zenbaki3 = zenbaki1 + zenbaki2;

		System.out.println("hizkia: " + zenbaki3);

		sc.close();
	}

}
