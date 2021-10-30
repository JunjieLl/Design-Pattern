package olympic.main.person.athlete;

import olympic.main.person.interview.Interviewee;
import olympic.main.person.interview.Listener;

import java.util.HashMap;

public abstract class Athlete extends Interviewee implements Listener {
    protected HashMap<String, Integer> rank = new HashMap<>();

    public Athlete(String name, String nation) {
        super(name,nation);
    }

    public String getName() {
        return name;
    }

    public String getNation() {
        return nation;
    }

    public Integer getRank(String game) {
        return rank.getOrDefault(game, 0);
    }

    public void setRank(String game, Integer rank) {
        this.rank.put(game, rank);
    }
}
