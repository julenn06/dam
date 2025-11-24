package ariketa;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) {
		String[] irakasgaiak = new String[5];
		String[] taldeak = new String[5];
		Scanner sc = new Scanner(System.in);
		Pertsonak[] pertsonak = new Pertsonak[100];
		Pertsonak irakaslea = new Irakasleak(null, null, 0, 0, taldeak, taldeak, 0);
		Pertsonak ikaslea = new Ikasleak(null, null, 0, 0, null);
		int kont = 0;
		int aukera = 0;
		int mota = 0;
		int eguna = 0;
		int hilabetea = 0;
		int aukeratuMota = 0;
		String nanAukeratu = "";
		String taldea = "";

		do {
			System.out.println("1. Gehitu pertsona.");
			System.out.println("2. Datuak erakutsi");
			System.out.println("3. Ikaslearen/irakaslearen datuak aldatzea");
			System.out.println("4. Ezabatu ikaslea/irakaslea");
			System.out.println("5. Zorionak ematea");
			System.out.println("6. Bilatu ikaslea taldeka");
			System.out.println("7. Irakasgaiaren arabera irakasleak bilatzea");
			System.out.println("8. Irten");
			System.out.print("Aukeratu: ");

			aukera = sc.nextInt();
			sc.nextLine();

			switch (aukera) {
			case 1:
				if (kont < pertsonak.length) {
					System.out.println("1. Ikaslea");
					System.out.println("2. Irakaslea");
					mota = sc.nextInt();
					sc.nextLine();

					if (mota == 1) {
						System.out.println("NAN (8 digitu + letra): ");
						String nan = sc.nextLine();
						while (Pattern.matches("\\d{8}[A-Z]", nan) == false) {
							System.out.println("NAN okerra. Sartu berriro:");
							nan = sc.next();
						}
						System.out.print("Izena: ");
						String izena = sc.nextLine();
						System.out.println("Urtebetetze eguna (1-31):");
						eguna = sc.nextInt();
						while (eguna < 1 || eguna > 31) {
							System.out.println("Eguna okerra. Sartu berriro:");
							eguna = sc.nextInt();
						}
						System.out.println("Urtebetetze hilabetea (1-12):");
						hilabetea = sc.nextInt();
						while (hilabetea < 1 || hilabetea > 12) {
							System.out.println("Hilabetea okerra. Sartu berriro:");
							hilabetea = sc.nextInt();
						}

						sc.nextLine();
						System.out.println("Taldea:");
						taldea = sc.next();

						pertsonak[kont] = new Ikasleak(nan, izena, eguna, hilabetea, taldea);
						kont++;
					} else if (mota == 2) {
						System.out.println("NAN (8 digitu + letra): ");
						String nan = sc.nextLine();
						while (Pattern.matches("\\d{8}[A-Z]", nan) == false) {
							System.out.println("NAN okerra. Sartu berriro:");
							nan = sc.next();
						}
						System.out.print("Izena: ");
						String izena = sc.nextLine();
						System.out.println("Urtebetetze eguna (1-31):");
						eguna = sc.nextInt();
						while (eguna < 1 || eguna > 31) {
							System.out.println("Eguna okerra. Sartu berriro:");
							eguna = sc.nextInt();
						}
						System.out.println("Urtebetetze hilabetea (1-12):");
						hilabetea = sc.nextInt();
						while (hilabetea < 1 || hilabetea > 12) {
							System.out.println("Hilabetea okerra. Sartu berriro:");
							hilabetea = sc.nextInt();
						}
						sc.nextLine();
						System.out.print("Zenbat irakasgai gehitu nahi dituzu? (Gehienez 5): ");
						int kopurua = sc.nextInt();
						while (kopurua < 1 || kopurua > 5) {
							System.out
									.println("Irakasgai Okerra. Gutxienez 1 eta Gehienez 5 Irakasgai. Sartu Berriro: ");
							kopurua = sc.nextInt();

						}
						sc.nextLine();

						for (int i = 0; i < kopurua; i++) {
							System.out.print("Irakasgaia " + (i + 1) + ": ");
							irakasgaiak[i] = sc.nextLine();
							System.out.print("Taldea: ");
							taldeak[i] = sc.nextLine();
						}

						pertsonak[kont] = new Irakasleak(nan, izena, eguna, hilabetea, irakasgaiak, taldeak, kopurua);
						kont++;
					} else {
						System.out.println("Aukera okerra.");
					}
				} else {
					System.out.println("Errorea: ezin dira pertsona gehiago gehitu.");
				}
				break;

			case 2:
				System.out.println();
				if (kont == 0) {
					System.out.println("Ez daude erregistrorik");
					System.out.println();
					break;
				}
				System.out.println("Datuak erakusten:");
				for (int i = 0; i < kont; i++) {
					pertsonak[i].erakutsi();
					System.out.println("----------------------");
				}
				break;

			case 3:
				System.out.println();
				if (kont == 0) {
					System.out.println("Ez daude erregistrorik");
					System.out.println();
					break;
				}
				System.out.println("Noren Datuak Aldatu nahi dituzu? (Aukeratu NAN)");
				System.out.println("1. Ikasle Bat");
				System.out.println("2. Irakasle Bat");
				aukeratuMota = sc.nextInt();

				if (aukeratuMota == 1) {
					boolean ikasleDago = false;
					System.out.println("Ikasleen lista:");
					for (int i = 0; i < pertsonak.length; i++) {
						if (pertsonak[i] != null && pertsonak[i] instanceof Ikasleak) {
							ikaslea = (Ikasleak) pertsonak[i];
							System.out.println("NAN: " + ikaslea.getNan() + ", Izena: " + ikaslea.getIzena());
							ikasleDago = true;
						}
					}
					if (!ikasleDago) {
						System.out.println("Ez dago ikaslerik erregistratuta.");
					} else {
						System.out.println("Aukeratu Ikaslearen NAN Zenbakia:");
						nanAukeratu = sc.next();
						boolean nanDago = false;
						for (int i = 0; i < pertsonak.length; i++) {
							if (pertsonak[i] != null && pertsonak[i] instanceof Ikasleak) {
								ikaslea = (Ikasleak) pertsonak[i];
								if (ikaslea.getNan().equals(nanAukeratu)) {
									nanDago = true;
									System.out.println("Datuak aldatzen...");
									System.out.print("Izena: ");
									String izena = sc.next();
									System.out.println("Urtebetetze eguna (1-31):");
									eguna = sc.nextInt();
									while (eguna < 1 || eguna > 31) {
										System.out.println("Eguna okerra. Sartu berriro:");
										eguna = sc.nextInt();
									}
									System.out.println("Urtebetetze hilabetea (1-12):");
									hilabetea = sc.nextInt();
									while (hilabetea < 1 || hilabetea > 12) {
										System.out.println("Hilabetea okerra. Sartu berriro:");
										hilabetea = sc.nextInt();
									}
									System.out.println("Taldea: ");
									taldea = sc.next();

									pertsonak[i] = new Ikasleak(nanAukeratu, izena, eguna, hilabetea, taldea);
									System.out.println("Ikaslea aldatu da.");
									break;
								}
							}
						}
						if (!nanDago) {
							System.out.println("NAN hori ez dago erregistratuta.");
						}
					}
				} else if (aukeratuMota == 2) {
					boolean ikasleDago = false;
					System.out.println("Irakasleen lista:");
					for (int i = 0; i < pertsonak.length; i++) {
						if (pertsonak[i] != null && pertsonak[i] instanceof Irakasleak) {
							irakaslea = (Irakasleak) pertsonak[i];
							System.out.println("NAN: " + irakaslea.getNan() + ", Izena: " + irakaslea.getIzena());
							ikasleDago = true;
						}
					}
					if (!ikasleDago) {
						System.out.println("Ez dago irakaslerik erregistratuta.");
					} else {
						System.out.println("Aukeratu Irakaslearen NAN Zenbakia:");
						nanAukeratu = sc.next();
						boolean nanDago = false;
						for (int i = 0; i < pertsonak.length; i++) {
							if (pertsonak[i] != null && pertsonak[i] instanceof Irakasleak) {
								irakaslea = (Irakasleak) pertsonak[i];
								if (irakaslea.getNan().equals(nanAukeratu)) {
									nanDago = true;
									System.out.println("Datuak aldatzen...");
									System.out.print("Izena: ");
									String izena = sc.next();
									System.out.println("Urtebetetze eguna (1-31):");
									eguna = sc.nextInt();
									while (eguna < 1 || eguna > 31) {
										System.out.println("Eguna okerra. Sartu berriro:");
										eguna = sc.nextInt();
									}
									System.out.println("Urtebetetze hilabetea (1-12):");
									hilabetea = sc.nextInt();
									while (hilabetea < 1 || hilabetea > 12) {
										System.out.println("Hilabetea okerra. Sartu berriro:");
										hilabetea = sc.nextInt();
									}
									System.out.print("Zenbat irakasgai aldatu nahi dituzu? (Gehienez 5): ");
									int kopurua = sc.nextInt();
									while (kopurua < 1 || kopurua > 5) {
										System.out.println(
												"Irakasgai Okerra. Gutxienez 1 eta Gehienez 5 Irakasgai. Sartu Berriro:");
										kopurua = sc.nextInt();
									}
									sc.nextLine();

									for (int j = 0; j < kopurua; j++) {
										System.out.print("Irakasgaia " + (j + 1) + ": ");
										irakasgaiak[j] = sc.nextLine();
										System.out.print("Taldea: ");
										taldeak[j] = sc.nextLine();
									}

									pertsonak[i] = new Irakasleak(nanAukeratu, izena, eguna, hilabetea, irakasgaiak,
											taldeak, kopurua);

									System.out.println("Irakaslea aldatu da.");
									break;
								}
							}
						}
						if (!nanDago) {
							System.out.println("NAN hori ez dago erregistratuta.");
						}
					}
				} else {
					System.out.println("Aukera okerra.");
				}
				break;
			case 4:
				System.out.println();
				if (kont == 0) {
					System.out.println("Ez daude erregistrorik");
					System.out.println();
					break;
				}
				nanAukeratu = "";
				System.out.println("Nor ezabatu nahi duzu?");
				System.out.println("1. Ikasle Bat");
				System.out.println("2. Irakasle Bat");
				aukeratuMota = sc.nextInt();

				if (aukeratuMota == 1) {
					boolean ikasleDago = false;
					System.out.println("Ikasleen lista:");
					for (int i = 0; i < pertsonak.length; i++) {
						if (pertsonak[i] != null && pertsonak[i] instanceof Ikasleak) {
							ikaslea = (Ikasleak) pertsonak[i];
							System.out.println("NAN: " + ikaslea.getNan() + ", Izena: " + ikaslea.getIzena());
							ikasleDago = true;
						}
					}
					if (!ikasleDago) {
						System.out.println("Ez dago ikaslerik erregistratuta.");
					} else {
						System.out.println("Aukeratu Ikaslearen NAN Zenbakia:");
						nanAukeratu = sc.next();
						boolean nanDago = false;
						for (int i = 0; i < pertsonak.length; i++) {
							if (pertsonak[i] != null && pertsonak[i] instanceof Ikasleak) {
								ikaslea = (Ikasleak) pertsonak[i];
								if (ikaslea.getNan().equals(nanAukeratu)) {
									nanDago = true;
									pertsonak[i] = null;
									System.out.println("Ikaslea ezabatu da.");
									kont--;
									break;
								}
							}
						}
						if (!nanDago) {
							System.out.println("NAN hori ez dago erregistratuta.");
						}
					}
				} else if (aukeratuMota == 2) {
					boolean ikasleDago = false;
					System.out.println("Irakasleen lista:");
					for (int i = 0; i < pertsonak.length; i++) {
						if (pertsonak[i] != null && pertsonak[i] instanceof Irakasleak) {
							irakaslea = (Irakasleak) pertsonak[i];
							System.out.println("NAN: " + irakaslea.getNan() + ", Izena: " + irakaslea.getIzena());
							ikasleDago = true;
						}
					}
					if (!ikasleDago) {
						System.out.println("Ez dago irakaslerik erregistratuta.");
					} else {
						System.out.println("Aukeratu Irakaslearen NAN Zenbakia:");
						nanAukeratu = sc.next();
						boolean nanDago = false;
						for (int i = 0; i < pertsonak.length; i++) {
							if (pertsonak[i] != null && pertsonak[i] instanceof Irakasleak) {
								irakaslea = (Irakasleak) pertsonak[i];
								if (irakaslea.getNan().equals(nanAukeratu)) {
									nanDago = true;
									pertsonak[i] = null;
									System.out.println("Irakaslea ezabatu da.");
									kont--;
									break;
								}
							}
						}
						if (!nanDago) {
							System.out.println("NAN hori ez dago erregistratuta.");
						}
					}
				} else {
					System.out.println("Aukera okerra.");
				}
				break;
			case 5:
				System.out.println();
				if (kont == 0) {
					System.out.println("Ez dago inor erregistratuta zoriontzeko");
					System.out.println();
					break;
				}
				System.out.println("Zein egun da gaur?");
				eguna = sc.nextInt();
				System.out.println("Zein hilabete da gaur?");
				hilabetea = sc.nextInt();

				boolean badago = false;

				for (int i = 0; i < pertsonak.length; i++) {
					if (pertsonak[i] != null) {
						if (pertsonak[i].getUrtebetetzeEguna() == eguna
								&& pertsonak[i].getUrtebetetzeHilabetea() == hilabetea) {
							badago = true;

							if (pertsonak[i] instanceof Ikasleak) {
								System.out.println();
								System.out.println("Zorionak, " + pertsonak[i].getIzena() + " Ikaslea");

							} else {
								System.out.println();
								System.out.println("Zorionak, " + pertsonak[i].getIzena() + " Irakaslea");

							}
						}
					}
				}
				if (!badago) {
					System.out.println("Ez dago inork data horretan urtebetetzeak betetzaen dituenik");
				}
				System.out.println();
				break;
			case 6:
				System.out.println();
				if (kont == 0) {
					System.out.println("Ez dago inork erregistratuta bilatzeko");
					System.out.println();
					break;
				}
				System.out.println("Zein taldeko ikasleak Erakutsi nahi dituzu?");
				taldea = sc.next();
				for (int i = 0; i < pertsonak.length; i++) {
					if (pertsonak[i] != null) {
						badago = true;
						if (pertsonak[i] instanceof Ikasleak) {
							ikaslea = pertsonak[i];
							System.out.println();
							System.out.println(ikaslea);
						}
					}
				}

				break;
			case 8:
				System.out.println("Irten egiten...");
				break;

			default:
				System.out.println("Aukera okerra. Saiatu berriro.");
			}

		} while (aukera != 8);

		sc.close();
	}
}
