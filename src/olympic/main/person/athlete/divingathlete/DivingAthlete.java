package olympic.main.person.athlete.divingathlete;

import olympic.main.person.athlete.IndividualAthlete;

public class DivingAthlete extends IndividualAthlete {

    public DivingAthlete(String name, String nation) {
        super(name, nation);
        System.out.println(nation + "运动员" + name + "已经入场");
    }
}