package olympic.main.game.football.round;

import olympic.main.game.ScheduleIterator;
import olympic.main.game.football.EliminationFootballGame;
import olympic.main.game.football.FootballGame;
import olympic.main.game.football.Observer;
import olympic.main.game.football.round.Round;
import olympic.main.person.athlete.footballathlete.FootballTeam;

import java.util.ArrayList;
import java.util.List;

/**
 * 淘汰赛的一轮
 */
public class EliminationRound extends Round implements Observer {
    String name = null;
    private List<FootballTeam> advancedTeams = new ArrayList<>();

    public EliminationRound(String name) {
        this.name = name;
    }

    /**
     * 进行本轮所有比赛并生成晋级名单
     * @param teams 上一轮的晋级球队
     * @return 晋级球队列表
     */
    @Override
    public List<FootballTeam> play(List<FootballTeam> teams) {
        System.out.println("classname: (EliminationRound) method: (play) action: (进行足球淘汰赛) ");
        for (int i = 0; i < teams.size(); i += 2) {
            EliminationFootballGame g = new EliminationFootballGame(teams.get(i), teams.get(i + 1));
            g.setObserver(this);
            schedule.addGame(g);
        }

        if (name != null) {
            System.out.println("\n【" + name + "】");
        }

        ScheduleIterator it = schedule.iterator();
        while (it.hasNext()) {
            it.next().start();
        }

        return advancedTeams;
    }

    /**
     * 根据比赛结果更新晋级名单
     * @param game 结束的比赛
     */
    @Override
    public void update(FootballGame game) {
        EliminationFootballGame e = (EliminationFootballGame) game;
        if (e.getScore1() > e.getScore2()) {
            advancedTeams.add(e.getTeam1());
        } else if (e.getScore1() < e.getScore2()) {
            advancedTeams.add(e.getTeam2());
        } else if (e.getPenaltyScore1() > e.getPenaltyScore2()) {
            advancedTeams.add(e.getTeam1());
        } else {
            advancedTeams.add(e.getTeam2());
        }
    }
}
