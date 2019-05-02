package logika;

public class PrikazDej implements IPrikaz {
    private static final String NAZEV = "dej";
    private final HerniPlan herniPlan;
    private Hra hra;

    public PrikazDej(HerniPlan herniPlan, Hra hra) {
        this.herniPlan = herniPlan;
        this.hra = hra;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            return "Nevím co mám komu dát";
        }
        String vec = parametry[0];
        String clovek = parametry[1];
        if (!herniPlan.getAktualniProstor().clovekJeVProstoru(clovek)) {
            return "Osoba " + clovek + " se v prostoru nenachází.";
        }
        Rozhovory rozhovor = new Rozhovory(herniPlan, hra);
        String odpoved = rozhovor.pokec(clovek, vec);
        return odpoved;
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
