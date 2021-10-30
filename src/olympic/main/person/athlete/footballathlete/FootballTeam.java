package olympic.main.person.athlete.footballathlete;

import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.TeamAthlete;

import java.util.List;


public class FootballTeam extends TeamAthlete {

    private int id;

    public FootballTeam(String name, String nation, List<Athlete> athleteList, int id) {
        super(name, nation, athleteList);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
