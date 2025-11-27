package Ariketa01;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Ariketa01 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel PanelNagusia;
	private JTextField txtErabiltzailea;
	private boolean isadmin = true;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtPasahitza;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ariketa01 frame = new Ariketa01();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ariketa01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		PanelNagusia = new JPanel();
		PanelNagusia.setBackground(new Color(128, 128, 192));
		PanelNagusia.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(PanelNagusia);
		PanelNagusia.setLayout(null);

		txtErabiltzailea = new JTextField();
		txtErabiltzailea.setHorizontalAlignment(SwingConstants.CENTER);
		txtErabiltzailea.setBackground(new Color(255, 128, 255));
		txtErabiltzailea.setBounds(28, 50, 113, 20);
		PanelNagusia.add(txtErabiltzailea);
		txtErabiltzailea.setColumns(10);

		lblNewLabel = new JLabel("Erabiltzailea");
		lblNewLabel.setBounds(54, 25, 57, 14);
		PanelNagusia.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Pasahitza");
		lblNewLabel_1.setBounds(54, 149, 46, 14);
		PanelNagusia.add(lblNewLabel_1);

		txtPasahitza = new JTextField();
		txtPasahitza.setBounds(28, 174, 113, 20);
		PanelNagusia.add(txtPasahitza);
		txtPasahitza.setColumns(10);

		JButton BotonAldatu = new JButton("Jarraitu");
		BotonAldatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (String.valueOf(txtErabiltzailea.getText()).compareTo("admin") == 0
						&& (String.valueOf(txtPasahitza.getText()).compareTo("admin") == 0)) {
					JOptionPane.showMessageDialog(null, "ONGI ETORRI");

				} else {
					JOptionPane.showMessageDialog(null, "Datu Okerrak");
				}
				isadmin = !isadmin;
			}
		});

		BotonAldatu.setBounds(259, 106, 113, 23);
		BotonAldatu.setVerticalAlignment(SwingConstants.BOTTOM);
		PanelNagusia.add(BotonAldatu);
	}

}