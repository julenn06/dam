package ariketa01;

public class Main {
	public static void main(String[] args) {
		Troiar troiar1 = new Troiar("Hector", 30, 9);
		Greziar greziar1 = new Greziar("Achilles", 25, 10);

		greziar1.zauritua = true;
		System.out.println(greziar1.erretiratu());
		System.out.println();

		troiar1.zauritua = true;
		System.out.println(troiar1.erretiratu());
		System.out.println();

		System.out.println("///////////////////////////");
		System.out.println();

		greziar1.zauritua = false;
		System.out.println(greziar1.erretiratu());
		System.out.println();

		troiar1.zauritua = false;
		System.out.println(troiar1.erretiratu());
		System.out.println();

		System.out.println("///////////////////////////");
		System.out.println();

		greziar1.hilda = true;
		System.out.println(greziar1.erretiratu());
		System.out.println();

		troiar1.hilda = true;
		System.out.println(troiar1.erretiratu());
		System.out.println();

		System.out.println("///////////////////////////");
		System.out.println();

		// Adina eta Indarra txarto
		troiar1 = new Troiar("Hector", 5, 100);
		greziar1 = new Greziar("Achilles", 5, 100);

		System.out.println(greziar1.erretiratu());
		System.out.println();

		System.out.println(troiar1.erretiratu());
		System.out.println();

		System.out.println("///////////////////////////");
		System.out.println();

		// Defektuzko balioak
		troiar1 = new Troiar();
		greziar1 = new Greziar();

		System.out.println(greziar1.erretiratu());
		System.out.println();

		System.out.println(troiar1.erretiratu());
		System.out.println();
	}
}