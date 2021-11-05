package olympic.main.person.athlete.volleyballathlete;

import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.TeamAthlete;

import java.util.List;

public class VolleyballTeam extends TeamAthlete {

    private static int uid = 0;

    private static int generateId() {
        return uid++;
    }

    private int id;

    public VolleyballTeam(String name, String nation, List<Athlete> athleteList) {
        super(name, nation, athleteList);
        this.id = generateId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
