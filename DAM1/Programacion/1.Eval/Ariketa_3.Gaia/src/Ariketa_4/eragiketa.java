package Ariketa_4;

public class eragiketa {
	/**
	 * 
	 * @param zenbakia integer zenbaki bat jasoko du, zenbaki lehena den ala ez
	 *                 jakiteko, eta zeintzuk diren lehen zenbakiak sartu duzun
	 *                 zenbakiarekin konparatuz jakiteko.
	 * @return kontadorea hasiko da gehitzen sartu duzun zenbakiaren arabera zenbat
	 *         zenbakiekin zatutuz hondarra 0 den. hondarra 0 bada, true itzuliko
	 *         dit. Hondarra 1 edo gehiago bada, false itzuliko dit,
	 */

	public static boolean lehenaDa(int zenbakia) {
		boolean lehena = true;

		int i;
		int kont = 0;

		for (i = 2; i <= zenbakia / 2 + 1; i++) {
			if (zenbakia % i == 0) {
				kont++;
			}
		}

		if (kont == 0) {
			lehena = true;
		} else {
			lehena = false;
		}
		return lehena;
	}
}