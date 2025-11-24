package ariketa;

public class Balidazioak {
	public static int soldataZenbakia(String ssoldata) {
		int soldata = 0;
		try {
			soldata = Integer.parseInt(ssoldata);
		} catch (Exception e) {
			soldata = -1;
		}
		return soldata;
	}

	public static int zenbkiaOsoa(String zbkosoa) {
		int adina = 0;
		try {
			adina = Integer.parseInt(zbkosoa);

		} catch (Exception e) {
			adina = -1;
		}
		return adina;
	}

	public static int rangoak(int zenbakia, int min, int max) {
		int emaitza = -1;
		if (zenbakia >= min && zenbakia <= max) {
			emaitza = zenbakia;
		}
		return emaitza;
	}
}