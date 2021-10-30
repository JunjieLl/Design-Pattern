package olympic.scene.enterarena;

import olympic.main.game.Aggregate;
import olympic.main.game.football.FootballGameManager;
import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.footballathlete.FootballTeam;

import java.util.ArrayList;
import java.util.List;

public class EnterManager implements Aggregate {
    private static EnterManager singleton = new EnterManager();
    private EnterManager() {}
    public static EnterManager getInstance() {
        return singleton;
    }
    private ArrayList<EnterTeam> allteams = new ArrayList<>();

    public void setTeams(EnterTeam teams) {
        allteams.add(teams);
    }

    public int getLength()
    {
        return allteams.size();
    }

    public EnterTeam getTeamAt(int index)
    {
        return allteams.get(index);
    }

    @Override
    public EnterIterator iterator() {
        return new EnterIterator(this);
    }

}
