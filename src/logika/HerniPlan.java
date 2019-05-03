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
        Prostor daleckaLod = new Prostor("lod","Dálecká loď");
        Prostor chodbaKVezeni = new Prostor("chodba1", "Chodba k Vězení");
        Prostor vezeni = new Prostor("vezeni","Vězení, kde je držena Rose");
        Prostor zbrojnice = new Prostor("zbrojnice","Zbrojnice naplněná hromadou zbraní");
        Prostor chodbaKMustku = new Prostor("chodba2","Chodba k můstku");
        Prostor rozcestiUMustku = new Prostor("rozcesti","Tady se rozchází cesta do skladu a k můstku");
        Prostor sklad = new Prostor("sklad","Místo, kde se nachází TARDIS");
        Prostor velitelskyMustek = new Prostor("mustek","Můstek - Tady je Davros");


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


        //veci
        Vec sroubovak = new Vec("sroubovak", true);
        Vec zbran = new Vec("zbran", false);
        Vec pacidlo = new Vec("pacidlo",true);
        Vec noviny = new Vec("noviny",true);
        Vec sachta = new Vec("sachta",false);
        Vec tardis = new Vec("TARDIS", false);


        //veci v prostoru
        zbrojnice.pridejVec(zbran);
        zbrojnice.pridejVec(sroubovak);
        daleckaLod.pridejVec(noviny);
        chodbaKVezeni.pridejVec(pacidlo);
        chodbaKVezeni.pridejVec(sachta);
        sklad.pridejVec(tardis);

        //lide
        Clovek dalek = new Clovek("Dalek");
        Clovek oswin = new Clovek("Oswin");
        Clovek sec = new Clovek("Sec");
        Clovek rose = new Clovek("Rose");
        Clovek davros = new Clovek("Davros");

        //kde jsou lide
        zbrojnice.pridejOsobu(oswin);
        chodbaKVezeni.pridejOsobu(sec);
        rozcestiUMustku.pridejOsobu(dalek);
        vezeni.pridejOsobu(rose);
        velitelskyMustek.pridejOsobu(davros);


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
