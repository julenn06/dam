package Ariketa04;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ariketa04 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel imageLabel; // JLabel para mostrar la imagen
	private int kont = 0; // Contador para saber qué imagen se está mostrando
	private String[] irudiak = { "irudia1.png", "irudia2.png", "irudia3.png", "irudia4.png", "irudia5.png",
			"irudia6.png" }; // Array con las rutas de las imágenes

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ariketa04 frame = new Ariketa04();
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
	public Ariketa04() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Inicializamos el JLabel para mostrar la imagen
		imageLabel = new JLabel();
		imageLabel.setBounds(43, 43, 125, 125);
		contentPane.add(imageLabel);

		// Cargar la primera imagen al iniciar
		updateImage(irudiak[kont]); // Llamar al método que actualiza la imagen

		// Botón "lehena" para ir a la primera imagen
		JButton lehena = new JButton("lehena");
		lehena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kont = 0; // Volver a la primera imagen;
				updateImage(irudiak[kont]); // Actualizar la imagen mostrada
			}
		});
		lehena.setBounds(300, 43, 124, 23);
		contentPane.add(lehena);

		// Botón "hurrengoa" para ir a la imagen siguiente
		JButton hurrengoa = new JButton("hurrengoa");
		hurrengoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (kont < irudiak.length - 1) {
					kont++; // Avanzar a la siguiente imagen
				}
				updateImage(irudiak[kont]); // Actualizar la imagen mostrada
			}
		});
		hurrengoa.setBounds(300, 77, 124, 23);
		contentPane.add(hurrengoa);

		// Botón "haurrekoa" para ir a la imagen anterior
		JButton haurrekoa = new JButton("haurrekoa");
		haurrekoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (kont > 0) {
					kont--; // Retroceder al la imagen anterior
				}
				updateImage(irudiak[kont]); // Actualizar la imagen mostrada
			}
		});
		haurrekoa.setBounds(300, 111, 124, 23);
		contentPane.add(haurrekoa);

		// Botón para ir a la última imagen
		JButton azkena = new JButton("azkena");
		azkena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kont = 5; // Ir al último índice del array
				updateImage(irudiak[kont]); // Actualizar la imagen mostrada
			}
		});
		azkena.setBounds(300, 145, 124, 23);
		contentPane.add(azkena);
	}

	// Método para actualizar la imagen en el JLabel
	private void updateImage(String ruta) {
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource(ruta)); // Cargar la imagen
																				// correspondiente al índice
																				// 'kont'
		Image image = imageIcon.getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(),
				Image.SCALE_SMOOTH); // Escalar la imagen al tamaño del JLabel
		imageLabel.setIcon(new ImageIcon(image)); // Actualizar el JLabel con la imagen escalada
	}
}
