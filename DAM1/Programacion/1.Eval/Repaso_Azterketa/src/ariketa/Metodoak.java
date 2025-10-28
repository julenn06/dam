package ariketa;

public class Metodoak {
	public static int soldataKalkulatu(int soldata, int adina, int semealabakop, int soldataOsoa, int kontadina) {

		if (adina > 60) {
			for (int i = 60; i < adina; i++) {
				kontadina++;
			}
		}
		soldataOsoa = soldata + semealabakop * 25 + kontadina * 50;
		return soldataOsoa;
	}

	public static int jubilaziorakoZenbat(int adina, final int JUBILAZIOA) {
		int jubilatu = 0;
		jubilatu = JUBILAZIOA - adina;
		return jubilatu;
	}

	public static String soldataMaila(int soldata) {
		String maila = "";
		if (soldata < 1000) {
			maila = "Soldata baxua";
		} else if (soldata >= 1000 && soldata <= 2000) {
			maila = "Soldata ertaina";
		} else if (soldata >= 2001 && soldata <= 3000) {
			maila = "Soldata altua";
		} else {
			maila = "Soldata oso altua";
		}
		return maila;
	}

	public static void emaitzakErakutsi(String izena, int soldata, int adina, int semealabakop, int soldataOsoa,
			int kontadina, final int JUBILAZIOA) {
		System.out.println("Izena: " + izena);
		System.out.println("Soldata osoa: " + soldataKalkulatu(soldata, adina, semealabakop, soldataOsoa, kontadina));
		System.out.println("Soldata maila: " + soldataMaila(soldata));
		System.out.println(jubilaziorakoZenbat(adina, JUBILAZIOA) + " urte jubilatzeko");
	}

	public static int batura(int batura, int soldata) {
		batura = batura + soldata;

		return batura;
	}

	public static double batazbestekoa(int batura, int kontsoldata) {
		double batazbestekoa;

		batazbestekoa = batura / kontsoldata;

		return batazbestekoa;
	}

	public static String soldataGuztiak(int soldata, int kontsoldata, String totala) {

		String cadena = String.valueOf(soldata);

		if (totala.length() == 0) {
			totala = cadena;
		} else {
			totala += ", " + cadena;
		}

		return totala;
	}

}
