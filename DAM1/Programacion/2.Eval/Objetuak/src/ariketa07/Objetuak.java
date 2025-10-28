package ariketa07;

public class Objetuak {

	private String izena = "";
	private String sexua = "E";
	private int adina = 0;
	private double altuera = 0;
	private double pisua = 0;

	public Objetuak() {

	}

	public Objetuak(String izena, int adina, String sexua) {
		this.izena = izena;
		this.adina = adina;
		this.sexua = sexua;
	}

	public Objetuak(String izena, String sexua, int adina, double altuera, double pisua) {
		this.izena = izena;
		this.adina = adina;
		this.sexua = sexua;
		this.pisua = pisua;
		this.altuera = altuera;
		sexuaBalidatu(sexua);
	}

	public void setIzena(String izena) {
		this.izena = izena;
		sexuaBalidatu(sexua);
	}

	public void setAdina(int adina) {
		this.adina = adina;
	}

	public void setSexua(String sexua) {
		this.sexua = sexua.equals("E") || sexua.equals("G") ? sexua : "E";
	}

	public void setPisua(double pisua) {
		this.pisua = pisua;
	}

	public void setAltuera(double altuera) {
		this.altuera = altuera;
	}

	public int kalkulatuIMC() {
		double imc = pisua / (altuera * altuera);
		if (imc < 20)
			return -1;
		if (imc >= 20 && imc <= 25)
			return 0;
		return 1;
	}

	public void IMCEmaitza() {
		int resultado = kalkulatuIMC();
		if (resultado == -1) {
			System.out.println(izena + " pisu idealaren azpitik dago");
		} else if (resultado == 0) {
			System.out.println(izena + " pisu ideala du");
		} else {
			System.out.println(izena + " pisu gehiegi du");
		}
	}

	public boolean adinezNagusikoaDa() {
		return adina >= 18;
	}

	@Override
	public String toString() {
		return "Izena: " + izena + "\n" + "Adina: " + adina + "\n" + "Sexua: " + sexua + "\n" + "Pisua: " + pisua
				+ " kg\n" + "Altuera: " + altuera + " m\n";
	}

	private void sexuaBalidatu(String sexua) {
		if (!sexua.equals("G") && !sexua.equals("E") || !sexua.equals("g") && !sexua.equals("e")) {
			sexua = "E";
		}
	}

	public String getIzena() {
		return izena;
	}

	public int getAdina() {
		return adina;
	}

	public String getSexua() {
		return sexua;
	}

	public double getPisua() {
		return pisua;
	}

	public double getAltuera() {
		return altuera;
	}
}
