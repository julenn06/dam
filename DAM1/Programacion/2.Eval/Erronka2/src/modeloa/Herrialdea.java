package modeloa;

public class Herrialdea {
	private String kodea;
	private String herrialdea;

	public Herrialdea(String kodea, String herrialdea) {
		this.kodea = kodea;
		this.herrialdea = herrialdea;
	}

	public String getKodea() {
		return kodea;
	}

	public void setKodea(String kodea) {
		this.kodea = kodea;
	}

	public String getHerrialdea() {
		return herrialdea;
	}

	public void setHerrialdea(String herrialdea) {
		this.herrialdea = herrialdea;
	}

	@Override
	public String toString() {
		return "Herrialdea [kodea=" + kodea + ", herrialdea=" + herrialdea + "]";
	}

}