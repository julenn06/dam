package ariketa01;

class Troiar extends Gerlari {
	public Troiar(String izena, int adina, int indarra) {
		super(izena, adina, indarra);
	}

	public Troiar() {
		super("TroiarX", 18, 10);
	}

	@Override
	boolean erretiratu() {
		System.out.println("Troiarra: " + izena);
		System.out.println("Adina: " + adina);
		System.out.println("Indarra: " + indarra);

		if (hilda) {
			System.out.println("Hilda dago");
			return true;
		}

		if (zauritua) {
			System.out.println("Zauritua dago. Troiarrak ezin dira erretiratu.");
			return false;
		}

		System.out.println("Troiarrak ezin dira erretiratu.");
		return false;
	}
}