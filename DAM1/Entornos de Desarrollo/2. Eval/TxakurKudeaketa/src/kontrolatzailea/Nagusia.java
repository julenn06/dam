package kontrolatzailea;

import modeloa.Txakurra;
import modeloa.TxakurKontenedorea;

public class Nagusia {
    public static void main(String[] args) {
        TxakurKontenedorea kontenedorea = new TxakurKontenedorea(5);

        kontenedorea.gehituTxakurra(new Txakurra("Max", 5, "Labrador"));
        kontenedorea.gehituTxakurra(new Txakurra("Bella", 3, "Beagle"));
        kontenedorea.gehituTxakurra(new Txakurra("Charlie", 4, "Bulldog"));

        System.out.println("Txakurren zerrenda:");
        kontenedorea.zerrendatuTxakurrak();

        System.out.println("Bella bilatzen:");
        System.out.println(kontenedorea.bilatuIzenez("Bella"));

        System.out.println("Max eguneratzen:");
        kontenedorea.eguneratuTxakurra("Max", 6, "Golden Retriever");
        kontenedorea.zerrendatuTxakurrak();

        System.out.println("Charlie ezabatzen:");
        kontenedorea.ezabatuTxakurra("Charlie");
        kontenedorea.zerrendatuTxakurrak();
    }
}

