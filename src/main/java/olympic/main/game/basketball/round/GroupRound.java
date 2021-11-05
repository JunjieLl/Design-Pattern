package olympic.main.game.basketball.round;

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

    // 小组赛积分榜
    private BasketballScoreBoard scoreBoard = BasketballScoreBoard.getInstance();

    /**
     * 进行所有小组赛并生成晋级名单
     */
    @Override
    public void start() {
        advancedTeams.clear();
        System.out.println("classname: (GroupRound) method: (play) action: (进行篮球小组赛) ");
        System.out.println("\n【小组赛】");
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

        int[] scores = scoreBoard.getScore();
        int[] gains = scoreBoard.getGain();
        int[] losses = scoreBoard.getLoss();

        // 内部类，用于对各组球队进行排名
        class ScoreEntry {
            public BasketballTeam team;
            public int score;
            public double rate;

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

        // 打印小组赛积分榜
        System.out.println("\n【小组赛积分榜】");
        for (int g = 0; g < 2; g++) {
            List<ScoreEntry> ranking = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                BasketballTeam t = teams.get(6 * g + i);
                ranking.add(new ScoreEntry(t, scores[t.getId()], gains[t.getId()], losses[t.getId()]));
            }

            Collections.sort(ranking, (o1, o2) -> {
                if (o1.score > o2.score) {
                    return -1;
                } else if (o1.score < o2.score) {
                    return 1;
                } else {
                    if (o1.rate > o2.rate) {
                        return -1;
                    } else if (o1.rate < o2.rate) {
                        return 1;
                    } else {
                       return 0;
                    }
                }
            });
            System.out.println("\nGroup " + (g + 1));
            System.out.println("排名\t球队\t\t积分\t\t得失球率");
            for (int i = 0; i < 6; i++) {
                System.out.printf("%d\t%s\t\t%d\t\t%f\n", i + 1, ranking.get(i).team.getNation(), ranking.get(i).score, ranking.get(i).rate);
            }
            for (int i = 0; i < 6; i++) {
                tmp.add(ranking.get(i).team);
            }
        }

        // 按四分之一决赛顺序排列
        for (int k = 0; k < 4; ++k) {
            advancedTeams.add(tmp.get(k));
            advancedTeams.add(tmp.get(7 - k));
        }
    }

}
