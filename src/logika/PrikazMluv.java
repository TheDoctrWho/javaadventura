package logika;

public class PrikazMluv implements IPrikaz {
    private static final String NAZEV = "mluv";
    private final HerniPlan herniPlan;

    public PrikazMluv(HerniPlan herniPlan) {
        this.herniPlan = herniPlan;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            return "Nevím s kým mluvit";
        }
        String clovek = parametry[0];
        if (!herniPlan.getAktualniProstor().clovekJeVProstoru(clovek)) {
            return "Věc s názvem " +
                    clovek +
                    " se v prostoru nenachází.";
        }
        Clovek clovicek = herniPlan.getAktualniProstor().getLide().get(clovek);
        if (!clovicek.isMluvi()) {
            return "Tuto vec neni mozne prenest!";
        }
        herniPlan
                .getAktualniProstor()
                .odstranVec(clovek);
        return "Sebral jsi vec " + clovek;
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
