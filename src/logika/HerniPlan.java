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
    
     /**
     *  Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví halu.
     */
    public HerniPlan() {
        zalozProstoryHry();

    }
    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví domeček.
     */
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory
        Prostor daleckaLod = new Prostor("Dálecká Loď","Dálecká loď");
        Prostor chodbaKVezeni = new Prostor("Chodba k Vězení", "chodba, přes kterou se dostaneme do vězení");
        Prostor vezeni = new Prostor("Vězení","Vězení, kde je držena Rose");
        Prostor zbrojnice = new Prostor("les","les s jahodami, malinami a pramenem vody");
        Prostor chodbaKMustku = new Prostor("hluboký_les","temný les, ve kterém lze potkat vlka");
        Prostor rozcestiUMustku = new Prostor("","");
        Prostor sklad = new Prostor("","");
        Prostor velitelskyMustek = new Prostor("","");


        // přiřazují se průchody mezi prostory (sousedící prostory)
        //sklad.setVychod(les);
        //les.setVychod(sklad);
        //les.setVychod(hlubokyLes);
        //hlubokyLes.setVychod(les);
        //hlubokyLes.setVychod(jeskyne);
        //hlubokyLes.setVychod(chaloupka);
        //jeskyne.setVychod(hlubokyLes);
        //chaloupka.setVychod(hlubokyLes);

        Vec koste = new Vec("koste", true);

        Clovek Dalek = new Clovek("Dalek", true);

        //domecek.pridejVec(koste);
                
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
    public void setAktualniProstor(Prostor prostor) {
       aktualniProstor = prostor;
    }

}
