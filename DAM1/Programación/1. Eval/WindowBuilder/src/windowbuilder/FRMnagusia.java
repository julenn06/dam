package windowbuilder;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FRMnagusia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel PanelNagusia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FRMnagusia frame = new FRMnagusia();
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
	public FRMnagusia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		PanelNagusia = new JPanel();
		PanelNagusia.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(PanelNagusia);
		PanelNagusia.setLayout(null);

		JButton btnOnartu = new JButton("Aldatu");
		btnOnartu.addActionListener(new ActionListener() {
			int x = 0, y = 0, z = 0;

			public void actionPerformed(ActionEvent e) {
				PanelNagusia.setBackground(new Color(x, y, z));
				;
				x = x + 20;
				y = y + 20;
				z = z + 20;
			}
		});
		btnOnartu.setBounds(171, 186, 89, 23);
		PanelNagusia.add(btnOnartu);
	}
}
