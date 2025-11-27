package modelo;

public class Liburua {

	private String izenburua;
	private String isbn;
	private String idazlea;

	public Liburua() {

		this.izenburua = "behin behinekoa";
		this.isbn = "XXXX";

	}

	public Liburua(String izenburua, String isbn, String idazlea) {

		this.izenburua = izenburua;
		this.isbn = isbn;
		this.idazlea = idazlea;
	}

	public String getizenburua() {
		return izenburua;
	}

	public void setizenburua(String izenburua) {
		this.izenburua = izenburua;
	}

	public String getisbn() {
		return isbn;
	}

	public void setisbn(String isbn) {
		this.isbn = isbn;
	}

	public String getidazlea() {
		return idazlea;
	}

	public void setidazlea(String idazlea) {
		this.idazlea = idazlea;
	}

	@Override
	public String toString() {
		return "Liburua [izenburua=" + izenburua + ", isbn=" + isbn + ", idazlea=" + idazlea + "]";
	}

}
