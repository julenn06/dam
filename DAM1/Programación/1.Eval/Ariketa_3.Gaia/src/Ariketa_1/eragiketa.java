package Ariketa_1;

public class eragiketa {
	/**
	 * 
	 * @param zenbakia integer zenbaki bat jasoko du bakoiti ala bikoiti den
	 *                 jakiteko.
	 * @return zenbakia bakoitia bada, true itzuliko du, eta bikoitia bada false
	 *         itzuliko du.
	 */

	public static boolean bikoitiaDa(int zenbakia) {
		boolean bikoiti = false;
		if (zenbakia % 2 == 0) {
			bikoiti = true;
		} else {
			bikoiti = false;
		}

		return bikoiti;
	}
}