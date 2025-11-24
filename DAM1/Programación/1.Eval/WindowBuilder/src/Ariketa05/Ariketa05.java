package Ariketa05;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Ariketa05 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField izena;
	private JTextField abizena;
	private JTextField NAN;
	private JTextField tlfnzenbakia;
	private JTable taula; // Tabla para mostrar contactos
	private String datuak[]; // Array para almacenar datos de un contacto
	private int kont = 0; // Contador de contactos
	private DefaultTableModel table; // Modelo de tabla

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ariketa05 frame = new Ariketa05();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Ariketa05() {
		setTitle("AGENDA");
		datuak = new String[4]; // Inicia el array
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Etiqueta para el campo de nombre
		JLabel lblNewLabel = new JLabel("Izena");
		lblNewLabel.setBounds(128, 15, 46, 14);
		contentPane.add(lblNewLabel);

		// Etiqueta para el campo de apellido
		JLabel lblNewLabel_3 = new JLabel("Abizena");
		lblNewLabel_3.setBounds(128, 62, 63, 14);
		contentPane.add(lblNewLabel_3);

		// Etiqueta para el campo de número de teléfono
		JLabel lblNewLabel_4 = new JLabel("Telefono zbk");
		lblNewLabel_4.setBounds(128, 112, 86, 14);
		contentPane.add(lblNewLabel_4);

		// Etiqueta para el campo de NAN
		JLabel lblNewLabel_2 = new JLabel("NAN");
		lblNewLabel_2.setBounds(128, 168, 46, 14);
		contentPane.add(lblNewLabel_2);

		// Campo de texto para el nombre
		izena = new JTextField();
		izena.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) { // Se activa al empezar a escribir en el JTextField, codigo ASCII
				int aux = e.getKeyChar();
				boolean izena = aux >= 65 && aux <= 90 || aux >= 97 && aux <= 122 || aux == 32; // 65-90: MAYUSCULAS,
																								// 97-122: minusculas,
																								// 32: espacio
				if (!izena) {
					e.consume(); // Consume el evento si no es válido, es como "return;"
				}
			}
		});
		izena.setBounds(128, 31, 86, 20);
		contentPane.add(izena);
		izena.setColumns(10);

		// Campo de texto para el apellido
		abizena = new JTextField();
		abizena.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int aux = e.getKeyChar();
				boolean abizena = aux >= 65 && aux <= 90 || aux >= 97 && aux <= 122 || aux == 32; // Permitir solo
																									// letras y espacios
				if (!abizena) {
					e.consume(); // Consume el evento si no es válido, es como "return;"
				}
			}
		});
		abizena.setBounds(128, 81, 86, 20);
		contentPane.add(abizena);
		abizena.setColumns(10);

		// Campo de texto para el número de teléfono
		tlfnzenbakia = new JTextField();
		tlfnzenbakia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				tlfnzenbakia.setForeground(Color.BLACK); // Cambia el color del texto a negro cuando el usuario escribe
				int aux = e.getKeyChar();
				boolean adina = aux >= 48 && aux <= 57; // 48-57: NUMEROS
				if (!adina) {
					e.consume(); // Consume el evento si no es válido
				}
			}
		});

		tlfnzenbakia.setBounds(128, 137, 86, 20);
		contentPane.add(tlfnzenbakia);
		tlfnzenbakia.setColumns(10);

		// Campo de texto para el NAN
		NAN = new JTextField();
		NAN.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				NAN.setForeground(Color.BLACK); // Cambia el color del texto a negro cuando el usuario escribe
				int aux = e.getKeyChar();
				boolean aldagaia = aux >= 48 && aux <= 57 || aux >= 65 && aux <= 90 || aux >= 97 && aux <= 122; // Permitir
																												// números
																												// y
																												// letras
				if (!aldagaia) {
					e.consume(); // Consume el evento si no es válido
				}
			}
		});
		NAN.setBounds(128, 193, 86, 20);
		contentPane.add(NAN);
		NAN.setColumns(10);

		// Botón para eliminar datos de los JTextField
		JButton ezabatu = new JButton("Ezabatu");
		ezabatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				izena.setText(""); // Limpia el campo de nombre
				abizena.setText(""); // Limpia el campo de apellido
				tlfnzenbakia.setText(""); // Limpia el campo de teléfono
				NAN.setText(""); // Limpia el campo de NAN
			}
		});
		ezabatu.setBounds(334, 80, 89, 23);
		contentPane.add(ezabatu);

		// Botón para eliminar la tabla
		JButton ezabatutaula = new JButton("Ezabatu Taula");
		ezabatutaula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showOptionDialog(null, "Seguru ezabatu nahi duzula taula? ", "Taula Ezabatu", // Contenido-Título
																														// de
																														// la
																														// ventana
						JOptionPane.YES_NO_OPTION, // Para 2 botones si/no
						JOptionPane.QUESTION_MESSAGE, // Tipo de ícono
						null, // null para icono por defecto
						new Object[] { "BAI", "EZ" }, // Opciones de la ventana
						// null para YES y NO
						"BAI"); // Selección predeterminada
				if (confirm == JOptionPane.YES_OPTION) {
					table.setRowCount(0); // Limpia la tabla
					kont = 0; // Reinicia el contador, ya que se eliminan todos los contactos
				}
			}
		});
		ezabatutaula.setBounds(214, 391, 138, 23);
		contentPane.add(ezabatutaula);

		// Botón para eliminar un contacto específico
		JButton ezabatupertsona = new JButton("Kendu Kontaktu bat");
		ezabatupertsona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int aukeratu = taula.getSelectedRow(); // Obtiene la fila seleccionada
				if (aukeratu != -1) {
					table.removeRow(aukeratu); // Elimina la fila seleccionada
					kont--; // Decrementa el contador
				} else {
					JOptionPane.showMessageDialog(null, "Aukeratu lehenengo ezabatu nahi duzun pertsona"); // Mensaje si
																											// no se
																											// selecciona
																											// ninguna
																											// fila
				}
			}
		});
		ezabatupertsona.setBounds(50, 391, 154, 23);
		contentPane.add(ezabatupertsona);

		// Botón para imprimir la tabla
		JButton inprimatu = new JButton("Inprimatu");
		inprimatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (kont > 0) { // Verifica si hay contactos para imprimir, comparando con el kont, que si
								// esta a 0 no hay nadie en la tabla
					try {
						taula.print(); // Intenta imprimir la tabla
					} catch (PrinterException e1) {
						e1.printStackTrace(); // Manejo de excepciones de impresión
					}
				} else {
					// Mensaje de advertencia si no hay contactos
					JOptionPane.showMessageDialog(null, "Gutxienez kontaktu bat gehitu");
					return; // Sale del método si no hay contactos
				}
			}
		});
		inprimatu.setBounds(361, 391, 89, 23);
		contentPane.add(inprimatu);

		// Inicializa el modelo de la tabla
		table = new DefaultTableModel(new String[] { "IZENA", "ABIZENA", "TELEFONOA", "NAN" }, 0);
		taula = new JTable(table);
		taula.getTableHeader().setReorderingAllowed(false); // Desactiva el poder mover los encabezados de la tabla
		taula.setBounds(128, 272, 295, 141);
		contentPane.add(taula);

		// Para que los nombres aparezcan en la tabla??
		JScrollPane scrollPane = new JScrollPane(taula);
		scrollPane.setBounds(50, 230, 400, 150);
		contentPane.add(scrollPane);

		// Botón para continuar
		JButton botoia = new JButton("Jarraitu");
		botoia.setBounds(334, 30, 89, 23);
		contentPane.add(botoia);

		// Acción del botón para agregar un nuevo contacto
		botoia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nan = NAN.getText(); // Obtiene el NAN ingresado

				// Almacena los datos ingresados en el array
				datuak[0] = izena.getText();
				datuak[1] = abizena.getText();
				datuak[2] = tlfnzenbakia.getText();
				datuak[3] = NAN.getText();
				taula.repaint(); // Refresca la tabla

				// Verifica si hay campos vacíos
				if (izena.getText().isEmpty() || abizena.getText().isEmpty() || tlfnzenbakia.getText().isEmpty()
						|| NAN.getText().isEmpty()) {
					// Mensaje de advertencia si faltan datos
					JOptionPane.showMessageDialog(null, "Mesedez, bete datu guztiak");
					return; // Sale del método si hay campos vacíos
				}

				// Verifica si el NAN tiene una longitud de 9 caracteres
				if (nan.length() != 9) {
					JOptionPane.showMessageDialog(null, "NAN okerra, sartu berriro");
					NAN.setText(""); // Limpia el campo de NAN
					return; // Sale del método si el NAN es incorrecto
				}

				String zenbakia = nan.substring(0, 8); // Obtiene los primeros 8 dígitos del NAN
				int zbk = Integer.parseInt(zenbakia); // Convierte a entero
				int hondarra = zbk % 23; // Calcula el resto

				// Array de letras para validar el NAN
				String[] letrak = { "T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q",
						"V", "H", "L", "C", "K", "E" };

				char emaitza = letrak[hondarra].charAt(0); // Obtiene la letra correspondiente de los numeros del NAN

				// Verifica si la letra del NAN es correcta y si el número de teléfono tiene 9
				// dígitos
				if (nan.charAt(8) != emaitza || tlfnzenbakia.getText().length() != 9) {
					JOptionPane.showMessageDialog(null, "Datu bat edo gehiago txarto daude. Berrido idatzi");

					// Cambia el color del texto si hay errores en el NAN o número de teléfono
					if (nan.charAt(8) != emaitza) {
						NAN.setForeground(Color.RED); // Cambia el color del texto a rojo
					}
					if (tlfnzenbakia.getText().length() != 9) {
						tlfnzenbakia.setForeground(Color.RED); // Cambia el color del texto a rojo
					}
					return; // Sale del método si hay errores
				}

				// Verifica si el NAN ya está registrado
				boolean NANBikoiztuta = false;
				for (int i = 0; i < table.getRowCount(); i++) { // Recorre las filas de la tabla
					if (nan.equals(table.getValueAt(i, 3))) { // Recorre las filas de la tabla en la posicion 3 que es
																// donde se situa el NAN y comprueba si son iguales
						NANBikoiztuta = true; // Marca como duplicado
					}
				}

				if (NANBikoiztuta) { // Si el NAN ya existe
					JOptionPane.showMessageDialog(null, "Ezin duzu gehitu kontaktu hau, NAN hau ba dago registratuta");
					return; // Sale del método
				}

				// Verifica si el número de contactos es menor o igual a 4
				if (kont <= 4) {
					// Almacena los datos en la tabla
					datuak[0] = izena.getText();
					datuak[1] = abizena.getText();
					datuak[2] = tlfnzenbakia.getText();
					datuak[3] = NAN.getText();
					table.addRow(datuak); // Añade los datos a la tabla
					kont++; // Incrementa el contador de contactos

					// Despues de añadir los datos a la tabla, borra el contenido de los TextField
					izena.setText("");
					abizena.setText("");
					tlfnzenbakia.setText("");
					NAN.setText("");
				} else {
					// botoia.setEnabled(false); // Desactiva el botón si la tabla está llena
					JOptionPane.showMessageDialog(null, "Taula Beteta Dago"); // Mensaje de advertencia por llegar al
																				// maximo de contactos
				}
			}
		});
	}
}