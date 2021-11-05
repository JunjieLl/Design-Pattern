package olympic.main.game.basketball.round;

import olympic.main.game.Game;
import olympic.main.game.Valve;
import olympic.main.game.basketball.BasketballMatch;
import olympic.main.game.basketball.Schedule;
import olympic.main.person.athlete.basketballathlete.BasketballTeam;

import java.util.ArrayList;
import java.util.List;

/**
 * 一轮比赛
 * Pipeline模式
 * 相当于Valve
 */
public abstract class Round extends Valve {
    /**
     * 下一轮比赛
     */
    private Round next = null;

    /**
     * 赛程表
     */
    protected Schedule schedule = new Schedule();

    /**
     * 本轮参赛球队
     */
    protected List<BasketballTeam> teams = null;

    /**
     * 晋级球队
     */
    protected List<BasketballTeam> advancedTeams = new ArrayList<>();

    /**
     * 读入本轮参赛球队
     * @param teams 参赛球队
     */
    public void setTeams(List<BasketballTeam> teams) {
        this.teams = teams;
    }

    /**
     * 获取本轮晋级球队
     * @return 晋级球队
     */
    public List<BasketballTeam> getAdvancedTeams() {
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
     * @return 下一轮比赛
     */
    public Round getNext() {
        return next;
    }
}
