package ariketa02;

public class Objetuak {

	private String izena = "";
	private String abizena = "";
	private int adina = 0;
	private boolean ezkondua = true;
	private String NAN = "";

	public Objetuak(String izena, String abizena, int adina, boolean ezkondua, String NAN) {

		this.izena = izena;
		this.abizena = abizena;
		this.adina = adina;
		this.ezkondua = ezkondua;
		this.NAN = NAN;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}

	public void setAdina(int adina) {
		this.adina = adina;
	}

	public void setEzkondua(boolean ezkondua) {
		this.ezkondua = ezkondua;
	}

	public void setNAN(String NAN) {
		this.NAN = NAN;
	}

	// ============================================//

	public String getIzena() {
		return this.izena;
	}

	public String getAbizena() {
		return this.abizena;
	}

	public int getAdina() {
		return this.adina;
	}

	public boolean getEzkondua() {
		return this.ezkondua;
	}

	public String getNAN() {
		return this.NAN;
	}

}