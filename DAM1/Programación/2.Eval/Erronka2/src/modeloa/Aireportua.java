package modeloa;

public class Aireportua {

	private String identifikatzailea;
	private String izena;

	public Aireportua(String identifikatzailea, String izena) {
		this.identifikatzailea = identifikatzailea;
		this.izena = izena;
	}

	public String getIdentifikatzailea() {
		return identifikatzailea;
	}

	public void setIdentifikatzailea(String identifikatzailea) {
		this.identifikatzailea = identifikatzailea;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	@Override
	public String toString() {
		return "Aireportua [identifikatzailea=" + identifikatzailea + ", izena=" + izena + "]";
	}

}
