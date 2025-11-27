package ariketa01;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import proba.BD_Konexioa;
import proba.Kontsultak;

import java.awt.event.*;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Ariketa00 extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ArrayList<Mensaje> mensajes = new ArrayList<>();
	private Mensaje mensajeTemporal = null;
	BD_Konexioa dbConnection = new BD_Konexioa();
	Kontsultak kontsultak = new Kontsultak();

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

	private Connection connection;

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Ariketa00() {
		dbConnection.connect();
		this.connection = dbConnection.getConnection();
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
		Salir.setBounds(269, 277, 161, 23);
		contentPane.add(Salir);

		JButton CargarBD = new JButton("Cargar BD");
		CargarBD.setBounds(73, 196, 154, 23);
		contentPane.add(CargarBD);

		JButton GuardarBD = new JButton("Guardar BD");
		GuardarBD.setBounds(269, 196, 154, 23);
		contentPane.add(GuardarBD);

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

		CargarBD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarBD();
			}
		});

		GuardarBD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarBD();
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
		String telefonoStr = JOptionPane.showInputDialog("Telefono Zenbakia:");

		int telefono = 0;
		try {
			telefono = Integer.parseInt(telefonoStr);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Telefono zenbakia zenbaki bat izan behar da.");
			return;
		}

		if (nombre != null && apellido != null && telefonoStr != null) {
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
			data[i][2] = String.valueOf(mensaje.getTelefono());
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
					try {
						int telefono = Integer.parseInt(datos[2].trim());
						Mensaje mensaje = new Mensaje(nombre, apellido, telefono);

						boolean existe = false;
						for (int i = 0; i < mensajes.size(); i++) {
							Mensaje m = mensajes.get(i);
							if (m.getNombre().equalsIgnoreCase(mensaje.getNombre())
									&& m.getApellido().equalsIgnoreCase(mensaje.getApellido())
									&& m.getTelefono() == mensaje.getTelefono()) {
								mensajes.set(i, mensaje);
								existe = true;
								break;
							}
						}

						if (!existe) {
							mensajes.add(mensaje);
						}
					} catch (NumberFormatException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Errorea telefono zenbakian, ezin izan da kargatu.");
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
						&& mensaje.getTelefono() == mensajeTemporal.getTelefono()) {
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
				JOptionPane.showMessageDialog(null, "Errorea mezuak gordetzean");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Ez daude mezurik gordetzeko.");
		}
	}

	private void cargarBD() {
		String kontsulta = "SELECT * FROM personas";
		try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(kontsulta)) {

			System.out.println("Mezuak:");
			while (rs.next()) {
				String izena = rs.getString("izena");
				String abizena = rs.getString("abizena");
				int telefonoa = rs.getInt("telefonoa");
				System.out.println("Izena: " + izena + ", Abizena: " + abizena + ", Telefonoa: " + telefonoa);
			}
		} catch (SQLException e1) {
			System.err.println("Errorea departamentuen kontsulta exekutatzerakoan: " + e1.getMessage());
		}
	}

	private void guardarBD() {
		if (!mensajes.isEmpty()) {
			Mensaje mensaje = mensajes.get(0);

			String izena = mensaje.getNombre();
			String abizena = mensaje.getApellido();
			int telefonoa = mensaje.getTelefono();
			String consulta = "INSERT INTO personas (izena, abizena, telefonoa) VALUES (?, ?, ?)";

			try (PreparedStatement pstmt = connection.prepareStatement(consulta)) {
				pstmt.setString(1, izena);
				pstmt.setString(2, abizena);
				pstmt.setInt(3, telefonoa);
				pstmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "Mezua gordeta.");
			} catch (SQLException e) {
				System.err.println("Erorrea mezua datu basean sartzean: " + e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Ez daude mezurik gordetzeko.");
		}
	}

}