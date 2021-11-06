package olympic.main.game.diving;


import olympic.main.game.Valve;

/**
 * 阀门的具体实现
 */
public abstract class DivingGame extends Valve {
    /**
     * 阀门开始
     * @param athletePool 传入阀门的输入（对象池）
     */
    abstract void takePlace(AthletePool athletePool);
}
