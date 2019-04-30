package logika;

public class Vec {

    private String nazev;
    private boolean jeSebratelna;

    public Vec(String nazev, boolean jeSebratelna){
        this.nazev = nazev;
        this.jeSebratelna = jeSebratelna;
    }

    public String getNazev() {
        return nazev;
    }

    public boolean jeSebratelna() {
        return jeSebratelna;
    }

    public boolean equals(Object object) {
        if (object instanceof Vec) {
            Vec vec = (Vec) object;
            return nazev.equals(vec.nazev);
        }
        return false;
    }

    public int hashCode() {
        return nazev.hashCode();
    }
}
