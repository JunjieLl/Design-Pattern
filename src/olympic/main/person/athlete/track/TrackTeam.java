package olympic.main.person.athlete.track;

import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.TeamAthlete;

import java.util.List;

public class TrackTeam extends TeamAthlete{
    public TrackTeam(String name, String nation, List<Athlete> athleteList) {
        super(name, nation, athleteList);
    }
}
