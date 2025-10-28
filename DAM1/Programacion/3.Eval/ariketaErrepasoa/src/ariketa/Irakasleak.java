package ariketa;

class Irakasleak extends Pertsonak {
	private String[] irakasgaiak = new String[5];
	private String[] taldeak = new String[5];
	private int asignaturaKont = 0;
	


	public Irakasleak(String nan, String izena, int urtebetetzeEguna, int urtebetetzeHilabetea, String[] irakasgaiak,
			String[] taldeak, int asignaturaKont) {
		super(nan, izena, urtebetetzeEguna, urtebetetzeHilabetea);
		this.irakasgaiak = irakasgaiak;
		this.taldeak = taldeak;
		this.asignaturaKont = asignaturaKont;
	}

	@Override
	public void erakutsi() {
	    String info = "IRAKASLEA: " + getNan() + " " + getIzena() + ", "
	                  + getUrtebetetzeHilabetea() + "ren " + getUrtebetetzeEguna() + "a, ";

	    for (int i = 0; i < asignaturaKont; i++) {
	        info += irakasgaiak[i] + " " + taldeak[i];
	        if (i < asignaturaKont - 1) {
	            info += ", ";
	        }
	    }

	    System.out.println(info);
	}
}