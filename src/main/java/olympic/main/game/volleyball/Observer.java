package olympic.main.game.volleyball;

/**
 * Observer模式
 */
public interface Observer {
    /**
     * 根据比赛结果更新数据
     * @param game 结束的比赛
     */
    void update(VolleyballMatch game);
}
