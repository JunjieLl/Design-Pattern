package olympic.main.game;



import olympic.main.person.athlete.Athlete;

import java.util.ArrayList;
import java.util.List;

public abstract class Game {
    protected List<Athlete> athletes = new ArrayList<>();
    public Game(List<Athlete> athleteList){
        this.athletes=athleteList;
    }



    protected String name;

    public String getName() {
        return name;
    }
    public Game(){}
    public abstract void start();
}
