package logika;

public class Clovek {

    private String nazev;
    private final boolean mluvi;

    public Clovek(String nazev, boolean mluvi) {
        this.nazev = nazev;
        this.mluvi = mluvi;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public boolean isMluvi() {
        return mluvi;
    }

}
