package olympic.main.game;

import olympic.main.game.Game;
import olympic.main.game.Valve;

/**
 * 抽象管道类
 * Pipeline模式
 */
public interface AbstractPipeline {
    /**
     * 向管道末尾添加比赛
     * @param newGame 要添加的比赛
     */
    void addContest(Valve newGame);

    /**
     * 从头开始依次进行各场比赛
     */
    void start();
}
