package vista;

import java.util.Scanner;

import modelo.LibZerrenda;
import modelo.Liburua;

public class Liburutegia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menua();
	}

	private static void menua() {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int aukera = -1;
		LibZerrenda lzerrenda = new LibZerrenda();
		do {
			System.out.println("1. Bilatu liburua (izenagatik)\r\n" + "2. Erakutsi liburu zerrenda\r\n"
					+ "3. Liburua gehitu\r\n"
					+ "4. Liburua ezabatu (ISBN eskatu, eta baldin badago, liburua ezabatuko da)\r\n" + "5. Salir ");
			aukera = balidatuZenbakia(sc, "Sartu aukera (1-5)", 1, 5, sc);
			switch (aukera) {
			case 1:
				bilatu(sc, lzerrenda);
				break;
			case 2:
				agendaPantailaratu(lzerrenda);
				break;
			case 3:
				gehitu(sc, lzerrenda);
				break;
			case 4:
				ezabatu(sc, lzerrenda);
				break;
			}
		} while (aukera != 5);

	}

	private static void ezabatu(Scanner sc, LibZerrenda lzerrenda) {
		// TODO Auto-generated method stub
		System.out.println("Sartu isbn kodea");
		String isbn = sc.nextLine();
		lzerrenda.ezabatu(isbn);
	}

	private static void gehitu(Scanner sc, LibZerrenda lzerrenda) {
		// TODO Auto-generated method stub
		System.out.println("Sartu izenburua");
		String izenburu = sc.nextLine();
		System.out.println("Sartu isbn");
		String isbn = sc.nextLine();
		System.out.println("Sartu idazlea");
		String idazle = sc.nextLine();
		Liburua lib = new Liburua(izenburu, isbn, idazle);
		lzerrenda.gehitu(lib);
	}

	private static void agendaPantailaratu(LibZerrenda lzerrenda) {
		// TODO Auto-generated method stub
		System.out.println(lzerrenda.lzerrendaEskuratu());
	}

	private static void bilatu(Scanner sc, LibZerrenda lzerrenda) {
		// TODO Auto-generated method stub
		System.out.println("Sartu titulua");
		String tit = sc.nextLine();
		int posizioa = lzerrenda.bilatutit(tit);
		if (posizioa != -1)
			System.out.println(lzerrenda.eskuratu(posizioa).toString());
		else
			System.out.println("Ez dago liburu hori");
	}

	private static int balidatuZenbakia(Scanner sc, String string, int min, int max, Scanner sc2) {
		// TODO Auto-generated method stub
		int aukera = -1;
		boolean error = true;
		do {
			System.out.println(string);
			String textua = sc.nextLine();
			try {
				aukera = Integer.valueOf(textua);
				if (aukera >= min && aukera <= max)
					error = false;

			} catch (Exception ex) {
				error = true;
			}
		} while (error);
		return aukera;
	}

}
