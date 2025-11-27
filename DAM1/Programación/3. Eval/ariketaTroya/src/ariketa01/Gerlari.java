package ariketa01;

abstract class Gerlari {

	protected String izena;
	protected int adina;
	protected int indarra;
	protected boolean zauritua;
	protected boolean hilda;

	public Gerlari(String izena, int adina, int indarra) {
		if (!egiaztatuAdina(adina)) {
			this.adina = 25;
		} else {
			this.adina = adina;
		}

		if (!egiaztatuIndarra(indarra)) {
			this.indarra = 5;
		} else {
			this.indarra = indarra;
		}

		this.izena = izena;
		this.zauritua = false;
		this.hilda = false;
	}

	public static boolean egiaztatuAdina(int adina) {
		return adina >= 15 && adina <= 60;
	}

	public static boolean egiaztatuIndarra(int indarra) {
		return indarra >= 1 && indarra <= 10;
	}

	abstract boolean erretiratu();
}