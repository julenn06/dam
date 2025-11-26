package modeloa;

public class Txakurra {
    private String izena;
    private int adina;
    private String arraza;

    // Eraikitzailea
    public Txakurra(String izena, int adina, String arraza) {
        this.izena = izena;
        this.adina = adina;
        this.arraza = arraza;
    }

    // Getter eta Setterrak
    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public int getAdina() {
        return adina;
    }

    public void setAdina(int adina) {
        this.adina = adina;
    }

    public String getArraza() {
        return arraza;
    }

    public void setArraza(String arraza) {
        this.arraza = arraza;
    }

    @Override
    public String toString() {
        return "Txakurra{" +
                "izena='" + izena + '\'' +
                ", adina=" + adina +
                ", arraza='" + arraza + '\'' +
                '}';
    }
}

