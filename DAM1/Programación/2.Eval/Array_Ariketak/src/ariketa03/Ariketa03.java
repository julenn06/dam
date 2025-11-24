package ariketa03;

public class Ariketa03 {

	public static void main(String[] args) {

		int zbk = 20;

		int[] array = new int[zbk];
		int baliomin = 0;
		int baliomax = 0;

		array = Metodoak.arrayzenbakiak(zbk, array);

		Metodoak.taulaKargatu(array, baliomin, baliomax);

		Metodoak.maiztasunaErakutsi(array);

		Metodoak.arrayInprimatu(array);

	}

}
