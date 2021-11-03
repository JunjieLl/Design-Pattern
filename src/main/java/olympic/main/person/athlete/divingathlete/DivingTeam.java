package olympic.main.person.athlete.divingathlete;

import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.TeamAthlete;

import java.util.List;

/**
 * 跳水组合（一组两人）
 */
public class DivingTeam extends TeamAthlete {

    public DivingTeam(String name, String nation, List<Athlete> athleteList) {
        super(name, nation, athleteList);
    }
}
