package olympic.main.game;

import olympic.main.person.athlete.Athlete;

import java.util.ArrayList;
import java.util.List;

public abstract class Game {
    protected List<Athlete> athleteList = new ArrayList<>();
    public Game(String name,List<Athlete> athleteList){
        this.athleteList=athleteList;
    }
    abstract public void start();
    protected String name;

    public String getName() {
        return name;
    }
}
