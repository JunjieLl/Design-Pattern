package olympic.main.game.diving;

import java.util.ArrayList;

public abstract class Strategy {
    /**
     * 策略名
     */
    protected String name;

    /**
     * 评委打分
     */
    protected ArrayList<Double> scores;

    /**
     * 比赛轮次
     */
    protected int cycleNumber;

    /**
     * 获取评分
     * @return 要修改的评分大小
     */
    abstract double decideScore();


    /**
     * 获取该策略下一场比赛要进行的轮次
     * @return cycleNumber 要进行的轮次
     */
    abstract int getCycleNumber();

    /**
     * 获取策略名字
     * @return 策略名
     */
    public String getName() {
        return name;
    }

    /**
     * 显示使用策略
     * @param strategy 策略名字
     */
    public void showStrategy(String strategy) {
        System.out.printf("classname: (%s) method: (%s) action: (%s)\n\n", strategy, strategy, "使用" + name + "规则");
    }
}
