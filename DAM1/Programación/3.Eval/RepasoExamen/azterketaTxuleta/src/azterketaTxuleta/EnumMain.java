package azterketaTxuleta;

import java.util.Scanner;

enum Colores {
	ROJO, VERDE, AZUL, MORADO
}

public class EnumMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Mete un color: (azul, morado, rojo o verde)");
		String colorElegido = sc.next().toUpperCase();

		try {
			Colores colores = Colores.valueOf(colorElegido);

			switch (colores) {
			case AZUL:
				System.out.println("Azul");
				break;

			case MORADO:
				System.out.println("Moradooooooo");
				break;
			case ROJO:

				System.out.println("Rooojo");
				break;

			case VERDE:
				System.out.println("Verdeeeeeeeee");
				break;
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Ese color no esta");
		}

		sc.close();
	}
}