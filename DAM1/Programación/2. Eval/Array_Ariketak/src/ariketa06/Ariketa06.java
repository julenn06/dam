package ariketa06;

public class Ariketa06 {

	public static void main(String[] args) {
		int zenbat = 20;
		int zbk[] = new int[zenbat];

		Metodoak.arraySortu(zenbat, zbk);
		Metodoak.alderantzikatuArray(zbk);
		Metodoak.arrayInprimatu(zbk);
	}

}