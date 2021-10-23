package olympic.main.game.football;

import olympic.main.game.ScheduleIterator;

import java.util.ArrayList;
import java.util.Collections;

public class GroupRound extends Round{

    ScoreBoard scoreBoard = ScoreBoard.getInstance();
    @Override
    public ArrayList<FootballTeam> play(ArrayList<FootballTeam> teams) {
        // 打乱顺序，分组
        Collections.shuffle(teams);
        for (int g = 0; g < 4; g++) {
            for (int i = 0; i < 4; i++) {
                for (int j = i + 1; j < 4; j++) {
                    schedule.addGame(new GroupFootballGame(teams.get(4 * g + i), teams.get(4 * g + j)));
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

        // 对各组球队进行排名
        class ScoreEntry{
            public FootballTeam team;
            public int score, goalDifference, goal;
            public ScoreEntry(FootballTeam team, int score, int goalDifference, int goal) {
                this.team = team;
                this.score = score;
                this.goalDifference = goalDifference;
                this.goal = goal;
            }
        }

        ArrayList<FootballTeam> tmp = new ArrayList<>();   // 晋级名单

        for (int g = 0; g < 4; g++) {
            ArrayList<ScoreEntry> ranking = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                FootballTeam t = teams.get(4 * g + i);
                ranking.add(new ScoreEntry(t, scores[t.getId()], goalDifferences[t.getId()], goals[t.getId()]));
            }
            Collections.sort(ranking, (o1, o2) -> {
                if (o1.score > o2.score) {
                    return 1;
                } else if (o1.score < o2.score) {
                    return -1;
                } else {
                    if (o1.goalDifference > o2.goalDifference) {
                        return 1;
                    } else if (o1.goalDifference < o2.goalDifference) {
                        return -1;
                    } else {
                        if (o1.goal > o2.goal) {
                            return 1;
                        } else if (o1.goal < o2.goal) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                }
            });
            System.out.println("\nGroup " + (g + 1));
            System.out.println("排名\t球队\t积分\t净胜球\t进球");
            for (int i = 0; i < 4; i++) {
                System.out.println("" + (i + 1) + "\t" + ranking.get(i).team.getNation() + "\t" + ranking.get(i).score + "\t" + ranking.get(i).goalDifference + "\t" + ranking.get(i).goal);
            }
            tmp.add(ranking.get(0).team);
            tmp.add(ranking.get(1).team);
        }

        ArrayList<FootballTeam> advancedTeams = new ArrayList<>();   // 晋级名单
        // 第一名与第二名比赛
        int k = 0;
        while (k + 3 < tmp.size()) {
            advancedTeams.add(tmp.get(k + 0));
            advancedTeams.add(tmp.get(k + 3));
            advancedTeams.add(tmp.get(k + 1));
            advancedTeams.add(tmp.get(k + 2));
            k += 4;
        }
        return advancedTeams;
    }
}
