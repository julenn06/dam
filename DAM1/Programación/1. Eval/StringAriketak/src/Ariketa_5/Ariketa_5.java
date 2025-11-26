package Ariketa_5;

import java.util.Scanner;

public class Ariketa_5 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String testu1 = "";
		String testu2 = "";

		System.out.println("Sartu lehenengo hitza: ");
		testu1 = sc.nextLine();

		System.out.println("Sartu bigarren hitza: ");
		testu2 = sc.nextLine();

		if (testu1.equals(testu2)) {
			System.out.println("Bi hitzak berdinak dira");
		} else {
			System.out.println("Hitzak ez dira berdinak");
		}

		sc.close();

	}
}