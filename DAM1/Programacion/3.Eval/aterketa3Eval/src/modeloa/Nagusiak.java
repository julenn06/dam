package modeloa;

import java.sql.Date;

public class Nagusiak extends Langileak {

	private Date sartzeData;
	private String kategoria;
	private String departamentua;

	public Nagusiak(int id, String izena) {
		super(id, izena);
	}

	public Date getSartzeData() {
		return sartzeData;
	}

	public void setSartzeData(Date sartzeData) {
		this.sartzeData = sartzeData;
	}

	public String getKategoria() {
		return kategoria;
	}

	public void setKategoria(String kategoria) {
		this.kategoria = kategoria;
	}

	public String getDepartamentua() {
		return departamentua;
	}

	public void setDepartamentua(String departamentua) {
		this.departamentua = departamentua;
	}

	@Override
	public String toString() {
		return "Nagusiak [sartzeData=" + sartzeData + ", kategoria=" + kategoria + ", departamentua=" + departamentua
				+ ", id=" + id + ", izena=" + izena + "]";
	}

}
