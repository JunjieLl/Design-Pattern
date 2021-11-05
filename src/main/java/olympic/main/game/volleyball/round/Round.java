package olympic.main.game.volleyball.round;

import olympic.main.game.Game;
import olympic.main.game.Valve;
import olympic.main.game.volleyball.VolleyballMatch;
import olympic.main.game.volleyball.Schedule;
import olympic.main.person.athlete.volleyballathlete.VolleyballTeam;

import java.util.ArrayList;
import java.util.List;

/**
 * 一轮比赛
 * Pipeline模式
 * 相当于Valve
 */
public abstract class Round extends Valve {
    private Round next = null;
    protected Schedule schedule = new Schedule();
    protected List<VolleyballTeam> teams = null;
    protected List<VolleyballTeam> advancedTeams = new ArrayList<>();

    public void setTeams(List<VolleyballTeam> teams) {
        this.teams = teams;
    }

    public List<VolleyballTeam> getAdvancedTeams() {
        return this.advancedTeams;
    }

    /**
     * 设置下一轮比赛
     * @param valve 下一轮比赛
     * @return 下一轮比赛
     */
    @Override
    public Valve setNext(Valve valve) {
        next = (Round) valve;
        return next;
    }

    /**
     * 获取下一轮比赛
     *
     * @return 下一轮比赛
     */
    public Round getNext() {
        return next;
    }
}
