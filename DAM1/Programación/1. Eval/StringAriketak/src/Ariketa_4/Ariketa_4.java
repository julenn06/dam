package Ariketa_4;

import java.util.Scanner;

public class Ariketa_4 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String testu1 = "";
		String testu2 = "";

		System.out.println("Sartu lehenengo testua");
		;
		testu1 = sc.nextLine();

		System.out.println("Sartu bigarren testua");
		;
		testu2 = sc.nextLine();

		System.out.println(testu1.concat(testu2));
		sc.close();
	}
}