package logika;

public class PrikazSeber implements IPrikaz {
    private static final String NAZEV = "seber";
    private final HerniPlan herniPlan;

    public PrikazSeber(HerniPlan herniPlan) {
        this.herniPlan = herniPlan;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            return "Nevím co mam sebrat.";
        }
        String nazevVeci = parametry[0];
        if (!herniPlan.getAktualniProstor()
                .vecJeVProstoru(nazevVeci)) {
            return "Věc s názvem " +
                    nazevVeci +
                    " se v prostoru nenachází.";
        }
        Vec vec = herniPlan.getAktualniProstor().getVeci().get(nazevVeci);
        if (!vec.isPrenositelna()) {
            return "Tuto vec neni mozne prenest!";
        }
        herniPlan
                .getAktualniProstor()
                .odstranVec(nazevVeci);
        return "Sebral jsi vec " + nazevVeci;
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
