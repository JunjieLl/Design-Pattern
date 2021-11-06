package olympic.main.game.basketball.round;

import olympic.utils.PrintBlockFormat;
import olympic.main.game.basketball.ScheduleIterator;
import olympic.main.game.basketball.BasketballMatch;
import olympic.main.game.basketball.Observer;

/**
 * 淘汰赛的一轮
 */
public class EliminationRound extends Round implements Observer {
    /**
     * 轮次名称，如决赛、半决赛、四分之一决赛
     */
    private final String name;

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
        System.out.println("\nclassname: (EliminationRound) method: (play) action: (进行篮球淘汰赛，使用了Observer模式以及Iterator模式) ");
        for (int i = 0; i < teams.size(); i += 2) {
            BasketballMatch g = new BasketballMatch(teams.get(i), teams.get(i + 1));
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
    public void update(BasketballMatch game) {
        if (game.getScore1() > game.getScore2()) {
            advancedTeams.add(game.getTeam1());
        } else {
            advancedTeams.add(game.getTeam2());
        }
    }

}
