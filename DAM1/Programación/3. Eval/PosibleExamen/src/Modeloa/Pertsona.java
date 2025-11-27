package Modeloa;

public abstract class Pertsona {

	protected int id;
	protected String izena;
	protected int adina;

	public Pertsona(int id, String izena, int adina) {

		this.id = id;
		this.izena = izena;
		this.adina = adina;
	}

	public Pertsona(String izena, int adina) {
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

	public void setAdina(int adina) {
		this.adina = adina;
	}

	@Override
	public String toString() {
		return "Pertsona [id=" + id + ", izena=" + izena + ", adina=" + adina + "]";
	}

	abstract double kalkulatuSoldata();

}
