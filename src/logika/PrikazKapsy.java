package logika;

import java.util.List;

/**
 *  Třída PrikazJdi implementuje pro hru příkaz jdi.
 *  Tato třída je součástí jednoduché textové hry.
 *
 *@author     Jarmila Pavlickova, Luboš Pavlíček
 *@version    pro školní rok 2016/2017
 */
class PrikazKapsy implements IPrikaz {
    private static final String NAZEV = "kapsy";
    private HerniPlan plan;

    /**
     *  Konstruktor třídy
     *
     *  @param plan herní plán, ve kterém se bude ve hře "chodit"
     */
    public PrikazKapsy(HerniPlan plan) {
        this.plan = plan;

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
        if (parametry.length != 0) {
            // pokud chybí druhé slovo (sousední prostor), tak ....
            return "Toto je bezparametrický příkaz";
        }

        Batoh kapsy = plan.getBatoh();
        if (kapsy.getObsahBatohu().size() == 0){
            return "Kapsy jsou prázdné";
        }
        String vracenyText = "Věci v kapsách: | ";
        for (Vec batoh : kapsy.getObsahBatohu()) {
            vracenyText += batoh.toString() + " | ";
        }
        return vracenyText;

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