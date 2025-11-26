package modelo;

public class LibZerrenda {

	private Liburua[] lzerrenda;
	private int sartuta;

	public LibZerrenda() {
		lzerrenda = new Liburua[3];
		sartuta = 0;
	}

	public void gehitu(Liburua lib) {
		if (!beteta()) {
			lzerrenda[sartuta] = lib;
			this.sartuta++;
		}
	}

	public boolean beteta() {
		boolean bete = false;
		if (this.sartuta == 3) {
			bete = true;
		}
		return bete;
	}

	public boolean ezabatu(String isbn) {
		int pos = this.bilatuisbn(isbn);
		boolean ezabatuta = false;
		if (pos < this.sartuta && pos >= 0) {
			this.lzerrenda[pos] = null;
			this.sartuta--;
			for (int i = pos; i < this.sartuta; i++) {
				lzerrenda[i] = lzerrenda[i + 1];
			}
			ezabatuta = true;
		}
		return ezabatuta;
	}

	public int bilatuisbn(String isbn) {
		int pos = 0;

		while (pos < this.sartuta && !lzerrenda[pos].getisbn().equals(isbn)) {
			pos++;
		}
		if (pos == this.sartuta)
			pos = -1;

		return pos;
	}

	public int bilatutit(String izenburua) {
		int pos = 0;

		while (pos < this.sartuta && !lzerrenda[pos].getizenburua().equals(izenburua)) {
			pos++;
		}
		if (pos == this.sartuta)
			pos = -1;

		return pos;
	}

	public Liburua eskuratu(int i) {
		Liburua per = null;
		if (i >= 0 && i < this.sartuta)
			per = lzerrenda[i];
		else
			System.out.println("Ez da aurkitu");
		return per;
	}

	public String lzerrendaEskuratu() {
		String texto = "";
		for (int i = 0; i < this.sartuta; i++) {
			texto += lzerrenda[i].toString();
		}
		return texto;
	}

}
