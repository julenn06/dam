package azterketaTxuleta;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		BD_Konexioa konexioa = new BD_Konexioa();
		Metodoak metodoak = new Metodoak();

		konexioa.conectar();

		String izena = "";
		String soldata = "";
		int adina = 0;
		double soldataDouble = 0;
		boolean error = false;

		Scanner sc = new Scanner(System.in);

		int aukera;
		boolean jarraitu = true;
		do {
			System.out.println();
			System.out.println("Zer egin nahi duzu?");
			System.out.println("1. Ikasleak ikusi");
			System.out.println("2. Ikaslea ezabatu izenarekin");
			System.out.println("3. Ikasela ezabatu IDArekin");
			System.out.println("4. Ikaslea Bilatu Izenarekin");
			System.out.println("5. Ikaslea bilatu Adinarekin");
			System.out.println("6. Irakasleak Bilatu soldatarekin 1 Modua");
			System.out.println("7. Irakasleak Bilatu soldatarekin 2 Modua");
			System.out.println("8. Bilatu Ikasleak irakaslearen izenarekin 1 Modua");
			System.out.println("9. Bilatu Ikasleak irakaslearen izenarekin 2 Modua (Join)");
			System.out.println("10. Soldata igo Irakasleei");
			System.out.println("11. Ikaslea Erregistratu");
			System.out.println("12. Irakaslea Erregistratu");
			System.out.println("13. Irakasleak ikusi (2 baldintzekin)");
			System.out.println("14.Itxi");
			aukera = sc.nextInt();

			switch (aukera) {

			case 1:
				metodoak.ikasleakIkusi(konexioa);
				break;
			case 2:
				System.out.println("Sartu ikaslearen izena:");
				izena = sc.next();
				metodoak.ikasleaEzabatuIzenaErabiltzen(konexioa, izena);
				break;

			case 3:
				int id;
				System.out.println("Sartu ikaslearen ID: ");
				id = sc.nextInt();
				metodoak.ikasleaEzabatuIDErabiltzen(konexioa, id);
				break;
			case 4:
				System.out.println("Sartu ikaslearen izena:");
				izena = sc.next();
				metodoak.ikasleaBilatuIzenarekin(konexioa, izena);
			case 5:
				System.out.println("Zein urteko Ikasleak Bilatu nahi dituzu?");
				adina = sc.nextInt();
				metodoak.ikaselakBilatuAdinarekin(konexioa, adina);
				break;

			// Forma 1 de manejar excepciones
			case 6:
				do {
					try {
						System.out.println("Zenbat baino gutxiago irabazten duten irakasleak bilatu nahi dituzu?");
						soldata = sc.next();
						soldata = soldata.replace(",", ".");
						error = metodoak.soldataBalidatu(soldata);
					} catch (SoldataBalidatu SB) {
						error = true;
					}
				} while (error);
				soldataDouble = Double.parseDouble(soldata);
				metodoak.irakasleakBilatuSoldatarekin(konexioa, soldataDouble);
				break;

			// Forma 2 de manejar excepciones
			case 7:
				do {
					try {
						System.out.println("Zenbat baino gutxiago irabazten duten irakasleak bilatu nahi dituzu?");
						soldata = sc.next();

						soldata = soldata.replace(",", ".");

						soldataDouble = Double.parseDouble(soldata);

						if (soldataDouble <= 0) {
							throw new SoldataBalidatu("Soldata ezin da izan 0 edo gutxiago.");
						}
						error = false;
					} catch (NumberFormatException e) {
						System.out.println(
								"Balidazio Errorea: Soldata behar bezala adierazi behar da (zenbaki bat izan behar da).");
						error = true;

					} catch (SoldataBalidatu SB) {
						error = true;
					}
				} while (error);

				soldataDouble = Double.parseDouble(soldata);
				metodoak.irakasleakBilatuSoldatarekin(konexioa, soldataDouble);
				break;
			case 8:
				System.out.println("Zein irakaslearen ikasleak aurkitu nahi dituzu?");
				izena = sc.next();
				metodoak.ikasleakBilatuIrakaslearekinForma1(konexioa, izena);
				break;

			case 9:
				System.out.println("Zein irakaslearen ikasleak aurkitu nahi dituzu?");
				izena = sc.next();
				metodoak.ikasleakBilatuIrakaslearekinForma2(konexioa, izena);
				break;
			case 10:
				do {
					try {
						System.out.println("Zenbat baino gutxiago irabazten dutenei igo?: ");
						soldata = sc.next();

						soldata = soldata.replace(",", ".");

						soldataDouble = Double.parseDouble(soldata);

						if (soldataDouble <= 0) {
							throw new SoldataBalidatu("Soldata ezin da izan 0 edo gutxiago.");
						}
						error = false;
					} catch (NumberFormatException e) {
						System.out.println(
								"Balidazio Errorea: Soldata behar bezala adierazi behar da (zenbaki bat izan behar da).");
						error = true;

					} catch (SoldataBalidatu SB) {
						error = true;
					}
				} while (error);

				soldataDouble = Double.parseDouble(soldata);
				metodoak.soldataIgo(konexioa, soldataDouble);
				break;

			// Forma 3 de manejar excepciones, la excepcion esta en el constructor
			case 11:
				do {
					System.out.println("Ikaslea erregistratu: ");

					System.out.print("Idatzi ikaslearen izena: ");
					izena = sc.next();

					System.out.print("Idatzi ikaslearen abizena: ");
					String abizena = sc.next();

					System.out.print("Idatzi ikaslearen adina: ");
					adina = sc.nextInt();

					System.out.print("Idatzi ikaslearen gela (aula): ");
					int gela = sc.nextInt();

					System.out.print("Idatzi ikaslearen kurtsoa: ");
					String kurtsoa = sc.next();

					System.out.print("Idatzi ikaslearen ordutegia: ");
					String ordutegia = sc.next();

					System.out.println();
					try {
						Ikasleak ikaslea = new Ikasleak(izena, abizena, adina, gela, kurtsoa, ordutegia);
						metodoak.ikasleaGehitu(ikaslea, konexioa);
						error = false;
					} catch (AdinaBalidatu AB) {
						System.out.println(AB.getMessage());
						error = true;
					}
				} while (error);
				break;
			case 12:

				System.out.print("Idatzi irakaslearen izena: ");
				izena = sc.next();

				System.out.print("Idatzi irakaslearen abizena: ");
				String abizena = sc.next();

				System.out.print("Idatzi irakaslearen adina: ");
				adina = sc.nextInt();

				System.out.print("Idatzi irakaslearen gela (aula): ");
				int gela = sc.nextInt();

				System.out.print("Idatzi irakaslearen soldata: ");
				soldata = sc.next();

				System.out.print("Idatzi irakaslearen ordutegia: ");
				String ordutegia = sc.next();

				System.out.println();

				try {

					soldata = soldata.replace(",", ".");

					error = metodoak.soldataBalidatu(soldata);

				} catch (SoldataBalidatu SB) {
					System.out.println(SB.getMessage());
					error = true;
				}

				if (!error) {
					try {
						soldataDouble = Double.parseDouble(soldata);
						Irakasleak irakaslea = new Irakasleak(izena, abizena, adina, gela, soldataDouble, ordutegia);
						metodoak.irakasleaGehitu(irakaslea, konexioa);
					} catch (AdinaBalidatu AB) {
						System.out.println(AB.getMessage());
					}
				}

				break;

			case 13:
				System.out.println("Irakaslearen izena: ");
				izena = sc.next();
				System.out.println("Irakaslearen Soldata: ");
				soldata = sc.next();

				try {
					soldata = soldata.replace(",", ".");
					error = metodoak.soldataBalidatu(soldata);
				} catch (SoldataBalidatu SB) {
					System.out.println(SB.getMessage());
					error = true;
				}
				if (!error) {
					soldataDouble = Double.parseDouble(soldata);
					metodoak.irakasleaIkusi(konexioa, izena, soldataDouble);
				}
				break;
			case 14:
				System.out.println("Irten...");
				jarraitu = false;
				break;
			default:
				System.out.println("Aukera okerra");
			}
		} while (jarraitu);
		sc.close();
	}

}