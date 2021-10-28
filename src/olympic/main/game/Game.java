package olympic.main.game;

import olympic.main.person.athlete.Athlete;

import java.util.ArrayList;
import java.util.List;

/**
 * Game抽象类
 */
public abstract class Game {
    /**
     * 每个元素为一个参赛房，如乒乓球比赛有两方，则有两个元素，一个元素为一方，元素可以为Individual athlete或Team Athlete
     */
    protected List<Athlete> athletes = new ArrayList<>();
    /**
     * 比赛名称
     */
    protected String name;

    /**
     *
     * @return 获取名字
     */
    public String getName() {
        return name;
    }

    /**
     * 一场比赛的流程发生在这里
     */
    abstract public void start();

    /**
     *
     * @return 获取参赛人员列表
     */
    public List<Athlete> getAthletes() {
        return athletes;
    }
}
