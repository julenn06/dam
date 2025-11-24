package programa;

public class Metodoak {

	public static double gmiKalkulatu(int kg, double altuera) {
		double emaitza;

		emaitza = kg / (altuera / 100 * altuera / 100);

		return emaitza;
	}

	public static double pisuIdeala(double altuera, String sexua) {
		double emaitza;

		if (sexua.equals("E") || sexua.equals("e")) {
			emaitza = (altuera * 0.675) - 56.25;
		} else {
			emaitza = (altuera * 0.75) - 62.5;
		}
		return emaitza;
	}

	public static String inprimatu(double gmi) {
		String emaitza = "";

		if (gmi < 18.5) {
			emaitza = "behar baino pisu txikiagoa edo desnutrizioa";
		} else if (gmi > 18.5 && gmi < 24.9) {
			emaitza = "normala";
		} else if (gmi > 25.0 && gmi < 29.9) {
			emaitza = "behar baino pisu handiagoa";
		} else if (gmi > 30.0 && gmi < 34.9) {
			emaitza = "obesitate arina";
		} else if (gmi > 35 && gmi < 39.9) {
			emaitza = "obesitate ertaina";
		} else {
			emaitza = "obesitate larria edo morbidoa";
		}

		return emaitza;
	}

	public static String argalduEdoGizendu(double pisuideala, double gmi, String sexua) {
		String emaitza = "";

		if (sexua.equals("E") || sexua.equals("e")) {
			if (pisuideala > gmi) {
				emaitza = "Pisua igo behar duzu";
			} else if (pisuideala == gmi) {
				emaitza = "Pisu egokia daukazu";
			} else {
				emaitza = "Pisua jeitzi behar duzu";
			}
		} else {
			if (pisuideala > gmi) {
				emaitza = "Pisua igo behar duzu";
			} else if (pisuideala == gmi) {
				emaitza = "Pisu egokia daukazu";
			} else {
				emaitza = "Pisua jeitzi behar duzu";
			}
		}
		return emaitza;
	}

	public static String pertsonenIzenak(String izena, String izenak) {

		if (izenak.length() == 0) {
			izenak = izena;
		} else {
			izenak += ", " + izena;
		}
		return izenak;
	}

}
