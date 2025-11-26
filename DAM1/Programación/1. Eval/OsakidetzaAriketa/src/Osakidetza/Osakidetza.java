package Osakidetza;

import java.util.Scanner;

public class Osakidetza {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String tis = "";
		String abizena = "";
		String jaiotzedata = "";
		String norekin = "";
		String hitzordua = "";
		int kont = 0;
		String mota = "";
		boolean errorea = true;
		int aux = 0;

		do {

			System.out.println();
			System.out.println("Sartu TIS zenbakia:");
			tis = sc.nextLine();

			System.out.println("Sartu Lehenengo Abizena:");
			abizena = sc.nextLine();

			System.out.println("Sartu Jaiotze data:");
			jaiotzedata = sc.nextLine();

			do {
				try {
					do {
						System.out.println("1. Ezabatu Hitzordua");
						System.out.println("2. Eskatu Hitzordua");
						System.out.println("3. Itzuli hasierara");
						hitzordua = sc.nextLine();
						errorea = false;
						aux = Integer.parseInt(hitzordua);
					} while (aux <= 0 || aux >= 4);

				} catch (Exception e) {
					errorea = true;
					System.out.println("ezin dira letrak sartu");
				}
			} while (errorea == true);

			if (aux == 1) {
				System.out.println();
				System.out.println("Zein hitz ordu ezabatu nahi duzu?");
				hitzordua = sc.nextLine();

				System.out.println(hitzordua + " Hitzordua ezabatu da");
				System.out.println();
				kont--;
				System.out.println("Berriro hasten...");
				continue;
			}

			if (aux == 3) {
				System.out.println();
				System.out.println("Berriro hasten...");
				continue;
			}

			do {
				try {
					do {
						System.out.println("1. Erizainarekin Hitzordua");
						System.out.println("2. Medikuarekin Hitzordua");
						System.out.println("3. Itzuli hasierara");
						norekin = sc.nextLine();
						errorea = false;
						aux = Integer.parseInt(norekin);
					} while (aux <= 0 || aux >= 4);
				} catch (Exception e) {
					errorea = true;
					System.out.println("ezin dira letrak sartu");
				}
			} while (errorea == true);

			if (aux == 3) {
				System.out.println();
				System.out.println("Berriro hasten...");
				continue;
			}

			do {
				try {
					do {
						System.out.println("1. Presentziala");
						System.out.println("2. Telefonoa");
						System.out.println("3. Itzuli hasierara");
						mota = sc.nextLine();
						errorea = false;
						aux = Integer.parseInt(mota);
					} while (aux <= 0 || aux >= 4);
				} catch (Exception e) {
					errorea = true;
					System.out.println("ezin dira letrak sartu");
				}

			} while (errorea == true);

			if (aux == 3) {
				System.out.println();
				System.out.println("Berriro hasten...");
				continue;
			}

			aux = Integer.parseInt(norekin);

			if (aux == 1) {
				norekin = "Erizainarekin Hitzordua";
			} else {
				norekin = "Medikuarekin Hitzordua";
			}

			aux = Integer.parseInt(mota);

			if (aux == 1) {
				mota = "Prezentziala";
			} else {
				mota = "Telefonoa";
			}

			kont++;

			System.out.println(tis);
			System.out.println(abizena);
			System.out.println(jaiotzedata);
			System.out.println(norekin);
			System.out.println(mota);
			System.out.println("Hitzordu zenbakia: " + kont);
		} while (errorea = true);

		sc.close();
	}
}