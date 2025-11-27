package admin_kontsola;

import java.util.Scanner;

/**
 * <code>admin_console</code> klasea, vending makina administratzeko kontsola
 * da. Erabiltzaileak login bidez sartu ahal izango dira eta hainbat
 * administrazio funtzio burutzeko aukera izango dute, hala nola produktuen
 * gehiketa, aldaketa eta ezabaketa.
 */
public class admin_console {

	/**
	 * Produktuen kopurua.
	 * <p>
	 * Hasierako balioa 12 da.
	 * </p>
	 */
	private static int kont = 12;

	/**
	 * 
	 * Metodo hau vending makina administratzailearen kontsola funtzioak kudeatzen
	 * ditu, erabiltzaileen autentifikazioa eta menuko aukeren selekzioa barne
	 * hartuz.
	 * 
	 * 
	 * @param izena   Produktuen izenak gordetzen dituen arraya
	 *                {@link metodoak.metodoak#get_izena(String[])}.
	 * @param zbk     Produktuen identifikazio zenbakiak gordetzen dituen arraya.
	 *                {@link metodoak.metodoak#get_zbk(String[])}.
	 * @param prezioa Produktuen prezioak gordetzen dituen arraya.
	 *                {@link metodoak.metodoak#get_prezioa(double[])}.
	 * @param mota    Produktuen motak gordetzen dituen arraya.
	 *                {@link metodoak.metodoak#get_mota(String[])}.
	 * @param irudiak Produktuei lotutako irudien izenak gordetzen dituen arraya.
	 *                {@link metodoak.metodoak#get_irudia(String[])}.
	 * 
	 */
	public static void vending_makina(String[] izena, String[] zbk, double[] prezioa, String[] mota, String[] irudiak) {

		izena = metodoak.metodoak.get_izena(izena);

		zbk = metodoak.metodoak.get_zbk(zbk);

		prezioa = metodoak.metodoak.get_prezioa(prezioa);

		mota = metodoak.metodoak.get_mota(mota);

		irudiak = metodoak.metodoak.get_irudia(irudiak);

		kont = metodoak.metodoak.get_kont(kont);

		Scanner sc = new Scanner(System.in);
		int aukera = 0; // Erabiltzaileak hautatutako aukera
		int atzera_aukera = 0;
		String user = ""; // Erabiltzailearen izena
		String password = ""; // Pasahitza
		String izena_p = ""; // Gehitu beharreko produktua
		String zbk_p = ""; // Produktuaren zenbakia
		String mota_p = ""; // Produktuaren mota
		String irudia_p = ""; // Produktuaren irudia
		String aukeratuzbk = "";
		String zbk_ezabatu = "";
		double prezioa_p = 0; // Produktuaren prezioa
		boolean balidazioak = false; // Balidazio egoera
		boolean badago = false; // Produktu bat dagoen ala ez
		// Erabiltzaile eta pasahitzen zerrenda
		String[] erabiltzaileak = { "admin", "julen", "karim", "ainara" };
		String[] pasahitzak = { "admin", "julen1", "karim1", "ainara1" };

		balidazioak = metodoak.metodoak.login(user, password, erabiltzaileak, pasahitzak, sc);

		if (balidazioak == false) {
			windowbuilder.vending_makina.main(null);
			return; // Programatik Irten balidazioa okerra bada
		}

		do {

			switch (metodoak.metodoak.hasierako_menu(aukera, balidazioak, sc)) {

			case 1:
				balidazioak = metodoak.metodoak.produktuagehitu(izena, zbk, prezioa, mota, irudiak, kont, atzera_aukera,
						balidazioak, izena_p, zbk_p, prezioa_p, mota_p, irudia_p, sc);
				if (kont < 20) {
					kont++;
				}
				break;
			case 2:

				balidazioak = metodoak.metodoak.produktuaaldatu(izena, zbk, prezioa, mota, irudiak, kont, atzera_aukera,
						balidazioak, izena_p, zbk_p, prezioa_p, mota_p, irudia_p, aukera, aukeratuzbk, sc);
				break;

			case 3:

				balidazioak = metodoak.metodoak.produktuaezabatu(izena, zbk, prezioa, mota, irudiak, kont,
						atzera_aukera, balidazioak, zbk_ezabatu, badago, sc);
				if (kont > 0) {
					kont--;
				}
				break;

			case 4:
				windowbuilder.vending_makina.main(null);
				return; // Programaren amaiera

			default:
				System.out.println("Sartu balio egoki bat");
				System.out.println();
				break;

			}

		} while (balidazioak == true); // Jarraitu nahi badu, bukle osoa errepikatuko da

		sc.close();
	}

}