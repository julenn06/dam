package ariketa00;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Ariketa00 extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ArrayList<Mensaje> mensajes = new ArrayList<>();
	private Mensaje mensajeTemporal = null;

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

	public Ariketa00() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton CargarMensaje = new JButton("Cargar Mensaje");
		CargarMensaje.setBounds(73, 50, 154, 23);
		contentPane.add(CargarMensaje);

		JButton GuardarMensaje = new JButton("Guardar Mensaje");
		GuardarMensaje.setBounds(269, 50, 161, 23);
		contentPane.add(GuardarMensaje);

		JButton AñadirMensaje = new JButton("Añadir Mensaje");
		AñadirMensaje.setBounds(73, 113, 154, 23);
		contentPane.add(AñadirMensaje);

		JButton ImprimirMensaje = new JButton("Imprimir Mensaje");
		ImprimirMensaje.setBounds(269, 113, 161, 23);
		contentPane.add(ImprimirMensaje);

		JButton Salir = new JButton("Salir");
		Salir.setBounds(269, 213, 161, 23);
		contentPane.add(Salir);

		CargarMensaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarMensaje();
			}
		});

		GuardarMensaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarMensaje();
			}
		});

		AñadirMensaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				añadirMensaje();
			}
		});

		ImprimirMensaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imprimirMensaje();
			}
		});

		Salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	private void añadirMensaje() {
		String nombre = JOptionPane.showInputDialog("Izena:");
		String apellido = JOptionPane.showInputDialog("Abizena:");
		String telefono = JOptionPane.showInputDialog("Telefono Zenbakia:");

		if (nombre != null && apellido != null && telefono != null) {
			mensajeTemporal = new Mensaje(nombre, apellido, telefono);
			JOptionPane.showMessageDialog(null, "Mezua gehitu da, baina ez da oraindik gorde.");
		}
	}

	private void imprimirMensaje() {
		String[][] data = new String[mensajes.size()][3];
		for (int i = 0; i < mensajes.size(); i++) {
			Mensaje mensaje = mensajes.get(i);
			data[i][0] = mensaje.getNombre();
			data[i][1] = mensaje.getApellido();
			data[i][2] = mensaje.getTelefono();
		}

		String[] columns = { "Izena", "Abizena", "Telefonoa" };
		JTable table = new JTable(data, columns);
		JScrollPane scrollPane = new JScrollPane(table);
		JOptionPane.showMessageDialog(null, scrollPane);
	}

	private void cargarMensaje() {
		mensajes.clear();

		File archivo = new File("mensajes.txt");
		if (!archivo.exists()) {
			try {
				archivo.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Ezin izan da sortu mensajes.txt fitxategia");
				return;
			}
		}

		try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] datos = line.split(",");
				if (datos.length == 3) {
					String nombre = datos[0].trim();
					String apellido = datos[1].trim();
					String telefono = datos[2].trim();
					Mensaje mensaje = new Mensaje(nombre, apellido, telefono);

					boolean existe = false;
					for (int i = 0; i < mensajes.size(); i++) {
						Mensaje m = mensajes.get(i);
						if (m.getNombre().equalsIgnoreCase(mensaje.getNombre())
								&& m.getApellido().equalsIgnoreCase(mensaje.getApellido())
								&& m.getTelefono().equals(mensaje.getTelefono())) {
							mensajes.set(i, mensaje);
							existe = true;
							break;
						}
					}

					if (!existe) {
						mensajes.add(mensaje);
					}
				}
			}
			JOptionPane.showMessageDialog(null, "Mezuak kargatu dira mensajes.txt fitxategitik");
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Errorea mezuak kargatzean");
		}
	}

	private void guardarMensaje() {
		if (mensajeTemporal != null) {
			boolean badago = false;
			for (int i = 0; i < mensajes.size(); i++) {
				Mensaje mensaje = mensajes.get(i);
				if (mensaje.getNombre().equalsIgnoreCase(mensajeTemporal.getNombre())
						&& mensaje.getApellido().equalsIgnoreCase(mensajeTemporal.getApellido())
						&& mensaje.getTelefono().equals(mensajeTemporal.getTelefono())) {
					mensajes.set(i, mensajeTemporal);
					badago = true;
					break;
				}
			}

			if (!badago) {
				mensajes.add(mensajeTemporal);
			}

			mensajeTemporal = null;

			try (BufferedWriter writer = new BufferedWriter(new FileWriter("mensajes.txt"))) {
				for (Mensaje mensaje : mensajes) {
					writer.write(mensaje.getNombre() + ", " + mensaje.getApellido() + ", " + mensaje.getTelefono());
					writer.newLine();
				}
				JOptionPane.showMessageDialog(null, "Mezuak kargatuta mensajes.txt fitxategian");
			} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erorrea mezuak gordetzean");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Ez daude mezurik gordetzeko.");
		}
	}
}