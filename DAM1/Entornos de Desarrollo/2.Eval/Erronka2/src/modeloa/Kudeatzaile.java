package modeloa;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Kudeatzaile {
	
	public static ArrayList<Bidaia> ezabatuBidaia (JTable taula, ArrayList<Bidaia> bidaiak) {
		
		int row = taula.getSelectedRow();
		if (row != -1) {
			String IDLerroa = taula.getValueAt(row, 0).toString();
			
			for (int i = 0; i<bidaiak.size(); i++ ) {
				
				if (bidaiak.get(i).getIdentifikatzailea().equals(IDLerroa)) {
					
					bidaiak.remove(i);
					break;
					
				}
				
			}
		}
		
		DefaultTableModel modeloa = (DefaultTableModel) taula.getModel();
		modeloa.removeRow(row);
		return bidaiak;
		
	}

}
