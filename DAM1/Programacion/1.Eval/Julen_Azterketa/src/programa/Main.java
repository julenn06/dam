package programa;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String izena = "";
		String pisua = "";
		String sexua = "";
		String ialtuera = "";
		String jarraitu = "";

		double altuera = 0;
		int kg = 0;

		double gmi = 0;
		double pisuideala = 0;

		String inprimatu = "";

		String pisuaigoedoez = "";

		int kont = 0;

		String izenguztiak = "";

		String jarraitusartzen = "";
		boolean jarraitubalidatu = false;

		do {
			System.out.println("Sartu pertsonaren izena: ");
			izena = sc.next();

			do {
				System.out.println("Sartu " + izena + " daukan pisua: ");
				pisua = sc.next();
				kg = Balidazioak.zenbakiada(pisua);
				kg = Balidazioak.rangoak(kg, 0, 250);
			} while (kg == -1);

			do {
				System.out.println("Sartu " + izena + " sexua (G/E): ");
				sexua = sc.next();
				sexua = Balidazioak.sexuaBalidatu(sexua);
			} while (sexua == "-1");

			do {
				System.out.println("Sartu " + izena + " daukan altuera (cm): ");
				ialtuera = sc.next();

				altuera = Balidazioak.zenbakiada(ialtuera);
				altuera = Balidazioak.altueraBalidatu(altuera, 0, 200);
			} while (altuera == -1);

			gmi = Metodoak.gmiKalkulatu(kg, altuera);

			pisuideala = Metodoak.pisuIdeala(altuera, sexua);
			kont++;

			inprimatu = Metodoak.inprimatu(gmi);
			pisuaigoedoez = Metodoak.argalduEdoGizendu(pisuideala, gmi, sexua);

			System.out.println(izena + ", zure gmi hau da: " + gmi);
			System.out.println(inprimatu);
			System.out.println("zure pisu ideala: " + String.format("%.2f", pisuideala));
			System.out.println(pisuaigoedoez);
			izenguztiak = Metodoak.pertsonenIzenak(izena, izenguztiak);
			do {
				System.out.println("Jarraitu nahi duzu? (B/E): ");
				jarraitu = sc.next();
				jarraitusartzen = Balidazioak.jarraitu(jarraitu);
				jarraitubalidatu = Balidazioak.jarraituBalidatu(jarraitusartzen);
			} while (jarraitusartzen == "-1");
		} while (jarraitubalidatu == true);

		inprimatu = Metodoak.inprimatu(gmi);
		pisuaigoedoez = Metodoak.argalduEdoGizendu(pisuideala, gmi, sexua);

		System.out.println("Tratatu diren pertsona kopurua: " + kont);
		System.out.println("Izenak: " + izenguztiak);
		sc.close();
	}

}
