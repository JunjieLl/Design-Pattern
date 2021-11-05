package olympic.main.game.football.round;

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

    // 小组赛积分榜
    private FootballScoreBoard scoreBoard = FootballScoreBoard.getInstance();

    /**
     * 进行所有小组赛并生成晋级名单
     */
    @Override
    public void start() {
        advancedTeams.clear();
        System.out.println("classname: (GroupRound) method: (play) action: (进行足球小组赛) ");
        System.out.println("\n【小组赛】");
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

        int[] scores = scoreBoard.getScore();
        int[] goalDifferences = scoreBoard.getGoalDifference();
        int[] goals = scoreBoard.getGoal();

        // 内部类，用于对各组球队进行排名
        class ScoreEntry {
            public FootballTeam team;
            public int score, goalDifference, goal;

            public ScoreEntry(FootballTeam team, int score, int goalDifference, int goal) {
                this.team = team;
                this.score = score;
                this.goalDifference = goalDifference;
                this.goal = goal;
            }
        }

        List<FootballTeam> tmp = new ArrayList<>();  // 晋级名单

        // 打印小组赛积分榜
        System.out.println("\n【小组赛积分榜】");
        for (int g = 0; g < 4; g++) {
            List<ScoreEntry> ranking = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                FootballTeam t = teams.get(4 * g + i);
                ranking.add(new ScoreEntry(t, scores[t.getId()], goalDifferences[t.getId()], goals[t.getId()]));
            }

            Collections.sort(ranking, (o1, o2) -> {
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
                        if (o1.goal > o2.goal) {
                            return -1;
                        } else if (o1.goal < o2.goal) {
                            return 1;
                        } else {
                            return 0;
                        }
                    }
                }
            });
            System.out.println("\nGroup " + (g + 1));
            System.out.println("排名\t球队\t\t积分\t\t净胜球\t进球");
            for (int i = 0; i < 4; i++) {
                System.out.printf("%d\t%s\t\t%d\t\t%d\t\t%d\n", i + 1, ranking.get(i).team.getNation(), ranking.get(i).score, ranking.get(i).goalDifference, ranking.get(i).goal);
            }
            tmp.add(ranking.get(0).team);
            tmp.add(ranking.get(1).team);
        }

        // 四分之一决赛是小组第一名与另一小组第二名比赛，因此需要对晋级球队重新排序以便生成后续赛程
        int k = 0;
        while (k + 3 < tmp.size()) {
            advancedTeams.add(tmp.get(k + 0));
            advancedTeams.add(tmp.get(k + 3));
            advancedTeams.add(tmp.get(k + 1));
            advancedTeams.add(tmp.get(k + 2));
            k += 4;
        }
    }

}
