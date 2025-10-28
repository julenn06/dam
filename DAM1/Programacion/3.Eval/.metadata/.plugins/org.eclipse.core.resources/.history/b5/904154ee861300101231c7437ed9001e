package ariketa;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Excepciones en ecuación de segundo grado");

			System.out.print("Introducir A: ");
			double A = sc.nextDouble();

			System.out.print("Introducir B: ");
			double B = sc.nextDouble();

			System.out.print("Introducir C: ");
			double C = sc.nextDouble();

			resolverEcuacion(A, B, C);

		} catch (Cero e) {
			System.out.println("El Valor A no puede ser Cero");
		} catch (Negativo e) {
			System.out.println("No da un resultado real");
		} catch (NumberFormatException e) {
			System.out.println("El dato introducido debe ser numérico");
		} finally {
			sc.close();
		}
	}

	public static void resolverEcuacion(double A, double B, double C) throws Cero, Negativo {
		if (A == 0) {
			throw new Cero("El valor de A no puede ser cero");
		}

		double resultado = B * B - 4 * A * C;

		if (resultado < 0) {
			throw new Negativo("No puede tener valores negativos");
		}

		if (resultado == 0) {
			System.out.println("El resultado es");
			double x = -B / (2 * A);
			System.out.println(" X: " + x);
			return;
		}

		double x1 = (-B + Math.sqrt(resultado)) / (2 * A);
		double x2 = (-B - Math.sqrt(resultado)) / (2 * A);

		System.out.println("Hay dos resultados posibles");
		System.out.println("x1: " + x1);
		System.out.println("x2: " + x2);
	}
}
