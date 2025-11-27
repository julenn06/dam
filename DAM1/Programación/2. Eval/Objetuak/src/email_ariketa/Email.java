package email_ariketa;

public class Email {
	private String norentzat;
	private String gaia;
	private String gorputza;
	private boolean irakurria;

	public Email(String norentzat, String gaia, String gorputza, boolean irakurria) {
		this.norentzat = norentzat;
		this.gaia = gaia;
		this.gorputza = gorputza;
		this.irakurria = irakurria;
	}

	public String getNorentzat() {
		return norentzat;
	}

	public void setNorentzat(String norentzat) {
		this.norentzat = norentzat;
	}

	public String getGaia() {
		return gaia;
	}

	public void setGaia(String gaia) {
		this.gaia = gaia;
	}

	public String getGorputza() {
		return gorputza;
	}

	public void setGorputza(String gorputza) {
		this.gorputza = gorputza;
	}

	public boolean getIrakurria() {
		return irakurria;
	}

	public void setIrakurria(boolean irakurria) {
		this.irakurria = irakurria;
	}
}