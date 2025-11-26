package email_ariketa;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int aukera = 0;
		int emailKopurua = 0;
		boolean irakurriGabe;
		String emailaErakutsi;
		int emailIrakurri;
		int emailEzabatu;

		Email e1 = new Email("Irakaslea", "Notak", "Ebaluazioa gainditu duzu", false);
		Email e2 = new Email("Pablo", "Proiektua", "Javaren kodea bidaltzen dizut", true);

		Email[] k1 = new Email[20];

		k1[0] = e1;
		k1[1] = e2;

		do {
			Metodoak.Menu();
			aukera = sc.nextInt();
			switch (aukera) {
			case 1:
				emailKopurua = Metodoak.emailKopurua(k1, emailKopurua);
				System.out.println(emailKopurua);
				break;
			case 2:
				Metodoak.gehitu(k1, sc);
				break;
			case 3:
				irakurriGabe = Metodoak.irakurriGabe(k1);
				if (irakurriGabe == true) {
					System.out.println("Ez daude mezurik irakutzeko");
					System.out.println();
				} else {
					System.out.println("Mezuak daude irakurri gabe");
					System.out.println();
				}
				break;
			case 4:
				emailaErakutsi = Metodoak.erakutsiLehenaIrakurriGabe(k1);
				System.out.println(emailaErakutsi);
			case 5:
				System.out.println("Zein email ikakurri nahi duzu? (1, 2...)");
				emailIrakurri = sc.nextInt();

				emailaErakutsi = Metodoak.erakutsi(emailIrakurri, k1);
				System.out.println(emailaErakutsi);
				System.out.println();
				break;
			case 6:
				System.out.println("Zein email ezabatu nahi duzu? (1, 2...)");
				emailEzabatu = sc.nextInt();
				Metodoak.ezabatu(emailEzabatu, k1);
				break;
			}
		} while (aukera != 7);

		sc.close();
	}

}
