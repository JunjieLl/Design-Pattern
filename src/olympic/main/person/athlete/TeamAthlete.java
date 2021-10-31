package olympic.main.person.athlete;

import java.util.ArrayList;
import java.util.List;

public class TeamAthlete extends Athlete{
    protected List<Athlete> athleteList = new ArrayList<>();

    public TeamAthlete(String name,String nation,List<Athlete> athleteList){
        super(name,nation);
        this.athleteList=athleteList;
    }

    public TeamAthlete(List<Athlete> athleteList,String nation){
        super("无名",nation);
        this.athleteList=athleteList;
    }

    public List<Athlete> getAthleteList() {
        return athleteList;
    }

    @Override
    public void update(String content) {
    }

    @Override
    public void passFire() {
        for(Athlete athlete:athleteList){
            athlete.passFire();
        }
    }

    public int getNumber()
    {
        return athleteList.size();
    }
}
