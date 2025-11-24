package ariketa;

abstract class Pertsonak {

	protected String nan;
	protected String izena;
	protected int urtebetetzeEguna;
	protected int urtebetetzeHilabetea;

	public Pertsonak(String nan, String izena, int urtebetetzeEguna, int urtebetetzeHilabetea) {
		this.nan = nan;
		this.izena = izena;
		this.urtebetetzeEguna = urtebetetzeEguna;
		this.urtebetetzeHilabetea = urtebetetzeHilabetea;
	}

	public abstract void erakutsi();

	public String getNan() {
		return nan;
	}

	public void setNan(String nan) {
		this.nan = nan;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public int getUrtebetetzeEguna() {
		return urtebetetzeEguna;
	}

	public void setUrtebetetzeEguna(int urtebetetzeEguna) {
		this.urtebetetzeEguna = urtebetetzeEguna;
	}

	public int getUrtebetetzeHilabetea() {
		return urtebetetzeHilabetea;
	}

	public void setUrtebetetzeHilabetea(int urtebetetzeHilabetea) {
		this.urtebetetzeHilabetea = urtebetetzeHilabetea;
	}
}