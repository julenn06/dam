package programa;

public class Balidazioak {

	public static int zenbakiada(String zenbakia) {
		int zbk = 0;
		try {
			zbk = Integer.parseInt(zenbakia);
		} catch (Exception e) {
			zbk = -1;
		}
		return zbk;
	}

	public static int rangoak(int zenbakia, int min, int max) {
		int emaitza = -1;
		if (zenbakia >= min && zenbakia <= max) {
			emaitza = zenbakia;
		}
		return emaitza;
	}

	public static String sexuaBalidatu(String sexua) {
		String gizonemakume = "";

		if (sexua.equals("G") || sexua.equals("g") || sexua.equals("E") || sexua.equals("e")) {
			gizonemakume = sexua;
		} else {
			gizonemakume = "-1";
		}
		return gizonemakume;
	}

	public static double altueraBalidatu(double zenbakia, int min, int max) {
		double emaitza = -1;
		if (zenbakia >= min && zenbakia <= max) {
			emaitza = zenbakia;
		}
		return emaitza;
	}

	public static String jarraitu(String jarraitu) {
		String balidatu = "";
		if (jarraitu.equals("B") || jarraitu.equals("b") || jarraitu.equals("E") || jarraitu.equals("e")) {
			balidatu = jarraitu;
		} else {
			balidatu = "-1";
		}
		return balidatu;
	}

	public static boolean jarraituBalidatu(String jarraitu) {
		boolean balidatu = true;
		if (jarraitu.equals("E") || jarraitu.equals("e")) {
			balidatu = false;
		} else {
			balidatu = true;
		}
		return balidatu;
	}
}
