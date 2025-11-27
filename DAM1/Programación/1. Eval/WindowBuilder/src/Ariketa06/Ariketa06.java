package Ariketa06;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Ariketa06 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ariketa06 frame = new Ariketa06();
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
	public Ariketa06() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Crear el panel rojo y configurarlo
		JPanel gorria = new JPanel();
		gorria.setBackground(Color.RED); // Establecer el color de fondo rojo
		gorria.setBounds(54, 11, 330, 173); // Definir el tamaño y posición
		contentPane.add(gorria); // Agregar el panel al contenido principal

		// Crear el panel verde y configurarlo
		JPanel berdea = new JPanel();
		berdea.setBackground(Color.GREEN);
		berdea.setBounds(54, 11, 330, 173);
		contentPane.add(berdea);

		// Crear el panel azul y configurarlo
		JPanel urdina = new JPanel();
		urdina.setBackground(Color.BLUE);
		urdina.setBounds(54, 11, 330, 173);
		contentPane.add(urdina);

		// Inicialmente, hacer que todos los paneles estén ocultos
		gorria.setVisible(false);
		berdea.setVisible(false);
		urdina.setVisible(false);

		// Crear el botón para mostrar el panel rojo
		JButton botongorria = new JButton("GORRIA");
		// Accion que se hara cuando pulse el boton
		botongorria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Mostrar el panel rojo y ocultar los demás
				gorria.setVisible(true);
				berdea.setVisible(false);
				urdina.setVisible(false);
			}
		});
		botongorria.setBounds(54, 195, 89, 23); // Posición y tamaño del botón
		contentPane.add(botongorria); // Agregar el botón

		// Crear el botón para mostrar el panel verde
		JButton botonberdea = new JButton("BERDEA");
		// Accion que se hara cuando pulse el boton
		botonberdea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Mostrar el panel verde y ocultar los demás
				gorria.setVisible(false);
				berdea.setVisible(true);
				urdina.setVisible(false);
			}
		});
		botonberdea.setBounds(175, 195, 89, 23); // Posición y tamaño del botón
		contentPane.add(botonberdea); // Agregar el botón

		// Crear el botón para mostrar el panel azul
		JButton botonurdina = new JButton("URDINA");
		// Accion que se hara cuando pulse el boton
		botonurdina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Mostrar el panel azul y ocultar los demás
				gorria.setVisible(false);
				berdea.setVisible(false);
				urdina.setVisible(true);
			}
		});
		botonurdina.setBounds(295, 195, 89, 23); // Posición y tamaño del botón
		contentPane.add(botonurdina); // Agregar el botón
	}
}
