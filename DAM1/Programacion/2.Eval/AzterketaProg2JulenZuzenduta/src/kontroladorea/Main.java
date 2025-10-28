package kontroladorea;

import java.util.Scanner;

import metodoak.LiburuKudeaketa;
import modeloa.Liburua;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int aukera = 0;

		LiburuKudeaketa kudeatu = new LiburuKudeaketa();
		Liburua l1 = new Liburua();
		Liburua[] l = new Liburua[10];
		Liburua[] liburuGuztiak = kudeatu.fitxategiaKargatu("Plantilla.txt", l);
		String[] idazlearenLiburuak = new String[10];

		do {

			try {
				aukera = 0;
				liburuGuztiak = kudeatu.fitxategiaKargatu("Plantilla.txt", l);
				System.out.println("1. Liburua Gehitu");
				System.out.println("2. Liburu Guztiak Pantailaratu");
				System.out.println("3. Bilatu ID bidez");
				System.out.println("4. Idazle Baten Liburuak");
				System.out.println("5. 2020-01-01 baino lehen");
				System.out.println("6. irten");
				aukera = sc.nextInt();
				if (aukera < 1 || aukera > 6) {
					System.out.println("Sartu Aukera Egoki Bat");
				}
			} catch (Exception e) {
				System.out.println("Sartu Zenbaki Bat");
			}

			switch (aukera) {

			case 1:
				l1 = kudeatu.liburuaGehitu(liburuGuztiak, sc);
				if (l1 == null) {
					break;
				}

				break;
			case 2:

				kudeatu.liburuGuztiak(liburuGuztiak);
				break;
			case 3:
				kudeatu.bilatuIDarekin(sc, liburuGuztiak);
				break;
			case 4:
				idazlearenLiburuak = kudeatu.bilatuIdazlearenIiburuak(sc, liburuGuztiak);
				for (int i = 0; i < idazlearenLiburuak.length; i++) {
					if (idazlearenLiburuak[i] != null) {
						System.out.println(idazlearenLiburuak[i]);
					}
				}
			case 5:
				break;
			case 6:
				kudeatu.fitxategianIdatzi(l1, "Plantilla.txt");
				break;
			}

		} while (aukera != 6);
	}

}
