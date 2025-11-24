package ariketaEnuntziatua;

abstract class Pertsona {

	protected int id;
	protected String izena;
	protected int adina;

	public Pertsona(int id, String izena, int adina) {
		super();
		this.id = id;
		this.izena = izena;
		this.adina = adina;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public int getAdina() {
		return adina;
	}

	public void setAdina(int adina) throws AdinBaliogabeaSalbuespena {
		if (adina < 18) {
			throw new AdinBaliogabeaSalbuespena("Adina ez da baliogarria: " + adina);
		}
		this.adina = adina;
	}

	abstract double kalkulatuSoldata();
}