package kontroladorea;

import java.awt.EventQueue;
import DAO.*;
import Konexioa.ConnectDB;
import bista.Ongietorri;

import javax.swing.JFrame;

public class App extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		ConnectDB konexioa = new ConnectDB(); 
		konexioa.conectar();
		
		if (konexioa.isConnected()) {
		    System.out.println("Conexión exitosa a la base de datos.");
		} else {
		    System.out.println("La conexión no se pudo establecer.");
		    return;  // Termina el programa si no se pudo conectar
		}
		
		AireportuaDAO aireportuaDAO = new AireportuaDAO();
	    aireportuaDAO.setConnection(konexioa.getConnection());

	    AgentziaDAO agentziaDAO = new AgentziaDAO();
	    agentziaDAO.setConnection(konexioa.getConnection());
	    
	    HerrialdeaDAO herrialdeaDAO = new HerrialdeaDAO();
	    herrialdeaDAO.setConnection(konexioa.getConnection());

	    BidaiaDAO bidaiaDAO = new BidaiaDAO();
	    bidaiaDAO.setConnection(konexioa.getConnection());

	    ZerbitzuakDAO zerbitzuaDAO = new ZerbitzuakDAO();
	    zerbitzuaDAO.setConnection(konexioa.getConnection());
	    
	    BidaiMotaDAO bidaiMotaDAO = new BidaiMotaDAO();
	    bidaiMotaDAO.setConnection(konexioa.getConnection());
	    
	    AgentziaMotaDAO agentziaMotaDAO = new AgentziaMotaDAO();
	    agentziaMotaDAO.setConnection(konexioa.getConnection());
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ongietorri ongietorri = new Ongietorri();
					ongietorri.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
	        



	
	

        
        

        	




