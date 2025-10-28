package zatia1;

class Filma extends Multimedia {
	private String aktoreGizona;
	private String aktoreEmakumea;

	public Filma(String titulua, String egilea, String formatua, double iraupena, String aktoreGizona,
			String aktoreEmakumea) {
		super(titulua, egilea, formatua, iraupena);
		this.aktoreGizona = aktoreGizona;
		this.aktoreEmakumea = aktoreEmakumea;
	}

	public String getAktoreGizona() {
		return aktoreGizona;
	}

	public String getAktoreEmakumea() {
		return aktoreEmakumea;
	}

	@Override
	public String toString() {
		return super.toString() + ", Aktore nagusia (gizona): " + (aktoreGizona != null ? aktoreGizona : "Ezezaguna")
				+ ", Aktore nagusia (emakumea): " + (aktoreEmakumea != null ? aktoreEmakumea : "Ezezaguna");
	}
}