package ariketa01;

import java.util.Scanner;

public class Ariketa01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String probintzia = "";
		String matrikula = "";
		String udalerria = "";
		int motorra = 0;

		Objetua kotxe1 = new Objetua(probintzia, matrikula, udalerria, motorra);

		System.out.println("Probintzia: ");
		probintzia = sc.next();
		kotxe1.setProbintzia(probintzia);

		System.out.println("Matrikula: ");
		matrikula = sc.next();
		kotxe1.setMatrikula(matrikula);

		System.out.println("Udalerria: ");
		udalerria = sc.next();
		kotxe1.setUdalerria(udalerria);

		System.out.println("Motorra: ");
		motorra = sc.nextInt();
		kotxe1.setMotorra(motorra);

		System.out.println(kotxe1.getProbintzia());
		System.out.println(kotxe1.getMatrikula());
		System.out.println(kotxe1.getUdalerria());
		System.out.println(kotxe1.getMotorra());

		sc.close();
	}

}
