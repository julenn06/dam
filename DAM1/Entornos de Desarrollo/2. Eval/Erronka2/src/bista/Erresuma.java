package bista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import DAO.AgentziaDAO;
import DAO.BidaiaDAO;
import DAO.ZerbitzuakDAO;
import Konexioa.ConnectDB;
import modeloa.Bidaia;
import modeloa.Zerbitzua;
import modeloa.Kudeatzaile;

public class Erresuma extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable bidaiaTable;
	private JTable zerbitzuTable;
	private String IDLerroaZ = "";
	private String IDtaula = "";
	private String IDLerroa = "";

	ArrayList<Bidaia> bidaiak;
	BidaiaDAO bidaiaDAO = new BidaiaDAO();
	ZerbitzuakDAO zerbitzuakDAO = new ZerbitzuakDAO();
	AgentziaDAO agentziaDAO = new AgentziaDAO();
	ConnectDB konexioa = new ConnectDB();

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("serial")
	public Erresuma(String erabiltzaile) {
		setTitle("Erresuma");
		int erabiltzailezbk = agentziaDAO.lortuID(erabiltzaile);

		bidaiak = bidaiaDAO.lortuBidaiAgentzia(erabiltzailezbk);

		for (Bidaia bidaia : bidaiak) {
			System.out.println("Bidaia Kodea: " + bidaia.getIdentifikatzailea());
			System.out.println("Bidaia Izena: " + bidaia.getIzena());
			System.out.println("Data Amaiera: " + bidaia.getDataAmaiera());
			System.out.println("Data Irteera: " + bidaia.getDataIrteera());
			System.out.println("Iraupena: " + bidaia.getIraupena());
			System.out.println("Kod Herrialdea: " + bidaia.getHelmuga());
			System.out.println("Izena Agentzia: " + bidaia.getAgentzia());
			System.out.println("-------------");

			bidaia.setZerbitzuak(zerbitzuakDAO.lortuZerbitzuBidaia(bidaia.getIdentifikatzailea()));

		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1546, 947);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton logoButton = new JButton("LOGO");
		logoButton.setBounds(370, 11, 755, 202);
		contentPane.add(logoButton);

		DefaultTableModel model = new DefaultTableModel(new Object[][] {}, // No se pasan filas aquí
				new String[] { "ID", "Izena", "Deskribapena", "Irteera", "Amaiera", "Bidaia Mota", "Iraupena",
						"Herrialdea" }) {
			boolean[] columnEditables = new boolean[] { false, true, true, true, true, true, false, false };

			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};

		// Crear la tabla y asignarle el modelo
		bidaiaTable = new JTable(model);

		// Modificar el encabezado
		JTableHeader header = bidaiaTable.getTableHeader();
		header.setBackground(Color.LIGHT_GRAY); // Color del encabezado
		header.setForeground(Color.BLACK); // Color del texto del encabezado

		// Configurar el tamaño de las columnas (puedes ajustarlo si lo necesitas)
		bidaiaTable.getColumnModel().getColumn(2).setPreferredWidth(93);
		bidaiaTable.setBounds(122, 261, 1115, 177);

		// Agregar la tabla al panel
		JScrollPane scrollPane = new JScrollPane(bidaiaTable);
		scrollPane.setBounds(122, 261, 1115, 177);
		contentPane.add(scrollPane);

		// Errenkadad bete
		for (Bidaia bidaia : bidaiak) {
			String[] row = { String.valueOf(bidaia.getIdentifikatzailea()), bidaia.getIzena(), bidaia.getDeskribapena(),
					bidaia.getDataIrteera(), bidaia.getDataAmaiera(), bidaia.getBidaiaMota(),
					String.valueOf(bidaia.getIraupena()), // Convertir la duración a String
					bidaia.getHelmuga()

			};

			// Obtener el DefaultTableModel y agregar la fila
			model.addRow(row); // Usamos addRow del DefaultTableModel
		}

		bidaiaTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = bidaiaTable.getSelectedRow();
				if (row != -1) {
					IDLerroa = (String) bidaiaTable.getValueAt(row, 0);

					Bidaia selectedBidaia = null;
					for (Bidaia bidaia : bidaiak) {
						if (bidaia.getIdentifikatzailea().equals(IDLerroa)) {
							selectedBidaia = bidaia;
							break;
						}
					}

					if (selectedBidaia != null) {
						updateZerbitzuTable(selectedBidaia.getZerbitzuak());
					}
				}

				System.out.println(bidaiak.get(bidaiaTable.getSelectedRow()).getIdentifikatzailea());
			}

		});

		zerbitzuTable = new JTable();
		zerbitzuTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID Zerbitzual", "Zerbitzu Mota", "Izena", "Data", "Prezioa" }));
		zerbitzuTable.getColumnModel().getColumn(1).setPreferredWidth(91);
		zerbitzuTable.setBounds(122, 495, 1115, 177);
		contentPane.add(zerbitzuTable);

		JButton ezabatuBButton = new JButton("EZABATU");
		ezabatuBButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				bidaiaDAO.ezabatuBidaiDB(bidaiak.get(bidaiaTable.getSelectedRow()).getIdentifikatzailea());

				bidaiak = Kudeatzaile.ezabatuBidaia(bidaiaTable, bidaiak);
				for (Bidaia bidaia : bidaiak) {
					System.out.println("Bidaia Kodea: " + bidaia.getIdentifikatzailea());
					System.out.println("Bidaia Izena: " + bidaia.getIzena());
					System.out.println("Data Amaiera: " + bidaia.getDataAmaiera());
					System.out.println("Data Irteera: " + bidaia.getDataIrteera());
					System.out.println("Iraupena: " + bidaia.getIraupena());
					System.out.println("Kod Herrialdea: " + bidaia.getHelmuga());
					System.out.println("Izena Agentzia: " + bidaia.getAgentzia());
					System.out.println("-------------");
				}

				bidaiaTable.repaint();
			}
		});
		ezabatuBButton.setBounds(1294, 320, 129, 48);
		contentPane.add(ezabatuBButton);

		zerbitzuTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = zerbitzuTable.getSelectedRow();
				if (row != -1) {
					IDLerroaZ = (String) zerbitzuTable.getValueAt(row, 0);
					IDtaula = (String) zerbitzuTable.getValueAt(row, 1);

				}

			}

		});

		JButton ezabatuZButton = new JButton("EZABATU");
		ezabatuZButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				zerbitzuakDAO.ezabatuZerbitzua(IDtaula, IDLerroaZ);

			}
		});
		ezabatuZButton.setBounds(1294, 554, 129, 48);
		contentPane.add(ezabatuZButton);

		JButton irtenButton = new JButton("IRTEN");
		irtenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Ongietorri frame = new Ongietorri();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

				dispose();
			}
		});
		irtenButton.setBounds(563, 759, 182, 106);
		contentPane.add(irtenButton);

		JButton gordeButton = new JButton("GORDE");
		gordeButton.setBounds(805, 759, 182, 106);
		contentPane.add(gordeButton);

		JButton gehituBButton = new JButton("GEHITU");
		gehituBButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							BidaiBerria frame = new BidaiBerria(erabiltzailezbk, bidaiak);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

			}
		});
		gehituBButton.setBounds(1294, 379, 129, 48);
		contentPane.add(gehituBButton);

		JButton gehituZButton = new JButton("GEHITU");
		gehituZButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ZerbitzuBerria frame = new ZerbitzuBerria(erabiltzailezbk, bidaiak, IDLerroa);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

			}
		});
		gehituZButton.setBounds(1294, 613, 129, 48);
		contentPane.add(gehituZButton);

	}

	// REVISAR LOCALIZACIÓN DEL MÉTODO
	private void updateZerbitzuTable(ArrayList<Zerbitzua> zerbitzuak) {

		DefaultTableModel zerbitzuModel = (DefaultTableModel) zerbitzuTable.getModel();

		zerbitzuModel.setRowCount(0);

		for (Zerbitzua zerbitzua : zerbitzuak) {

			if (zerbitzua.getOstatuKodea() > 0) {
				String[] row = { String.valueOf(zerbitzua.getOstatuKodea()), "Ostatua", zerbitzua.getIzenaOstatua(),
						String.valueOf(zerbitzua.getPrezioaOstatua()), zerbitzua.getSarreraEguna(), };
				zerbitzuModel.addRow(row);
			} else if (zerbitzua.getIDJoanEtorri() > 0) {
				String[] row = { String.valueOf(zerbitzua.getIDJoanEtorri()), "Hegaldia (Buelta)",
						zerbitzua.getHegaldiKodeaBuelta(), zerbitzua.getIrteeraData(), };
				zerbitzuModel.addRow(row);

			} else if (zerbitzua.getHegaldia() > 0) {
				String[] row = { String.valueOf(zerbitzua.getHegaldia()), "Hegaldia", zerbitzua.getHegaldiKodea(),
						String.valueOf(zerbitzua.getPrezioaHegaldia()), zerbitzua.getIrteeraData(), };
				zerbitzuModel.addRow(row);

			} else if (zerbitzua.getBesteKodea() > 0) {
				String[] row = { String.valueOf(zerbitzua.getBesteKodea()), "Beste Zerbitzuak",
						zerbitzua.getBesteZerbitzuak(), String.valueOf(zerbitzua.getPrezioaBesteZerbitzuak()),
						zerbitzua.getDataBesteZerbitzua(), };
				zerbitzuModel.addRow(row);
			}
		}
	}
}
