package metodoak;

import java.awt.Image;
import java.net.URL;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import windowbuilder.vending_makina;

public class metodoak {

	Scanner sc = new Scanner(System.in);

	/**
	 * Produktuen izenak gordetzen dituen arraya.
	 */
	private static String[] izena = { "Ruffles", "Pringles", "Txiskeroa", "Facundo", "Txokolate", "Fanta", "Coca-Cola",
			"Estutxea", "Pendrive", "kit-kat", "Toblerone", "Nestea", "", "", "", "", "", "", "", "" };

	/**
	 * Produktuen identifikazio zenbakiak gordetzen dituen arraya.
	 */
	private static String[] zenbakia = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "", "", "", "",
			"", "", "", "" };

	/**
	 * Produktuen prezioak gordetzen dituen arraya.
	 */
	private static double[] prezioa = { 1.50, 2.00, 0.90, 1.00, 1.50, 1.30, 1.70, 4.25, 7.50, 2.20, 3, 1.50, 0, 0, 0, 0,
			0, 0, 0, 0 };

	/**
	 * Produktuen motak gordetzen dituen arraya, zenbakiekin adierazita.
	 */
	private static String[] mota = { "1", "1", "4", "1", "3", "2", "2", "4", "4", "3", "3", "2", "", "", "", "", "", "",
			"", "" };

	/**
	 * Produktuei lotutako irudiaren izenak gordetzen dituen arraya.
	 */
	private static String[] argazkia = { "ruffles.jpg", "pringles.jpg", "txiskeroa.png", "facundo.jpg", "txokolate.jpg",
			"fanta.jpg", "cocacola.jpg", "estuche.jpg", "pendrive.jpg", "kit-kat.jpg", "toblerone.jpg", "nestea.jpg",
			null, null, null, null, null, null, null, null };

	/**
	 * Produktuen izenak lortzeko metodoa.
	 * 
	 * @param array Produktuen izenak gordetzen dituen arraya.
	 * @return <code>izena</code> arraya, produktuen izenekin.
	 */
	public static String[] get_izena(String[] array) {
		return izena;
	}

	/**
	 * Produktuen identifikazio zenbakiak lortzeko metodoa.
	 * 
	 * @param array Produktuen identifikazio zenbakiak gordetzen dituen arraya.
	 * @return <code>zenbakia</code> arraya, produktuen identifikazio zenbakiekin.
	 */
	public static String[] get_zbk(String[] array) {
		return zenbakia;
	}

	/**
	 * Produktuen prezioak lortzeko metodoa.
	 * 
	 * @param array Produktuen prezioak gordetzen dituen arraya.
	 * @return <code>prezioa</code> arraya, produktuen prezioekin.
	 */
	public static double[] get_prezioa(double[] array) {
		return prezioa;
	}

	/**
	 * Produktuei lotutako irudien izenak lortzeko metodoa.
	 * 
	 * @param array Produktuei lotutako irudien izenak gordetzen dituen arraya.
	 * @return <code>argazkia</code> arraya, irudien izenekin.
	 */
	public static String[] get_irudia(String[] array) {
		return argazkia;
	}

	/**
	 * Produktuen motak lortzeko metodoa.
	 * 
	 * @param array Produktuen motak gordetzen dituen arraya.
	 * @return <code>mota</code> arraya, produktuen motekin.
	 */
	public static String[] get_mota(String[] array) {
		return mota;
	}

	/**
	 * Produktuen kopurua lortzeko metodoa.
	 * 
	 * @param kont Produktuen kopurua.
	 * @return <code>kont</code> zenbakia, produktu kopurua adierazten duena.
	 */
	public static int get_kont(int kont) {
		return kont;
	}

	/**
	 * Produktuen taula bat erakusten du ordenatu ondoren. Produktuak identifikazio
	 * zenbakien arabera antolatzeko
	 * {@link #ordenatuzenbakiak(String[], String[], double[], String[], String[], int)}
	 * metodoa erabiltzen du.
	 *
	 * @param izena   Produktuen izenen arraya {@link #get_izena(String[])}.
	 * @param zbk     Produktuen identifikazio zenbakien arraya
	 *                {@link #get_zbk(String[])}.
	 * @param prezioa Produktuen prezioen arraya {@link #get_prezioa(double[])}.
	 * @param mota    Produktu moten arraya, hasieran zenbakiekin adierazita
	 *                {@link #get_mota(String[])}.
	 * @param irudiak Produktuei lotutako irudien izenen arraya
	 *                {@link #get_irudia(String[])}.
	 * @param kont    Erakutsi beharreko produktuen kopurua.
	 */
	public static void taula(String[] izena, String[] zbk, double[] prezioa, String[] mota, String[] irudiak,
			int kont) {
		// Produktuak erakutsi aurretik ordenatu
		ordenatuzenbakiak(izena, zbk, prezioa, mota, irudiak, kont);

		// Produktuen taula bistaratu
		System.out.println("------------------------------------------------------------------------------");
		System.out.printf(
				"\u001B[32m%-10s\u001B[0m     | \u001B[33m%-8s\u001B[0m | \u001B[31m%-6s\u001B[0m | \u001B[36m%-10s\u001B[0m        | \u001B[38;5;214m%-6s\u001B[0m            | \n",
				"Izena", "Zenbakia", "Prezioa", "Mota", "Irudiak");
		System.out.println("------------------------------------------------------------------------------");

		// Produktuak iteratu eta bakoitza bistaratu
		for (int i = 0; i < kont; i++) {
			if (izena[i] != null && zbk[i] != null && prezioa[i] > 0 && mota[i] != null && irudiak[i] != null) {

				// Mota bakoitzari dagokion izena ezarri
				if (mota[i].equals("1")) {
					mota[i] = "paketea";
				} else if (mota[i].equals("2")) {
					mota[i] = "edaria";
				} else if (mota[i].equals("3")) {
					mota[i] = "snack";
				} else if (mota[i].equals("4")) {
					mota[i] = "objetua";
				}

				// Produktuaren datuak taulan inprimatu
				System.out.printf(
						"\u001B[32m%-10s\u001B[0m     | \u001B[33m%-8s\u001B[0m | \u001B[31m%-6.2f\u001B[0m  | \u001B[36m%-10s\u001B[0m        |  \u001B[38;5;214m%-6s\u001B[0m       | \n",
						izena[i].toLowerCase(), zbk[i], prezioa[i], mota[i].toLowerCase(), irudiak[i].toLowerCase());
				System.out.println("------------------------------------------------------------------------------");
			}
		}
	}

	/**
	 * Produktuak identifikazio zenbakiaren arabera goranzko hurrenkeran ordenatzen
	 * ditu, burbuila-algoritmoa erabiliz. Identifikazio-zenbakien arrayan posizioak
	 * aldatzen direnean, produktuaren izena, prezioa, mota eta irudia jasotzen
	 * dituzten arrayetan ere aldaketak egiten dira, datuak koherente mantentzeko.
	 *
	 * @param izena   Produktuen izenen arraya. {@link #get_izena(String[])}
	 *                metodoaren bidez erabiltzen da.
	 * @param zbk     Produktuen identifikazio zenbakiak gordetzen dituen arraya.
	 *                {@link #get_zbk(String[])} metodoaren bidez erabiltzen da.
	 * @param prezioa Produktuen prezioak gordetzen dituen arraya.
	 *                {@link #get_prezioa(double[])} metodoaren bidez erabiltzen da.
	 * @param mota    Produktu motak gordetzen dituen arraya.
	 *                {@link #get_mota(String[])} metodoaren bidez erabiltzen da.
	 * @param irudiak Produktuei lotutako irudi izenak gordetzen dituen arraya.
	 *                {@link #get_irudia(String[])} metodoaren bidez erabiltzen da.
	 * @param kont    Ordenatu beharreko produktuen kopurua.
	 */
	public static void ordenatuzenbakiak(String[] izena, String[] zbk, double[] prezioa, String[] mota,
			String[] irudiak, int kont) {
		// Produktuak zenbakien arabera ordenatzeko burbuila-algoritmoa
		for (int i = 0; i < kont - 1; i++) {
			// Bi dimentsioko buclea, elementuak alderatzeko
			for (int j = 0; j < kont - i - 1; j++) {
				// Elementuak ez direla null eta ordena egokia den ala ez egiaztatu
				if (zbk[j] != null && zbk[j + 1] != null && Integer.parseInt(zbk[j]) > Integer.parseInt(zbk[j + 1])) {
					// Posizioak aldatu array guztietan
					String ordenatu_izena = izena[j];
					String ordenatu_zbk = zbk[j];
					double ordenatu_prezioa = prezioa[j];
					String ordenatu_mota = mota[j];
					String ordenatu_irudia = irudiak[j];

					// Aldaketa egin
					izena[j] = izena[j + 1];
					zbk[j] = zbk[j + 1];
					prezioa[j] = prezioa[j + 1];
					mota[j] = mota[j + 1];
					irudiak[j] = irudiak[j + 1];

					// Elementu temporalei balioa ematea
					izena[j + 1] = ordenatu_izena;
					zbk[j + 1] = ordenatu_zbk;
					prezioa[j + 1] = ordenatu_prezioa;
					mota[j + 1] = ordenatu_mota;
					irudiak[j + 1] = ordenatu_irudia;
				}
			}
		}
	}

	/**
	 * Saio-hasiera prozesua burutzen du, sartutako erabiltzaile-izena eta pasahitza
	 * balioztatuz erabiltzaile eta pasahitzen arrayen aurka. Erabiltzaile-izena eta
	 * pasahitza sartzen dira {@code Scanner} baten bidez, eta saioa ondo hasi dela
	 * itzultzen du.
	 *
	 * @param user           Sartutako erabiltzaile-izena.
	 * @param password       Sartutako pasahitza.
	 * @param erabiltzaileak Erabiltzaile izen baliodunen arraya.
	 * @param pasahitzak     Pasahitz baliodunen arraya.
	 * @param sc             Erabiltzailearen sarrera jasotzeko {@link Scanner}
	 *                       objektua.
	 * @return true saio-hasiera egokia bada, false bestela.
	 */

	public static boolean login(String user, String password, String[] erabiltzaileak, String[] pasahitzak,
			Scanner sc) {
		System.out.println("Erabiltzailea: ");
		user = sc.next(); // Erabiltzailearen izena irakurri
		System.out.println("Pasahitza: ");
		password = sc.next(); // Pasahitza irakurri

		// Erabiltzailearen balidazioa
		for (int i = 0; i < erabiltzaileak.length; i++) {
			if (erabiltzaileak[i].equals(user) && pasahitzak[i].equals(password)) {
				return true; // Balidazioa arrakastatsua
			}
		}
		return false;
	}

	/**
	 * Hasierako menua erakusten du eta eskuragarri dauden aukeren artean bat
	 * hautatzeko aukera ematen du. Erabiltzaileak hautatutako aukera itzultzen du.
	 *
	 * @param aukera      Erabiltzaileak hautatutako aukera zenbakia gordetzeko
	 *                    aldagaia.
	 * @param balidazioak Hautatutako aukera balioduna den adierazten duen booleana.
	 * @param sc          Erabiltzailearen sarrera jasotzeko {@link Scanner}
	 *                    objektua.
	 * @return Erabiltzaileak hautatutako aukera zenbakia.
	 */

	public static int hasierako_menu(int aukera, boolean balidazioak, Scanner sc) {
		do {
			try {
				System.out.println();
				System.out.println("Zer nahi duzu egin?"); // Aukera galdetu
				System.out.println("1. Produktu bat gehitu");
				System.out.println("2. Produktu bat aldatu");
				System.out.println("3. Produktu bat ezabatu");
				System.out.println("4. Atera");
				aukera = sc.nextInt(); // Erabiltzaileak hautatutako aukera irakurri
				balidazioak = true; // Balidazioa egiaztatu

			} catch (Exception e) { // Excepcion bat sortzen bada
				System.out.println("Sartu balio egoki bat"); // Mezu okerra
				System.out.println();
				sc.next();
				balidazioak = false; // Balidazioa faltsua
			}
		} while (balidazioak == false); // Balidazioa faltsua bada, berriz saiatu

		return aukera;
	}

	/**
	 * Produktu berri bat gehitzen du sisteman, bere datuak hartu eta balioztatu
	 * ondoren. Produktuaren izena, identifikazio zenbakia, prezioa, mota eta irudia
	 * egiaztatzen dira eta taulan gehitzen dira.
	 *
	 * @param izena         Produktuen izenen array-a. {@link #get_izena(String[])}
	 * @param zbk           Produktuen identifikazio zenbakien array-a.
	 *                      {@link #get_zbk(String[])}
	 * @param prezioa       Produktuen prezioen array-a.
	 *                      {@link #get_prezioa(double[])}
	 * @param mota          Produktuen moten array-a. {@link #get_mota(String[])}
	 * @param irudiak       Produktuei lotutako irudien izenen array-a.
	 *                      {@link #get_irudia(String[])}
	 * @param kont          Sisteman dauden produktuen kantitatea.
	 * @param atzera_aukera Prozesua bertan behera uzteko aukera.
	 * @param balidazioak   Sartutako datuak baliodunak diren adierazten duen
	 *                      aldagaia.
	 * @param izena_p       Gehitu beharreko produktuaren izena.
	 * @param zbk_p         Gehitu beharreko produktuaren identifikazio zenbakia.
	 * @param prezioa_p     Gehitu beharreko produktuaren prezioa.
	 * @param mota_p        Gehitu beharreko produktuaren mota.
	 * @param irudia_p      Gehitu beharreko produktuaren irudiaren izena.
	 * @param sc            Erabiltzailearen sarrera harrapatzeko Scanner-a.
	 * @return true produktua behar bezala gehitzen bada, false bestela.
	 */
	public static boolean produktuagehitu(String[] izena, String[] zbk, double[] prezioa, String[] mota,
			String[] irudiak, int kont, int atzera_aukera, boolean balidazioak, String izena_p, String zbk_p,
			double prezioa_p, String mota_p, String irudia_p, Scanner sc) {
		// Produktuen taula erakutsi
		metodoak.taula(izena, zbk, prezioa, mota, irudiak, kont);

		if (kont == 20) {
			System.out.println();
			System.out.println("\u001B[31m" + "Ezin dituzu produktu gehiago sartu" + "\u001B[0m");
			return balidazioak;
		}

		System.out.println();
		System.out.println("\u001B[32m" + "Produktua Gehitu" + "\u001B[0m");

		// Izen berria sartzeko eskaera
		System.out.println("Sartu izen berria: ");
		sc.nextLine();
		izena_p = sc.nextLine();
		balidazioak = true;

		do {
			// Zenbaki berria sartzeko eskaera
			System.out.println("Sartu zenbaki berria: ");
			zbk_p = sc.next();
			balidazioak = true;

			// Sartutako balioa zenbaki bat dela egiaztatu
			try {
				Integer.parseInt(zbk_p); // zbk_p zenbaki bat ez bada, errore bat botako du
			} catch (Exception e) {
				System.out.println("Zenbaki bat sartu behar duzu, saiatu berriro: ");
				balidazioak = false;
				continue; // Ez bada zenbaki bat, bueltatu hasierara
			}

			// Zenbaki hori lehendik existitzen den egiaztatu
			for (int i = 0; i < kont; i++) {
				if (zbk_p.equals(zbk[i])) {
					System.out.println(zbk_p + " zenbakia existitzen da, aukeratu beste bat: ");
					System.out.println();
					balidazioak = false;
				}
			}
		} while (!balidazioak);

		// Prezio berria sartzeko eskaera
		do {
			balidazioak = true; // Iterazio bakoitzean balidazioa berriro hasi
			System.out.println("Sartu prezio berria: ");

			String prezioa_balidatu = sc.next(); // Sartutako balioa String gisa irakurri

			// Aldatu koma puntu bihurtzeko
			prezioa_balidatu = prezioa_balidatu.replace(',', '.');

			// Saiatu irakurritako balioa double-era bihurtzen
			try {
				prezioa_p = Double.parseDouble(prezioa_balidatu); // String-a double-era bihurtu
				// Prezioa positiboa den egiaztatu
				if (prezioa_p < 0) {
					balidazioak = false; // Negatiboa bada ez da baliozkoa
					System.out.println("Prezioa positiboa izan behar da.");
				}
			} catch (NumberFormatException e) {
				balidazioak = false; // Bihurtzea posible ez bada ez da baliozkoa
				System.out.println("Sartu balio egoki bat.");
			}
		} while (!balidazioak); // Balidazioa ondo ez den bitartean jarraitu

		System.out.println("Aukeratu zein produktu mota den: ");
		System.out.println();

		do {
			System.out.println("1. Paketeak");
			System.out.println("2. Edariak");
			System.out.println("3. Snack");
			System.out.println("4. Objetuak");
			System.out.println("Aukeratu zenbaki bat: ");
			mota_p = sc.next();

			try {
				int zenbakiada = Integer.parseInt(mota_p);
				balidazioak = true;

				if (zenbakiada < 1 || zenbakiada > 4) {
					balidazioak = false;
					System.out.println("Aukera egoki bat aukeratu");
				}
			} catch (Exception e) {
				System.out.println("Aukera egoki bat aukeratu");
				balidazioak = false;
			}

		} while (balidazioak == false);

		do {
			System.out.println("Sartu produktuaren irudiaren izena");
			irudia_p = sc.next();
			if (irudia_p.toLowerCase().endsWith(".png") || irudia_p.toLowerCase().endsWith(".jpg")) {
				balidazioak = true;
			} else {
				System.out.println();
				System.out.println("Irudia .png edo .jpg izan behar da");
				balidazioak = false;
			}
		} while (balidazioak == false);

		System.out.println();
		System.out.println("\u001B[32m" + "Produktua Gehitu da" + "\u001B[0m");

		// Produktua taularen amaieran gehitu, leku librerik badago
		if (kont < izena.length) {
			izena[kont] = izena_p;
			zbk[kont] = zbk_p; // Erabiltzaileak sartutako zenbakia hartu da
			prezioa[kont] = prezioa_p;
			mota[kont] = mota_p;
			irudiak[kont] = irudia_p;
			kont++;

			// Produktuen taula erakutsi
			metodoak.taula(izena, zbk, prezioa, mota, irudiak, kont);
		} else {
		}

		return balidazioak;

	}

	/**
	 * Sistema barruan dagoen produktu bat aldatzen du, bere datu berriak hartu eta
	 * balidatu ondoren.
	 *
	 * @param izena         Produktuen izenen array-a. {@link #get_izena(String[])}
	 * @param zbk           Produktuen identifikazio zenbakien array-a.
	 *                      {@link #get_zbk(String[])}
	 * @param prezioa       Produktuen prezioen array-a.
	 *                      {@link #get_prezioa(double[])}
	 * @param mota          Produktuen moten array-a. {@link #get_mota(String[])}
	 * @param irudiak       Produktuei lotutako irudien izenen array-a.
	 *                      {@link #get_irudia(String[])}
	 * @param kont          Sisteman dauden produktuen kantitatea.
	 * @param atzera_aukera Prozesua bertan behera uzteko aukera.
	 * @param balidazioak   Sartutako datuak baliodunak diren adierazten duen
	 *                      aldagaia.
	 * @param izena_p       Produktuaren eguneratutako izena.
	 * @param zbk_p         Produktuaren eguneratutako identifikazio zenbakia.
	 * @param prezioa_p     Produktuaren eguneratutako prezioa.
	 * @param mota_p        Produktuaren eguneratutako mota.
	 * @param irudia_p      Produktuaren eguneratutako irudiaren izena.
	 * @param aukera        Erabiltzaileak hautatutako aukera.
	 * @param aukeratuzbk   Aldatu nahi den produktuaren identifikazio zenbakia.
	 * @param sc            Erabiltzailearen sarrera harrapatzeko Scanner-a.
	 * @return true produktua behar bezala aldatzen bada, false bestela.
	 */

	public static boolean produktuaaldatu(String[] izena, String[] zbk, double[] prezioa, String[] mota,
			String[] irudiak, int kont, int atzera_aukera, boolean balidazioak, String izena_p, String zbk_p,
			double prezioa_p, String mota_p, String irudia_p, int aukera, String aukeratuzbk, Scanner sc) {

		// Produktuen taula erakutsi
		metodoak.taula(izena, zbk, prezioa, mota, irudiak, kont);

		do {
			try {
				System.out.println();
				System.out.println("1. Jarraitu");
				System.out.println("2. Atzera");
				atzera_aukera = sc.nextInt();
				balidazioak = true;
				if (atzera_aukera < 1 || atzera_aukera > 2) {
					System.out.println("Aukeratu balio egoki bat");
					balidazioak = false;
				}
			} catch (Exception e) {
				System.out.println("Aukeratu balio egoki bat");
				balidazioak = false;
				sc.next();
			}

		} while (balidazioak == false);

		if (kont == 0) {
			System.out.println("\u001B[31m" + "Ez daude produktuak aldatzeko" + "\u001B[0m");
			return balidazioak;
		}

		switch (atzera_aukera) {

		case 1:

			System.out.println();
			System.out.println("\u001B[32m" + "Produktua aldatu" + "\u001B[0m");
			System.out.println();

			// Produktua aurkitzeko aldatu nahi den zenbakia eskatzen du
			do {
				balidazioak = false;
				System.out.println("Aukeratu produktuaren ZENBAKIA aldatzeko");
				aukeratuzbk = sc.next();

				// Zenbakia aurkitzen den ala ez egiaztatzen du
				for (int i = 0; i < kont; i++) {
					if (aukeratuzbk.equals(zbk[i])) {
						balidazioak = true;
					}
				}

				// Zenbakia ez bada aurkitu, mezua erakusten du
				if (balidazioak == false) {
					System.out.println("Sartu zenbaki egoki bat");
				}

			} while (balidazioak == false);

			// Izen berria sartzeko eskaera
			do {
				try {
					System.out.println("izen zaharra mantendu nahi duzu?");
					System.out.println("1. Bai");
					System.out.println("2. Ez");
					balidazioak = true;
					aukera = sc.nextInt();
					if (aukera < 1 || aukera > 2) {
						System.out.println();
						System.out.println("Balio egoki bat sartu");
						balidazioak = false;
					}
				} catch (Exception e) {
					System.out.println();
					System.out.println("Balio egoki bat sartu");
					sc.next();
					balidazioak = false;
				}
			} while (balidazioak == false);

			if (aukera == 1) {
				for (int i = 0; i < kont; i++) {
					if (aukeratuzbk.equals(zbk[i])) {
						izena_p = izena[i];
					}
				}
			} else {
				// Zenbaki berria sartzeko eskaera
				System.out.println("Sartu izen berria: ");
				izena_p = sc.next();
				balidazioak = true;
			}

			do {
				try {
					System.out.println();
					System.out.println("zenbaki zaharra mantendu nahi duzu?");
					System.out.println("1. Bai");
					System.out.println("2. Ez");
					balidazioak = true;
					aukera = sc.nextInt();
					if (aukera < 1 || aukera > 2) {
						System.out.println();
						System.out.println("Balio egoki bat sartu");
						balidazioak = false;
					}
				} catch (Exception e) {
					System.out.println();
					System.out.println("Balio egoki bat sartu");
					sc.next();
					balidazioak = false;
				}
			} while (balidazioak == false);

			if (aukera == 1) {
				zbk_p = aukeratuzbk;

			} else {
				do {
					// Zenbaki berria sartzeko eskaera
					System.out.println("Sartu zenbaki berria: ");
					zbk_p = sc.next();
					balidazioak = true;
					// Zenbaki berria existitzen den ala ez egiaztatzen du
					for (int i = 0; i < kont; i++) {
						if (zbk_p.equals(zbk[i])) {
							System.out.println(zbk_p + " produktu zenbakia existitzen da, aukeratu beste bat: ");
							balidazioak = false;
						}
					}
					try {
						Integer.parseInt(zbk_p);

					} catch (Exception e) {
						System.out.println("Balio egoki bat sartu");
						balidazioak = false;

					}
				} while (balidazioak == false);
			}

			do {
				// Prezio zaharra mantendu nahi duzun galdetu
				do {
					try {
						System.out.println("prezio zaharra mantendu nahi duzu?");
						System.out.println("1. Bai");
						System.out.println("2. Ez");
						balidazioak = true; // Balidazioa hasi
						aukera = sc.nextInt(); // Erabiltzailearen aukera irakurri
						// Aukera baliozko den egiaztatu
						if (aukera < 1 || aukera > 2) {
							System.out.println();
							System.out.println("Balio egoki bat sartu");
							balidazioak = false; // Balidazioa okerra
						}
					} catch (Exception e) {
						System.out.println();
						System.out.println("Balio egoki bat sartu");
						sc.next(); // Hurrengo sarrera irakurri errorea saihesteko
						balidazioak = false; // Balidazioa okerra
					}
				} while (!balidazioak); // Balidazioa okerra den bitartean jarraitu

				if (aukera == 1) {
					// Prezio zaharra mantendu
					for (int i = 0; i < kont; i++) {
						if (aukeratuzbk.equals(zbk[i])) {
							prezioa_p = prezioa[i]; // Prezioa zaharra ezarri
						}
					}
				} else {
					// Prezio berria sartzeko eskaera
					do {
						balidazioak = true; // Iterazio bakoitzean balidazioa berriro hasi
						System.out.println("Sartu prezio berria: ");

						String prezioa_balidatu = sc.next(); // Sartutako balioa String gisa irakurri

						// Aldatu koma puntu bihurtzeko
						prezioa_balidatu = prezioa_balidatu.replace(',', '.');

						// Saiatu irakurritako balioa double-era bihurtzen
						try {
							prezioa_p = Double.parseDouble(prezioa_balidatu); // String-a double-era bihurtu
							// Prezioa positiboa den egiaztatu
							if (prezioa_p < 0) {
								balidazioak = false; // Negatiboa bada ez da baliozkoa
								System.out.println("Prezioa positiboa izan behar da.");
							}
						} catch (NumberFormatException e) {
							balidazioak = false; // Bihurtzea posible ez bada ez da baliozkoa
							System.out.println("Sartu balio egoki bat.");
						}
					} while (!balidazioak); // Balidazioa okerra den bitartean jarraitu
				}
			} while (!balidazioak); // Balidazioa egokia izan arte jarraitu

			do {
				try {
					System.out.println("mota zaharra mantendu nahi duzu?");
					System.out.println("1. Bai");
					System.out.println("2. Ez");
					balidazioak = true;
					aukera = sc.nextInt();
					if (aukera < 1 || aukera > 2) {
						System.out.println();
						System.out.println("Balio egoki bat sartu");
						balidazioak = false;
					}
				} catch (Exception e) {
					System.out.println();
					System.out.println("Balio egoki bat sartu");
					sc.next();
					balidazioak = false;
				}
			} while (balidazioak == false);
			if (aukera == 1) {
				for (int i = 0; i < kont; i++) {
					mota_p = mota[i];
				}
			} else {
				do {
					System.out.println("1. Paketeak");
					System.out.println("2. Edariak");
					System.out.println("3. Snack");
					System.out.println("4. Objetuak");
					System.out.println("Aukeratu zenbaki bat: ");
					mota_p = sc.next();

					try {
						int zenbakiada = Integer.parseInt(mota_p);
						balidazioak = true;

						if (zenbakiada < 1 || zenbakiada > 4) {
							balidazioak = false;
							System.out.println("Aukera egoki bat aukeratu");
						}
					} catch (Exception e) {
						System.out.println("Aukera egoki bat aukeratu");
						balidazioak = false;
					}

				} while (balidazioak == false);
			}

			do {
				try {
					System.out.println("irudi zaharra mantendu nahi duzu?");
					System.out.println("1. Bai");
					System.out.println("2. Ez");
					balidazioak = true;
					aukera = sc.nextInt();
					if (aukera < 1 || aukera > 2) {
						System.out.println();
						System.out.println("Balio egoki bat sartu");
						balidazioak = false;
					}
				} catch (Exception e) {
					System.out.println();
					System.out.println("Balio egoki bat sartu");
					sc.next();
					balidazioak = false;
				}
			} while (balidazioak == false);

			if (aukera == 1) {
				for (int i = 0; i < kont; i++) {
					irudia_p = irudiak[i];
				}
			} else {
				do {
					System.out.println("Sartu produktuaren irudiaren izena");
					irudia_p = sc.next();
					if (irudia_p.toLowerCase().endsWith(".png") || irudia_p.toLowerCase().endsWith(".jpg")) {
						balidazioak = true;
					} else {
						System.out.println();
						System.out.println("Irudia .png edo .jpg izan behar da");
						balidazioak = false;
					}
				} while (balidazioak == false);
			}

			// Produktuaren datuak eguneratzen ditu, aurkitzen badu
			for (int i = 0; i < kont; i++) {
				if (aukeratuzbk.equals(zbk[i])) {
					izena[i] = izena_p;
					zbk[i] = zbk_p;
					prezioa[i] = prezioa_p;
					mota[i] = mota_p;
					irudiak[i] = irudia_p;
					System.out.println(aukeratuzbk + " produktua aldatu da.");
				}
			}

			// Produktuen taula erakutsi
			metodoak.taula(izena, zbk, prezioa, mota, irudiak, kont);

			break;
		case 2:
			balidazioak = true;
			break;
		}

		return balidazioak;

	}

	/**
	 * Produktu bat ezabatzeko aukera ematen du identifikadore bakar batean (zbk)
	 * oinarrituta. Produktuen taula bat erakusten du, erabiltzaileari jarraitu edo
	 * atzera egiteko aukera eskatzen dio, eta ezabatzeko sartutako produktuen
	 * identifikadorea baliozkoa dela egiaztatzen du.
	 *
	 * @param izena         Produktuen izenen array-a. {@link #get_izena(String[])}
	 * @param zbk           Produktuen identifikazio zenbakien array-a.
	 *                      {@link #get_zbk(String[])}
	 * @param prezioa       Produktuen prezioen array-a.
	 *                      {@link #get_prezioa(double[])}
	 * @param mota          Produktuen moten array-a. {@link #get_mota(String[])}
	 * @param irudiak       Produktuei lotutako irudien izenen array-a.
	 *                      {@link #get_irudia(String[])}
	 * @param kont          Sisteman dauden produktuen kantitatea.
	 * 
	 * 
	 * @param atzera_aukera Erabiltzaileak ezabaketan jarraitu edo atzera egin nahi
	 *                      duen adierazten duen aldagaia.
	 * @param balidazioak   Prozesuan zehar balidazioa agokia den edo ez adierazten
	 *                      duen aldagaia.
	 * @param zbk_ezabatu   Erabiltzaileak ezabatu nahi duen produktuen
	 *                      identifikadorea.
	 * @param badago        Ezabatu beharreko produktua array-an dagoen adierazten
	 *                      du.
	 * @param sc            Erabiltzailearen sarrerak harrapatzeko eskaneatzailea.
	 * @return `true` baldin eta eragiketa egokia bada, `false` bestela edo
	 *         erabiltzaileak ezabatu nahi ez badu.
	 */

	public static boolean produktuaezabatu(String[] izena, String[] zbk, double[] prezioa, String[] mota,
			String[] irudiak, int kont, int atzera_aukera, boolean balidazioak, String zbk_ezabatu, boolean badago,
			Scanner sc) {

		metodoak.taula(izena, zbk, prezioa, mota, irudiak, kont);

		do {
			try {
				System.out.println();
				System.out.println("1. Jarraitu");
				System.out.println("2. Atzera");
				atzera_aukera = sc.nextInt();
				balidazioak = true;
				if (atzera_aukera < 1 || atzera_aukera > 2) {
					System.out.println("Aukeratu balio egoki bat");
					balidazioak = false;
				}
				if (kont == 0) {
					System.out.println("\u001B[31m" + "Ez daude produktuak ezabatzeko" + "\u001B[0m");
					return balidazioak;
				}
			} catch (Exception e) {
				System.out.println("Aukeratu balio egoki bat");
				balidazioak = false;
				sc.next();
			}
		} while (balidazioak == false);

		switch (atzera_aukera) {

		case 1:
			System.out.println();
			System.out.println("\u001B[32m" + "Produktua ezabatu" + "\u001B[0m");
			System.out.println();

			do {
				do {

					balidazioak = true; // Balidazioak hasieratu
					System.out.println("Aukeratu produktuaren ZENBAKIA ezabatzeko");
					zbk_ezabatu = sc.next();

					// Produktu zenbakia bilatzea
					for (int i = 0; i < kont; i++) {
						if (zbk_ezabatu.equals(zbk[i])) {
							badago = true; // Produktua aurkitu da
						}
					}
					if (badago) {
						balidazioak = true; // Balidazioa onartzen da
					} else {
						balidazioak = false; // Balidazioa ez da onartzen
						System.out.println("Sartu zenbaki egoki bat");
					}

				} while (balidazioak == false); // Balidazioa okerra bada

				// Produktua ezabatzen
				for (int i = 0; i < kont; i++) {
					if (zbk_ezabatu.equals(zbk[i])) {
						System.out.println(izena[i] + " Produktua ezabatu da");
						System.out.println();

						// Datuak mugitu, balio berdinak izateko jarraitzen
						for (int j = i; j < kont - 1; j++) {
							izena[j] = izena[j + 1];
							zbk[j] = zbk[j + 1];
							prezioa[j] = prezioa[j + 1];
							mota[j] = mota[j + 1];
						}

						// Kontadorea jaitzi eta arrayetan dauden datuak pozizio horietan ezabatu
						kont--;
						izena[kont] = null;
						zbk[kont] = null;
						prezioa[kont] = 0;
						mota[kont] = null;
						irudiak[kont] = null;

					}
				}

			} while (balidazioak == false); // Balidazioa okerra bada

			// Produktuen taula erakutsi
			metodoak.taula(izena, zbk, prezioa, mota, irudiak, kont);

			break;

		case 2:
			balidazioak = true;
			break;
		}
		return balidazioak;
	}

	/**
	 * Produktu baten izena erabiliz, produktuaren indizea bilatzen du arrayan
	 * produktua ezabatzeko
	 * 
	 * @param produktu_izena Bilatu beharreko produktuaren izena.
	 * @param izena          Produktuaren izenak gordetzen dituen arraya.
	 * @return Produktuaren indizea arrayan, edo -1 produktua ez badago.
	 */
	public static int produktua_taulatik_ezabatu(String produktu_izena, String[] izena) {
		// Produktuaren izena arrayan bilatzen dugu
		for (int i = 0; i < izena.length; i++) {
			if (izena[i].equals(produktu_izena)) { // Izena aurkitu bada
				return i; // Indizea itzuli
			}
		}
		return -1; // Produktua ez badago, -1 itzultzen dugu
	}

	// =========================================================================================//

	/**
	 * Erosketaren laburpena erakusten du panel batean, produktu bakoitzaren izena,
	 * kantitatea, prezioa eta guztizko zenbatekoa barne. Hori guztia,
	 * erabiltzaileari produktuaren informazioa modu argian eta ikusgarrian
	 * aurkezteko.
	 * 
	 * @param panel_laburpena       Laburpena erakutsiko den JPanel.
	 * @param produktuakKontagailua Kantitateen arraya, non bakoitzak produktu
	 *                              bakoitzaren kantitatea gordetzen duen.
	 * @param irudiak               Produktuen irudiak gordetzen dituen arraya.
	 * @param izena                 Produktuen izenak gordetzen dituen arraya.
	 * @param prezioa               Produktuen unitateko prezioak gordetzen dituen
	 *                              arraya.
	 * @param ordaindu              Erabiltzaileak ordaindutako zenbatekoa.
	 * @param bez                   Produktuen BEZa (zergaren) zenbatekoa.
	 * @return Eguneratuta dagoen JPanel, laburpena erakusten duena.
	 */
	public static JPanel erakutsi_laburpena(JPanel panel_laburpena, int[] produktuakKontagailua, String[] irudiak,
			String[] izena, double[] prezioa, double ordaindu, double bez) {

		panel_laburpena.removeAll(); // Panelaren edukia guztiz garbitu, edukia freskatzeko
		int y = 0; // Hasierako Y posizioa, elementuen lehen posizioa ezartzeko
		int x = 0;

		// Produktuak kantitate bat baldin badu, panelan erakutsiko dira
		for (int i = 0; i < produktuakKontagailua.length; i++) {
			if (y == 840) {
				y = 0;
				x = x + 250;
			}
			if (produktuakKontagailua[i] > 0) { // Produktuak kantitate bat badu
				// Produktuaren irudia kargatu, eta irudia_balidatu metodoa erabiliz egiaztatu
				JLabel produktuaren_irudia = new JLabel(irudia_balidatu("/img/" + irudiak[i]));
				produktuaren_irudia.setBounds(x + 10, y, 100, 100); // Irudiaren kokapena panelan
				panel_laburpena.add(produktuaren_irudia); // Irudia panelari gehitu

				// Produktuaren izena, kantitatea eta prezioa erakutsi
				JLabel info_produktua = new JLabel(izena[i] + " x" + produktuakKontagailua[i] + " - "
						+ String.format("%.2f", prezioa[i] * produktuakKontagailua[i]) + "€");
				info_produktua.setBounds(x + 120, y + 30, 250, 30); // Testuaren kokapena panelan
				panel_laburpena.add(info_produktua); // Testua panelari gehitu

				y += 120; // Hurrengo produktua kokatzeko Y posizioa handitu
			}
		}

		// Erosketaren totalaren etiketaren sorrera eta kokapena panelan
		JLabel prezio_totala = new JLabel("Totala: " + String.format("%.2f", ordaindu) + "€");
		JLabel bez_gehituta = new JLabel("Beza gehituta: " + String.format("%.2f", bez) + "€");
		prezio_totala.setBounds(x + 25, y, 200, 30); // Totalaren kokapena panelan
		bez_gehituta.setBounds(x + 25, y + 15, 200, 30); // Totalaren kokapena panelan
		panel_laburpena.add(prezio_totala); // Totalaren etiketa panelari gehitu
		panel_laburpena.add(bez_gehituta); // Totalaren etiketa panelari gehitu

		panel_laburpena.revalidate(); // Layout berrikusi
		panel_laburpena.repaint(); // Panelaren marrazketa berriro egin eguneratutako edukiarekin
		panel_laburpena.setVisible(true); // Panelari ikusgai egin eguneratzean

		return panel_laburpena;
	}

	// =========================================================================================//

	/**
	 * Irudi bat kargatzen eta balidatzen duen metodoa. Irudia ez badago edo errore
	 * bat gertatzen bada, defektuzko irudi bat itzultzen du. Gainera, kargatutako
	 * irudiaren tamaina egokitzen du.
	 * 
	 * @param img Irudiaren fitxategiaren bidea.
	 * @return Irudi kargatu eta tamainarekin egokitua itzultzen du. Irudiaren
	 *         fitxategia ez badago edo errore bat gertatzen bada, defektuzko irudia
	 *         itzultzen da.
	 */
	public static ImageIcon irudia_balidatu(String img) {
		try {

			URL irudia = vending_makina.class.getResource(img);
			ImageIcon irudi_ikonoa;

			if (irudia != null) {
				irudi_ikonoa = new ImageIcon(irudia); // Irudia kargatu
			} else {
				// Irudi bat aurkitu ezin bada, defektuzko irudia erabiliko da
				URL defektuzko_irudia = vending_makina.class.getResource("/img/defektuz.jpg");
				if (defektuzko_irudia != null) {
					irudi_ikonoa = new ImageIcon(defektuzko_irudia); // Defektuzko irudia kargatu
				} else {
					return new ImageIcon(); // Defektuzko irudia ere ez bada aurkitzen, irudi huts bat itzultzen du
				}
			}

			// Irudiaren tamaina egokitzen da bistaratzea errazagoa izan dadin
			Image ikonoa = irudi_ikonoa.getImage();
			Image ikonoaren_tamaina = ikonoa.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
			return new ImageIcon(ikonoaren_tamaina); // Tamaina egokitua duen irudia itzultzen du
		} catch (Exception e) {
			return new ImageIcon(); // Akats bat gertatzen bada, irudi huts bat itzultzen du
		}
	}

}
