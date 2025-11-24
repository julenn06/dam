package bista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

public class BesteZerbitzua extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField izenaBField;
	private JTextField prezioaBField;
	private JTextField textField;

	public BesteZerbitzua() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton atzeraBButton = new JButton("ATZERA");
		atzeraBButton.setBounds(99, 283, 110, 66);
		contentPane.add(atzeraBButton);
		
		JButton gordeBButton = new JButton("GORDE");
		gordeBButton.setBounds(327, 283, 110, 66);
		contentPane.add(gordeBButton);
		
		JLabel izenaBLabel = new JLabel("Izena:");
		izenaBLabel.setBounds(43, 58, 110, 14);
		contentPane.add(izenaBLabel);
		
		JLabel dataBLabel = new JLabel("Data:");
		dataBLabel.setBounds(43, 99, 110, 14);
		contentPane.add(dataBLabel);
		
		JLabel prezioaBLabel = new JLabel("Prezioa:");
		prezioaBLabel.setBounds(43, 145, 110, 14);
		contentPane.add(prezioaBLabel);
		
		JLabel deskribapenaBLabel = new JLabel("Deskribapena:");
		deskribapenaBLabel.setBounds(43, 191, 110, 14);
		contentPane.add(deskribapenaBLabel);
		
		JDateChooser irteeraBDateChooser = new JDateChooser();
		irteeraBDateChooser.setBounds(223, 99, 200, 20);
		contentPane.add(irteeraBDateChooser);
		
		izenaBField = new JTextField();
		izenaBField.setBounds(223, 55, 200, 20);
		contentPane.add(izenaBField);
		izenaBField.setColumns(10);
		
		prezioaBField = new JTextField();
		prezioaBField.setColumns(10);
		prezioaBField.setBounds(223, 142, 101, 20);
		contentPane.add(prezioaBField);
		
		JLabel euroOLabel = new JLabel("€");
		euroOLabel.setBounds(331, 145, 46, 14);
		contentPane.add(euroOLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(223, 188, 200, 20);
		contentPane.add(textField);
	}
}
