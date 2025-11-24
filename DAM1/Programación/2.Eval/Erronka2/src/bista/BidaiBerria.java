package bista;

import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import DAO.BidaiMotaDAO;
import DAO.BidaiaDAO;
import DAO.HerrialdeaDAO;
import modeloa.BidaiMota;
import modeloa.Bidaia;
import modeloa.Herrialdea;

public class BidaiBerria extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField izenabidaiaField;
	private JTextField deskribapenBidaiaField;
	private JDateChooser irteeraDateChooser;
	private JDateChooser helmugaDateChooser;
	private JLabel motaBidaiaLabel;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public BidaiBerria(int erabiltzailezbk, ArrayList<Bidaia> bidaiak) {
		setTitle("BIDAI BERRIA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 831, 691);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel izenaBidaiaLabel = new JLabel("Bidaiaren Izena:");
		izenaBidaiaLabel.setBounds(47, 160, 110, 14);
		contentPane.add(izenaBidaiaLabel);
		
		izenabidaiaField = new JTextField();
		izenabidaiaField.setBounds(292, 157, 446, 20);
		contentPane.add(izenabidaiaField);
		izenabidaiaField.setColumns(10);
		
		JLabel deskribapenaBidaiaLabel = new JLabel("Bidaiaren Deskribapena:");
		deskribapenaBidaiaLabel.setBounds(47, 207, 152, 14);
		contentPane.add(deskribapenaBidaiaLabel);
		
		deskribapenBidaiaField = new JTextField();
		deskribapenBidaiaField.setColumns(10);
		deskribapenBidaiaField.setBounds(292, 204, 446, 20);
		contentPane.add(deskribapenBidaiaField);
		
		JLabel irteeraDataLabel = new JLabel("Irteera Data:");
        irteeraDataLabel.setBounds(47, 257, 110, 14);
        contentPane.add(irteeraDataLabel);
        
        irteeraDateChooser = new JDateChooser();
        irteeraDateChooser.setBounds(292, 257, 200, 20);
        contentPane.add(irteeraDateChooser);
        
        JLabel helmugaDataLabel = new JLabel("Helmuga Data:");
        helmugaDataLabel.setBounds(47, 315, 110, 14);
        contentPane.add(helmugaDataLabel);
        
        helmugaDateChooser = new JDateChooser();
        helmugaDateChooser.setBounds(292, 315, 200, 20);
        contentPane.add(helmugaDateChooser);
        
        motaBidaiaLabel = new JLabel("Bidaia mota:");
        motaBidaiaLabel.setBounds(47, 384, 110, 14);
        contentPane.add(motaBidaiaLabel);
        
        Choice bidaiMotaChoice = new Choice();
        bidaiMotaChoice.setBounds(292, 380, 200, 20);
        contentPane.add(bidaiMotaChoice);
        
        JLabel herrialdeBidaiaLabel = new JLabel("Herrialdea:");
        herrialdeBidaiaLabel.setBounds(47, 454, 110, 14);
        contentPane.add(herrialdeBidaiaLabel);
        
        Choice herrialdeChoice = new Choice();
        herrialdeChoice.setBounds(292, 450, 200, 20);
        contentPane.add(herrialdeChoice);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(292, 11, 232, 98);
        contentPane.add(lblNewLabel);
        
        BidaiMotaDAO bidaiMotaDAO = new BidaiMotaDAO();
	    ArrayList<BidaiMota> bidaiMotak = bidaiMotaDAO.lortuBidaiMotak();

	    for (BidaiMota bidaiMota : bidaiMotak) {
	        bidaiMotaChoice.add(bidaiMota.getDeskribapenaBidaiMota());
	    }   
	    HerrialdeaDAO herrialdeaDAO = new HerrialdeaDAO();
	    ArrayList<Herrialdea> herrialdeak = herrialdeaDAO.lortuHerrialdeGuztiak();
	    
	    for (Herrialdea herrialdea : herrialdeak) {
	    	herrialdeChoice.add(herrialdea.getHerrialdea());
	    }
        
        JButton okBidaiBerriaButton = new JButton("GORDE");
        okBidaiBerriaButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		SimpleDateFormat formatoa = new SimpleDateFormat("yyyy-MM-dd");
        		
        		String izenaBidaia = izenabidaiaField.getText();
        		String deskribapenaBidaia = deskribapenBidaiaField.getText();
        		Date irteeraDate = irteeraDateChooser.getDate();
        		Date helmugaDate = helmugaDateChooser.getDate();
        		String irteeraData = formatoa.format(irteeraDate);
        		String helmugaData = formatoa.format(helmugaDate);
        		String bidaiaMota = bidaiMotaDAO.lortuID(bidaiMotaChoice.getSelectedItem());
        		String herrialdea = herrialdeaDAO.lortuID(herrialdeChoice.getSelectedItem());
        		int agentzia = erabiltzailezbk;
        		int iraupena = 3;
        		
        		Bidaia bidaiBerria = new Bidaia(izenaBidaia, deskribapenaBidaia, bidaiaMota, irteeraData, helmugaData, iraupena, herrialdea, agentzia);
        		bidaiak.add(bidaiBerria);
        		
        		 boolean exito = BidaiaDAO.sartuBidaia(bidaiBerria);

 		        if (exito) {
 		            System.out.println("Bidaiaa gordeta");
 		        } else {
 		            System.out.println("Errorea Bidaia erregistratzen");
 		        }
        	}
        	
       	
        });
        okBidaiBerriaButton.setBounds(514, 565, 89, 23);
        contentPane.add(okBidaiBerriaButton);
        
        JButton atzeraBidaiBerriaButton_1 = new JButton("ATZERA");
        atzeraBidaiBerriaButton_1.setBounds(227, 565, 89, 23);
        contentPane.add(atzeraBidaiBerriaButton_1);
        
	   
	}
}