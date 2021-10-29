package olympic.main.person.athlete.pingong.Strategy;

import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.IndividualAthlete;

public interface Strategy {
    Boolean playWith(Athlete oppoent);
    void setOwnerAthlete(Athlete ownerAthlete);
}
