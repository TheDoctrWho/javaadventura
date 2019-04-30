package logika;

import java.util.ArrayList;
import java.util.List;

public class Batoh {

    private List<Vec> obsahBatohu;
    private static final int KAPACITA_BATOHU = 4;

    public Batoh(List<Vec> obsahBatohu) {
        this.obsahBatohu = obsahBatohu;
    }

    public Batoh(){
        obsahBatohu = new ArrayList<Vec>();
    }

    public boolean pridejVec(Vec vec){
        return obsahBatohu.add(vec);
    }

    public boolean jeVBatohuMisto(){
        return obsahBatohu.size() < KAPACITA_BATOHU;
    }

    public List<Vec> getObsahBatohu(){
        return obsahBatohu;
    }
}
