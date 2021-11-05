package olympic.main.game.basketball;

import olympic.Utils.PrintBlockFormat;
import olympic.main.person.athlete.basketballathlete.BasketballTeam;

import java.util.Random;

/**
 * 一场篮球比赛
 * Observer 模式
 * Template Method 模式
 */
public class BasketballMatch {

    /**
     * 双方球队
     */
    private final BasketballTeam team1;
    private final BasketballTeam team2;

    /**
     * 双方得分
     */
    private int score1, score2;

    /**
     * 观察者
     */
    private Observer observer = null;

    /**
     * 构造函数
     * @param team1 球队1
     * @param team2 球队2
     */
    public BasketballMatch(BasketballTeam team1, BasketballTeam team2) {
        super();
        this.team1 = team1;
        this.team2 = team2;
        this.score1 = this.score2 = 0;
    }

    /**
     * 开始比赛
     */
    public void begin() {
        PrintBlockFormat.getPrintFormat().addString("\n【篮球赛事】" + team1.getName() + " vs " + team2.getName());
        PrintBlockFormat.getPrintFormat().addString("比赛开始");
    }

    /**
     * 进行本场比赛
     */
    public void play() {
        begin();
        // 随机产生比分
        generateResult();
        notifyObserver();
    }

    /**
     * 生成比赛结果（随机生成）
     */
    public void generateResult() {
        Random r = new Random();
        score1 = 60 + r.nextInt(60);
        score2 = 60 + r.nextInt(60);
        while (score1 == score2) {
            score1 += r.nextInt(5);
            score2 += r.nextInt(5);
        }
        PrintBlockFormat.getPrintFormat().addString("比赛结束，比分为" + score1 + "-" + score2);
    }

    /**
     * 获取球队1的得分
     * @return 球队1的得分
     */
    public int getScore1() {
        return score1;
    }

    /**
     * 获取球队2的得分
     * @return 球队2的得分
     */
    public int getScore2() {
        return score2;
    }

    /**
     * 获取球队1
     * @return 球队1
     */
    public BasketballTeam getTeam1() {
        return team1;
    }

    /**
     * 获取球队2
     * @return 球队2
     */
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