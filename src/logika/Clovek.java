package logika;

public class Clovek {

    private String nazev;
    private boolean spolecnik;

    public Clovek(String nazev) {
        this.nazev = nazev;
        this.spolecnik = false;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }
    public void setSpolecnik(boolean spolecnik){
        this.spolecnik = spolecnik;
    }

    public String toString(){
        return nazev;
    }
}
