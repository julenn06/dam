package proba1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String txt = "Plantilla.txt";
		Menua menua = new Menua();
		FitxategiRW fitxategia = new FitxategiRW();
		Futbolista[] f = new Futbolista[25];
		Futbolista[] jugadores = fitxategia.fitxategiaKargatu(txt, f);
		Scanner sc = new Scanner(System.in);
		int aukera = 0;

		do {
			aukera = menua.menua(aukera, sc);
			jugadores = fitxategia.fitxategiaKargatu(txt, f);
			switch (aukera) {
			case 1:
				Futbolista sartu = fitxategia.datuakSortu(sc, f);
				if (sartu != null) {
					fitxategia.EscribirFichTexto(sartu, txt);
					fitxategia.fitxategiaIrakurri(txt, f);
				}
				break;

			case 2:
				fitxategia.ezabatuLerroa(sc, f, txt);
				break;

			case 3:
				fitxategia.jokalariGuztiak(jugadores);
				break;

			case 4:
				fitxategia.bilatuIzenarekin(sc, jugadores);
				break;

			case 5:
				fitxategia.bilatuBikoiztuak(jugadores);
				break;

			case 6:
				fitxategia.editarFutbolista(jugadores, sc, txt);
				break;

			case 7:
				fitxategia.mostrarFutbolistasPorEdad(jugadores, sc);
				break;

			case 8:
				fitxategia.sortuFitxategia(sc);
				break;

			case 9:
				fitxategia.ezabatuFitxategia(sc);
				break;

			case 10:
				fitxategia.ordenarPorNombre(jugadores, txt);
				break;

			case 11:
				fitxategia.ordenarPorEdad(jugadores, txt);
				break;

			case 12:
				System.out.println("Irteten...");
				break;
			}
		} while (aukera != 12);
		sc.close();
	}
}