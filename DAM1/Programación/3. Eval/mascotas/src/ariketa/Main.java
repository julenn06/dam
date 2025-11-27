package ariketa;

public class Main {
	public static void main(String[] args) {
		Inventario inventario = new Inventario(8);

		inventario.agregarMascota(new Perro("Max", 5, "Saludable", "2019-01-01", "Labrador", true));
		inventario.agregarMascota(new Perro("Rex", 3, "Saludable", "2021-06-15", "Bulldog", false));
		inventario.agregarMascota(new Gato("Mimi", 2, "Saludable", "2022-03-10", "Negro", true));
		inventario.agregarMascota(new Gato("Luna", 4, "Saludable", "2020-08-25", "Blanco", false));
		inventario.agregarMascota(new Loro("Paco", 6, "Activo", "2018-11-12", "Corto", true, "Amazonas"));
		inventario.agregarMascota(new Loro("Lola", 5, "Activo", "2019-07-30", "Mediano", false, "África"));
		inventario.agregarMascota(new Canario("Piolin", 1, "Feliz", "2023-02-14", "Pequeño", true, "Amarillo"));
		inventario.agregarMascota(new Canario("Sol", 2, "Feliz", "2022-05-20", "Pequeño", true, "Naranja"));

		inventario.mostrarMascotas();
	}
}