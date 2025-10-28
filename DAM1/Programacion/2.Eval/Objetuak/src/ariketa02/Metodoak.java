package ariketa02;

import java.util.Scanner;

public class Metodoak {

	public static boolean ezkontzaBalidatu(String aux, boolean ezkondua) {
		if (aux.equals("Bai") || aux.equals("bai")) {
			ezkondua = true;
		} else {
			ezkondua = false;
		}
		return ezkondua;
	}

	public static void datuakErakutsi(Objetuak p1, Objetuak p2) {
		System.out.println("Lehenengo pertsonaren datuak: ");
		System.out.println("Izena: " + p1.getIzena());
		System.out.println("Abizena: " + p1.getAbizena());
		System.out.println("Adina: " + p1.getAdina());
		System.out.println("Ezkonduta: " + p1.getEzkondua());
		System.out.println("NAN: " + p1.getNAN());
		System.out.println();
		System.out.println();
		System.out.println("Bigarren pertsonaren datuak: ");
		System.out.println("Izena: " + p2.getIzena());
		System.out.println("Abizena: " + p2.getAbizena());
		System.out.println("Adina: " + p2.getAdina());
		System.out.println("Ezkonduta: " + p2.getEzkondua());
		System.out.println("NAN: " + p2.getNAN());
	}

	public static void zaharrena(Objetuak p1, Objetuak p2) {

		if (p1.getAdina() > p2.getAdina()) {
			System.out.println(p1.getIzena() + " " + p1.getAbizena() + " adin gehiago dauka");
		} else if (p1.getAdina() == p2.getAdina()) {
			System.out.println(p1.getAdina() + " " + p1.getAbizena() + " eta " + p2.getAdina() + " " + p2.getAbizena()
					+ " adin berdina dute");
		} else {
			System.out.println(p2.getIzena() + " " + p2.getAbizena() + " adin gehiago dauka");
		}
	}

	public static void DatuakBete(Objetuak p1, Objetuak p2, Scanner sc) {

		boolean ezkondua = false;

		System.out.println("Lehenengo pertsonaren izena");
		p1.setIzena(sc.next());

		System.out.println("Lehenengo pertsonaren abizena");
		p1.setAbizena(sc.next());

		System.out.println("Lehenengo pertsonaren adina");
		p1.setAdina(sc.nextInt());

		System.out.println("Lehenengo pertsona ezkonduta dago? bai/ez");
		ezkondua = ezkontzaBalidatu(sc.next(), ezkondua);
		p1.setEzkondua(ezkondua);

		System.out.println("Lehenengo pertsonaren NAN");
		p1.setNAN(sc.next());

		System.out.println("Bigarren pertsonaren izena");
		p2.setIzena(sc.next());

		System.out.println("Bigarren pertsonaren abizena");
		p2.setAbizena(sc.next());

		System.out.println("Bigarren pertsonaren adina");
		p2.setAdina(sc.nextInt());

		System.out.println("Bigarren pertsona ezkonduta dago? bai/ez");
		ezkondua = ezkontzaBalidatu(sc.next(), ezkondua);
		p2.setEzkondua(ezkondua);

		System.out.println("Bigarren pertsonaren NAN");
		p2.setNAN(sc.next());
	}
}