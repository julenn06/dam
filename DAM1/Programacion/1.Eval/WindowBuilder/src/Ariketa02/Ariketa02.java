package Ariketa02;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Ariketa02 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ariketa02 frame = new Ariketa02();
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
	public Ariketa02() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JRadioButton aukera1 = new JRadioButton("Fortnite", false);
		aukera1.setBounds(124, 70, 109, 23);
		contentPane.add(aukera1);

		JRadioButton aukera2 = new JRadioButton("Black Ops III", false);
		aukera2.setBounds(124, 96, 109, 23);
		contentPane.add(aukera2);

		JRadioButton aukera3 = new JRadioButton("Uncharted 5", false);
		aukera3.setBounds(124, 122, 109, 23);
		contentPane.add(aukera3);

		JRadioButton aukera4 = new JRadioButton("Gran Turismo 6", false);
		aukera4.setBounds(124, 148, 146, 23);
		contentPane.add(aukera4);

		JLabel lblNewLabel = new JLabel("Zein da bideojokorik hoberena?");
		lblNewLabel.setBounds(124, 49, 176, 14);
		contentPane.add(lblNewLabel);

		JLabel emaitza = new JLabel("");
		emaitza.setBounds(153, 194, 46, 14);
		contentPane.add(emaitza);

		ButtonGroup talde1 = new ButtonGroup();
		talde1.add(aukera1);
		talde1.add(aukera2);
		talde1.add(aukera3);
		talde1.add(aukera4);

		aukera1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (aukera1.isSelected()) {
					JOptionPane.showMessageDialog(null, "aukeratu duzu: Fortnite");
				}
			}
		});
		aukera2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (aukera2.isSelected()) {
					JOptionPane.showMessageDialog(null, "aukeratu duzu: Black Ops III");
				}
			}
		});
		aukera3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (aukera3.isSelected()) {
					JOptionPane.showMessageDialog(null, "aukeratu duzu: Uncharted 5");
				}
			}
		});
		aukera4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (aukera4.isSelected()) {
					JOptionPane.showMessageDialog(null, "aukeratu duzu: Gran Turismo 6");
				}
			}
		});
	}
}