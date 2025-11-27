package ariketa05;

import java.util.Scanner;

public class Ariketa05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String tenp = "";
		double tenperatura = 0;
		double celsius = 0;
		double fahrenheit = 0;
		int aukera = 0;

		do {
			do {
				try {
					System.out.println("Zer kalkulatu nahi duzu?");
					System.out.println("1. Celsius --> Fahrenheit");
					System.out.println("2. Fahrenheit --> Celsius");
					aukera = sc.nextInt();
				} catch (Exception e) {
					System.out.println("Sartu zenbaki bat");
					aukera = -1;
					sc.next();
				}
			} while (aukera == -1);
			System.out.println("Sartu tenperatura: ");
			tenp = sc.next();

			tenp = tenp.replace(",", ".");

			tenperatura = Double.parseDouble(tenp);

			switch (aukera) {
			case 1:
				fahrenheit = Metodoak.fahrenheitToCelsiust(tenperatura);
				break;
			case 2:
				celsius = Metodoak.celsiusToFahrenheit(tenperatura);
				break;
			default:
				System.out.println("Sartu datu egokia");
				aukera = -1;

			}
		} while (aukera != 1 && aukera != 2);

		if (aukera == 1) {
			System.out.println("Fahrenheit: " + fahrenheit);
		} else {
			System.out.println("Celsius: " + celsius);
		}

		sc.close();
	}
}
