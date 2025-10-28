package bista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DAO.AgentziaDAO;

public class Ongietorri extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField erabiltzaileField;
	private JPasswordField passwordField;

	

	


	/*public void setConnection(Connection konexioa1) {
		this.konexioa = (ConnectDB) konexioa1;
	}*/

	/**
	 * Create the frame.
	 */

	public Ongietorri() {

		setTitle("Bidaiatu!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		erabiltzaileField = new JTextField();
		erabiltzaileField.setHorizontalAlignment(SwingConstants.CENTER);
		erabiltzaileField.setBounds(177, 123, 203, 20);
		contentPane.add(erabiltzaileField);
		erabiltzaileField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(177, 175, 203, 20);
		contentPane.add(passwordField);
			
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setEnabled(false);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\in1dm3-d\\Downloads\\Screenshot 2025-01-24 at 09-29-22 como-sera-el-avion-del-futuro.jpg (Imagen JPEG 1344 × 896 píxeles).png"));
		btnNewButton.setBounds(0, 0, 546, 87);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\in1dm3-d\\Downloads\\Screenshot 2025-01-24 at 09-29-41 como-sera-el-avion-del-futuro.jpg (Imagen JPEG 1344 × 896 píxeles).png"));
		btnNewButton_1.setBounds(0, 259, 546, 87);
		contentPane.add(btnNewButton_1);
		
		JLabel erabiltzaileLabel = new JLabel("Erabiltzaile");
		erabiltzaileLabel.setHorizontalAlignment(SwingConstants.CENTER);
		erabiltzaileLabel.setBounds(231, 98, 86, 14);
		contentPane.add(erabiltzaileLabel);
		
		JLabel pasahitzaLabel = new JLabel("Pasahitza");
		pasahitzaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pasahitzaLabel.setBounds(231, 154, 86, 14);
		contentPane.add(pasahitzaLabel);
		

		
		//Sartu botoia
		
			JButton sartuButton = new JButton("SARTU");
			sartuButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					

					String erabiltzaile = erabiltzaileField.getText();
					String pasahitza = new String(passwordField.getPassword());
					
					AgentziaDAO agentziaDAO = new AgentziaDAO();
					

					try {
					if (agentziaDAO.lortuErabiltzailea(erabiltzaile).equals(erabiltzaile)) {
						JOptionPane.showInputDialog(erabiltzaile, "FUNCIONA");
					}
					} catch (Exception w) {
						JOptionPane.showMessageDialog(erabiltzaileField, "Erabiltzailea ez dago erregistratuta");
					}
					
					try {
						if (agentziaDAO.lortuPasahitza(erabiltzaile).equals(pasahitza)) {
							JOptionPane.showInputDialog(pasahitza, "FUNCIONA");
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										Erresuma frame = new Erresuma(erabiltzaile);
										frame.setVisible(true);
									} catch (Exception e) {
										e.printStackTrace();
									}
									
									dispose();
								}
							});
						}
					} catch (Exception w) {
						JOptionPane.showMessageDialog(erabiltzaileField, "Pasahitza okerra da");
					}
					
				}
				
			});
			sartuButton.setBounds(142, 226, 123, 23);
			contentPane.add(sartuButton);
				
			
		
		//Erregistratu botoia
			
			JButton erregistratuButton = new JButton("ERREGISTRATU");
			erregistratuButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								Erregistratu frame = new Erregistratu();
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					
					dispose();
				}
			});
			erregistratuButton.setBounds(287, 226, 123, 23);
			contentPane.add(erregistratuButton);
	}
			}
