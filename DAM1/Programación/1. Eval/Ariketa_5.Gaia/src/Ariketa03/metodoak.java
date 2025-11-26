package Ariketa03;

public class metodoak {

	static int[] aux;

	public static int arrazenbakiaky(int zbk) {

		int[] array = new int[zbk];

		for (int i = 0; i < zbk; i++) {
			array[i] = (int) (Math.random() * 9) + 1;
			System.out.println(array[i]);
		}
		aux = array;
		return zbk;
	}

}
