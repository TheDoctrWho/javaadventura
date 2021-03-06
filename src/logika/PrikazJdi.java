package logika;

/**
 *  Třída PrikazJdi implementuje pro hru příkaz jdi.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 *@author     Jarmila Pavlickova, Luboš Pavlíček
 *@version    pro školní rok 2016/2017
 */
class PrikazJdi implements IPrikaz {
    private static final String NAZEV = "jdi";
    private HerniPlan plan;
    private Hra hra;
    
    /**
    *  Konstruktor třídy
    *  
    *  @param plan herní plán, ve kterém se bude ve hře "chodit" 
    */    
    public PrikazJdi(HerniPlan plan, Hra hra) {
        this.plan = plan;
        this.hra = hra;
    }

    /**
     *  Provádí příkaz "jdi". Zkouší se vyjít do zadaného prostoru. Pokud prostor
     *  existuje, vstoupí se do nového prostoru. Pokud zadaný sousední prostor
     *  (východ) není, vypíše se chybové hlášení.
     *
     *@param parametry - jako  parametr obsahuje jméno prostoru (východu),
     *                         do kterého se má jít.
     *@return zpráva, kterou vypíše hra hráči
     */ 
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (sousední prostor), tak ....
            return "Kam mám jít? Musíš zadat jméno východu";
        }

        String smer = parametry[0];

        // zkoušíme přejít do sousedního prostoru
        Prostor sousedniProstor = plan.getAktualniProstor().vratSousedniProstor(smer);
        Batoh kapsy = plan.getBatoh();
        Rozhovory rozhovor = new Rozhovory(plan, hra);

        if (sousedniProstor == null) {
            return "Tam se odsud jít nedá!";
        } else if (smer.contains("chodba2") && !kapsy.obsahujePredmet("mapa")){
            return "Tam se bez mapy neodvážím!";
        } else if (smer.contains("mustek")){
            plan.setAktualniProstor(sousedniProstor);
            return sousedniProstor.dlouhyPopis() + "\n" + "\n" + rozhovor.pokec("Davros","");
        } else if (smer.contains("rozcesti") && !kapsy.obsahujePredmet("sroubovak")){
            plan.setAktualniProstor(sousedniProstor);
            return sousedniProstor.dlouhyPopis() + "\n" + "\n" + rozhovor.pokec("Dalek","");
        } else if (smer.contains("rozcesti") && kapsy.obsahujePredmet("sroubovak")){
            plan.setAktualniProstor(sousedniProstor);
            return sousedniProstor.dlouhyPopis() + "\n" + "\n" + rozhovor.pokec("Dalek","sroubovak");
        } else if (smer.contains("zbrojnice") && kapsy.obsahujePredmet("pacidlo")){
            plan.setAktualniProstor(sousedniProstor);
            return sousedniProstor.dlouhyPopis() + "\n" + "\n Vždyť jsi Dalek Oswin!!!";
        } else if (kapsy.obsahujePredmet("pacidlo")){
            plan.setAktualniProstor(sousedniProstor);
            return sousedniProstor.dlouhyPopis() + "\n" + "\n" + "Doktore prosím pomoz mi jsem tu uvězněná a " +
                    "potřebuji se odtud dostat jsem ve Zbrojnici, pomož mi PROSÍM!";
        } else if (smer.contains("TARDIS")&& kapsy.obsahujePredmet("Rose")){
            hra.setKonecHry(true);
            return "Gratuluji právě jste úspěšně dokončili hru.";
        } else if (smer.contains("TARDIS")&& !kapsy.obsahujePredmet("Rose")){
            return "Nemohu odejít bez Rose!!! Musím ji zachránit";
        }
        else {
            plan.setAktualniProstor(sousedniProstor);
            return sousedniProstor.dlouhyPopis();
        }
    }
    
    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return nazev prikazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }

}
