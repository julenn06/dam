package ariketa02;

public class Ariketa02 {

	public static void main(String[] args) {

		int zbk = 20;
		int[] array = new int[zbk];

		array = Metodoak.taulakargatu(zbk, array);
		Metodoak.bikoitiakbatu(array);
		Metodoak.bakoitiabatu(array);

	}

}
