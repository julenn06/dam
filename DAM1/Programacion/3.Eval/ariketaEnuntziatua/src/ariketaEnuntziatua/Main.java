package ariketaEnuntziatua;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int adina;
		int aukera;
		String izena;
		BD_Metodoak kontsultak = new BD_Metodoak();
		Langilea langilea = new Langilea(0, null, 0, null, 0, 0);
		FreeLancer freelancer = new FreeLancer(0, null, 0, 0, 0);
		do {
			System.out.println("1. Langile berria gehitu");
			System.out.println("2. Freelancer berria gehitu");
			System.out.println("3. Langileen zerrenda ikusi");
			System.out.println("4. Freelancer-en zerrenda ikusi");
			System.out.println("5. Langile baten datuak eguneratu");
			System.out.println("6. Freelancer baten datuak eguneratu");
			System.out.println("7. Langile bat ezabatu");
			System.out.println("8. Freelancer bat ezabatu");
			System.out.println("9. Irten");
			System.out.println("=========================");
			System.out.print("Aukeratu zenbaki bat: ");

			aukera = sc.nextInt();

			switch (aukera) {
			case 1:
				System.out.println("Izena:");
				langilea.setIzena(sc.next());
				do {
					System.out.println("Adina:");
					adina = sc.nextInt();
					try {
						langilea.setAdina(adina);
					} catch (AdinBaliogabeaSalbuespena e) {
						System.out.println(e.getMessage());
					}
				} while (adina < 18);

				System.out.println("Kargua:");
				langilea.setKargua(sc.next());
				System.out.println("Oinarrizko Soldata:");
				langilea.setOinarrizkoSoldata(sc.nextDouble());
				System.out.println("Antzinatasuna: ");
				langilea.setAntzinatasuna(sc.nextInt());

				kontsultak.langileaSartu(langilea);

				break;
			case 2:
				System.out.println("Izena:");
				freelancer.setIzena(sc.next());
				do {
					System.out.println("Adina:");
					adina = sc.nextInt();
					try {
						freelancer.setAdina(adina);
					} catch (AdinBaliogabeaSalbuespena e) {
						System.out.println(e.getMessage());
					}
				} while (adina < 18);
				System.out.println("Lanorduak:");
				freelancer.setLanorduak(sc.nextInt());
				System.out.println("Ordain Saria Orduko: ");
				freelancer.setOrdainSariaOrduko(sc.nextDouble());

				kontsultak.freelancerSartu(freelancer);
				break;
			case 3:
				kontsultak.langileakIkusi(langilea);
				break;
			case 4:
				kontsultak.freelancerIkusi();
				break;
			case 5:
				System.out.println("Langilearen Izena:");
				izena = sc.next();
				kontsultak.langileBatIkusi(izena);
				System.out.println("Izena:");
				langilea.setIzena(sc.next());
				do {
					System.out.println("Adina:");
					adina = sc.nextInt();
					try {
						langilea.setAdina(adina);
					} catch (AdinBaliogabeaSalbuespena e) {
						System.out.println(e.getMessage());
					}
				} while (adina < 18);

				System.out.println("Kargua:");
				langilea.setKargua(sc.next());
				System.out.println("Oinarrizko Soldata:");
				langilea.setOinarrizkoSoldata(sc.nextDouble());
				System.out.println("Antzinatasuna: ");
				langilea.setAntzinatasuna(sc.nextInt());

				kontsultak.langileaEguneratu(langilea, izena);
				break;
			case 6:
				System.out.println("Freelancer Izena:");
				izena = sc.next();
				kontsultak.freelancerBatIkusi(izena);
				System.out.println("Izena:");
				freelancer.setIzena(sc.next());
				do {
					System.out.println("Adina:");
					adina = sc.nextInt();
					try {
						freelancer.setAdina(adina);
					} catch (AdinBaliogabeaSalbuespena e) {
						System.out.println(e.getMessage());
					}
				} while (adina < 18);
				System.out.println("Lanorduak:");
				freelancer.setLanorduak(sc.nextInt());
				System.out.println("Ordain Saria Orduko: ");
				freelancer.setOrdainSariaOrduko(sc.nextDouble());
				kontsultak.freelancerEguneratu(freelancer, izena);
				break;
			case 7:
				System.out.println("Izena:");
				kontsultak.langileBatEzabatu(sc.next());
				break;
			case 8:
				System.out.println("Izena:");
				kontsultak.freeancerBatEzabatu(sc.next());
				break;
			case 9:
				System.out.println("Irten...");
				break;
			default:
				System.out.println("Aukera okerra. Mesedez, saiatu berriro.");
			}
			System.out.println();
		} while (aukera != 9);
		sc.close();
	}
}