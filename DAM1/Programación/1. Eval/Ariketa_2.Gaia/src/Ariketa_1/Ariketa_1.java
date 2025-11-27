package Ariketa_1;

import java.util.Scanner;

public class Ariketa_1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int soldata = 0;

		System.out.println("Soldata: ");
		soldata = sc.nextInt();

		if (soldata >= 3000) {
			System.out.println("Zergak ordaindu behar dituzu!!!");
		} else {
			System.out.println("Es dituzu zergarik ordaindu behar");
		}

		sc.close();
	}

}