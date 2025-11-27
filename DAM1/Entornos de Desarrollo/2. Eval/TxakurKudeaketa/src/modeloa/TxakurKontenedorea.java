package modeloa;

public class TxakurKontenedorea {
	private Txakurra[] txakurrak;
	private int kontagailua;

	// Eraikitzailea
	public TxakurKontenedorea(int edukiera) {
		txakurrak = new Txakurra[edukiera];
		kontagailua = 0;
	}

	// Sortu edo gehitu txakur berri bat
	public boolean gehituTxakurra(Txakurra txakurra) {
		if (kontagailua < txakurrak.length) {
			txakurrak[kontagailua++] = txakurra;
			return true;
		} else {
			System.out.println("Kontenedorea beteta dago.");
			return false;
		}
	}

	// Txakur guztiak zerrendatu
	public void zerrendatuTxakurrak() {
		for (int i = 0; i < kontagailua; i++) {
			System.out.println(txakurrak[i]);
		}
	}

	// Txakur bat bilatu izenaren arabera
	public Txakurra bilatuIzenez(String izena) {
		for (int i = 0; i < kontagailua; i++) {
			if (txakurrak[i].getIzena().equalsIgnoreCase(izena)) {
				return txakurrak[i];
			}
		}
		return null; // Ez da aurkitu
	}

	// Txakur baten informazioa eguneratu
	public boolean eguneratuTxakurra(String izena, int adinBerria, String arrazaBerria) {
		Txakurra txakurra = bilatuIzenez(izena);
		if (txakurra != null) {
			txakurra.setAdina(adinBerria);
			txakurra.setArraza(arrazaBerria);
			return true;
		}
		return false;
	}

	// Txakur bat ezabatu izenaren arabera
	public boolean ezabatuTxakurra(String izena) {
		for (int i = 0; i < kontagailua; i++) {
			if (txakurrak[i].getIzena().equalsIgnoreCase(izena)) {
				// Elementuak ezkerrera mugitzen dira
				for (int j = i; j < kontagailua - 1; j++) {
					txakurrak[j] = txakurrak[j + 1];
				}
				txakurrak[--kontagailua] = null; // Azken erreferentzia ezabatu
				return true;
			}
		}
		return false;
	}


}
