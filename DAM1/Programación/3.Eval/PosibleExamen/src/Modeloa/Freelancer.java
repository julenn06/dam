package Modeloa;

public class Freelancer extends Pertsona {

	protected Double lanorduak;
	protected Double ordainsariaOrduko;

	public Freelancer(int id, String izena, int adina, Double lanorduak, Double ordainsariaOrduko) {
		super(id, izena, adina);
		this.lanorduak = lanorduak;
		this.ordainsariaOrduko = ordainsariaOrduko;
	}

	public Freelancer(String izena, int adina, Double lanorduak, Double ordainsariaOrduko) {
		super(izena, adina);
		this.lanorduak = lanorduak;
		this.ordainsariaOrduko = ordainsariaOrduko;
	}

	public Double getLanorduak() {
		return lanorduak;
	}

	public void setLanorduak(Double lanorduak) {
		this.lanorduak = lanorduak;
	}

	public Double getOrdainsariaOrduko() {
		return ordainsariaOrduko;
	}

	public void setOrdainsariaOrduko(Double ordainsariaOrduko) {
		this.ordainsariaOrduko = ordainsariaOrduko;
	}

	@Override
	double kalkulatuSoldata() {

		double soldataOsoa = 0;

		soldataOsoa = lanorduak * ordainsariaOrduko;

		return soldataOsoa;
	}

	@Override
	public String toString() {
		return "Freelancer [id=" + id + ", izena=" + izena + ", adina=" + adina + ", lanorduak=" + lanorduak
				+ ", ordainsariaOrduko=" + ordainsariaOrduko + ",  Soldata=" + kalkulatuSoldata() + "]";
	}

}
