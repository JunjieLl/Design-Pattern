package olympic.main.game;

/**
 * 抽象阀门类，代表一轮比赛
 * Pipeline模式
 */
public abstract class Valve extends Game{

    /**
     * 设置下一个阀门
     * @param valve 下一个阀门
     * @return 下一个阀门
     */
    public abstract Valve setNext(Valve valve);

    /**
     * 开始当前阀门的过滤（即进行当前比赛）
     */
    public abstract void start();
}
