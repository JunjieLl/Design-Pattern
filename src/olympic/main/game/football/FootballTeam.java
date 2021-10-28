package olympic.main.game.football;

import olympic.main.person.athlete.TeamAthlete;


public class FootballTeam extends TeamAthlete {

    private int id;

    public FootballTeam(String nation, int id) {
        super(nation);
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
