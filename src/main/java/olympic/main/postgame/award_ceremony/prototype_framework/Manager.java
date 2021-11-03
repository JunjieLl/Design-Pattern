package olympic.main.postgame.award_ceremony.prototype_framework;

import java.util.*;

public class Manager {
    private HashMap showcase = new HashMap();
    public void register(String name, MedalProduct proto){
        showcase.put(name,proto);
    }
    public MedalProduct create(String protoName){
        MedalProduct p = (MedalProduct) showcase.get(protoName);
        return p.createClone();
    }
}
