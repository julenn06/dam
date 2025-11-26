package Ariketa_SalbuespenKontrola;

import java.util.Scanner;

public class Ariketa_SalbuespenKontrola {

	public static void main(String[] args) {
		
		boolean errorea = true;
		int zkiOsoak = 0;
		Scanner sc = new Scanner(System.in); 
		
		do {
		System.out.println("Sartu zenbat zenbaki sartuko dituzun:");
		String katea = sc.nextLine(); 
		try {
		errorea = false;
		zkiOsoak = Integer.parseInt(katea);
		
		} catch(Exception e) {
		errorea = true;
		System.out.println("Zenbaki oso bat sartu behar duzu. ");
		}
		} while(errorea == true);

		
		System.out.println(zkiOsoak);
sc.close();
	}

}
