package logika;

public class Clovek {

    private String nazev;

    public Clovek(String nazev) {
        this.nazev = nazev;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String toString(){
        return nazev;
    }
}
