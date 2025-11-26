package ariketa04;

import java.util.Scanner;

public class Ariketa04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String izena;
		int adina;
		String sexua;

		System.out.println("Izena: ");
		izena = sc.nextLine();

		System.out.println("Adina: ");
		adina = sc.nextInt();

		System.out.println("Sexua (G/E): ");
		sexua = sc.next();

		System.out.println("Pisua (KG): ");
		double pisua = sc.nextDouble();

		System.out.println("Altuera (m): ");
		double altuera = sc.nextDouble();

		Objetuak p1 = new Objetuak(izena, adina, "", sexua, pisua, altuera);

		Objetuak p2 = new Objetuak(izena, adina, sexua);

		System.out.println("Izena: ");
		izena = sc.next();

		System.out.println("Adina: ");
		adina = sc.nextInt();

		System.out.println("Sexua (G/E): ");
		sexua = sc.next();
		p2.setIzena(izena);
		p2.setAdina(adina);
		p2.setSexua(sexua);

		Objetuak p3 = new Objetuak();
		p3.setIzena(izena);
		p3.setAdina(adina);
		p3.setSexua(sexua);
		p3.setPisua(pisua);
		p3.setAltuera(altuera);

		p1.IMCEmaitza();
		System.out.println("Adin nagusia da? " + p1.adinezNagusikoaDa());
		System.out.println(p1.toString());

		p2.IMCEmaitza();
		System.out.println("Adin nagusia da? " + p2.adinezNagusikoaDa());
		System.out.println(p2.toString());

		p3.IMCEmaitza();
		System.out.println("Adin nagusia da? " + p3.adinezNagusikoaDa());
		System.out.println(p3.toString());

		sc.close();
	}
}
