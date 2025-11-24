package Ariketa_01;

public class eragiketa {

	public static Boolean balidazioa(String balidazioa) {

		int aux;
		boolean balidatu = true;

		try {
			aux = Integer.parseInt(balidazioa);
			if (aux > 0 && aux <= 6) {

				balidatu = true;
			} else if (aux == 6) {
				balidatu = true;
			} else {
				balidatu = false;
			}
		} catch (Exception e) {
			balidatu = false;
		}

		return balidatu;
	}

	public static void lerroa(int zenbakia, String karakterea) {

		for (int i = 0; i < zenbakia; i++) {
			System.out.print(karakterea);
		}
	}

	public static Boolean letraMinuskula(String letra) {

		boolean balidatu = false;

		try {
			if (letra == letra.toLowerCase() || letra.length() > 1) {
				balidatu = false;
			} else {
				balidatu = true;
			}

		} catch (Exception e) {
			balidatu = false;
		}

		return balidatu;
	}

	public static Boolean letraMaiuskula(String letra) {

		boolean balidatu = false;

		try {
			if (letra == letra.toUpperCase() || letra.length() > 1) {
				balidatu = false;
			} else {
				balidatu = true;
			}

		} catch (Exception e) {
			balidatu = false;
		}

		return balidatu;
	}

	public static Boolean EsaldiMinuskula(String esaldia) {

		boolean balidatu = false;

		try {
			if (esaldia == esaldia.toLowerCase()) {
				balidatu = false;
			} else {
				balidatu = true;
			}

		} catch (Exception e) {
			balidatu = false;
		}

		return balidatu;
	}

	public static Boolean EsaldiMaiuskula(String esaldia) {

		boolean balidatu = false;

		try {
			if (esaldia == esaldia.toUpperCase()) {
				balidatu = false;
			} else {
				balidatu = true;
			}

		} catch (Exception e) {
			balidatu = false;
		}

		return balidatu;
	}

}