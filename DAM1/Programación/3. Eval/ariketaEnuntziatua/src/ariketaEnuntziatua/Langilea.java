package ariketaEnuntziatua;

class Langilea extends Pertsona {

	private String kargua = "";
	private double oinarrizkoSoldata = 0;
	private int antzinatasuna = 0;

	public Langilea(int id, String izena, int adina, String kargua, double oinarrizkoSoldata, int antzinatasuna) {
		super(id, izena, adina);
		this.kargua = kargua;
		this.oinarrizkoSoldata = oinarrizkoSoldata;
		this.antzinatasuna = antzinatasuna;
	}

	public String getKargua() {
		return kargua;
	}

	public void setKargua(String kargua) {
		this.kargua = kargua;
	}

	public double getOinarrizkoSoldata() {
		return oinarrizkoSoldata;
	}

	public void setOinarrizkoSoldata(double oinarrizkoSoldata) {
		this.oinarrizkoSoldata = oinarrizkoSoldata;
	}

	public int getAntzinatasuna() {
		return antzinatasuna;
	}

	public void setAntzinatasuna(int antzinatasuna) {
		this.antzinatasuna = antzinatasuna;
	}

	double soldata(double i, int a) {
		double soldata = i + (a * 1000);
		return soldata;
	}

	@Override
	double kalkulatuSoldata() {
		double soldata = oinarrizkoSoldata + (antzinatasuna * 1000);
		return soldata;
	}
}