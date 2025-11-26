package prueba1;

public class Funciones {

	// 1. Gehitu zenbaki bat zerrendara
	public boolean gehituZenbakia(int[] zenbakiak, int zenbakia, int kontagailua) {
		if (kontagailua < zenbakiak.length) {
			zenbakiak[kontagailua] = zenbakia;
			return true;
		}
		return false;
	}

	// 2. Bilatu zenbaki bat zerrendan
	public boolean bilatuZenbakia(int[] zenbakiak, int zenbakia, int kontagailua) {
		for (int i = 0; i < kontagailua; i++) {
			if (zenbakiak[i] == zenbakia) {
				return true;
			}
		}
		return false;
	}

	// 3. Eguneratu zerrendako zenbaki bat
	public boolean eguneratuZenbakia(int[] zenbakiak, int zaharra, int berria, int kontagailua) {
		for (int i = 0; i < kontagailua; i++) {
			if (zenbakiak[i] == zaharra) {
				zenbakiak[i] = berria;
				return true;
			}
		}
		return false;
	}

	// 4. Kendu zenbaki bat zerrendatik
	public boolean kenduZenbakia(int[] zenbakiak, int zenbakia, int kontagailua) {
		for (int i = 0; i < kontagailua; i++) {
			if (zenbakiak[i] == zenbakia) {
				for (int j = i; j < kontagailua - 1; j++) {
					zenbakiak[j] = zenbakiak[j + 1];
				}
				return true;
			}
		}
		return false;
	}

	// 5. Konprobatu zenbakia positiboa den
	public boolean zenbakiaPositiboaDa(int zenbakia) {
		return zenbakia > 0;
	}

	// 6. Lortu zenbakiaren bikoitza
	public int bikoiztuZenbakia(int zenbakia) {
		return zenbakia * 2;
	}

	// 7. Kalkulatu zenbaki baten eremua
	public int zenbakiarenEremua(int zenbakia) {
		if (zenbakia < 0)
			return -1;
		return zenbakia * zenbakia;
	}

	// 8. Zerrenda hutsik dagoen ala ez egiaztatu
	public boolean zerrendaHutsik(int kontagailua) {
		return kontagailua == 0;
	}

	// 9. Kalkulatu batez bestekoa
	public double batezBestekoa(int[] zenbakiak, int kontagailua) {
		if (kontagailua == 0)
			return 0;
		int batura = 0;
		for (int i = 0; i < kontagailua; i++) {
			batura += zenbakiak[i];
		}
		return (double) batura / kontagailua;
	}
	
	// 10.
	public boolean isAdult(int age) {
		if (age >= 18) {
			return true;
		}
		return false;
	}
	
	// 11.
	public int addIfPositive(int a, int b) {
		if (a > 0 && b > 0) {
			return a + b;
		}
		return 0;
	}

}