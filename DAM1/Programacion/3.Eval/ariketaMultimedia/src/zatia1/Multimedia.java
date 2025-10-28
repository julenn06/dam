package zatia1;

public class Multimedia {
	private String titulua;
	private String egilea;
	private String formatua;
	private double iraupena;

	private static final String[] FORMATUAK = { "wav", "mp3", "midi", "avi", "mov", "mkv", "bluray", "cdAudio", "dvd" };

	public Multimedia(String titulua, String egilea, String formatua, double iraupena) {
		this.titulua = titulua;
		this.egilea = egilea;
		this.iraupena = iraupena;

		boolean baliozkoFormatua = false;
		for (String f : FORMATUAK) {
			if (f.equalsIgnoreCase(formatua)) {
				baliozkoFormatua = true;
				break;
			}
		}
		this.formatua = baliozkoFormatua ? formatua : "ezezaguna";
	}

	public String getTitulua() {
		return titulua;
	}

	public String getEgilea() {
		return egilea;
	}

	public String getFormatua() {
		return formatua;
	}

	public double getIraupena() {
		return iraupena;
	}

	@Override
	public String toString() {
		return "Titulua: " + titulua + ", Egilea: " + egilea + ", Formatua: " + formatua + ", Iraupena: " + iraupena
				+ " min";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Multimedia) {
			Multimedia m = (Multimedia) obj;
			return this.titulua.equalsIgnoreCase(m.titulua) && this.egilea.equalsIgnoreCase(m.egilea);
		}
		return false;
	}
}