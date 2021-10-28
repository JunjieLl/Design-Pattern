package olympic.main.game.football;

import olympic.main.person.athlete.footballathlete.FootballTeam;

import java.util.Random;

public class EliminationFootballGame extends FootballGame{
    public EliminationFootballGame(FootballTeam team1, FootballTeam team2) {
        super(team1, team2);
    }

    @Override
    public void generateResult() {
        Random r = new Random();
        score1 = r.nextInt(10);
        score2 = r.nextInt(10);
        if (score1 == score2) {
            System.out.println("90分钟内双方打平，比分为" + score1 + "-" + score2);
            System.out.println("进入加时赛");
            score1 += r.nextInt(5);
            score2 += r.nextInt(5);
            if (score1 == score2) {
                System.out.println("120分钟内双方打平，比分为" + score1 + "-" + score2);
                System.out.println("进入点球决胜阶段");
                while (penaltyScore1 == penaltyScore2) {
                    penaltyScore1 += r.nextInt(5);
                    penaltyScore2 += r.nextInt(5);
                }
                System.out.println("比赛结束，点球比分为" + penaltyScore1 + "-" + penaltyScore2);
            }
            else {
                System.out.println("比赛结束，比分为" + score1 + "-" + score2);
            }
        }
        else {
            System.out.println("比赛结束，比分为" + score1 + "-" + score2);
        }
    }

    public void setObserver(Observer o) {
        this.observer = o;
    }
}
