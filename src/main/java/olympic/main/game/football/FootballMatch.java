package olympic.main.game.football;

import olympic.main.game.Game;
import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.footballathlete.FootballTeam;

import java.util.List;

/**
 * 一场足球比赛
 * Observer 模式
 * Template Method 模式
 */
public abstract class FootballMatch {

    private FootballTeam team1, team2;
    protected int score1, score2;
    protected Observer observer = null;

    public FootballMatch(FootballTeam team1, FootballTeam team2) {
        super();
        this.team1 = team1;
        this.team2 = team2;
        this.score1 = this.score2 = 0;
    }

    public void begin() {
        System.out.println("\n【足球赛事】" + team1.getName() + " vs " + team2.getName());
        System.out.println("比赛开始");
    }

    public void play() {
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
        if (observer != null) {
            observer.update(this);
        }
    }
}