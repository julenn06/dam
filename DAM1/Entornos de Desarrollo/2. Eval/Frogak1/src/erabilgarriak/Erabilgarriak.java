package erabilgarriak;

public class Erabilgarriak {

	// 1. Sumar dos números
	public static int sumar(int a, int b) {
		return a + b;
	}

	// 2. Restar dos números
	public static int restar(int a, int b) {
		return a - b;
	}

	// 3. Multiplicar dos números
	public static int multiplicar(int a, int b) {
		return a * b;
	}

	// 4. Dividir dos números (con manejo de división por cero)
	public static double dividir(int a, int b) {
		if (b == 0) {
			throw new IllegalArgumentException("No se puede dividir por cero");
		}
		return (double) a / b;
	}

	// 5. Calcular el factorial de un número
	public static int factorial(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("El número debe ser positivo");
		}
		int resultado = 1;
		for (int i = 1; i <= n; i++) {
			resultado *= i;
		}
		return resultado;
	}

	// 6. Verificar si un número es par
	public static boolean esPar(int n) {
		return n % 2 == 0;
	}

	// 7. Contar vocales en una cadena
	public static int contarVocales(String texto) {
		if (texto == null) {
			throw new IllegalArgumentException("El texto no puede ser nulo");
		}
		int contador = 0;
		String vocales = "aeiouAEIOU";
		for (char c : texto.toCharArray()) {
			if (vocales.indexOf(c) != -1) {
				contador++;
			}
		}
		return contador;
	}

	// 8. Invertir una cadena
	public static String invertirCadena(String texto) {
		if (texto == null) {
			throw new IllegalArgumentException("El texto no puede ser nulo");
		}
		return new StringBuilder(texto).reverse().toString();
	}

	// 9. Buscar un elemento en un array
	public static boolean buscarEnArray(int[] array, int valor) {
		if (array == null) {
			throw new IllegalArgumentException("El array no puede ser nulo");
		}
		for (int num : array) {
			if (num == valor) {
				return true;
			}
		}
		return false;
	}

	// 10. Encontrar el máximo en un array
	public static int maxEnArray(int[] array) {
		if (array == null || array.length == 0) {
			throw new IllegalArgumentException("El array no puede ser nulo o vacío");
		}
		int max = array[0];
		for (int num : array) {
			if (num > max) {
				max = num;
			}
		}
		return max;
	}

}