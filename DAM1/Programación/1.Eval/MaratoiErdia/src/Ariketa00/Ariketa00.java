/**
* Korrikalarien datuen sarrera kudeatzen duen eta estatistikak kalkulatzen dituen klase nagusia
* maratoietako denborei buruz, generoaren eta adinaren arabera sailkatuta.
*
* Programa honek hainbat korrikalariri buruzko informazioa sartzeko aukera ematen du.

* bere izena, adina, generoa eta maratoi-denbora, eta
* batez bestekoak, eta korridorerik azkarrena eta motelena.


*
* @author Julen
* @version 1.0
* @since 2024-10-21
 */
package Ariketa00;

import java.util.Scanner;

public class Ariketa00 {

	/**
	 * Programa hasten duen metodo nagusia.
	 *
	 * @param args Komando-lerroaren argumentuak (ez dira programa honetan
	 *             erabiltzen).
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); // Scanner

		// Inicialización de variables
		int usersartu = 0; // Variable para almacenar la decisión de seguir metiendo datos
		int adina = 0;
		int sexua = 0;
		int denbora = 0; // Tiempo total en segundos
		int orduak = 0; // Horas
		int minutuak = 0; // Minutos
		int segunduak = 0; // Segundos
		int KontEmakumeGaztea = 0; // Contador para cuantas mujeres jóvenes
		int KontEmakumeHandia = 0; // Contador para cuantas mujeres mayores
		int KontGizonGaztea = 0; // Contador para cuantas hombres jóvenes
		int KontGizonHandia = 0; // Contador para cuantas hombres mayores
		int EmakumeGaztea = 0; // Suma de tiempos para mujeres jóvenes
		int EmakumeHandia = 0; // Suma de tiempos para mujeres mayores
		int GizonGaztea = 0; // Suma de tiempos para hombres jóvenes
		int GizonHandia = 0; // Suma de tiempos para hombres mayores
		int zbkswitch = 0; // Variable para clasificar el tiempo
		int max = 0; // Tiempo máximo
		int min = Integer.MAX_VALUE; // Tiempo mínimo
		int jarraitu = 0; // Variable para preguntar si continuar metiendo corredores
		int KontTotala = 0; // Contador total de corredores
		int ordumax = 0; // Horas del tiempo máximo
		int minutumax = 0; // Minutos del tiempo máximo
		int segundumax = 0; // Segundos del tiempo máximo
		int ordumin = 0; // Horas del tiempo mínimo
		int minutumin = 0; // Minutos del tiempo mínimo
		int segundumin = 0; // Segundos del tiempo mínimo
		String izena = ""; // Nombre del corredor
		String izenamax = ""; // Nombre del corredor con el tiempo máximo
		String izenamin = ""; // Nombre del corredor con el tiempo mínimo

		boolean balidazioak = true; // Variable para validar entradas

		do {
			try {
				System.out.println("Korrikalariaren datuak sartu nahi dituzu?");
				System.out.println("1. Bai");
				System.out.println("2. Ez");
				usersartu = sc.nextInt();

				// Validar que la opción esté en el rango correcto
				if (usersartu < 1 || usersartu > 2) {
					System.out.println("Sartu aukera zuzena (1 edo 2).");
					balidazioak = false;
				} else {
					balidazioak = true;
				}
			} catch (Exception e) {
				System.out.println("Sartu aukera zuzena (1 edo 2).");
				sc.next(); // Limpiar la entrada
				balidazioak = false; // Marcar como inválido
			}

		} while (!balidazioak); // Repetir hasta que la entrada sea válida

		// Si el usuario no quiere continuar, finalizar el programa
		if (usersartu == 2) {
			System.out.println("Programa amaitu da");
			sc.close();
			return;
		}

		// Bucle para ingresar los datos de los corredores
		do {
			// Reiniciar la validación para el ingreso de datos del corredor
			balidazioak = true;

			// Ingreso de datos del corredor
			do {
				try {
					System.out.println("Sartu Korrikalariaren Izena");
					izena = sc.next();
					System.out.println("Sartu Korrikalariaren Adina");
					adina = sc.nextInt();
					System.out.println("Korrikalariaren sexua:");
					System.out.println("1. Emakumea");
					System.out.println("2. Gizona");
					sexua = sc.nextInt();
					balidazioak = true;
					if (sexua < 1 || sexua > 2) {
						System.out.println("Balio Egokiak sartu");
						balidazioak = false;
					}
				} catch (Exception e) {
					System.out.println("Balio Egokiak sartu");
					sc.next(); // Limpiar la entrada
					balidazioak = false; // Marcar como inválido
				}
			} while (!balidazioak); // Repetir hasta que la entrada sea válida

			// Ingreso del tiempo del corredor
			do {
				try {
					System.out.println("Zein izan zen bere azken maratoriaren marka?");
					System.out.println("Zenbat ordu:");
					orduak = sc.nextInt();
					System.out.println("Zenbat minutu:");
					minutuak = sc.nextInt();
					System.out.println("Zenbat segundu:");
					segunduak = sc.nextInt();
					balidazioak = true;
				} catch (Exception e) {
					System.out.println();
					System.out.println("Balio egokiak sartu");
					System.out.println();
					sc.next();
					balidazioak = false;
				}
			} while (balidazioak == false); // Repetir hasta que la entrada sea válida

			// Convertir el tiempo a segundos
			orduak = orduak * 3600; // Convertir horas a segundos
			minutuak = minutuak * 60; // Convertir minutos a segundos
			denbora = orduak + minutuak + segunduak; // Sumar todos los segundos

			// Clasificar el tiempo para el mensaje de posición
			if (denbora <= 5400) {
				zbkswitch = 1;
			} else if (denbora > 5400 && denbora < 6000) {
				zbkswitch = 2;
			} else if (denbora >= 6000 && denbora < 6600) {
				zbkswitch = 3;
			} else if (denbora >= 6600) {
				zbkswitch = 4;
			}

			// Mensaje según el grupo de tiempo
			switch (zbkswitch) {
			case 1:
				System.out.println("Lehenengo Kutxan Egongo da"); // primer grupo
				break;
			case 2:
				System.out.println("Bigarren Kutxan Egongo da"); // segundo grupo
				break;
			case 3:
				System.out.println("Hirugarren Kutxan Egongo da"); // tercer grupo
				break;
			case 4:
				System.out.println("Laugarren Kutxan Egongo da"); // cuarto grupo
				break;
			}

			// Contar y sumar tiempos según el sexo y la edad
			if (sexua == 1) { // Si es mujer
				if (adina < 35) { // Si es joven
					KontEmakumeGaztea++; // Incrementar contador de mujeres jóvenes
					EmakumeGaztea = EmakumeGaztea + denbora; // Sumar tiempo
				} else { // Si es mayor
					KontEmakumeHandia++; // Incrementar contador de mujeres mayores
					EmakumeHandia = EmakumeHandia + denbora; // Sumar tiempo
				}
			} else if (sexua == 2) { // Si es hombre
				if (adina < 35) { // Si es joven
					KontGizonGaztea++; // Incrementar contador de hombres jóvenes
					GizonGaztea = GizonGaztea + denbora; // Sumar tiempo
				} else { // Si es mayor
					KontGizonHandia++; // Incrementar contador de hombres mayores
					GizonHandia = GizonHandia + denbora; // Sumar tiempo
				}
			}

			// Determinar el máximo y mínimo de tiempo
			if (denbora > max) {
				max = denbora; // Actualizar el máximo
				izenamax = izena; // Actualizar el nombre del corredor con el máximo
			}
			if (denbora < min) {
				min = denbora; // Actualizar el mínimo
				izenamin = izena; // Actualizar el nombre del corredor con el mínimo
			}

			// Preguntar si se desea ingresar otro corredor
			do {
				try {
					System.out.println();
					System.out.println("Beste korrikalari bat sartu nahi duzu?");
					System.out.println("1. Bai");
					System.out.println("2. Ez");
					jarraitu = sc.nextInt();

					// Validar la entrada
					if (jarraitu == 1 || jarraitu == 2) {
						balidazioak = true;
					} else {
						balidazioak = false;
					}
				} catch (Exception e) {
					sc.next(); // Limpiar la entrada
					System.out.println("Sartu aukera zuzena (1 edo 2).");
					balidazioak = false;
				}
			} while (balidazioak == false); // Repetir hasta que la entrada sea válida

			// Verificamos si el usuario no quiere continuar
			if (jarraitu == 2) {
				break; // Salir del bucle si el usuario responde que no
			}
		} while (balidazioak == true); // Repetir todo mientras sea válido

		// Calcular el total de corredores
		KontTotala = KontEmakumeGaztea + KontEmakumeHandia + KontGizonGaztea + KontGizonHandia;

		// Calcular horas, minutos y segundos del tiempo máximo
		ordumax = max / 3600; // Horas
		minutumax = (max % 3600) / 60; // Minutos
		segundumax = max % 60; // Segundos

		// Calcular horas, minutos y segundos del tiempo mínimo
		ordumin = min / 3600; // Horas
		minutumin = (min % 3600) / 60; // Minutos
		segundumin = min % 60; // Segundos

		// Mostrar resultados
		System.out.println("Korrikalari Kopurua: " + KontTotala);
		System.out.println();

		// Cálculo de promedios para mujeres jóvenes
		if (KontEmakumeGaztea > 0) {
			int auxEmakumeGaztea = EmakumeGaztea / KontEmakumeGaztea; // Promedio de tiempo
			int EmakumeGazteaOrdu = auxEmakumeGaztea / 3600; // Horas promedio
			int EmakumeGazteaMinutu = (auxEmakumeGaztea % 3600) / 60; // Minutos promedio
			int EmakumeGazteaSegundu = auxEmakumeGaztea % 60; // Segundos promedio

			System.out.println("Emakume gazteen batazbestekoa: " + EmakumeGazteaOrdu + " ordu, " + EmakumeGazteaMinutu
					+ " minutu eta " + EmakumeGazteaSegundu + " segundu");
		}

		// Cálculo de promedios para mujeres mayores
		if (KontEmakumeHandia > 0) {
			int auxEmakumeHandia = EmakumeHandia / KontEmakumeHandia; // Promedio de tiempo
			int EmakumeHandiaOrdu = auxEmakumeHandia / 3600; // Horas promedio
			int EmakumeHandiaMinutu = (auxEmakumeHandia % 3600) / 60; // Minutos promedio
			int EmakumeHandiaSegundu = auxEmakumeHandia % 60; // Segundos promedio

			System.out.println("Emakume Handien batazbestekoa: " + EmakumeHandiaOrdu + " ordu, " + EmakumeHandiaMinutu
					+ " minutu eta " + EmakumeHandiaSegundu + " segundu");
		}

		// Cálculo de promedios para hombres jóvenes
		if (KontGizonGaztea > 0) {
			int auxGizonGaztea = GizonGaztea / KontGizonGaztea; // Promedio de tiempo
			int GizonGazteaOrdu = auxGizonGaztea / 3600; // Horas promedio
			int GizonGazteaMinutu = (auxGizonGaztea % 3600) / 60; // Minutos promedio
			int GizonGazteaSegundu = auxGizonGaztea % 60; // Segundos promedio

			System.out.println("Gizon Gazteen batazbestekoa: " + GizonGazteaOrdu + " ordu, " + GizonGazteaMinutu
					+ " minutu eta " + GizonGazteaSegundu + " segundu");
		}

		// Cálculo de promedios para hombres mayores
		if (KontGizonHandia > 0) {
			int auxGizonHandia = GizonHandia / KontGizonHandia; // Promedio de tiempo
			int GizonHandiaOrdu = auxGizonHandia / 3600; // Horas promedio
			int GizonHandiaMinutu = (auxGizonHandia % 3600) / 60; // Minutos promedio
			int GizonHandiaSegundu = auxGizonHandia % 60; // Segundos promedio

			System.out.println("Gizon Handien batazbestekoa: " + GizonHandiaOrdu + " ordu, " + GizonHandiaMinutu
					+ " minutu eta " + GizonHandiaSegundu + " segundu");
		}

		// Mostrar resultados finales
		System.out.println();
		System.out.println(izenamin + " izan du denbora azkarrena: " + ordumin + " ordu " + minutumin + " minutu eta "
				+ segundumin + " segundu"); // Mostrar el corredor con el tiempo más rápido
		System.out.println(izenamax + " izan du denbora motelena: " + ordumax + " ordu " + minutumax + " minutu eta "
				+ segundumax + " segundu"); // Mostrar el corredor con el tiempo más lento

		sc.close();
	}
}