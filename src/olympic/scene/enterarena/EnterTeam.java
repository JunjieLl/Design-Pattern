package olympic.scene.enterarena;

import olympic.main.person.athlete.Athlete;

import java.util.ArrayList;
import java.util.List;

public class EnterTeam {
    List<Athlete> athletes;
    String nation;

    public EnterTeam(List<Athlete> athletes, String nation) {
        this.athletes = athletes;
        this.nation = nation;
    }

    public List<Athlete> getAthletes() {
        return athletes;
    }

    public String getNation() {
        return nation;
    }
}
