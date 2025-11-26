package ariketaEnuntziatua;

class FreeLancer extends Pertsona {

	private int lanorduak = 0;
	private double ordainSariaOrduko = 0;

	public FreeLancer(int id, String izena, int adina, int lanorduak, double ordainSariaOrduko) {
		super(id, izena, adina);
		this.lanorduak = lanorduak;
		this.ordainSariaOrduko = ordainSariaOrduko;
	}

	public int getLanorduak() {
		return lanorduak;
	}

	public void setLanorduak(int lanorduak) {
		this.lanorduak = lanorduak;
	}

	public double getOrdainSariaOrduko() {
		return ordainSariaOrduko;
	}

	public void setOrdainSariaOrduko(double ordainSariaOrduko) {
		this.ordainSariaOrduko = ordainSariaOrduko;
	}

	@Override
	double kalkulatuSoldata() {
		double soldata = lanorduak * ordainSariaOrduko;
		return soldata;
	}
}
