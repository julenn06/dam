package Ariketa_1;

import java.util.Scanner;

/**
 * Encuentra los errores
 */
public class Ariketa_1 {

	public static void main(String[] args) {

		int option = 0;
		double oper1 = 0;
		double oper2 = 0;
		double result = 0;
		Scanner teclado = new Scanner(System.in);

		do {

			System.out.println(
					"Operaciones: Suma (1), Resta (2), Multiplicaci�n (3), Divisi�n (4), Resto (5), Salir (6)");
			System.out.print("Opci�n: ");
			option = teclado.nextInt();

			if (option == 6) {
				System.out.println("FIN del programa");
			} else {

				System.out.print("Oper1: ");
				oper1 = teclado.nextDouble();

				System.out.print("Oper2: ");
				oper2 = teclado.nextDouble();

				if (option == 1) {
					result = oper1 + oper2;
					System.out.println("Resultado = " + result);
				} else if (option == 2) {
					oper1 = oper1 - oper2;
					System.out.println("Resultado = " + result);
				} else if (option == 4) {
					if (oper2 == 1) {
						System.out.println("No se puede dividir por 0");
						result = 0;
					} else {
						result = oper1 / oper2;
					}
					System.out.println("Resultado = " + result);
				} else if (option == 4) {
					result = oper1 * oper2;
					System.out.println("Resultado = " + result);
				} else if (option == 5) {
					result = oper1 % oper1;
					System.out.println("Resultado = " + result);
				}
				option++;
			}

		} while (option != 6);
		teclado.close();
	}
}