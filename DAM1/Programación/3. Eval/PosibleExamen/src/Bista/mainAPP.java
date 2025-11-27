package Bista;

import java.util.ArrayList;
import java.util.Scanner;
import Kudeatzailea.PertsonaKudeatzaile;
import Modeloa.Freelancer;
import Modeloa.Langilea;
import Modeloa.Pertsona;

public class mainAPP {

	public static void main(String[] args) {

		String sOpe = "";
		int ope = 0;
		int opeLangile = 0;
		Scanner sc = new Scanner(System.in);

		PertsonaKudeatzaile kudeatzaile = new PertsonaKudeatzaile();

		ArrayList<Pertsona> pertsonak = kudeatzaile.getAllPertsonak();

		do {

			System.out.println("========= MENUA =========");
			System.out.println("1. Langile berria gehitu");
			System.out.println("2. Freelancer berria gehitu");
			System.out.println("3. Langileen zerrenda ikusi");
			System.out.println("4. Freelancer-en zerrenda ikusi");
			System.out.println("5. Langile baten datuak eguneratu");
			System.out.println("6. Freelancer baten datuak eguneratu");
			System.out.println("7. Langile bat ezabatu");
			System.out.println("8. Freelancer bat ezabatu");
			System.out.println("9. Irten");
			System.out.print("=========================\nAukeratu zenbaki bat: ");

			sOpe = sc.nextLine();
			// TODO Validar String
			ope = Integer.parseInt(sOpe);

			switch (ope) {
			case 1:
				System.out.println("Sartu izena:");
				String izenabl = sc.nextLine();
				System.out.println("sartu adina: ");
				String sAdinabl = sc.nextLine();
				int adinabl = Integer.parseInt(sAdinabl); // TODO Validar
				System.out.println("sartu kargua:");
				String karguabl = sc.nextLine();
				System.out.println("sartu oinarrizko soldata");
				String sOinarrizkobl = sc.nextLine();
				Double oinarrizkobl = Double.parseDouble(sOinarrizkobl); // TODO Validar
				System.out.println("Sartu antzinatasuna:");
				String sAntzinatasunabl = sc.nextLine();
				int antzinatasunabl = Integer.parseInt(sAntzinatasunabl);

				Langilea l1 = new Langilea(izenabl, adinabl, karguabl, oinarrizkobl, antzinatasunabl);

				kudeatzaile.insertLangileak(l1);
				pertsonak = kudeatzaile.getAllPertsonak();

				break;
			case 2:
				System.out.println("Sartu izena:");
				String izenabf = sc.nextLine();
				System.out.println("sartu adina: ");
				String sAdinabf = sc.nextLine();
				int adinabf = Integer.parseInt(sAdinabf); // TODO Validar
				System.out.println("sartu lanorduak:");
				String sLanorduakbf = sc.nextLine();
				Double lanorduakbf = Double.parseDouble(sLanorduakbf); // TODO Validar
				System.out.println("sartu oinarrizko soldata");
				String sOinarrizkobf = sc.nextLine();
				Double oinarrizkobf = Double.parseDouble(sOinarrizkobf); // TODO Validar

				Freelancer f1 = new Freelancer(izenabf, adinabf, lanorduakbf, oinarrizkobf);

				kudeatzaile.insertFreelancer(f1);
				pertsonak = kudeatzaile.getAllPertsonak();
				break;
			case 3:

				for (Pertsona p : pertsonak) {
					if (p instanceof Langilea) {
						System.out.println(p);
					}
				}

				break;
			case 4:
				for (Pertsona p : pertsonak) {
					if (p instanceof Freelancer) {
						System.out.println(p);
					}
				}
				break;
			case 5:

				System.out.println("Langile baten datuak eguneratzen...");
				for (Pertsona p : pertsonak) {
					if (p instanceof Langilea) {
						System.out.println(p);
					}
				}
				System.out.println("Aukeratu nahi duzun langilearen ID-a");

				String saldatutakoLangile = sc.nextLine();
				int aldatukoLangile = Integer.parseInt(saldatutakoLangile);

				do {
					System.out.println("Aukeratu eguneratuko den datua:");
					System.out.println("1. Izena");
					System.out.println("2. Adina");
					System.out.println("3. kargua");
					System.out.println("4. Oinarrizko Soldata");
					System.out.println("5. Antzinatasuna");
					System.out.println("6. Atzera");

					sOpe = sc.nextLine();
					opeLangile = Integer.parseInt(sOpe);

					switch (opeLangile) {

					case 1:

						System.out.println("Sartu izen berria:");

						String l = sc.nextLine();
						kudeatzaile.eguneratuIzena(aldatukoLangile, l);

						break;

					case 2:

						System.out.println("Sartu adina berria:");

						String sl2 = sc.nextLine();
						int l2 = Integer.parseInt(sl2);
						kudeatzaile.eguneratuAdina(aldatukoLangile, l2);

						break;

					case 3:

						System.out.println("Sartu kargu berria:");

						String l3 = sc.nextLine();
						kudeatzaile.eguneratuKargua(aldatukoLangile, l3);

						break;

					case 4:

						System.out.println("Sartu oinarrizko soldata berria:");

						String sl4 = sc.nextLine();
						Double l4 = Double.parseDouble(sl4);
						kudeatzaile.eguneratuSoldata(aldatukoLangile, l4);

						break;

					case 5:

						System.out.println("Sartu antzinatasuna berria:");

						String sl5 = sc.nextLine();
						int l5 = Integer.parseInt(sl5);
						kudeatzaile.eguneratuAntzinatasuna(aldatukoLangile, l5);

						break;

					case 6:

						break;

					}
				} while (opeLangile != 6);

				pertsonak = kudeatzaile.getAllPertsonak();

				break;
			case 6:
				System.out.println("Freelancer baten datuak eguneratzen...");
				for (Pertsona p : pertsonak) {
					if (p instanceof Freelancer) {
						System.out.println(p);
					}
				}
				System.out.println("Aukeratu nahi duzun langilearen ID-a");

				String saldatutakoFreelancer = sc.nextLine();
				int aldatukoFreelancer = Integer.parseInt(saldatutakoFreelancer);

				do {
					System.out.println("Aukeratu eguneratuko den datua:");
					System.out.println("1. Izena");
					System.out.println("2. Adina");
					System.out.println("3. lanorduak");
					System.out.println("4. ordainaria orduko");
					System.out.println("5. Atzera");

					sOpe = sc.nextLine();
					opeLangile = Integer.parseInt(sOpe);

					switch (opeLangile) {

					case 1:

						System.out.println("Sartu izen berria:");

						String f = sc.nextLine();
						kudeatzaile.eguneratuFIzena(aldatukoFreelancer, f);

						break;

					case 2:

						System.out.println("Sartu adina berria:");

						String sf2 = sc.nextLine();
						int f2 = Integer.parseInt(sf2);
						kudeatzaile.eguneratuFAdina(aldatukoFreelancer, f2);

						break;

					case 3:

						System.out.println("Sartu lanordu berriak:");

						String sf3 = sc.nextLine();
						int f3 = Integer.parseInt(sf3);
						kudeatzaile.eguneratuFLanorduak(aldatukoFreelancer, f3);

						break;

					case 4:

						System.out.println("Sartu ordainsaria orduko berria:");

						String sf4 = sc.nextLine();
						Double f4 = Double.parseDouble(sf4);
						kudeatzaile.eguneratuFOrdainsariaOrduko(aldatukoFreelancer, f4);

						break;

					case 5:

						break;

					}
				} while (opeLangile != 5);

				pertsonak = kudeatzaile.getAllPertsonak();

				break;
			case 7:
				System.out.println("Sartu langilearen izena:");
				String izenaL = sc.nextLine();

				kudeatzaile.deleteLangileak(izenaL);
				pertsonak = kudeatzaile.getAllPertsonak();

				break;
			case 8:
				System.out.println("Sartu Freelanceraren izena:");
				String izenaF = sc.nextLine();

				kudeatzaile.deleteFreelancerak(izenaF);
				pertsonak = kudeatzaile.getAllPertsonak();

				break;

			case 9:
				System.out.println("Irten...");

				break;
			default:
				System.out.println("Aukera baliogabea, berriro saiatu.");
				break;
			}

		} while (ope != 9);

		sc.close();
	}
}