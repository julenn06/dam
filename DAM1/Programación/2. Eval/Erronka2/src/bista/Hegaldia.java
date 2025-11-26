package bista;

import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

public class Hegaldia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField kodeaJField;
	private JTextField kodeaHField;

	public Hegaldia() {
		setTitle("HEGALDI BERRIA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 918, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel etorriPanel = new JPanel();
		etorriPanel.setBounds(511, 94, 381, 329);
		contentPane.add(etorriPanel);
		etorriPanel.setLayout(null);
		
		JLabel irteeraJLabel = new JLabel("Irteera Data:");
		irteeraJLabel.setBounds(10, 25, 97, 14);
		etorriPanel.add(irteeraJLabel);
		
		JLabel orduaJLabel = new JLabel("Irteera Ordua:");
		orduaJLabel.setBounds(10, 65, 97, 14);
		etorriPanel.add(orduaJLabel);
		
		JLabel kodeaJLabel = new JLabel("Kodea:");
		kodeaJLabel.setBounds(10, 104, 97, 14);
		etorriPanel.add(kodeaJLabel);
		
		JLabel irteAireportuaJLabel = new JLabel("Irteera Aireportua:");
		irteAireportuaJLabel.setBounds(10, 147, 97, 14);
		etorriPanel.add(irteAireportuaJLabel);
		
		JLabel helmugaJLabel = new JLabel("Helmuga:");
		helmugaJLabel.setBounds(10, 192, 97, 14);
		etorriPanel.add(helmugaJLabel);
		
		JLabel airelineaJLabel = new JLabel("Airelinea");
		airelineaJLabel.setBounds(10, 237, 97, 14);
		etorriPanel.add(airelineaJLabel);
		
		kodeaJField = new JTextField();
		kodeaJField.setBounds(166, 101, 86, 20);
		etorriPanel.add(kodeaJField);
		kodeaJField.setColumns(10);
		
		JDateChooser irteeraDateChooser_1 = new JDateChooser();
		irteeraDateChooser_1.setBounds(166, 19, 200, 20);
		etorriPanel.add(irteeraDateChooser_1);

		
		JLabel irteeraHLabel = new JLabel("Irteera Data:");
		irteeraHLabel.setBounds(22, 49, 97, 14);
		contentPane.add(irteeraHLabel);
		
		JLabel orduaHLabel = new JLabel("Irteera Ordua:");
		orduaHLabel.setBounds(22, 96, 97, 14);
		contentPane.add(orduaHLabel);
		
		JLabel kodeaHLabel = new JLabel("Kodea:");
		kodeaHLabel.setBounds(22, 149, 97, 14);
		contentPane.add(kodeaHLabel);
		
		JLabel irteAireportuaHLabel = new JLabel("Irteera Aireportua:");
		irteAireportuaHLabel.setBounds(22, 209, 97, 14);
		contentPane.add(irteAireportuaHLabel);
		
		JLabel helmugaHLabel = new JLabel("Helmuga:");
		helmugaHLabel.setBounds(22, 260, 97, 14);
		contentPane.add(helmugaHLabel);
		
		JLabel airelineaHLabel = new JLabel("Airelinea:");
		airelineaHLabel.setBounds(22, 316, 97, 14);
		contentPane.add(airelineaHLabel);
		
		JCheckBox etorriCheckBox = new JCheckBox("Etorri");
		etorriCheckBox.setBounds(511, 45, 97, 23);
		contentPane.add(etorriCheckBox);
		
		kodeaHField = new JTextField();
		kodeaHField.setColumns(10);
		kodeaHField.setBounds(153, 146, 86, 20);
		contentPane.add(kodeaHField);
		
		JDateChooser irteeraDateChooser = new JDateChooser();
		irteeraDateChooser.setBounds(153, 43, 200, 20);
		contentPane.add(irteeraDateChooser);
		

        // Crear un modelo de fecha para el JSpinner (establecer hora, minutos y segundos)
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 12); // Establecer una hora inicial
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date initialDate = calendar.getTime();

        SpinnerDateModel model = new SpinnerDateModel(initialDate, null, null, Calendar.HOUR_OF_DAY);
        JSpinner timeSpinner = new JSpinner(model);

        // Establecer formato de hora y minuto
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
        timeSpinner.setEditor(timeEditor);

        // Ajustar posición y tamaño del JSpinner
        timeSpinner.setBounds(153, 88, 80, 30);
        contentPane.add(timeSpinner);

        // Mostrar la hora seleccionada cuando el usuario presione un botón (ejemplo)
        timeSpinner.addChangeListener(e -> {
            Date selectedTime = (Date) timeSpinner.getValue();
            System.out.println("Hora seleccionada: " + selectedTime.toString());
        });
    
        // Crear un modelo de fecha para el JSpinner (establecer hora, minutos y segundos)
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.HOUR_OF_DAY, 12); // Establecer una hora inicial
        calendar1.set(Calendar.MINUTE, 0);
        calendar1.set(Calendar.SECOND, 0);


        SpinnerDateModel model1 = new SpinnerDateModel(initialDate, null, null, Calendar.HOUR_OF_DAY);
        
		JSpinner timeSpinner1 = new JSpinner(model1);
		timeSpinner1.setBounds(172, 57, 80, 30);
		etorriPanel.add(timeSpinner1);
		
		        // Establecer formato de hora y minuto
		        JSpinner.DateEditor timeEditor1 = new JSpinner.DateEditor(timeSpinner1, "HH:mm");
		        timeSpinner1.setEditor(timeEditor1);
		        
		        Choice irteeraJChoice = new Choice();
		        irteeraJChoice.setBounds(166, 141, 200, 20);
		        etorriPanel.add(irteeraJChoice);
		        
		        Choice helmugaJChoice = new Choice();
		        helmugaJChoice.setBounds(166, 186, 200, 20);
		        etorriPanel.add(helmugaJChoice);
		        
		        Choice airelineaJChoice = new Choice();
		        airelineaJChoice.setBounds(166, 231, 200, 20);
		        etorriPanel.add(airelineaJChoice);
		        
		        Choice irteeraHChoice = new Choice();
		        irteeraHChoice.setBounds(153, 209, 200, 20);
		        contentPane.add(irteeraHChoice);
		        
		        Choice helmugaHChoice = new Choice();
		        helmugaHChoice.setBounds(153, 260, 200, 20);
		        contentPane.add(helmugaHChoice);
		        
		        Choice airelineaHChoice = new Choice();
		        airelineaHChoice.setBounds(153, 310, 200, 20);
		        contentPane.add(airelineaHChoice);
		        
		        JButton atzeraHButton = new JButton("ATZERA");
		        atzeraHButton.setBounds(99, 357, 110, 66);
		        contentPane.add(atzeraHButton);
		        
		        JButton gordeHButton = new JButton("GORDE");
		        gordeHButton.setBounds(304, 357, 110, 66);
		        contentPane.add(gordeHButton);
                Date selectedTime1 = (Date) timeSpinner1.getValue();
		                // Mostrar la hora seleccionada cuando el usuario presione un botón (ejemplo)
		                timeSpinner1.addChangeListener(e -> {
		                    System.out.println("Hora seleccionada: " + selectedTime1.toString());
		                });

		
		etorriCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Mostrar o ocultar el JPanel según el estado del JCheckBox
                etorriPanel.setVisible(etorriCheckBox.isSelected());
            }
        });

        // Inicialmente, oculta el etorriPanel
        etorriPanel.setVisible(false);
    }
	}

