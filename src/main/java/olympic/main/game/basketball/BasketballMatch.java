package olympic.main.game.basketball;

import olympic.main.game.Game;
import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.basketballathlete.BasketballTeam;

import java.util.List;
import java.util.Random;

/**
 * 一场篮球比赛
 * Observer 模式
 * Template Method 模式
 */
public class BasketballMatch {

    private BasketballTeam team1, team2;
    private int score1, score2;
    private Observer observer = null;

    public BasketballMatch(BasketballTeam team1, BasketballTeam team2) {
        super();
        this.team1 = team1;
        this.team2 = team2;
        this.score1 = this.score2 = 0;
    }

    public void begin() {
        System.out.println("\n【篮球赛事】" + team1.getName() + " vs " + team2.getName());
        System.out.println("比赛开始");
    }

    public void play() {
        begin();
        // 随机产生比分
        generateResult();
        notifyObserver();
    }

    public void generateResult() {
        Random r = new Random();
        score1 = 60 + r.nextInt(60);
        score2 = 60 + r.nextInt(60);
        System.out.println("比赛结束，比分为" + score1 + "-" + score2);
    }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }

    public BasketballTeam getTeam1() {
        return team1;
    }

    public BasketballTeam getTeam2() {
        return team2;
    }

    /**
     * 设置观察者
     * @param o 观察者
     */
    public void setObserver(Observer o) {
        this.observer = o;
    }

    /**
     * 通知观察者更新数据
     */
    public void notifyObserver() {
        if (observer != null) {
            observer.update(this);
        }
    }
}