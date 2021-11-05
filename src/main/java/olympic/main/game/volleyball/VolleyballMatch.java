package olympic.main.game.volleyball;

import olympic.Utils.PrintBlockFormat;
import olympic.main.game.Game;
import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.volleyballathlete.VolleyballTeam;

import java.util.List;
import java.util.Random;

/**
 * 一场排球比赛
 * Observer 模式
 * Template Method 模式
 */
public class VolleyballMatch {

    private VolleyballTeam team1, team2;
    private int score1, score2;
    private Observer observer = null;

    public VolleyballMatch(VolleyballTeam team1, VolleyballTeam team2) {
        super();
        this.team1 = team1;
        this.team2 = team2;
        this.score1 = this.score2 = 0;
    }

    public void begin() {
        PrintBlockFormat.getPrintFormat().addString("\n【排球赛事】" + team1.getName() + " vs " + team2.getName());
        PrintBlockFormat.getPrintFormat().addString("比赛开始");
    }

    public void play() {
        begin();
        // 随机产生比分
        generateResult();
        notifyObserver();
    }

    public void generateResult() {
        Random r = new Random();
        int set = 1;
        int[] point = new int[2];
        while (score1 < 3 && score2 < 3) {
            point[0] = point[1] = 0;
            while ((point[0] < 24 && point[1] < 24) || Math.abs(point[0] - point[1]) < 2) {
                point[r.nextInt(2)]++;
            }
            PrintBlockFormat.getPrintFormat().addString("第" + (set++) + "局结束，比分为" + point[0] + "-" + point[1]);
            if (point[0] > point[1]) {
                score1++;
            } else {
                score2++;
            }
        }
        PrintBlockFormat.getPrintFormat().addString("比赛结束，比分为" + score1 + "-" + score2);
    }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }

    public VolleyballTeam getTeam1() {
        return team1;
    }

    public VolleyballTeam getTeam2() {
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