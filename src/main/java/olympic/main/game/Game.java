package olympic.main.game;

import olympic.main.person.athlete.Athlete;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象比赛类
 */
public abstract class Game {
    /**
     * 运动员列表
     */
    protected List<Athlete> athletes = new ArrayList<>();



    /**
     * 构造函数
     */
    public Game(){}

    /**
     * 开始比赛
     */
    abstract public void start();

    /**
     * 比赛名称
     */
    protected String name;

    /**
     * 获取比赛名称
     * @return 比赛名
     */
    public String getName() {
        return name;
    }

    /**
     * 获取运动员列表
     * @return 运动员列表
     */
    public List<Athlete> getAthletes() {
        return athletes;
    }

}
