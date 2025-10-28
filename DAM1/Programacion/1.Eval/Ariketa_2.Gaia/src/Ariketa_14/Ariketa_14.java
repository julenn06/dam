package Ariketa_14;

import java.util.Scanner;

public class Ariketa_14 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		float batura = 0;
		int kontua = 0;
		float dirua = 0;
		int h = 0;
		int z = 0;
		int n = 0;

		System.out.println("Sartu zure kontua: ");
		kontua = sc.nextInt();

		while (kontua >= 0) {

			System.out.println("zenbat diru daukazu:");
			dirua = sc.nextFloat();

			if (dirua > 0) {
				h++;
				batura = batura + dirua;
			} else if (dirua < 0) {
				z++;
			} else {
				n++;
			}

			System.out.println("Sartu zure kontua: ");
			kontua = sc.nextInt();

		}

		System.out.println("Amaitu duzu");
		System.out.println(h + " kontu hartzekodunak dira ");
		System.out.println(z + " kontu zordunak dira");
		System.out.println(n + " kontu ez daukate baliorik");
		System.out.println("Diru guztiaren batura: " + batura);

		sc.close();
	}
}
