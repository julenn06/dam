package bista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

public class Ostatua extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField izenaOField;
	private JTextField hiriaOField;
	private JTextField textField_2;

	public Ostatua() {
		setTitle("OSTATU BERRIA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel izenaOLabel = new JLabel("Ostatuaren Izena:");
		izenaOLabel.setBounds(41, 70, 117, 14);
		contentPane.add(izenaOLabel);
		
		JLabel hiriaOLabel = new JLabel("Hiria:");
		hiriaOLabel.setBounds(41, 114, 117, 14);
		contentPane.add(hiriaOLabel);
		
		JLabel prezioaOLabel = new JLabel("Prezioa:");
		prezioaOLabel.setBounds(41, 157, 117, 14);
		contentPane.add(prezioaOLabel);
		
		JDateChooser sarreraODateChooser = new JDateChooser();
		sarreraODateChooser.setBounds(243, 193, 200, 20);
		contentPane.add(sarreraODateChooser);
		
		JDateChooser irteeraODateChooser = new JDateChooser();
		irteeraODateChooser.setBounds(243, 239, 200, 20);
		contentPane.add(irteeraODateChooser);
		
		JLabel sarreraOLabel = new JLabel("Sarrera Eguna:");
		sarreraOLabel.setBounds(41, 193, 117, 14);
		contentPane.add(sarreraOLabel);
		
		JLabel irteeraOLabel = new JLabel("Irteera Eguna:");
		irteeraOLabel.setBounds(41, 239, 117, 14);
		contentPane.add(irteeraOLabel);
		
		izenaOField = new JTextField();
		izenaOField.setBounds(243, 67, 200, 20);
		contentPane.add(izenaOField);
		izenaOField.setColumns(10);
		
		hiriaOField = new JTextField();
		hiriaOField.setColumns(10);
		hiriaOField.setBounds(243, 111, 200, 20);
		contentPane.add(hiriaOField);
		
		textField_2 = new JTextField();
		textField_2.setBounds(243, 154, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel euroOLabel = new JLabel("€");
		euroOLabel.setBounds(334, 157, 46, 14);
		contentPane.add(euroOLabel);
		
		JButton atzeraOButton = new JButton("ATZERA");
		atzeraOButton.setBounds(112, 289, 110, 66);
		contentPane.add(atzeraOButton);
		
		JButton gordeOButton = new JButton("GORDE");
		gordeOButton.setBounds(334, 289, 110, 66);
		contentPane.add(gordeOButton);
	}
}
