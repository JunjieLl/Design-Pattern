package olympic.main.person.athlete.divingathlete;

import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.TeamAthlete;

import java.util.List;

public class DivingTeam extends TeamAthlete {

    public DivingTeam(String name, String nation, List<Athlete> athleteList) {
        super(name,nation,athleteList);
        System.out.println(nation + "组合" + name + "已经入场");
    }
}
