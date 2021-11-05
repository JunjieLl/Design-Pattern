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

    /**
     * 双方球队
     */
    private VolleyballTeam team1, team2;

    /**
     * 双方得分（获胜局数）
     */
    private int score1, score2;

    /**
     * 双方小分总分
     */
    private int point1, point2;

    /**
     * 观察者
     */
    private Observer observer = null;

    /**
     * 构造函数
     * @param team1 球队1
     * @param team2 球队2
     */
    public VolleyballMatch(VolleyballTeam team1, VolleyballTeam team2) {
        super();
        this.team1 = team1;
        this.team2 = team2;
        this.score1 = this.score2 = 0;
        this.point1 = this.point2 = 0;
    }

    /**
     * 开始比赛
     */
    public void begin() {
        PrintBlockFormat.getPrintFormat().addString("\n【排球赛事】" + team1.getName() + " vs " + team2.getName());
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
            point1 += point[0];
            point2 += point[1];
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
    public VolleyballTeam getTeam1() {
        return team1;
    }

    /**
     * 获取球队2
     * @return 球队2
     */
    public VolleyballTeam getTeam2() {
        return team2;
    }

    /**
     * 获取球队1的小分总分
     * @return 球队1的小分总分
     */
    public int getPoint1() {
        return point1;
    }

    /**
     * 获取球队2的小分总分
     * @return 球队2的小分总分
     */
    public int getPoint2() {
        return point2;
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