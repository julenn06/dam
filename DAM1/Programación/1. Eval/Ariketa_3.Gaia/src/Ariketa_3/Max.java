package Ariketa_3;

public class Max {
	/**
	 * 
	 * @param zenbakia  integer zenbaki bat jasoko du zenbaki2 integer zenbakiarekin
	 *                  konparatzeko zein den handiagoa.
	 * @param zenbakia2 integer zenbaki bat jasoko du zenbakia integer zenbakiarekin
	 *                  konparatzeko zein den handiagoa.
	 * @return zenbakia2 zenbakia baino handiagoa bada, true itzuliko dit, bestela
	 *         false itzuliko dit.
	 */
	public static boolean handiagoaDa(int zenbakia, int zenbakia2) {
		boolean handia = false;

		if (zenbakia < zenbakia2) {
			handia = true;

		} else {
			handia = false;
		}

		return handia;
	}
}