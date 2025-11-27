package ariketa;

import java.util.Scanner;

public class Birpasa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String izena = "";
		String ssoldata = "";
		int soldata = 0;
		int soldataOsoa = 0;
		String sadina = "";
		int adina = 0;
		int kontadina = 0;
		String ssemealabakop = "";
		int semealabakop = 0;
		final int JUBILAZIOA = 65;
		String sjarraitu = "";
		int jarraitu = 0;
		int kontsoldata = 0;
		int batura = 0;
		double batazbestekoa = 0;
		String totala = "";
		do {
			System.out.println("Sartu langilearen izena");
			izena = sc.next();

			do {
				System.out.println("Sartu langilearen soldata");
				ssoldata = sc.next();
				soldata = ariketa.Balidazioak.soldataZenbakia(ssoldata);
				soldata = ariketa.Balidazioak.rangoak(soldata, 800, 3000);
			} while (soldata == -1);
			batura = ariketa.Metodoak.batura(batura, soldata);
			totala = ariketa.Metodoak.soldataGuztiak(soldata, kontsoldata, totala);
			kontsoldata++;

			do {
				System.out.println("Sartu langilearen adina");
				sadina = sc.next();
				adina = ariketa.Balidazioak.zenbkiaOsoa(sadina);
				adina = ariketa.Balidazioak.rangoak(adina, 18, 65);
			} while (adina == -1);

			do {
				System.out.println("Sartu langilearen seme alaba kopurua");
				ssemealabakop = sc.next();
				semealabakop = ariketa.Balidazioak.zenbkiaOsoa(ssemealabakop);
				semealabakop = ariketa.Balidazioak.rangoak(semealabakop, 0, 50);
			} while (semealabakop == -1);

			ariketa.Metodoak.emaitzakErakutsi(izena, soldata, adina, semealabakop, soldataOsoa, kontadina, JUBILAZIOA);

			do {
				System.out.println("1 Jarraitu / 2 Ez jarraitu");
				sjarraitu = sc.next();
				jarraitu = ariketa.Balidazioak.zenbkiaOsoa(sjarraitu);
				jarraitu = ariketa.Balidazioak.rangoak(jarraitu, 1, 2);
			} while (jarraitu == -1);

		} while (jarraitu == 1);

		System.out.println(batura);
		System.out.println("Langileen soldata guztiak: " + totala);
		batazbestekoa = ariketa.Metodoak.batazbestekoa(batura, kontsoldata);
		System.out.println(batazbestekoa);

		sc.close();
	}

}
