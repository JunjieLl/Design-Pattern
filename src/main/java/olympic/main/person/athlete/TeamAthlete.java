package olympic.main.person.athlete;

import java.util.ArrayList;
import java.util.List;

/**
 * 团队运动员类
 */
public class TeamAthlete extends Athlete {
    protected List<Athlete> athleteList = new ArrayList<>();

    public TeamAthlete(String name, String nation, List<Athlete> athleteList) {
        super(name, nation);
        this.athleteList = athleteList;
    }

    public TeamAthlete(List<Athlete> athleteList, String nation) {
        super("无名", nation);
        this.athleteList = athleteList;
    }

    public TeamAthlete(String nation) {
        super("无名", nation);
    }

    public List<Athlete> getAthleteList() {
        return athleteList;
    }

    @Override
    public void update(String content) {
        memory.add(content);
        for (Athlete athlete : athleteList) {
            athlete.getMemory().add(content);
        }
    }

    @Override
    public void passFire() {
        for (Athlete athlete : athleteList) {
            athlete.passFire();
        }
    }

    public Athlete getFirstAthlete() {
        return athleteList.get(0);
    }

    public void addMember(Athlete athlete) {
        athleteList.add(athlete);
    }

    public int getNumber() {
        return athleteList.size();
    }
}
