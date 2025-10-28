package bista;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modeloa.Bidaia;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ZerbitzuBerria extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


		public ZerbitzuBerria(int erabiltzailezbk, ArrayList<Bidaia> bidaiak, String IDLerroa) {
			setTitle("ZERBITZU BERRIA");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 699, 393);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JButton ostatuaButton = new JButton("OSTATUA");
			ostatuaButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								Ostatua frame = new Ostatua();
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			});
			ostatuaButton.setBounds(35, 81, 175, 152);
			contentPane.add(ostatuaButton);
			
			JButton hegaldiaButton = new JButton("HEGALDIA");
			hegaldiaButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								Hegaldia frame = new Hegaldia();
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			});
			hegaldiaButton.setBounds(256, 81, 175, 152);
			contentPane.add(hegaldiaButton);
			
			JButton besteButton = new JButton("BESTE ZERBITZUAK");
			besteButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								BesteZerbitzua frame = new BesteZerbitzua();
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			});
			besteButton.setBounds(474, 81, 175, 152);
			contentPane.add(besteButton);
		}
	}


