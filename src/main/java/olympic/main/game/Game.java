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
     * @param name 比赛名称
     * @param athleteList 运动员列表
     */
    public Game(String name,List<Athlete> athleteList){
        this.athletes=athleteList;
        this.name = name;
    }

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
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 获取运动员列表
     * @return 运动员列表
     */
    public List<Athlete> getAthletes() {
        return this.getAthletes();
    }

}
