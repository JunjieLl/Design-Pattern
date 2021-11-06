package olympic.main.game.football.round;

import olympic.utils.PrintBlockFormat;
import olympic.main.game.football.ScheduleIterator;
import olympic.main.game.football.GroupFootballMatch;
import olympic.main.game.football.FootballScoreBoard;
import olympic.main.person.athlete.footballathlete.FootballTeam;

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
    private final FootballScoreBoard scoreBoard = FootballScoreBoard.getInstance();

    /**
     * 进行所有小组赛并生成晋级名单
     */
    @Override
    public void start() {
        advancedTeams.clear();
        System.out.println("\nclassname: (GroupRound) method: (play) action: (进行足球小组赛，使用了Observer模式、Singleton模式以及Iterator模式) ");
        PrintBlockFormat.getPrintFormat().addString("小组赛");
        // 打乱顺序，分组
        Collections.shuffle(teams);
        for (int g = 0; g < 4; g++) {
            for (int i = 0; i < 4; i++) {
                for (int j = i + 1; j < 4; j++) {
                    schedule.addMatch(new GroupFootballMatch(teams.get(4 * g + i), teams.get(4 * g + j)));
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
        int[] goalDifferences = scoreBoard.getGoalDifference();
        int[] goals = scoreBoard.getGoal();

        // 内部类，用于对各组球队进行排名
        class ScoreEntry {
            public final FootballTeam team;
            public final int score;
            public final int goalDifference;
            public final int goal;

            public ScoreEntry(FootballTeam team, int score, int goalDifference, int goal) {
                this.team = team;
                this.score = score;
                this.goalDifference = goalDifference;
                this.goal = goal;
            }
        }

        List<FootballTeam> tmp = new ArrayList<>();  // 晋级名单

        // 调用格式化打印接口，打印小组赛积分榜
        PrintBlockFormat.getPrintFormat().addString("小组赛积分榜");
        for (int g = 0; g < 4; g++) {
            List<ScoreEntry> ranking = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                FootballTeam t = teams.get(4 * g + i);
                ranking.add(new ScoreEntry(t, scores[t.getId()], goalDifferences[t.getId()], goals[t.getId()]));
            }

            // 排序规则：先按积分排序，积分相同者，净胜球多者排名在前；若净胜球仍相同，进球数多者在前
            ranking.sort((o1, o2) -> {
                if (o1.score > o2.score) {
                    return -1;
                } else if (o1.score < o2.score) {
                    return 1;
                } else {
                    if (o1.goalDifference > o2.goalDifference) {
                        return -1;
                    } else if (o1.goalDifference < o2.goalDifference) {
                        return 1;
                    } else {
                        return Integer.compare(o2.goal, o1.goal);
                    }
                }
            });
            PrintBlockFormat.getPrintFormat().addString("\nGroup " + (g + 1));
            PrintBlockFormat.getPrintFormat().addString("排名\t球队\t\t积分\t\t净胜球\t进球");
            for (int i = 0; i < 4; i++) {
                PrintBlockFormat.getPrintFormat().addString(String.format("%d\t\t%s\t\t%d\t\t%d\t\t%d", i + 1, ranking.get(i).team.getNation(), ranking.get(i).score, ranking.get(i).goalDifference, ranking.get(i).goal));
            }
            tmp.add(ranking.get(0).team);
            tmp.add(ranking.get(1).team);
        }
        PrintBlockFormat.getPrintFormat().printFormatLeftScreen(true);

        // 四分之一决赛是小组第一名与另一小组第二名比赛，因此需要对晋级球队重新排序以便生成后续赛程
        int k = 0;
        while (k + 3 < tmp.size()) {
            advancedTeams.add(tmp.get(k));
            advancedTeams.add(tmp.get(k + 3));
            advancedTeams.add(tmp.get(k + 1));
            advancedTeams.add(tmp.get(k + 2));
            k += 4;
        }
    }

}
