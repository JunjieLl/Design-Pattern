package olympic.main.game.volleyball.round;

import olympic.Utils.PrintBlockFormat;
import olympic.main.game.volleyball.ScheduleIterator;
import olympic.main.game.volleyball.VolleyballMatch;
import olympic.main.game.volleyball.Observer;

/**
 * 淘汰赛的一轮
 */
public class EliminationRound extends Round implements Observer {
    /**
     * 轮次名称，如决赛、半决赛、四分之一决赛
     */
    private String name = null;

    /**
     * 构造函数
     * @param name 轮次名称
     */
    public EliminationRound(String name) {
        this.name = name;
    }

    /**
     * 进行本轮所有比赛
     */
    @Override
    public void start() {
        advancedTeams.clear();
        System.out.println("\nclassname: (EliminationRound) method: (play) action: (进行排球淘汰赛，使用了Observer模式以及Iterator模式) ");
        for (int i = 0; i < teams.size(); i += 2) {
            VolleyballMatch g = new VolleyballMatch(teams.get(i), teams.get(i + 1));
            g.setObserver(this);
            schedule.addMatch(g);
        }

        if (name != null) {
            PrintBlockFormat.getPrintFormat().addString(name);
        }

        ScheduleIterator it = schedule.iterator();
        while (it.hasNext()) {
            it.next().play();
        }
        PrintBlockFormat.getPrintFormat().printFormatLeftScreen(true);
    }

    /**
     * 根据比赛结果更新晋级名单
     *
     * @param game 结束的比赛
     */
    @Override
    public void update(VolleyballMatch game) {
        VolleyballMatch e = (VolleyballMatch) game;
        if (e.getScore1() > e.getScore2()) {
            advancedTeams.add(e.getTeam1());
        } else {
            advancedTeams.add(e.getTeam2());
        }
    }

}
