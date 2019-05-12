package logika;

public class PrikazMluv implements IPrikaz {
    private static final String NAZEV = "mluv";
    private final HerniPlan herniPlan;
    private Hra hra;

    public PrikazMluv(HerniPlan herniPlan, Hra hra) {
        this.herniPlan = herniPlan;
        this.hra = hra;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            return "Nevím s kým mluvit";
        }
        String clovek = parametry[0];
        if (!herniPlan.getAktualniProstor().clovekJeVProstoru(clovek)) {
            return "Osoba " + clovek + " se v prostoru nenachází.";
        }
        Rozhovory rozhovor = new Rozhovory(herniPlan, hra);
        Batoh kapsy = herniPlan.getBatoh();
        String odpoved;
        if (kapsy.obsahujePredmet("sroubovak")&& herniPlan.getAktualniProstor().getNazev().equals("vezeni")){
            odpoved = rozhovor.pokec(clovek, "sroubovak");
        } else {
            odpoved = rozhovor.pokec(clovek, "");
        }
        return odpoved;
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
