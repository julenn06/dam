package zatia1;

public class Main {
	public static void main(String[] args) {
		MultimediaZerrenda lista = new MultimediaZerrenda(10);

		Filma f1 = new Filma("Inception", "Christopher Nolan", "bluray", 148, "Leonardo DiCaprio", "Marion Cotillard");
		Filma f2 = new Filma("Titanic", "James Cameron", "dvd", 195, "Leonardo DiCaprio", "Kate Winslet");
		Filma f3 = new Filma("Interstellar", "Christopher Nolan", "mkv", 169, "Matthew McConaughey", "Anne Hathaway");

		lista.add(f1);
		lista.add(f2);
		lista.add(f3);

		System.out.println(lista);
	}

}
