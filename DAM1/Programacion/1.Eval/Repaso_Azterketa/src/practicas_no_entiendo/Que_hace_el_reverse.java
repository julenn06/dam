package practicas_no_entiendo;

import java.util.Scanner;

public class Que_hace_el_reverse {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String prueba = "ayuda";

		String inverso = new StringBuilder(prueba).reverse().toString();

		System.out.println("palabra bien escrita: " + prueba);
		System.out.println("Palabra al reves: " + inverso);

//========DE FORMA MANUAL SIN USAR STRINGBUILDER=========//
		String invertido = "";

		for (int i = prueba.length() - 1; i >= 0; i--) {
			invertido += prueba.charAt(i);
		}
		System.out.println(invertido);
//=====================================================//
		sc.close();
	}

}
