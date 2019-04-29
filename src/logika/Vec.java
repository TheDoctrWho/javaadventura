package logika;

public class Vec {

    private String nazev;
    private final boolean prenositelna;

    public Vec(String nazev, boolean prenositelna) {
        this.nazev = nazev;
        this.prenositelna = prenositelna;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public boolean isPrenositelna() {
        return prenositelna;
    }
}
