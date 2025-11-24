package ariketa;

class Inventario {
	private Mascotas[] mascotas;
	private int kont;

	public Inventario(int capacidad) {
		mascotas = new Mascotas[capacidad];
		kont = 0;
	}

	public void agregarMascota(Mascotas mascota) {
		if (kont < mascotas.length) {
			mascotas[kont++] = mascota;
		} else {
			System.out.println("El inventario esta lleno");
		}
	}

	public void mostrarMascotas() {
		for (int i = 0; i < kont; i++) {
			mascotas[i].muestra();
			mascotas[i].habla();
			if (mascotas[i] instanceof Aves aves) {
				aves.volar();
			}
			System.out.println();
		}
	}
}