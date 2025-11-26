package ariketa01;

class Greziar extends Gerlari {
	public Greziar(String izena, int adina, int indarra) {
		super(izena, adina, indarra);
	}

	public Greziar() {
		super("GreziarX", 20, 8);
	}

	@Override
	boolean erretiratu() {
		System.out.println("Greziarra: " + izena);
		System.out.println("Adina: " + adina);
		System.out.println("Indarra: " + indarra);

		if (hilda) {
			System.out.println("Hilda dago");
			return true;
		}

		if (zauritua) {
			System.out.println("Zauritua: " + zauritua + ". RETIRADA");
			return true;
		} else {
			System.out.println("Zauritua: " + zauritua + ". Ezin da erretiratu");
			return false;
		}
	}
}