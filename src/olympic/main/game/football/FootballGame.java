package olympic.main.game.football;

import olympic.main.game.Game;
import olympic.main.person.athlete.footballathlete.FootballTeam;

/**
 * Observer 模式
 * Template Method 模式
 */
public abstract class FootballGame extends Game {

    private FootballTeam team1, team2;
    protected int score1, score2, penaltyScore1, penaltyScore2;
    protected Observer observer = null;

    public FootballGame(FootballTeam team1, FootballTeam team2) {
        super();
        this.team1 = team1;
        this.team2 = team2;
        this.score1 = this.score2 = 0;
    }

    public void begin() {
        System.out.println("\n【足球赛事】" + team1.getNation() + " vs " + team2.getNation());
        System.out.println("比赛开始");
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void start() {
        begin();
        // 随机产生比分
        generateResult();
        notifyObserver();
    }

    public abstract void generateResult();

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }

    public FootballTeam getTeam1() {
        return team1;
    }

    public FootballTeam getTeam2() {
        return team2;
    }

    public void notifyObserver() {
        observer.update(this);
    }

    public int getPenaltyScore1() {
        return penaltyScore1;
    }

    public int getPenaltyScore2() {
        return penaltyScore2;
    }
}