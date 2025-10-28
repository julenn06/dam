package ariketa01;

public class Objetua {

	private String probintzia = "";
	private String matrikula = "";
	private String udalerria = "";
	private int motorra = 0;

	public Objetua(String prob, String matr, String udal, int motor) {

		this.probintzia = prob;
		this.matrikula = matr;
		this.udalerria = udal;
		this.motorra = motor;
	}

	public void setProbintzia(String probintzia) {
		this.probintzia = probintzia;
	}

	public void setMatrikula(String matrikula) {
		this.matrikula = matrikula;
	}

	public void setUdalerria(String udalerria) {
		this.udalerria = udalerria;
	}

	public void setMotorra(int motorra) {
		this.motorra = motorra;
	}

//==========================================================//

	public String getProbintzia() {
		return this.probintzia;
	}

	public String getMatrikula() {
		return this.matrikula;
	}

	public String getUdalerria() {
		return this.udalerria;
	}

	public int getMotorra() {
		return this.motorra;
	}

}
