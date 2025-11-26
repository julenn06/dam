package windowbuilder;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class vending_makina extends JFrame {

	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	private static JButton ongi_etorri;
	private double ordaindu;
	private int[] produktuakKontagailua;
	private Stack<Double> pilaPrezioak = new Stack<>();
	private JPanel panel_laburpena; // Panel de resumen de compra
	private JTable taula;
	private DefaultTableModel table;
	private int produktuak_erosi = 0;
	private double bez = 0.00;
	private String[] izena;

	private String[] zbk;

	private double[] prezioa;

	private String[] mota;

	private String[] irudiak;

	private JTextField ordainketa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vending_makina frame = new vending_makina();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public vending_makina() {

		izena = metodoak.metodoak.get_izena(izena);

		zbk = metodoak.metodoak.get_zbk(zbk);

		prezioa = metodoak.metodoak.get_prezioa(prezioa);

		mota = metodoak.metodoak.get_mota(mota);

		irudiak = metodoak.metodoak.get_irudia(irudiak);

		produktuakKontagailua = new int[20];

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1200, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Administrazio kontsola irekutzeko botoia
		JButton admin_botoia = new JButton();
		admin_botoia.setBounds(10, 10, 80, 80);
		contentPane.add(admin_botoia);
		admin_botoia.setOpaque(false);
		admin_botoia.setContentAreaFilled(false);
		admin_botoia.setBorderPainted(false);
		admin_botoia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Erabiltzen den metodoa kontsola irekitzeko
				dispose();
				admin_kontsola.admin_console.vending_makina(izena, zbk, prezioa, mota, irudiak);

			}
		});

		// Taularen modeloa hasieratu
		table = new DefaultTableModel(new String[] { "IZENA", "KANTITATEA", "PREZIOA" }, 0);
		taula = new JTable(table);
		taula.getTableHeader().setReorderingAllowed(false); // Taulako goiburuak mugitzeko aukera desgaitu
		taula.setBounds(128, 250, 295, 141);
		contentPane.add(taula);

		// Izenak taulan ager daitezen
		JScrollPane produktu_panela = new JScrollPane(taula);
		produktu_panela.setVisible(false);
		produktu_panela.setBounds(774, 513, 400, 407);
		contentPane.add(produktu_panela);

		// Irudien TITULOA

		JLabel pakete_label = new JLabel("EDARIAK");
		pakete_label.setBounds(549, 75, 86, 14);
		pakete_label.setVisible(false);
		contentPane.add(pakete_label);

		JLabel edaria_label = new JLabel("PAKETEAK");
		edaria_label.setBounds(200, 75, 86, 14);
		edaria_label.setVisible(false);
		contentPane.add(edaria_label);

		JLabel snack_label = new JLabel("SNACK");
		snack_label.setBounds(200, 475, 86, 14);
		snack_label.setVisible(false);
		contentPane.add(snack_label);

		JLabel objetuak_label = new JLabel("OBJETUAK");
		objetuak_label.setBounds(549, 475, 86, 14);
		objetuak_label.setVisible(false);
		contentPane.add(objetuak_label);

		// Pakete Produktuaren irudia
		ImageIcon irudia_paketea = new ImageIcon(getClass().getResource("/img/paketeak.jpg"));

		// Botoia sortu eta irudia hartu
		JButton botoia_paketeak = new JButton(irudia_paketea);
		botoia_paketeak.setBounds(100, 100, 250, 250);

		// Botoiak hasieran ez ikusteko
		botoia_paketeak.setOpaque(false);
		botoia_paketeak.setContentAreaFilled(false);
		botoia_paketeak.setBorderPainted(false);
		botoia_paketeak.setVisible(false);

		// Botoia panelera gehitu
		contentPane.add(botoia_paketeak);

		// Edari Produktuaren irudia
		ImageIcon irudia_edariak = new ImageIcon(getClass().getResource("/img/edariak.jpg"));

		// Botoia sortu eta irudia hartu
		JButton botoia_edariak = new JButton(irudia_edariak);
		botoia_edariak.setBounds(450, 100, 250, 250);
		// Botoiak hasieran ez ikusteko

		botoia_edariak.setOpaque(false);
		botoia_edariak.setContentAreaFilled(false);
		botoia_edariak.setBorderPainted(false);
		botoia_edariak.setVisible(false);

		// Botoia panelera gehitu
		contentPane.add(botoia_edariak);

		// Snack Produktuaren irudia
		ImageIcon irudia_snack = new ImageIcon(getClass().getResource("/img/snack.jpg"));

		// Botoia sortu eta irudia hartu
		JButton botoia_snack = new JButton(irudia_snack);
		botoia_snack.setBounds(100, 500, 250, 250);
		// Botoiak hasieran ez ikusteko

		botoia_snack.setOpaque(false);
		botoia_snack.setContentAreaFilled(false);
		botoia_snack.setBorderPainted(false);
		botoia_snack.setVisible(false);

		// Botoia panelera gehitu
		contentPane.add(botoia_snack);

		// Objetuen Produktuaren irudia
		ImageIcon irudia_objetuak = new ImageIcon(getClass().getResource("/img/objetuak.jpg"));

		// Botoia sortu eta irudia hartu
		JButton botoia_objetuak = new JButton(irudia_objetuak);
		botoia_objetuak.setBounds(450, 500, 250, 250);
		// Botoiak hasieran ez ikusteko

		botoia_objetuak.setOpaque(false);
		botoia_objetuak.setContentAreaFilled(false);
		botoia_objetuak.setBorderPainted(false);
		botoia_objetuak.setVisible(false);

		// Botoia panelera gehitu
		contentPane.add(botoia_objetuak);

		panel_laburpena = new JPanel();
		panel_laburpena.setBounds(20, 10, 755, 800);
		panel_laburpena.setLayout(null);
		panel_laburpena.setVisible(false);
		contentPane.add(panel_laburpena);

		ordainketa = new JTextField();

		// Botoiak ordaintzeko
		ordainketa = new JTextField();

		JButton zbk0 = new JButton("0");

		JButton zbk1 = new JButton("1");

		JButton zbk2 = new JButton("2");

		JButton zbk3 = new JButton("3");

		JButton zbk4 = new JButton("4");

		JButton zbk5 = new JButton("5");

		JButton zbk6 = new JButton("6");

		JButton zbk7 = new JButton("7");

		JButton zbk8 = new JButton("8");

		JButton zbk9 = new JButton("9");

		JButton zbk_punto = new JButton(".");

		JButton zbk_enter = new JButton("OK");

		JButton zbk_atzera = new JButton("<---");

		// ============================PAKETEAREN
		// IRUDIAK/DATUAK===================================//

		JPanel panelPaketea = new JPanel(); // Paketeak erakusteko panela sortu
		panelPaketea.setLayout(null); // Panela diseinurik gabe
		panelPaketea.setPreferredSize(new Dimension(1000, 2500)); // Desplazamendua ahalbidetzeko espazioa egokitzea

		int paketeak_bakarrik = 0;

		for (int i = 0; i < 20; i++) {
			// Produktuak datuak dituen eta mota "1" edo "paketea" den egiaztatzen du
			if (izena[i] != null && zbk[i] != null && prezioa[i] > 0 && mota[i] != null && irudiak[i] != null) {

				// Mota "1" edo "paketea" denean bakarrik erakutsi
				if (mota[i].equals("1") || mota[i].equals("paketea")) {

					// Produktu ikusgarriak bakarrik kontuan hartuz, posizio dinamikoa kalkulatzen
					// dugu
					int zutabea = paketeak_bakarrik % 3; // Kolumna (0, 1, 2)
					int ilara = paketeak_bakarrik / 3; // Ilara (0, 1, 2, 3, ...)

					// Produktuaren osagaia sortu
					JLabel paketea = new JLabel();
					paketea.setBounds(105 + zutabea * 250, 100 + ilara * 300, 200, 200); // Posizio dinamikoa
					panelPaketea.add(paketea);

					// Irudia eguneratu, irudia_balidatu funtzioa erabiliz
					ImageIcon irudia = metodoak.metodoak.irudia_balidatu("/img/" + irudiak[i]); // Irudiaren
																								// existentzian
																								// egiaztatu
					paketea.setIcon(irudia); // Irudia ezarri

					// Etiketak gehitu (izen, kodea, prezioa)
					JLabel izenaLabel = new JLabel(izena[i]);
					izenaLabel.setBounds(105 + zutabea * 250, 35 + ilara * 300, 200, 35); // Posizio egokitua
					izenaLabel.setHorizontalAlignment(JLabel.CENTER); // Testua zentroan
					panelPaketea.add(izenaLabel);

					JLabel zbkLabel = new JLabel("Kodea: " + zbk[i]);
					zbkLabel.setBounds(105 + zutabea * 250, 40 + ilara * 300, 200, 55); // Posizio egokitua
					zbkLabel.setHorizontalAlignment(JLabel.CENTER); // Testua zentroan
					panelPaketea.add(zbkLabel);

					JLabel prezioaLabel = new JLabel("Prezioa: " + String.format("%.2f", prezioa[i]) + "€");
					prezioaLabel.setBounds(105 + zutabea * 250, 45 + ilara * 300, 200, 75); // Posizio egokitua
					prezioaLabel.setHorizontalAlignment(JLabel.CENTER); // Testua zentroan
					panelPaketea.add(prezioaLabel);

					JButton aukeratu_paketea = new JButton("aukeratu");
					aukeratu_paketea.setBounds(105 + zutabea * 250, 310 + ilara * 300, 200, 30);
					aukeratu_paketea.setVisible(true);
					panelPaketea.add(aukeratu_paketea);

					final int pakete_totala = i;

					aukeratu_paketea.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							produktuak_erosi++; // Produktuen kontagailua handitzen dugu
							ordaindu += prezioa[pakete_totala]; // Prezioa ordaindutako guztira gehitzen dugu
							bez = ordaindu * 1.21; // BEZ-a kalkulatzen dugu
							produktuakKontagailua[pakete_totala]++; // Produktuaren kantitatea handitzen dugu
							pilaPrezioak.push(prezioa[pakete_totala]); // Prezioa pilan gordetzen dugu

							// Produktuarekin fila berri bat taularen bukaeran gehitzen dugu
							DefaultTableModel model = (DefaultTableModel) taula.getModel();
							model.addRow(new String[] { izena[pakete_totala], "1",
									String.format("%.2f€", prezioa[pakete_totala]) });

							// Taula freskatu
							taula.repaint();
						}
					});

					// Ikusgarri dauden produktuen kontagailua handitzen dugu
					paketeak_bakarrik++;
				}
			}
		}

		// Panelaren altuera osoa adierazi
		int ilarak_paketeak = (int) Math.ceil(paketeak_bakarrik / (double) 3); // Kalkulatu
																				// beharrezko ilarak
		int altuera_paketeak = 100 + ilarak_paketeak * 200 + (ilarak_paketeak - 1) * 40; // Altuera
																							// guztira
																							// kalkulatu

		panelPaketea.setPreferredSize(new Dimension(1000, altuera_paketeak + 120)); // Ezarri panela tamaina egokiarekin

		// Panela JScrollPane batean gehitu, desplazamendua ahalbidetzeko
		JScrollPane scrollPanePaketeak = new JScrollPane(panelPaketea); // Panela ScrollPanel batean kokatu
		scrollPanePaketeak.setBounds(80, 80, 900, 350); // ScrollPane-ren tamaina definitzen (100x100 kokapena, 900px
														// zabala, 350px altuera)
		scrollPanePaketeak.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Ezin da mugitu
																									// horizontalean
		scrollPanePaketeak.setVisible(false); // ScrollPane ikusgai egin

		contentPane.add(scrollPanePaketeak); // Gehitu JScrollPane nagusira (contentPane)

// =======================================================================================//

// ============================EDARIAREN IRUDIAK/DATUAK===================================//

		// Panelaren konfigurazioa
		JPanel panelEdaria = new JPanel(); // Edariak erakusteko panela sortu
		panelEdaria.setLayout(null); // Panela diseinurik gabe
		panelEdaria.setPreferredSize(new Dimension(1000, 2500)); // Desplazamendua ahalbidetzeko espazioa egokitzea

		int edariak_bakarrik = 0; // Edariak kontatzeko aldagaia

		for (int i = 0; i < 20; i++) {
			// Produktuak datuak dituen eta mota "2" edo "edaria" den egiaztatzen du
			if (izena[i] != null && zbk[i] != null && prezioa[i] > 0 && mota[i] != null && irudiak[i] != null) {

				// Mota "2" edo "edaria" denean bakarrik erakutsi
				if (mota[i].equals("2") || mota[i].equals("edaria")) {

					// Produktu ikusgarriak bakarrik kontuan hartuz, posizio dinamikoa kalkulatzen
					// dugu
					int zutabea = edariak_bakarrik % 3; // Kolumna (0, 1, 2)
					int ilara = edariak_bakarrik / 3; // Ilara (0, 1, 2, 3, ...)

					// Produktuaren osagaia sortu
					JLabel edaria = new JLabel();
					edaria.setBounds(105 + zutabea * 250, 100 + ilara * 300, 200, 200); // Posizio dinamikoa
					panelEdaria.add(edaria);

					// Irudia eguneratu, irudia_balidatu funtzioa erabiliz
					ImageIcon irudia = metodoak.metodoak.irudia_balidatu("/img/" + irudiak[i]); // Irudiaren
																								// existentzian
																								// egiaztatu
					edaria.setIcon(irudia); // Irudia ezarri

					// Etiketak gehitu (izen, kodea, prezioa)
					JLabel izenaLabel = new JLabel(izena[i]);
					izenaLabel.setBounds(105 + zutabea * 250, 35 + ilara * 300, 200, 35); // Posizio egokitua
					izenaLabel.setHorizontalAlignment(JLabel.CENTER); // Testua zentroan
					panelEdaria.add(izenaLabel);

					JLabel zbkLabel = new JLabel("Kodea: " + zbk[i]);
					zbkLabel.setBounds(105 + zutabea * 250, 40 + ilara * 300, 200, 55); // Posizio egokitua
					zbkLabel.setHorizontalAlignment(JLabel.CENTER); // Testua zentroan
					panelEdaria.add(zbkLabel);

					JLabel prezioaLabel = new JLabel("Prezioa: " + String.format("%.2f", prezioa[i]) + "€");
					prezioaLabel.setBounds(105 + zutabea * 250, 45 + ilara * 300, 200, 75); // Posizio egokitua
					prezioaLabel.setHorizontalAlignment(JLabel.CENTER); // Testua zentroan
					panelEdaria.add(prezioaLabel);

					JButton aukeratu_edaria = new JButton("aukeratu");
					aukeratu_edaria.setBounds(105 + zutabea * 250, 310 + ilara * 300, 200, 30);
					aukeratu_edaria.setVisible(true);
					panelEdaria.add(aukeratu_edaria);

					final int edaria_totala = i; // Produkto jakin bat aukeratzen denean, edariaTotala erabili
					aukeratu_edaria.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							produktuak_erosi++; // Produktuen kontagailua handitzen dugu
							ordaindu += prezioa[edaria_totala]; // Prezioa ordaindutako guztira gehitzen dugu
							bez = ordaindu * 1.21; // BEZ-a kalkulatzen dugu
							produktuakKontagailua[edaria_totala]++; // Produktuaren kantitatea handitzen dugu
							pilaPrezioak.push(prezioa[edaria_totala]); // Prezioa pilan gordetzen dugu

							// Produktuarekin fila berri bat taularen bukaeran gehitzen dugu
							DefaultTableModel model = (DefaultTableModel) taula.getModel();
							model.addRow(new String[] { izena[edaria_totala], "1",
									String.format("%.2f€", prezioa[edaria_totala]) });

							// Taula freskatu
							taula.repaint();
						}
					});

					// Ikusgarri dauden produktuen kontagailua handitzen dugu
					edariak_bakarrik++;
				}
			}
		}

		// Panelaren altuera osoa adierazi
		int ilarak_edariak = (int) Math.ceil(edariak_bakarrik / (double) 3); // Kalkulatu
																				// beharrezko ilarak
		int altuera_edariak = 100 + ilarak_edariak * 200 + (ilarak_edariak - 1) * 40; // Altuera
																						// guztira
																						// kalkulatu

		panelEdaria.setPreferredSize(new Dimension(1000, altuera_edariak + 120)); // Ezarri panela tamaina egokiarekin

		// Panela JScrollPane batean gehitu, desplazamendua ahalbidetzeko
		JScrollPane scrollPaneEdariak = new JScrollPane(panelEdaria); // Panela ScrollPanel batean kokatu
		scrollPaneEdariak.setBounds(80, 80, 900, 350); // ScrollPane-ren tamaina definitzen (100x100 kokapena, 900px
														// zabala, 350px altuera)
		scrollPaneEdariak.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Ezin da mugitu
																								// horizontalean
		scrollPaneEdariak.setVisible(false); // ScrollPane ikusgai egin

		contentPane.add(scrollPaneEdariak); // Gehitu JScrollPane nagusira (contentPane)

// =======================================================================================//

		// ============================SNACK
		// IRUDIAK/DATUAK===================================//

		JPanel panelSnack = new JPanel(); // Paketeak erakusteko panela sortu
		panelSnack.setLayout(null); // Panela diseinurik gabe
		panelSnack.setPreferredSize(new Dimension(1000, 2500)); // Desplazamendua ahalbidetzeko espazioa egokitzea

		int snack_bakarrik = 0;

		for (int i = 0; i < 20; i++) {
			// Produktuak datuak dituen eta mota "3" edo "paketea" den egiaztatzen du
			if (izena[i] != null && zbk[i] != null && prezioa[i] > 0 && mota[i] != null && irudiak[i] != null) {

				// Mota "3" edo "snack" denean bakarrik erakutsi
				if (mota[i].equals("3") || mota[i].equals("snack")) {

					// Produktu ikusgarriak bakarrik kontuan hartuz, posizio dinamikoa kalkulatzen
					// dugu
					int zutabea = snack_bakarrik % 3; // Kolumna (0, 1, 2)
					int ilara = snack_bakarrik / 3; // Ilara (0, 1, 2, 3, ...)

					// Produktuaren osagaia sortu
					JLabel snack = new JLabel();
					snack.setBounds(105 + zutabea * 250, 100 + ilara * 300, 200, 200); // Posizio dinamikoa
					panelSnack.add(snack);

					// Irudia eguneratu, irudia_balidatu funtzioa erabiliz
					ImageIcon irudia = metodoak.metodoak.irudia_balidatu("/img/" + irudiak[i]); // Irudiaren
																								// existentzian
																								// egiaztatu
					snack.setIcon(irudia); // Irudia ezarri

					// Etiketak gehitu (izen, kodea, prezioa)
					JLabel izenaLabel = new JLabel(izena[i]);
					izenaLabel.setBounds(105 + zutabea * 250, 35 + ilara * 300, 200, 35); // Posizio egokitua
					izenaLabel.setHorizontalAlignment(JLabel.CENTER); // Testua zentroan
					panelSnack.add(izenaLabel);

					JLabel zbkLabel = new JLabel("Kodea: " + zbk[i]);
					zbkLabel.setBounds(105 + zutabea * 250, 40 + ilara * 300, 200, 55); // Posizio egokitua
					zbkLabel.setHorizontalAlignment(JLabel.CENTER); // Testua zentroan
					panelSnack.add(zbkLabel);

					JLabel prezioaLabel = new JLabel("Prezioa: " + String.format("%.2f", prezioa[i]) + "€");
					prezioaLabel.setBounds(105 + zutabea * 250, 45 + ilara * 300, 200, 75); // Posizio egokitua
					prezioaLabel.setHorizontalAlignment(JLabel.CENTER); // Testua zentroan
					panelSnack.add(prezioaLabel);

					JButton aukeratu_snack = new JButton("aukeratu");
					aukeratu_snack.setBounds(105 + zutabea * 250, 310 + ilara * 300, 200, 30);
					aukeratu_snack.setVisible(true);
					panelSnack.add(aukeratu_snack);

					final int snack_totala = i;

					aukeratu_snack.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							produktuak_erosi++; // Produktuen kontagailua handitzen dugu
							ordaindu += prezioa[snack_totala]; // Prezioa ordaindutako guztira gehitzen dugu
							bez = ordaindu * 1.21; // BEZ-a kalkulatzen dugu
							produktuakKontagailua[snack_totala]++; // Produktuaren kantitatea handitzen dugu
							pilaPrezioak.push(prezioa[snack_totala]); // Prezioa pilan gordetzen dugu

							// Produktuarekin fila berri bat taularen bukaeran gehitzen dugu
							DefaultTableModel model = (DefaultTableModel) taula.getModel();
							model.addRow(new String[] { izena[snack_totala], "1",
									String.format("%.2f€", prezioa[snack_totala]) });

							// Taula freskatu
							taula.repaint();
						}
					});
					// Ikusgarri dauden produktuen kontagailua handitzen dugu
					snack_bakarrik++;
				}
			}
		}

		// Panelaren altuera osoa adierazi
		int ilarak_snack = (int) Math.ceil(snack_bakarrik / (double) 3); // Kalkulatu
																			// beharrezko ilarak
		int altuera_snack = 100 + ilarak_snack * 200 + (ilarak_snack - 1) * 40; // Altuera
																				// guztira
																				// kalkulatu

		panelSnack.setPreferredSize(new Dimension(1000, altuera_snack + 120)); // Ezarri panela tamaina egokiarekin

		// Panela JScrollPane batean gehitu, desplazamendua ahalbidetzeko
		JScrollPane scrollPaneSnack = new JScrollPane(panelSnack); // Panela ScrollPanel batean kokatu
		scrollPaneSnack.setBounds(80, 80, 900, 350); // ScrollPane-ren tamaina definitzen (100x100 kokapena, 900px
														// zabala, 350px altuera)
		scrollPaneSnack.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Ezin da mugitu
																								// horizontalean
		scrollPaneSnack.setVisible(false); // ScrollPane ikusgai egin

		contentPane.add(scrollPaneSnack); // Gehitu JScrollPane nagusira (contentPane)

// =======================================================================================//

		// ============================OBJEKTUAREN
		// IRUDIAK/DATUAK===================================//

		JPanel panelObjetua = new JPanel(); // Objektuak erakusteko panela sortu
		panelObjetua.setLayout(null); // Panela diseinurik gabe
		panelObjetua.setPreferredSize(new Dimension(1000, 2500)); // Desplazamendua ahalbidetzeko espazioa egokitzea

		int objektuak_bakarrik = 0;

		for (int i = 0; i < 20; i++) {
			// Produktuak datuak dituen eta mota "4" edo "objetua" den egiaztatzen du
			if (izena[i] != null && zbk[i] != null && prezioa[i] > 0 && mota[i] != null && irudiak[i] != null) {

				// Mota "4" edo "objetua" denean bakarrik erakutsi
				if (mota[i].equals("4") || mota[i].equals("objetua")) {

					// Produktu ikusgarriak bakarrik kontuan hartuz, posizio dinamikoa kalkulatzen
					// dugu
					int zutabea = objektuak_bakarrik % 3; // Kolumna (0, 1, 2)
					int ilara = objektuak_bakarrik / 3; // Ilara (0, 1, 2, 3, ...)

					// Produktuaren osagaia sortu
					JLabel objektua = new JLabel();
					objektua.setBounds(105 + zutabea * 250, 100 + ilara * 300, 200, 200); // Posizio dinamikoa
					panelObjetua.add(objektua);

					// Irudia eguneratu, irudia_balidatu funtzioa erabiliz
					ImageIcon irudia = metodoak.metodoak.irudia_balidatu("/img/" + irudiak[i]); // Irudiaren
																								// existentzian
																								// egiaztatu
					objektua.setIcon(irudia); // Irudia ezarri

					// Etiketak gehitu (izen, kodea, prezioa)
					JLabel izenaLabel = new JLabel(izena[i]);
					izenaLabel.setBounds(105 + zutabea * 250, 35 + ilara * 300, 200, 35); // Posizio egokitua
					izenaLabel.setHorizontalAlignment(JLabel.CENTER); // Testua zentroan
					panelObjetua.add(izenaLabel);

					JLabel zbkLabel = new JLabel("Kodea: " + zbk[i]);
					zbkLabel.setBounds(105 + zutabea * 250, 40 + ilara * 300, 200, 55); // Posizio egokitua
					zbkLabel.setHorizontalAlignment(JLabel.CENTER); // Testua zentroan
					panelObjetua.add(zbkLabel);

					JLabel prezioaLabel = new JLabel("Prezioa: " + String.format("%.2f", prezioa[i]) + "€");
					prezioaLabel.setBounds(105 + zutabea * 250, 45 + ilara * 300, 200, 75); // Posizio egokitua
					prezioaLabel.setHorizontalAlignment(JLabel.CENTER); // Testua zentroan
					panelObjetua.add(prezioaLabel);

					JButton aukeratu_objektua = new JButton("aukeratu");
					aukeratu_objektua.setBounds(105 + zutabea * 250, 310 + ilara * 300, 200, 30);
					aukeratu_objektua.setVisible(true);
					panelObjetua.add(aukeratu_objektua);

					final int objetua_totala = i;

					aukeratu_objektua.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							produktuak_erosi++; // Produktuen kontagailua handitzen dugu
							ordaindu += prezioa[objetua_totala]; // Prezioa ordaindutako guztira gehitzen dugu
							bez = ordaindu * 1.21; // BEZ-a kalkulatzen dugu
							produktuakKontagailua[objetua_totala]++; // Produktuaren kantitatea handitzen dugu
							pilaPrezioak.push(prezioa[objetua_totala]); // Prezioa pilan gordetzen dugu

							// Produktuarekin fila berri bat taularen bukaeran gehitzen dugu
							DefaultTableModel model = (DefaultTableModel) taula.getModel();
							model.addRow(new String[] { izena[objetua_totala], "1",
									String.format("%.2f€", prezioa[objetua_totala]) });

							// Taula freskatu
							taula.repaint();
						}
					});
					// Ikusgarri dauden produktuen kontagailua handitzen dugu
					objektuak_bakarrik++;
				}
			}
		}

		// Panelaren altuera osoa adierazi
		int ilarak_objetuak = (int) Math.ceil(objektuak_bakarrik / (double) 3); // Kalkulatu
		// beharrezko ilarak
		int altuera_objetuak = 100 + ilarak_objetuak * 200 + (ilarak_objetuak - 1) * 40; // Altuera
		// guztira
		// kalkulatu

		panelObjetua.setPreferredSize(new Dimension(1000, altuera_objetuak + 120)); // Ezarri panela tamaina egokiarekin

		// Panela JScrollPane batean gehitu, desplazamendua ahalbidetzeko
		JScrollPane scrollPaneObjetuak = new JScrollPane(panelObjetua); // Panela ScrollPanel batean kokatu
		scrollPaneObjetuak.setBounds(80, 80, 900, 350); // ScrollPane-ren tamaina definitzen (100x100 kokapena, 900px
		// zabala, 350px altuera)
		scrollPaneObjetuak.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Ezin da mugitu
		// horizontalean
		scrollPaneObjetuak.setVisible(false); // ScrollPane ikusgai egin

		contentPane.add(scrollPaneObjetuak); // Gehitu JScrollPane nagusira (contentPane)

		// =======================================================================================//

		ongi_etorri = new JButton("ONGI ETORRI");
		ongi_etorri.setOpaque(false);
		ongi_etorri.setContentAreaFilled(false);
		ongi_etorri.setBorderPainted(false);
		ongi_etorri.setBounds(10, 11, 1164, 939);
		contentPane.add(ongi_etorri);

		// BOTOIAK SORTU
		JButton atzera_botoia = new JButton("ATZERA");
		atzera_botoia.setBounds(100, 870, 125, 50);
		atzera_botoia.setVisible(false);
		contentPane.add(atzera_botoia);

		JButton atzera_ongi_etorri_botoia = new JButton("ATZERA");
		atzera_ongi_etorri_botoia.setBounds(100, 870, 125, 50);
		atzera_ongi_etorri_botoia.setVisible(false);
		contentPane.add(atzera_ongi_etorri_botoia);

		JButton ordaindu_botoia = new JButton("ORDAINDU");
		ordaindu_botoia.setBounds(225, 870, 125, 50);
		ordaindu_botoia.setVisible(false);
		contentPane.add(ordaindu_botoia);

		JButton ordaindu_finala = new JButton("ORDAINDU");
		ordaindu_finala.setBounds(225, 870, 125, 50);
		ordaindu_finala.setVisible(false);
		contentPane.add(ordaindu_finala);

		JButton ezabatu_produktua = new JButton("Kendu Produktu Bat");
		ezabatu_produktua.setBounds(900, 457, 150, 50);
		contentPane.add(ezabatu_produktua);
		ezabatu_produktua.setVisible(false);

		// Produktua ezabatzean, botoiari entzungailu bat gehitzen diogu
		ezabatu_produktua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Aukeratutako produktua taulatik lortzen dugu
				int aukeratu = taula.getSelectedRow();

				// Egiaztatu produktu bat aukeratu dela eta pilaPrezioak ez dela hutsik
				if (aukeratu != -1 && !pilaPrezioak.isEmpty()) {
					// Egiaztatu produktu aukeratua taulako azkena den
					int azken_zutabea = taula.getRowCount() - 1;

					if (aukeratu == azken_zutabea) {
						// Azken prezioa pilaPrezioak pilatik ateratzen dugu
						double prezioa_ezabatua = pilaPrezioak.pop(); // Azken prezioa atera
						ordaindu -= prezioa_ezabatua; // Totala eguneratzen da
						bez -= prezioa_ezabatua * 1.21; // BEZ Totala eguneratzen dagoen

						// Produktuaren izena taulatik lortzen dugu
						String produktu_izena = (String) taula.getValueAt(aukeratu, 0);
						int produktua_taula = metodoak.metodoak.produktua_taulatik_ezabatu(produktu_izena, izena); // Produktuaren
																													// indizea
																													// lortzen
																													// dugu

						// Produktuaren kantitatea eguneratzen dugu
						if (produktua_taula >= 0) {
							produktuakKontagailua[produktua_taula]--; // Produktuaren kantitatea murriztu
						}

						// Produktua taulatik ezabatzen dugu
						table.removeRow(aukeratu);

						// Interfazea eguneratzen dugu laburpenaren aldetik

					} else {
						// Erabiltzaileari mezu bat erakusten diogu azken produktua ez bada
						JOptionPane.showMessageDialog(null, "Bakarrik azken produktua ezabatu daiteke.");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Aukeratu lehenengo ezabatu nahi duzun produktua");
				}
			}
		});

		// PAKETEAK IRUDIAREN BOTOIAREN ZEREGINA
		botoia_paketeak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atzera_ongi_etorri_botoia.setVisible(false);
				atzera_botoia.setVisible(true);

				scrollPanePaketeak.setVisible(true);

				edaria_label.setVisible(false);
				pakete_label.setVisible(false);
				snack_label.setVisible(false);
				objetuak_label.setVisible(false);

				botoia_paketeak.setVisible(false);
				botoia_edariak.setVisible(false);
				botoia_snack.setVisible(false);
				botoia_objetuak.setVisible(false);
			}
		});

		// EDARIAK IRUDIAREN BOTOIAREN ZEREGINA
		botoia_edariak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atzera_ongi_etorri_botoia.setVisible(false);
				atzera_botoia.setVisible(true);

				scrollPaneEdariak.setVisible(true);

				edaria_label.setVisible(false);
				pakete_label.setVisible(false);
				snack_label.setVisible(false);
				objetuak_label.setVisible(false);

				botoia_paketeak.setVisible(false);
				botoia_edariak.setVisible(false);
				botoia_snack.setVisible(false);
				botoia_objetuak.setVisible(false);

			}
		});
		// SNACK IRUDIAREN BOTOIAREN ZEREGINA
		botoia_snack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atzera_ongi_etorri_botoia.setVisible(false);
				atzera_botoia.setVisible(true);

				scrollPaneSnack.setVisible(true);

				edaria_label.setVisible(false);
				pakete_label.setVisible(false);
				snack_label.setVisible(false);
				objetuak_label.setVisible(false);

				botoia_paketeak.setVisible(false);
				botoia_edariak.setVisible(false);
				botoia_snack.setVisible(false);
				botoia_objetuak.setVisible(false);

			}
		});
		// OBJETUAK IRUDIAREN BOTOIAREN ZEREGINA
		botoia_objetuak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atzera_ongi_etorri_botoia.setVisible(false);
				atzera_botoia.setVisible(true);

				scrollPaneObjetuak.setVisible(true);

				edaria_label.setVisible(false);
				pakete_label.setVisible(false);
				snack_label.setVisible(false);
				objetuak_label.setVisible(false);

				botoia_paketeak.setVisible(false);
				botoia_edariak.setVisible(false);
				botoia_snack.setVisible(false);
				botoia_objetuak.setVisible(false);

			}
		});

		// Ongi etorri botoiaren zeregina definitu
		ongi_etorri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Elementu guztiak ikusgarri jarri
				ongi_etorri.setVisible(false);
				atzera_ongi_etorri_botoia.setVisible(true);
				edaria_label.setVisible(true);
				pakete_label.setVisible(true);
				snack_label.setVisible(true);
				objetuak_label.setVisible(true);

				botoia_paketeak.setVisible(true);
				botoia_edariak.setVisible(true);
				botoia_snack.setVisible(true);
				botoia_objetuak.setVisible(true);
				ordaindu_botoia.setVisible(true);
				ezabatu_produktua.setVisible(true);
				produktu_panela.setVisible(true);
				ezabatu_produktua.setVisible(true);
			}
		});

		// Ongi etorri botoiaren zeregina definitu
		atzera_ongi_etorri_botoia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Elementu guztiak eskutatu

				atzera_ongi_etorri_botoia.setVisible(false);
				ongi_etorri.setVisible(true);

				edaria_label.setVisible(false);
				pakete_label.setVisible(false);
				snack_label.setVisible(false);
				objetuak_label.setVisible(false);

				botoia_paketeak.setVisible(false);
				botoia_edariak.setVisible(false);
				botoia_snack.setVisible(false);
				botoia_objetuak.setVisible(false);

				ezabatu_produktua.setVisible(false);
				produktu_panela.setVisible(false);
				ordaindu_botoia.setVisible(false);
			}
		});

		// Atzera botoiaren zeregina definitu
		atzera_botoia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Atzera botoia ezkutatu eta hasierako elementuak berriro ikusi
				atzera_botoia.setVisible(false);
				atzera_ongi_etorri_botoia.setVisible(true);
				edaria_label.setVisible(true);
				pakete_label.setVisible(true);
				snack_label.setVisible(true);
				objetuak_label.setVisible(true);

				botoia_paketeak.setVisible(true);
				botoia_edariak.setVisible(true);
				botoia_snack.setVisible(true);
				botoia_objetuak.setVisible(true);

				scrollPanePaketeak.setVisible(false);
				scrollPaneEdariak.setVisible(false);
				scrollPaneSnack.setVisible(false);
				scrollPaneObjetuak.setVisible(false);
				panel_laburpena.setVisible(false);

				produktu_panela.setVisible(true);
				ezabatu_produktua.setVisible(true);
				ordaindu_finala.setVisible(false);
				ordaindu_botoia.setVisible(true);

				ordainketa.setVisible(false);

				zbk0.setVisible(false);

				zbk1.setVisible(false);

				zbk2.setVisible(false);

				zbk3.setVisible(false);

				zbk4.setVisible(false);

				zbk5.setVisible(false);

				zbk6.setVisible(false);

				zbk7.setVisible(false);

				zbk8.setVisible(false);

				zbk9.setVisible(false);

				zbk_punto.setVisible(false);

				zbk_enter.setVisible(false);

				zbk_atzera.setVisible(false);

			}
		});

		// Produktuak ordaintzeko botoiaren zeregina
		ordaindu_botoia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Atzera botoia ezkutatzea
				atzera_ongi_etorri_botoia.setVisible(false);

				// Produktuen etiketak ezkutatzea
				edaria_label.setVisible(false);
				pakete_label.setVisible(false);
				snack_label.setVisible(false);
				objetuak_label.setVisible(false);

				// Produktuen botoiak ezkutatzea
				botoia_paketeak.setVisible(false);
				botoia_edariak.setVisible(false);
				botoia_snack.setVisible(false);
				botoia_objetuak.setVisible(false);

				// Scroll-paneak ezkutatzea
				scrollPanePaketeak.setVisible(false);
				scrollPaneEdariak.setVisible(false);
				scrollPaneSnack.setVisible(false);
				scrollPaneObjetuak.setVisible(false);

				// Atzera botoia eta laburpena erakustea
				atzera_botoia.setVisible(true);
				metodoak.metodoak.erakutsi_laburpena(panel_laburpena, produktuakKontagailua, irudiak, izena, prezioa,
						ordaindu, bez);
				panel_laburpena.setVisible(true);

				// Produktu panela eta botoiak ezkutatzea
				produktu_panela.setVisible(false);
				ezabatu_produktua.setVisible(false);
				ordaindu_botoia.setVisible(false);
				ordaindu_finala.setVisible(true);
			}
		});

		// Ordainketa finalaren botoiaren zeregina
		ordaindu_finala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showOptionDialog(null, "Seguru ordaindu nahi duzula? ", "Ordainketa",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "BAI", "EZ" },
						"BAI"); // Aukera lehenetsia
				if (produktuak_erosi == 0 && confirm == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, "Ez duzu inolako produkturik aukeratu.", "Errorea",
							JOptionPane.ERROR_MESSAGE);
					dispose();
					main(null);
				}
				if (confirm == JOptionPane.YES_OPTION) {
					// Laburpena panela ezkutatzea
					panel_laburpena.setVisible(true);
					// Ordainketa testu-eremua eta botoiak erakustea
					ordainketa.setVisible(true);
					zbk0.setVisible(true);
					zbk1.setVisible(true);
					zbk2.setVisible(true);
					zbk3.setVisible(true);
					zbk4.setVisible(true);
					zbk5.setVisible(true);
					zbk6.setVisible(true);
					zbk7.setVisible(true);
					zbk8.setVisible(true);
					zbk9.setVisible(true);
					zbk_punto.setVisible(true);
					zbk_enter.setVisible(true);
					zbk_atzera.setVisible(true);
					ordaindu_finala.setVisible(false);
					atzera_botoia.setVisible(false);
				} else {
					dispose();
					main(null);
				}
			}
		});

		// Ordainketa testu-eremua eta botoiak hasieratzea
		ordainketa.setBounds(900, 460, 225, 35);
		contentPane.add(ordainketa);
		ordainketa.setColumns(10);

		// Botoi zenbakidunen kokapena eta ikusgarritasuna hasieratzea
		zbk0.setBounds(975, 785, 75, 75);
		contentPane.add(zbk0);
		zbk1.setBounds(900, 560, 75, 75);
		contentPane.add(zbk1);
		zbk2.setBounds(975, 560, 75, 75);
		contentPane.add(zbk2);
		zbk3.setBounds(1050, 560, 75, 75);
		contentPane.add(zbk3);
		zbk4.setBounds(900, 635, 75, 75);
		contentPane.add(zbk4);
		zbk5.setBounds(975, 635, 75, 75);
		contentPane.add(zbk5);
		zbk6.setBounds(1050, 635, 75, 75);
		contentPane.add(zbk6);
		zbk7.setBounds(900, 710, 75, 75);
		contentPane.add(zbk7);
		zbk8.setBounds(975, 710, 75, 75);
		contentPane.add(zbk8);
		zbk9.setBounds(1050, 710, 75, 75);
		contentPane.add(zbk9);
		zbk_punto.setBounds(900, 785, 75, 75);
		contentPane.add(zbk_punto);
		zbk_enter.setBounds(1050, 785, 75, 75);
		contentPane.add(zbk_enter);
		zbk_atzera.setBounds(900, 510, 225, 50);
		contentPane.add(zbk_atzera);

		// Ordainketa testu-eremua eta botoiak hasieran ezkutatzea
		ordainketa.setVisible(false);
		zbk0.setVisible(false);
		zbk1.setVisible(false);
		zbk2.setVisible(false);
		zbk3.setVisible(false);
		zbk4.setVisible(false);
		zbk5.setVisible(false);
		zbk6.setVisible(false);
		zbk7.setVisible(false);
		zbk8.setVisible(false);
		zbk9.setVisible(false);
		zbk_punto.setVisible(false);
		zbk_enter.setVisible(false);
		zbk_atzera.setVisible(false);

		// Zenbaki eta koma botoientzako ActionListener-a
		ActionListener action_zenbakia = e -> {
			JButton botoia_zbk = (JButton) e.getSource();
			String testua = ordainketa.getText();
			ordainketa.setText(testua + botoia_zbk.getText());
		};

		// ActionListener-a botoi zenbakidun eta koma bakoitzari esleitzea
		zbk0.addActionListener(action_zenbakia);
		zbk1.addActionListener(action_zenbakia);
		zbk2.addActionListener(action_zenbakia);
		zbk3.addActionListener(action_zenbakia);
		zbk4.addActionListener(action_zenbakia);
		zbk5.addActionListener(action_zenbakia);
		zbk6.addActionListener(action_zenbakia);
		zbk7.addActionListener(action_zenbakia);
		zbk8.addActionListener(action_zenbakia);
		zbk9.addActionListener(action_zenbakia);
		zbk_punto.addActionListener(action_zenbakia);

		// Atzera botoirako ActionListener-a (zbk_atzera)
		zbk_atzera.addActionListener(_ -> {
			String testua = ordainketa.getText();
			if (!testua.isEmpty()) {
				ordainketa.setText(testua.substring(0, testua.length() - 1));
			}
		});

		// Konfirmazio botoirako ActionListener-a (zbk_enter)
		zbk_enter.addActionListener(_ -> {
			try {
				// Sartutako diru-kantitatea jasotzea
				String dirua = ordainketa.getText();
				int ordaindubeharrekoa = (int) Math.round(Double.parseDouble(dirua) * 100);
				int bueltak = ordaindubeharrekoa - (int) Math.round(ordaindu * 121); // Zentimoekin lan egitea

				// Billete eta txanpon kopurua zenbatzeko aldagaien hasieraketa
				int billete200 = 0, billete100 = 0, billete50 = 0, billete20 = 0, billete10 = 0, billete5 = 0;
				int txanpon200 = 0, txanpon100 = 0, txanpon50 = 0, txanpon20 = 0, txanpon10 = 0, txanpon5 = 0,
						txanpon2 = 0, txanpon1 = 0;

				if (bueltak >= 0) { // Itzuli behar den dirua positiboa bada
					// Bueltako dirua osatzeko billete eta txanpon kopurua kalkulatzea
					while (bueltak >= 20000) {
						billete200++;
						bueltak -= 20000;
					}
					while (bueltak >= 10000) {
						billete100++;
						bueltak -= 10000;
					}
					while (bueltak >= 5000) {
						billete50++;
						bueltak -= 5000;
					}
					while (bueltak >= 2000) {
						billete20++;
						bueltak -= 2000;
					}
					while (bueltak >= 1000) {
						billete10++;
						bueltak -= 1000;
					}
					while (bueltak >= 500) {
						billete5++;
						bueltak -= 500;
					}
					while (bueltak >= 200) {
						txanpon200++;
						bueltak -= 200;
					}
					while (bueltak >= 100) {
						txanpon100++;
						bueltak -= 100;
					}
					while (bueltak >= 50) {
						txanpon50++;
						bueltak -= 50;
					}
					while (bueltak >= 20) {
						txanpon20++;
						bueltak -= 20;
					}
					while (bueltak >= 10) {
						txanpon10++;
						bueltak -= 10;
					}
					while (bueltak >= 5) {
						txanpon5++;
						bueltak -= 5;
					}
					while (bueltak >= 2) {
						txanpon2++;
						bueltak -= 2;
					}
					while (bueltak >= 1) {
						txanpon1++;
						bueltak -= 1;
					}

					// Guztizkoa eurotan bi dezimalekin formatzea
					String total = String.format("%.2f",
							(ordaindubeharrekoa - (int) Math.round(ordaindu * 121)) / 100.0);

					// Billete eta txanponen banaketa erakusteko mezua sortzea
					String mezua = "Bueltak: " + total + "€\n";
					if (billete200 > 0)
						mezua += "200€ billeteak: " + billete200 + "\n";
					if (billete100 > 0)
						mezua += "100€ billeteak: " + billete100 + "\n";
					if (billete50 > 0)
						mezua += "50€ billeteak: " + billete50 + "\n";
					if (billete20 > 0)
						mezua += "20€ billeteak: " + billete20 + "\n";
					if (billete10 > 0)
						mezua += "10€ billeteak: " + billete10 + "\n";
					if (billete5 > 0)
						mezua += "5€ billeteak: " + billete5 + "\n";
					if (txanpon200 > 0)
						mezua += "2€ txanponak: " + txanpon200 + "\n";
					if (txanpon100 > 0)
						mezua += "1€ txanponak: " + txanpon100 + "\n";
					if (txanpon50 > 0)
						mezua += "0.50€ txanponak: " + txanpon50 + "\n";
					if (txanpon20 > 0)
						mezua += "0.20€ txanponak: " + txanpon20 + "\n";
					if (txanpon10 > 0)
						mezua += "0.10€ txanponak: " + txanpon10 + "\n";
					if (txanpon5 > 0)
						mezua += "0.05€ txanponak: " + txanpon5 + "\n";
					if (txanpon2 > 0)
						mezua += "0.02€ txanponak: " + txanpon2 + "\n";
					if (txanpon1 > 0)
						mezua += "0.01€ txanponak: " + txanpon1 + "\n";

					// Bueltako diruaren mezua erakustea
					JPanel panel = new JPanel();
					JTextArea bueltak_mezua = new JTextArea(mezua); // mezua multilinea erabiliz erakusten da
					bueltak_mezua.setEditable(false); // Ezin da aldatu testua
					bueltak_mezua.setOpaque(false); // gardena
					bueltak_mezua.setLineWrap(true); // Lerroaren bukaeran automatikoki sartzen du saltoak
					bueltak_mezua.setWrapStyleWord(true); // Hitz osoetan mozten du, lerroaren bukaeran

					// Textuaren edukian oinarritutako neurria ezartzea
					bueltak_mezua.setColumns(15); // Lerro bakoitzeko karaktere kopurua (murriztua)
					bueltak_mezua.setRows(Math.min(mezua.split("\n").length, 10)); // Gehienez 10 lerro, edo edukia
																					// gutxiago
																					// bada, horren arabera
					bueltak_mezua.setPreferredSize(new Dimension(200, bueltak_mezua.getPreferredSize().height)); // Zabalera
					// finkoa,
					// murriztua

					// JTextArea-a JScrollPane batean sartzea (testua oso luzea bada, desplazamendua
					// gehitzen da)
					JScrollPane bueltak_ikusi = new JScrollPane(bueltak_mezua);
					bueltak_ikusi.setBorder(null); // Mugak kentzeko
					bueltak_ikusi.setPreferredSize(
							new Dimension(200, Math.min(200, bueltak_mezua.getPreferredSize().height))); // Gehienez
																											// 200px
																											// altuera
																											// eta
																											// zabalera
																											// txikia

					panel.add(bueltak_ikusi);

					// Onartu botoi pertsonalizatu bat sortzea
					int result = JOptionPane.showOptionDialog(null, panel, "Bueltak", JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null, new String[] { "Onartu" }, // Botoiaren izena
							"Onartu");

					if (result == JOptionPane.OK_OPTION) {
						// Itxi leioa
						JOptionPane.showMessageDialog(null, "Hasierara bueltatzen...");

						// Atzeko hildoa sortu atzerapena sartu ahal izateko
						new Thread(new Runnable() {
							@Override
							public void run() {
								try {
									contentPane.setVisible(false); // Ikusten den guztia kendu
									// 10 segundo itxaron (10.000 milisegundo)
									Thread.sleep(10000);
									dispose();
									// Atzerapenaren ondoren main metodoa deitu
									main(null);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						}).start(); // Hildoa hasieratu

					}

				} else {
					// Ordainketa osatzeko falta den dirua erakustea
					JOptionPane.showMessageDialog(null,
							String.format("%.2f", -bueltak / 100.0) + "€ falta zaizkizu ordainketa amaitzeko",
							"Errorea", JOptionPane.ERROR_MESSAGE);
				}

			} catch (NumberFormatException ex) {
				// Zenbakia parseatu ezin bada, errore mezua erakustea
				JOptionPane.showMessageDialog(null, "Sartu balio egoki bat ordainketarako", "Errorea",
						JOptionPane.ERROR_MESSAGE);
			}
		});

	}
}