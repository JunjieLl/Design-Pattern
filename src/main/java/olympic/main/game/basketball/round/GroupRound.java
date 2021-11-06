package olympic.main.game.basketball.round;

import olympic.utils.PrintBlockFormat;
import olympic.main.game.basketball.BasketballMatch;
import olympic.main.game.basketball.BasketballScoreBoard;
import olympic.main.game.basketball.ScheduleIterator;
import olympic.main.person.athlete.basketballathlete.BasketballTeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 小组赛
 * 调用play打完所有小组赛并生成晋级名单
 */
public class GroupRound extends Round {

    /**
     * 小组赛积分榜
     */
    private final BasketballScoreBoard scoreBoard = BasketballScoreBoard.getInstance();

    /**
     * 进行所有小组赛并生成晋级名单
     */
    @Override
    public void start() {
        advancedTeams.clear();
        System.out.println("\nclassname: (GroupRound) method: (play) action: (进行篮球小组赛，使用了Observer模式、Singleton模式以及Iterator模式) ");
        PrintBlockFormat.getPrintFormat().addString("小组赛");
        // 打乱顺序，分组
        Collections.shuffle(teams);
        for (int g = 0; g < 2; g++) {
            for (int i = 0; i < 6; i++) {
                for (int j = i + 1; j < 6; j++) {
                    BasketballMatch match = new BasketballMatch(teams.get(6 * g + i), teams.get(6 * g + j));
                    match.setObserver(BasketballScoreBoard.getInstance());
                    schedule.addMatch(match);
                }
            }
        }

        // 进行所有比赛
        ScheduleIterator it = schedule.iterator();
        while (it.hasNext()) {
            it.next().play();
        }

        PrintBlockFormat.getPrintFormat().printFormatLeftScreen(true);

        int[] scores = scoreBoard.getScore();
        int[] gains = scoreBoard.getGain();
        int[] losses = scoreBoard.getLoss();

        // 内部类，用于对各组球队进行排名
        class ScoreEntry {
            public final BasketballTeam team;
            public final int score;
            public final double rate;

            public ScoreEntry(BasketballTeam team, int score, int gain, int loss) {
                this.team = team;
                this.score = score;
                if (loss != 0) {
                    rate = ((double)gain) / loss;
                } else {
                    rate = Integer.MAX_VALUE;
                }
            }
        }

        List<BasketballTeam> tmp = new ArrayList<>();  // 晋级名单

        // 调用格式化打印接口，打印小组赛积分榜
        PrintBlockFormat.getPrintFormat().addString("小组赛积分榜");
        for (int g = 0; g < 2; g++) {
            List<ScoreEntry> ranking = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                BasketballTeam t = teams.get(6 * g + i);
                ranking.add(new ScoreEntry(t, scores[t.getId()], gains[t.getId()], losses[t.getId()]));
            }

            // 排序规则：先按积分排序，积分相同者，得失球率高者排名在前
            ranking.sort((o1, o2) -> {
                if (o1.score > o2.score) {
                    return -1;
                } else if (o1.score < o2.score) {
                    return 1;
                } else {
                    return Double.compare(o2.rate, o1.rate);
                }
            });
            PrintBlockFormat.getPrintFormat().addString("\nGroup " + (g + 1));
            PrintBlockFormat.getPrintFormat().addString("排名\t球队\t\t积分\t\t得失球率");
            for (int i = 0; i < 6; i++) {
                String str = String.format("%d\t\t%s\t\t%d\t\t%f", i + 1, ranking.get(i).team.getNation(), ranking.get(i).score, ranking.get(i).rate);
                PrintBlockFormat.getPrintFormat().addString(str);
            }
            for (int i = 0; i < 6; i++) {
                tmp.add(ranking.get(i).team);
            }
        }

        PrintBlockFormat.getPrintFormat().printFormatLeftScreen(true);
        // 按四分之一决赛顺序排列
        for (int k = 0; k < 4; ++k) {
            advancedTeams.add(tmp.get(k));
            advancedTeams.add(tmp.get(7 - k));
        }
    }

}
