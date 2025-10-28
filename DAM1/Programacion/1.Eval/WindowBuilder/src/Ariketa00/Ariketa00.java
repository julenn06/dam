package Ariketa00;

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

public class Ariketa00 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel PanelNagusia;
	private JTextField txtHey;
	private boolean isHey = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ariketa00 frame = new Ariketa00();
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
	public Ariketa00() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		PanelNagusia = new JPanel();
		PanelNagusia.setBackground(new Color(128, 128, 192));
		PanelNagusia.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(PanelNagusia);
		PanelNagusia.setLayout(null);

		JButton btnAldatu = new JButton("Testua aldatu");
		btnAldatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (isHey) {
					txtHey.setText("Kaixo mundua!");
				} else {
					txtHey.setText("Hey!");
				}
				isHey = !isHey;
			}
		});

		btnAldatu.setBounds(73, 81, 113, 23);
		btnAldatu.setVerticalAlignment(SwingConstants.BOTTOM);
		PanelNagusia.add(btnAldatu);

		txtHey = new JTextField();
		txtHey.setHorizontalAlignment(SwingConstants.CENTER);
		txtHey.setText("Hey!");
		txtHey.setBackground(new Color(255, 128, 255));
		txtHey.setBounds(236, 83, 113, 20);
		PanelNagusia.add(txtHey);
		txtHey.setColumns(10);
	}
}