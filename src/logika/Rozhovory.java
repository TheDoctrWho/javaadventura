package logika;

public class Rozhovory {
    private Hra hra;
    private HerniPlan plan;

    public Rozhovory(HerniPlan plan, Hra hra) {
        this.plan = plan;
        this.hra = hra;
    }

    public String pokec(String jmeno, String item){
        String odpoved;
        switch(jmeno) {
            case "Dalek":
                if (item.contains("sroubovak")){
                    odpoved = "Nechoď na můstek je tam Davros";
                } else {
                    odpoved = "EXTERMINATE! EXTERMINATE!";
                    hra.setKonecHry(true);
                }
                break;
            case "Oswin":
                if (item.contains("pacidlo")){
                    odpoved = "Run you clever boy and remember";
                    Batoh kapsy = plan.getBatoh();
                    kapsy.odeberVec(item);
                }else{
                    odpoved = "Potřebuji páčidlo, dones mi nějaké.";
                }
                break;
            case "Sec":
                if (item.contains("noviny")){
                    odpoved = "Děkuji tady máš Mapu";
                    Batoh kapsy = plan.getBatoh();
                    kapsy.odeberVec(item);
                    Vec mapa = new Vec("mapa", true);
                    kapsy.pridejVec(mapa);
                }else{
                    odpoved = "Chci nějaké novinky. Dones mi noviny, \n"+
                            "a já ti dám mapu lodi,";
                }
                break;
            case "Rose":                                                        //zatim BETA
                if (item.contains("sroubovak")){
                    odpoved = "Pojdmě musíme se odtud dostat";
                    Batoh kapsy = plan.getBatoh();
                    Vec rose = new Vec("Rose", true);
                    kapsy.pridejVec(rose);
                }else{
                    odpoved = "Doktore dostaň mě odsud prosím.";
                }
                break;
            case "Davros":
                odpoved = "Teď už mi neunikneš!";
                hra.setKonecHry(true);
                break;
            default:
                return "Jejda něco se pokazilo: " + jmeno;
        }
        return odpoved;
    }



}
