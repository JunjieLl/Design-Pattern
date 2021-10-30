package olympic.main.game.football;

import olympic.main.person.athlete.footballathlete.FootballTeam;

import java.util.Random;

/**
 * 足球小组赛
 */
public class GroupFootballGame extends FootballGame{
    public GroupFootballGame(FootballTeam team1, FootballTeam team2) {
        super(team1, team2);
        this.observer = ScoreBoard.getInstance();
    }

    /**
     * 随机生成比赛结果
     * 小组赛可以有平局
     */
    @Override
    public void generateResult() {
        Random r = new Random();
        score1 = r.nextInt(5);
        score2 = r.nextInt(5);
        System.out.println("比赛结束，比分为" + score1 + "-" + score2);
    }
}
