package olympic.main.game.football;

import olympic.main.person.athlete.TeamAthlete;


public class FootballTeam extends TeamAthlete {

    private int group;
    private int id;   // 组内的ID

    public FootballTeam(String nation, int group, int id) {
        super(nation);
        this.group = group;
        this.id = id;
    }

    public int getGroup() {
        return group;
    }

    public int getId() {
        return id;
    }
}
