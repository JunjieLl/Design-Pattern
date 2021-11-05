package olympic.main.game.volleyball.round;

import olympic.Utils.PrintBlockFormat;
import olympic.main.game.volleyball.VolleyballMatch;
import olympic.main.game.volleyball.VolleyballScoreBoard;
import olympic.main.game.volleyball.ScheduleIterator;
import olympic.main.person.athlete.volleyballathlete.VolleyballTeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 小组赛
 * 调用play打完所有小组赛并生成晋级名单
 */
public class GroupRound extends Round {

    // 小组赛积分榜
    private VolleyballScoreBoard scoreBoard = VolleyballScoreBoard.getInstance();

    /**
     * 进行所有小组赛并生成晋级名单
     */
    @Override
    public void start() {
        advancedTeams.clear();
        System.out.println("\nclassname: (GroupRound) method: (play) action: (进行排球小组赛，使用了Observer模式、Singleton模式以及Iterator模式) ");
        PrintBlockFormat.getPrintFormat().addString("小组赛");
        // 打乱顺序，分组
        Collections.shuffle(teams);
        for (int g = 0; g < 2; g++) {
            for (int i = 0; i < 6; i++) {
                for (int j = i + 1; j < 6; j++) {
                    VolleyballMatch match = new VolleyballMatch(teams.get(6 * g + i), teams.get(6 * g + j));
                    match.setObserver(VolleyballScoreBoard.getInstance());
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
        int[] win = scoreBoard.getWin();
        int[] gain = scoreBoard.getGain();
        int[] loss = scoreBoard.getLoss();
        int[] pointGain = scoreBoard.getPointGain();
        int[] pointLoss = scoreBoard.getPointLoss();

        // 内部类，用于对各组球队进行排名
        class ScoreEntry {
            public VolleyballTeam team;
            public int score;
            public int win;
            public double rate;
            public double pointRate;

            public ScoreEntry(VolleyballTeam team, int score, int win, int gain, int loss, int pointGain, int pointLoss) {
                this.team = team;
                this.score = score;
                this.win = win;

                // 胜负局比
                if (loss != 0) {
                    rate = ((double) gain) / loss;
                } else {
                    rate = Integer.MAX_VALUE;
                }

                // 得失分比
                if (pointLoss != 0) {
                    pointRate = ((double) pointGain) / pointLoss;
                } else {
                    pointRate = Integer.MAX_VALUE;
                }
            }
        }

        List<VolleyballTeam> tmp = new ArrayList<>();  // 晋级名单

        // 打印小组赛积分榜
        PrintBlockFormat.getPrintFormat().addString("小组赛积分榜");
        for (int g = 0; g < 2; g++) {
            List<ScoreEntry> ranking = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                VolleyballTeam t = teams.get(6 * g + i);
                ranking.add(new ScoreEntry(t, scores[t.getId()], win[t.getId()], gain[t.getId()], loss[t.getId()], pointGain[t.getId()], pointLoss[t.getId()]));
            }

            Collections.sort(ranking, (o1, o2) -> {
                if (o1.score > o2.score) {
                    return -1;
                } else if (o1.score < o2.score) {
                    return 1;
                } else {
                    if (o1.win > o2.win) {
                        return -1;
                    } else if (o1.win < o2.win) {
                        return 1;
                    } else {
                        if (o1.rate > o2.rate) {
                            return -1;
                        } else if (o1.rate < o2.rate) {
                            return 1;
                        } else {
                            if (o1.pointRate > o2.pointRate) {
                                return -1;
                            } else if (o1.pointRate < o2.pointRate) {
                                return 1;
                            } else {
                                return 0;
                            }
                        }
                    }
                }
            });
            PrintBlockFormat.getPrintFormat().addString("\nGroup " + (g + 1));
            PrintBlockFormat.getPrintFormat().addString("排名\t球队\t\t积分\t\t胜场\t\t胜负局比\t\t得失分比");
            for (int i = 0; i < 6; i++) {
                PrintBlockFormat.getPrintFormat().addString(String.format("%d\t%s\t\t%d\t\t%d\t\t%.2f\t\t%.2f", i + 1, ranking.get(i).team.getNation(), ranking.get(i).score, ranking.get(i).win, ranking.get(i).rate, ranking.get(i).pointRate));
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
