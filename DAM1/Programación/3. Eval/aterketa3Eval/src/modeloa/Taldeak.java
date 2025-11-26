package modeloa;

public class Taldeak extends Langileak {

	private String helbidea;

	public Taldeak(int id, String izena) {
		super(id, izena);
	}

	public String getHelbidea() {
		return helbidea;
	}

	public void setHelbidea(String helbidea) {
		this.helbidea = helbidea;
	}

	@Override
	public String toString() {
		return "Taldeak [helbidea=" + helbidea + ", id=" + id + ", izena=" + izena + "]";
	}

}