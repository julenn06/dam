package ariketa07;

public class Ariketa07 {

	public static void main(String[] args) {

		int zenbat = 20;
		int zbkmax = 10;
		int zbk[] = new int[zenbat];

		Metodoak.taulaKargatu(zenbat, zbk, zbkmax);
		Metodoak.zeroakMugitu(zenbat, zbk);
		Metodoak.arrayInprimatu(zenbat, zbk);
	}

}