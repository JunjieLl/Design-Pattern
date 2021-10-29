package olympic.main.person.athlete;

import java.util.HashMap;

public abstract class Athlete {
    protected String name;
    protected String nation;
    protected HashMap<String, Integer> rank = new HashMap<>();

    public Athlete(String name, String nation) {
        this.name = name;
        this.nation = nation;
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
