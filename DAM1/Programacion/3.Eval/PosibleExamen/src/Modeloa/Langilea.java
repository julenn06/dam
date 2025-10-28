package Modeloa;

public class Langilea extends Pertsona {

	protected String kargua;
	protected double oinarrizkoSoldata;
	protected int antzinatasuna;

	public Langilea(int id, String izena, int adina, String kargua, double oinarrizkoSoldata, int antzinatasuna) {
		super(id, izena, adina);
		this.kargua = kargua;
		this.oinarrizkoSoldata = oinarrizkoSoldata;
		this.antzinatasuna = antzinatasuna;
	}

	public Langilea(String izena, int adina, String kargua, double oinarrizkoSoldata, int antzinatasuna) {
		super(izena, adina);
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

	@Override
	double kalkulatuSoldata() {

		double soldataOsoa = 0;

		soldataOsoa = this.oinarrizkoSoldata + (this.antzinatasuna * 1000);

		return soldataOsoa;
	}

	@Override
	public String toString() {
		return "Langilea [id=" + id + ", izena=" + izena + ", adina=" + adina + ", kargua=" + kargua
				+ ", oinarrizkoSoldata=" + oinarrizkoSoldata + ", antzinatasuna=" + antzinatasuna + ", Soldata="
				+ kalkulatuSoldata() + "]";
	}

}
