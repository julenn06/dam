package modeloa;

public class Zerbitzua {

	private int ostatuKodea;
	private int besteKodea;
	private int IDJoanEtorri;
	private double prezioaOstatua;
	private String sarreraEguna;
	private String irteeraEguna;
	private String logelaMota;
	private String izenaOstatua;
	private int hegaldia;
	private String besteZerbitzuak;
	private double prezioaBesteZerbitzuak;
	private String jatorrizkoAireportua;
	private String helmugakoAireportua;
	private String hegaldiKodea;
	private String aeroLinea;
	private double prezioaHegaldia;
	private String irteeraData;
	private String irteeraOrdutegia;
	private int bidaiarenIraupena;
	private String itzuleraData;
	private String itzuleraOrdua;
	private int bidaiarenIraupenaBuelta;
	private String hegaldiKodeaBuelta;
	private String aeroLineaBuelta;
	private String dataBesteZerbitzua;
	private String deskribapenaBesteZerbitzua;
	private String ostatuaHiria;
	private String bueltaData;
	private String bueltaOrdutegia;

	// Constructor de Ostatua Kodearekin
	public Zerbitzua(int ostatuKodea, double prezioaOstatua, String sarreraEguna, String irteeraEguna,
			String logelaMota, String izenaOstatua) {
		this.ostatuKodea = ostatuKodea;
		this.prezioaOstatua = prezioaOstatua;
		this.sarreraEguna = sarreraEguna;
		this.irteeraEguna = irteeraEguna;
		this.logelaMota = logelaMota;
		this.izenaOstatua = izenaOstatua;
	}

	// Constructor de Ostatua kode gabe
	public Zerbitzua(double prezioaOstatua, String ostatuaHiria, String sarreraEguna, String irteeraEguna,
			String logelaMota, String izenaOstatua, int bidaiaOs) {

		this.prezioaOstatua = prezioaOstatua;
		this.ostatuaHiria = ostatuaHiria;
		this.sarreraEguna = sarreraEguna;
		this.irteeraEguna = irteeraEguna;
		this.logelaMota = logelaMota;
		this.izenaOstatua = izenaOstatua;
	}

	// Constructor Beste Zerbitzuak kodearekin
	public Zerbitzua(int besteKodea, String besteZerbitzuak, double prezioaBesteZerbitzuak, String dataBesteZerbitzua,
			String deskribapenaBesteZerbitzua) {
		this.besteKodea = besteKodea;
		this.besteZerbitzuak = besteZerbitzuak;
		this.prezioaBesteZerbitzuak = prezioaBesteZerbitzuak;
		this.dataBesteZerbitzua = dataBesteZerbitzua;
		this.deskribapenaBesteZerbitzua = deskribapenaBesteZerbitzua;
	}

	// Constructor Beste Zerbitzuak kode gabe
	public Zerbitzua(String besteZerbitzuak, double prezioaBesteZerbitzuak, String dataBesteZerbitzua,
			String deskribapenaBesteZerbitzua, int bidaiaBe) {

		this.besteZerbitzuak = besteZerbitzuak;
		this.prezioaBesteZerbitzuak = prezioaBesteZerbitzuak;
		this.dataBesteZerbitzua = dataBesteZerbitzua;
		this.deskribapenaBesteZerbitzua = deskribapenaBesteZerbitzua;
	}

	// Constructor Hegaldia
	public Zerbitzua(int hegaldia, String jatorrizkoAireportua, String helmugakoAireportua, String hegaldiKodea,
			String aeroLinea, double prezioaHegaldia, String irteeraData, String irteeraOrdutegia,
			int bidaiarenIraupena) {
		this.hegaldia = hegaldia;
		this.jatorrizkoAireportua = jatorrizkoAireportua;
		this.helmugakoAireportua = helmugakoAireportua;
		this.hegaldiKodea = hegaldiKodea;
		this.aeroLinea = aeroLinea;
		this.prezioaHegaldia = prezioaHegaldia;
		this.irteeraData = irteeraData;
		this.irteeraOrdutegia = irteeraOrdutegia;
		this.bidaiarenIraupena = bidaiarenIraupena;

	}

	// Constructor Hegaldia kode gabe
	public Zerbitzua(String jatorrizkoAireportua, String helmugakoAireportua, String hegaldiKodea, String aeroLinea,
			double prezioaHegaldia, String irteeraData, String irteeraOrdutegia, int bidaiarenIraupena, int IDBidaia) {

		this.jatorrizkoAireportua = jatorrizkoAireportua;
		this.helmugakoAireportua = helmugakoAireportua;
		this.hegaldiKodea = hegaldiKodea;
		this.aeroLinea = aeroLinea;
		this.prezioaHegaldia = prezioaHegaldia;
		this.irteeraData = irteeraData;
		this.irteeraOrdutegia = irteeraOrdutegia;
		this.bidaiarenIraupena = bidaiarenIraupena;

	}

	// Constructor Joanetorri
	public Zerbitzua(int IDJoanEtorri, String jatorrizkoAireportua, String helmugakoAireportua, String itzuleraData,
			String itzuleraOrdutegia, int bidaiarenIraupenaBuelta, String hegaldiKodeaBuelta, String aeroLineaBuelta) {
		this.IDJoanEtorri = IDJoanEtorri;
		this.jatorrizkoAireportua = jatorrizkoAireportua;
		this.helmugakoAireportua = helmugakoAireportua;
		this.bueltaData = itzuleraData;
		this.bueltaOrdutegia = itzuleraOrdutegia;
		this.bidaiarenIraupenaBuelta = bidaiarenIraupenaBuelta;
		this.hegaldiKodeaBuelta = hegaldiKodeaBuelta;
		this.aeroLineaBuelta = aeroLineaBuelta;
	}

	public Zerbitzua(int ostatuKodea, int besteKodea, int iDJoanEtorri, double prezioaOstatua, String sarreraEguna,
			String irteeraEguna, String logelaMota, String izenaOstatua, int hegaldia, String besteZerbitzuak,
			double prezioaBesteZerbitzuak, String jatorrizkoAireportua, String helmugakoAireportua, String hegaldiKodea,
			String aeroLinea, double prezioaHegaldia, String irteeraData, String irteeraOrdutegia,
			int bidaiarenIraupena, String itzuleraData, String itzuleraOrdua, int bidaiarenIraupenaBuelta,
			String hegaldiKodeaBuelta, String aeroLineaBuelta, String dataBesteZerbitzua) {
		this.ostatuKodea = ostatuKodea;
		this.besteKodea = besteKodea;
		IDJoanEtorri = iDJoanEtorri;
		this.prezioaOstatua = prezioaOstatua;
		this.sarreraEguna = sarreraEguna;
		this.irteeraEguna = irteeraEguna;
		this.logelaMota = logelaMota;
		this.izenaOstatua = izenaOstatua;
		this.hegaldia = hegaldia;
		this.besteZerbitzuak = besteZerbitzuak;
		this.prezioaBesteZerbitzuak = prezioaBesteZerbitzuak;
		this.jatorrizkoAireportua = jatorrizkoAireportua;
		this.helmugakoAireportua = helmugakoAireportua;
		this.hegaldiKodea = hegaldiKodea;
		this.aeroLinea = aeroLinea;
		this.prezioaHegaldia = prezioaHegaldia;
		this.irteeraData = irteeraData;
		this.irteeraOrdutegia = irteeraOrdutegia;
		this.bidaiarenIraupena = bidaiarenIraupena;
		this.itzuleraData = itzuleraData;
		this.itzuleraOrdua = itzuleraOrdua;
		this.bidaiarenIraupenaBuelta = bidaiarenIraupenaBuelta;
		this.hegaldiKodeaBuelta = hegaldiKodeaBuelta;
		this.aeroLineaBuelta = aeroLineaBuelta;
		this.dataBesteZerbitzua = dataBesteZerbitzua;
	}

	public Zerbitzua(String izenaOstatua, String hiria, int prezioOstatua, String sarreraEguna, String irteeraEguna,
			String kodLogelaMota, int bidaiaOs) {
		this.izenaOstatua = izenaOstatua;
		this.ostatuaHiria = hiria;
		this.prezioaOstatua = prezioOstatua;
		this.sarreraEguna = sarreraEguna;
		this.irteeraEguna = irteeraEguna;
		this.logelaMota = kodLogelaMota;
		this.ostatuKodea = bidaiaOs;
	}

	public int getOstatuKodea() {
		return ostatuKodea;
	}

	public String getBueltaData() {
		return bueltaData;
	}

	public void setBueltaData(String bueltaData) {
		this.bueltaData = bueltaData;
	}

	public String getBueltaOrdutegia() {
		return bueltaOrdutegia;
	}

	public void setBueltaOrdutegia(String bueltaOrdutegia) {
		this.bueltaOrdutegia = bueltaOrdutegia;
	}

	public String getOstatuaHiria() {
		return ostatuaHiria;
	}

	public void setOstatuaHiria(String ostatuaHiria) {
		this.ostatuaHiria = ostatuaHiria;
	}

	public void setOstatuKodea(int ostatuKodea) {
		this.ostatuKodea = ostatuKodea;
	}

	public String getDeskribapenaBesteZerbitzua() {
		return deskribapenaBesteZerbitzua;
	}

	public void setDeskribapenaBesteZerbitzua(String deskribapenaBesteZerbitzua) {
		this.deskribapenaBesteZerbitzua = deskribapenaBesteZerbitzua;
	}

	public int getBesteKodea() {
		return besteKodea;
	}

	public void setBesteKodea(int besteKodea) {
		this.besteKodea = besteKodea;
	}

	public int getIDJoanEtorri() {
		return IDJoanEtorri;
	}

	public void setIDJoanEtorri(int iDJoanEtorri) {
		IDJoanEtorri = iDJoanEtorri;
	}

	public double getPrezioaOstatua() {
		return prezioaOstatua;
	}

	public void setPrezioaOstatua(double prezioaOstatua) {
		this.prezioaOstatua = prezioaOstatua;
	}

	public String getSarreraEguna() {
		return sarreraEguna;
	}

	public void setSarreraEguna(String sarreraEguna) {
		this.sarreraEguna = sarreraEguna;
	}

	public String getIrteeraEguna() {
		return irteeraEguna;
	}

	public void setIrteeraEguna(String irteeraEguna) {
		this.irteeraEguna = irteeraEguna;
	}

	public String getLogelaMota() {
		return logelaMota;
	}

	public void setLogelaMota(String logelaMota) {
		this.logelaMota = logelaMota;
	}

	public String getIzenaOstatua() {
		return izenaOstatua;
	}

	public void setIzenaOstatua(String izenaOstatua) {
		this.izenaOstatua = izenaOstatua;
	}

	public int getHegaldia() {
		return hegaldia;
	}

	public void setHegaldia(int hegaldia) {
		this.hegaldia = hegaldia;
	}

	public String getBesteZerbitzuak() {
		return besteZerbitzuak;
	}

	public void setBesteZerbitzuak(String besteZerbitzuak) {
		this.besteZerbitzuak = besteZerbitzuak;
	}

	public double getPrezioaBesteZerbitzuak() {
		return prezioaBesteZerbitzuak;
	}

	public void setPrezioaBesteZerbitzuak(double prezioaBesteZerbitzuak) {
		this.prezioaBesteZerbitzuak = prezioaBesteZerbitzuak;
	}

	public String getJatorrizkoAireportua() {
		return jatorrizkoAireportua;
	}

	public void setJatorrizkoAireportua(String jatorrizkoAireportua) {
		this.jatorrizkoAireportua = jatorrizkoAireportua;
	}

	public String getHelmugakoAireportua() {
		return helmugakoAireportua;
	}

	public void setHelmugakoAireportua(String helmugakoAireportua) {
		this.helmugakoAireportua = helmugakoAireportua;
	}

	public String getHegaldiKodea() {
		return hegaldiKodea;
	}

	public void setHegaldiKodea(String hegaldiKodea) {
		this.hegaldiKodea = hegaldiKodea;
	}

	public String getAeroLinea() {
		return aeroLinea;
	}

	public void setAeroLinea(String aeroLinea) {
		this.aeroLinea = aeroLinea;
	}

	public double getPrezioaHegaldia() {
		return prezioaHegaldia;
	}

	public void setPrezioaHegaldia(double prezioaHegaldia) {
		this.prezioaHegaldia = prezioaHegaldia;
	}

	public String getIrteeraData() {
		return irteeraData;
	}

	public void setIrteeraData(String irteeraData) {
		this.irteeraData = irteeraData;
	}

	public String getIrteeraOrdutegia() {
		return irteeraOrdutegia;
	}

	public void setIrteeraOrdutegia(String irteeraOrdutegia) {
		this.irteeraOrdutegia = irteeraOrdutegia;
	}

	public int getBidaiarenIraupena() {
		return bidaiarenIraupena;
	}

	public void setBidaiarenIraupena(int bidaiarenIraupena) {
		this.bidaiarenIraupena = bidaiarenIraupena;
	}

	public String getItzuleraData() {
		return itzuleraData;
	}

	public void setItzuleraData(String itzuleraData) {
		this.itzuleraData = itzuleraData;
	}

	public String getItzuleraOrdua() {
		return itzuleraOrdua;
	}

	public void setItzuleraOrdua(String itzuleraOrdua) {
		this.itzuleraOrdua = itzuleraOrdua;
	}

	public int getBidaiarenIraupenaBuelta() {
		return bidaiarenIraupenaBuelta;
	}

	public void setBidaiarenIraupenaBuelta(int bidaiarenIraupenaBuelta) {
		this.bidaiarenIraupenaBuelta = bidaiarenIraupenaBuelta;
	}

	public String getHegaldiKodeaBuelta() {
		return hegaldiKodeaBuelta;
	}

	public void setHegaldiKodeaBuelta(String hegaldiKodeaBuelta) {
		this.hegaldiKodeaBuelta = hegaldiKodeaBuelta;
	}

	public String getAeroLineaBuelta() {
		return aeroLineaBuelta;
	}

	public void setAeroLineaBuelta(String aeroLineaBuelta) {
		this.aeroLineaBuelta = aeroLineaBuelta;
	}

	public String getDataBesteZerbitzua() {
		return dataBesteZerbitzua;
	}

	public void setDataBesteZerbitzua(String dataBesteZerbitzua) {
		this.dataBesteZerbitzua = dataBesteZerbitzua;
	}

	@Override
	public String toString() {
		return "Zerbitzua [ostatuKodea=" + ostatuKodea + ", besteKodea=" + besteKodea + ", IDJoanEtorri=" + IDJoanEtorri
				+ ", prezioaOstatua=" + prezioaOstatua + ", sarreraEguna=" + sarreraEguna + ", irteeraEguna="
				+ irteeraEguna + ", logelaMota=" + logelaMota + ", izenaOstatua=" + izenaOstatua + ", hegaldia="
				+ hegaldia + ", besteZerbitzuak=" + besteZerbitzuak + ", prezioaBesteZerbitzuak="
				+ prezioaBesteZerbitzuak + ", jatorrizkoAireportua=" + jatorrizkoAireportua + ", helmugakoAireportua="
				+ helmugakoAireportua + ", hegaldiKodea=" + hegaldiKodea + ", aeroLinea=" + aeroLinea
				+ ", prezioaHegaldia=" + prezioaHegaldia + ", irteeraData=" + irteeraData + ", irteeraOrdutegia="
				+ irteeraOrdutegia + ", bidaiarenIraupena=" + bidaiarenIraupena + ", itzuleraData=" + itzuleraData
				+ ", itzuleraOrdua=" + itzuleraOrdua + ", bidaiarenIraupenaBuelta=" + bidaiarenIraupenaBuelta
				+ ", hegaldiKodeaBuelta=" + hegaldiKodeaBuelta + ", aeroLineaBuelta=" + aeroLineaBuelta
				+ ", dataBesteZerbitzua=" + dataBesteZerbitzua + "]";
	}

}