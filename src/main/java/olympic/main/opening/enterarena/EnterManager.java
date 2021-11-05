package olympic.main.opening.enterarena;

import olympic.main.game.Aggregate;
import olympic.main.person.athlete.TeamAthlete;

import java.util.ArrayList;
import java.util.List;

/**
 * 入场管理者
 */
public class EnterManager implements Aggregate {
    private static EnterManager singleton = new EnterManager();

    private EnterManager() {
    }

    /**
     * 返回入场管理者实例
     * @return EnterManager
     */
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

    /**
     * 返回队伍长度
     * @return allteams.size()
     */
    public int getLength() {
        return allteams.size();
    }

    /**
     * 获取相应位置的队员
     * @param index
     * @return
     */
    public TeamAthlete getTeamAt(int index) {
        return allteams.get(index);
    }

    /**
     * 入场迭代器
     * @return EnterIterator
     */
    @Override
    public EnterIterator iterator() {
        return new EnterIterator(this);
    }

}
