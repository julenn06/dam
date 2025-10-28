package metodoak;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import modeloa.Liburua;

public class LiburuKudeaketa {
	Liburua hutsik = new Liburua();
	Liburua[] liburuak = new Liburua[10];

	public Liburua[] fitxategiaKargatu(String izena, Liburua[] l) {

		int zenbat = 0;

		try {
			File oFile = new File(izena);
			BufferedReader oBufferedReader = new BufferedReader(new FileReader(oFile));
			String katea;

			while ((katea = oBufferedReader.readLine()) != null && zenbat < 25) {
				String[] datuak = katea.split(";");

				if (datuak.length >= 5) {
					String idaux = datuak[0];
					int id = Integer.parseInt(idaux);

					String izenburua = datuak[1];

					String egilea = datuak[2];
					String editoriala = datuak[3];
					String argitaratze_data = datuak[4];

					l[zenbat] = new Liburua(id, izenburua, egilea, editoriala, argitaratze_data);
					zenbat++;
				}
			}
			oBufferedReader.close();
		} catch (FileNotFoundException fn) {
			System.out.println("Ez da fitxategia aurkitzen.");
			return null;
		} catch (IOException io) {
			System.out.println("I/O errorea.");
			return null;
		}

		if (zenbat > 0) {
			return l;
		} else {
			return null;
		}

	}

	public Liburua liburuaGehitu(Liburua[] liburuGuztiak, Scanner sc) {
		int id = 0;
		String izenburua;
		String egilea;
		String editoriala;
		String argitaratze_data;
		int kont = 0;
		do {
			try {
				System.out.println("Liburuaren ID");
				id = sc.nextInt();
			} catch (Exception e) {
				System.out.println("Sartu Baliozko Zenbaki Bat");
				id = -1;
				sc.next();
			}
		} while (id < 0);

		kont = idBalidatu(liburuGuztiak, kont, id);

		if (kont == -1) {
			hutsik = null;
		}

		if (kont != -1) {
			System.out.println("Liburuaren Izenburua");
			izenburua = sc.next();

			System.out.println("Liburuaren Egilea");
			egilea = sc.next();

			System.out.println("Liburuaren Editoriala");
			editoriala = sc.next();

			System.out.println("Liburuaren Argitaratze Data 'yyyy-mm-dd' formatuan sartu");
			argitaratze_data = sc.next();

			hutsik = new Liburua(id, izenburua, egilea, editoriala, argitaratze_data);
			liburuak[kont + 1] = hutsik;
		}
		return hutsik;
	}

	public int idBalidatu(Liburua[] liburuGuztiak, int kont, int id) {
		for (int i = 0; i < liburuGuztiak.length; i++) {
			if (liburuGuztiak[i] != null) {
				kont++;
			}
		}
		for (int i = 0; i < kont; i++) {
			if (liburuGuztiak[i].getId() == id) {
				System.out.println();
				System.out.println("ID Hori existitzen da, beste bat sartu");
				System.out.println();
				kont = -1;

			}
		}
		return kont;
	}

	public void bilatuIDarekin(Scanner sc, Liburua[] liburua) {
		System.out.print("Sartu liburuaren IDa bilatzeko: ");
		int ID = sc.nextInt();
		boolean aurkituta = false;

		for (Liburua liburuak : liburua) {
			if (liburuak != null && liburuak.getId() == (ID)) {
				liburua.toString();
				aurkituta = true;
				System.out.println(liburuak.toString());
			}
		}

		if (!aurkituta) {
			System.out.println("Ez da aurkitu: " + ID);
		}

	}

	public String[] bilatuIdazlearenIiburuak(Scanner sc, Liburua[] liburua) {
		System.out.print("Sartu egilearen izena bilatzeko: ");
		String izena = sc.next();
		boolean aurkituta = false;
		String[] liburuGuztiak = new String[10];
		int kont = 0;

		for (Liburua liburuak : liburua) {
			if (liburuak != null && liburuak.getEgilea().equalsIgnoreCase(izena)) {
				liburua.toString();
				aurkituta = true;
				String liburuGuztiakaux = liburuak.getIzenburua();
				liburuGuztiak[kont] = liburuGuztiakaux;
				kont++;
			}
		}

		if (!aurkituta) {
			System.out.println("Ez da aurkitu idazlea: " + izena);
		}
		return liburuGuztiak;

	}

	public void liburuGuztiak(Liburua[] liburuak) {
		if (liburuak == null || liburuak.length == 0) {
			System.out.println("Ez dago futbolaririk fitxategian.");
			return;
		}
		System.out.println();
		System.out.println("Liburu guztiak:");
		boolean daudeJokalariak = false;

		for (Liburua liburua : liburuak) {
			if (liburua != null) {
				liburua.ikusiLiburuak();
				daudeJokalariak = true;
			}
		}
		System.out.println();

		if (!daudeJokalariak) {
			System.out.println("Ez daude futbolaririk zerrendan.");
		}
	}

	public void fitxategianIdatzi(Liburua sartu, String fitxategia) {
		File oFile = new File(fitxategia);
		try (FileWriter oFileWriter = new FileWriter(oFile, true)) {

			String futbolista = sartu.toString();
			oFileWriter.write(System.lineSeparator());
			oFileWriter.write(futbolista);

		} catch (FileNotFoundException fn) {
			System.out.println("Ez da fitxategia aurkitzen");
		} catch (IOException io) {
			System.out.println("I/O errorea");
		}
	}
}
