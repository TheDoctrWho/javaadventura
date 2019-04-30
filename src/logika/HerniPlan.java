package logika;


/**
 *  Class HerniPlan - třída představující mapu a stav adventury.
 * 
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  propojuje je vzájemně pomocí východů 
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 *@version    pro školní rok 2016/2017
 */
public class HerniPlan {
    
    private Prostor aktualniProstor;
    private Batoh batoh;

     /**
     *  Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví halu.
     */
    public HerniPlan() {
        zalozProstoryHry();
        batoh = new Batoh();

    }
    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví Dálecká Loď.
     */
    @SuppressWarnings("Duplicates")
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory
        Prostor daleckaLod = new Prostor("DáleckáLoď","Dálecká loď");
        Prostor chodbaKVezeni = new Prostor("ChodbakVězení", "chodba, přes kterou se dostaneme do vězení");
        Prostor vezeni = new Prostor("Vězení","Vězení, kde je držena Rose");
        Prostor zbrojnice = new Prostor("Zbrojnice","Zbrojnice naplněná hromadou zbraní");
        Prostor chodbaKMustku = new Prostor("Chodbakmůstku","chodba kterou se jde k můstku");
        Prostor rozcestiUMustku = new Prostor("Rozcestíumůstku","Tady se rozchází cesta do skladu a k můstku");
        Prostor sklad = new Prostor("Sklad","Místo, kde se nachází TARDIS");
        Prostor velitelskyMustek = new Prostor("Můstek","Tady je Davros");
        Prostor tardis = new Prostor("TARDIS", "HAPPY END");


        // přiřazují se průchody mezi prostory (sousedící prostory)
        daleckaLod.setVychod(chodbaKVezeni);
        daleckaLod.setVychod(zbrojnice);
        chodbaKVezeni.setVychod(daleckaLod);
        chodbaKVezeni.setVychod(vezeni);
        chodbaKVezeni.setVychod(chodbaKMustku);
        vezeni.setVychod(chodbaKVezeni);
        zbrojnice.setVychod(daleckaLod);
        zbrojnice.setVychod(chodbaKMustku);
        chodbaKMustku.setVychod(zbrojnice);
        chodbaKMustku.setVychod(chodbaKVezeni);
        chodbaKMustku.setVychod(rozcestiUMustku);
        rozcestiUMustku.setVychod(chodbaKMustku);
        rozcestiUMustku.setVychod(sklad);
        rozcestiUMustku.setVychod(velitelskyMustek);
        sklad.setVychod(rozcestiUMustku);
        velitelskyMustek.setVychod(rozcestiUMustku);
        sklad.setVychod(tardis);


        //veci
        Vec sroubovak = new Vec("Šroubovák", true);
        Vec zbran = new Vec("Zbraň", false);
        Vec pacidlo = new Vec("Páčidlo",true);
        Vec noviny = new Vec("Dálecké noviny",true);
        Vec sachta = new Vec("Větrací šachta",false);

        //veci v prostoru
        zbrojnice.pridejVec(zbran);
        zbrojnice.pridejVec(sroubovak);
        daleckaLod.pridejVec(noviny);
        chodbaKVezeni.pridejVec(pacidlo);
        chodbaKVezeni.pridejVec(sachta);

        //lide
        Clovek dalek = new Clovek("Dalek");
        Clovek oswin = new Clovek("Oswin");
        Clovek sec = new Clovek("Sec");
        Clovek rose = new Clovek("Rose");

        //kde jsou lide
        zbrojnice.pridejOsobu(oswin);
        chodbaKVezeni.pridejOsobu(sec);
        rozcestiUMustku.pridejOsobu(dalek);
        vezeni.pridejOsobu(rose);


        aktualniProstor = daleckaLod;  // hra začíná v domečku
    }
    
    /**
     *  Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     *@return     aktuální prostor
     */
    
    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }
    
    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     *@param  prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor){
    aktualniProstor = prostor;
    }

    public Batoh getBatoh() {
        return batoh;
    }

}
