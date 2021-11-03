package olympic.main.opening.enterarena;

import olympic.main.game.Aggregate;
import olympic.main.person.athlete.TeamAthlete;

import java.util.ArrayList;
import java.util.List;

public class EnterManager implements Aggregate {
    private static EnterManager singleton = new EnterManager();
    private EnterManager() {}
    public static EnterManager getInstance() {
        return singleton;
    }
    private List<TeamAthlete> allteams = new ArrayList<>();

    /**
     * 添加成员
     * @param teams
     */
    public void setTeams(TeamAthlete teams) {
        allteams.add(teams);
    }

    public int getLength()
    {
        return allteams.size();
    }

    public TeamAthlete getTeamAt(int index)
    {
        return allteams.get(index);
    }

    @Override
    public EnterIterator iterator() {
        return new EnterIterator(this);
    }

}
