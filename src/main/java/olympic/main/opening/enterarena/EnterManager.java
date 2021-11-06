package olympic.main.opening.enterarena;

import olympic.main.game.Aggregate;
import olympic.main.person.athlete.TeamAthlete;

import java.util.ArrayList;
import java.util.List;

/**
 * 入场管理者
 */
public class EnterManager implements Aggregate {
    private final static EnterManager singleton = new EnterManager();


    /**
     * 构造函数
     */
    private EnterManager() {
    }

    /**
     * 返回入场管理者实例
     * @return EnterManager 返回实例
     */
    public static EnterManager getInstance() {
        return singleton;
    }

    /**
     * 所有队伍
     */
    private final List<TeamAthlete> allteams = new ArrayList<>();

    /**
     * 添加成员
     * @param teams 添加队伍
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
     * @param index 相应位置
     * @return 相应位置的队员
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
