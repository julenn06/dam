package Ariketa03;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Ariketa03 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField izena;
	private JTextField abizena1;
	private JTextField abizena2;
	private JTextField adina;
	private JTextField NANedoAIZ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ariketa03 frame = new Ariketa03();
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
	public Ariketa03() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Izena");
		lblNewLabel.setBounds(128, 15, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel IblNewLabel1 = new JLabel("1. Abizena");
		IblNewLabel1.setBounds(128, 62, 63, 14);
		contentPane.add(IblNewLabel1);

		JLabel IblNewLabel2 = new JLabel("2. Abizena");
		IblNewLabel2.setBounds(128, 112, 63, 14);
		contentPane.add(IblNewLabel2);

		JLabel lblNewLabel_1 = new JLabel("Adina");
		lblNewLabel_1.setBounds(128, 168, 46, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("NAN/AIZ");
		lblNewLabel_2.setBounds(128, 224, 46, 14);
		contentPane.add(lblNewLabel_2);

		izena = new JTextField();
		izena.setBounds(128, 31, 86, 20);
		contentPane.add(izena);
		izena.setColumns(10);

		abizena1 = new JTextField();
		abizena1.setBounds(128, 81, 86, 20);
		contentPane.add(abizena1);
		abizena1.setColumns(10);

		abizena2 = new JTextField();
		abizena2.setBounds(128, 137, 86, 20);
		contentPane.add(abizena2);
		abizena2.setColumns(10);

		adina = new JTextField();
		adina.setBounds(128, 193, 86, 20);
		contentPane.add(adina);
		adina.setColumns(10);

		NANedoAIZ = new JTextField();
		NANedoAIZ.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int aux = e.getKeyChar();
				boolean zenbakia = aux >= 48 && aux <= 57 || aux >= 65 && aux <= 90 || aux >= 97 && aux <= 122;
				if (!zenbakia) {
					e.consume();
				}
			}
		});
		NANedoAIZ.setBounds(128, 270, 86, 20);
		contentPane.add(NANedoAIZ);
		NANedoAIZ.setColumns(10);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(128, 249, 86, 22);
		contentPane.add(comboBox);

		JButton botoia = new JButton("Jarraitu");
		botoia.setBounds(334, 192, 89, 23);
		contentPane.add(botoia);
		comboBox.addItem("");
		comboBox.addItem("NAN");
		comboBox.addItem("AIZ");

		botoia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Verifica si el NAN tiene una longitud de 9 caracteres
				if (NANedoAIZ.getText().length() != 9) {
					JOptionPane.showMessageDialog(null, "NAN okerra, sartu berriro");
					NANedoAIZ.setText(""); // Limpia el campo de NAN
					return; // Sale del método si el NAN es incorrecto
				}

				String zenbakia = NANedoAIZ.getText().substring(0, 8); // Obtiene los primeros 8 dígitos del NAN
				int zbk = Integer.parseInt(zenbakia); // Convierte a entero
				int hondarra = zbk % 23; // Calcula el resto

				// Array de letras para validar el NAN
				String[] letrak = { "T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q",
						"V", "H", "L", "C", "K", "E" };

				char emaitza = letrak[hondarra].charAt(0); // Obtiene la letra correspondiente de los numeros del NAN

				// Verifica si la letra del NAN es correcta y si el número de teléfono tiene 9
				// dígitos
				if (NANedoAIZ.getText().charAt(8) != emaitza) {
					JOptionPane.showMessageDialog(null, "Datu bat edo gehiago txarto daude. Berrido idatzi");
				}
			}
		});
	}
}