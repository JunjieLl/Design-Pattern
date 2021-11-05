package olympic.main.game.basketball;

import olympic.main.game.Aggregate;

import java.util.ArrayList;
import java.util.List;

/**
 * 赛程，即比赛的容器
 * Iterator模式
 */
public class Schedule implements Aggregate {
    /**
     * 赛程表
     */
    protected List<BasketballMatch> schedule = new ArrayList<>();

    /**
     * 向赛程表添加比赛
     * @param match 要添加的比赛
     */
    public void addMatch(BasketballMatch match) {
        schedule.add(match);
    }

    /**
     * 获取指定下标的比赛
     * @param index 下标
     * @return 指定位置的比赛
     */
    public BasketballMatch getGameAt(int index) {
        return schedule.get(index);
    }

    /**
     * 获取赛程中的比赛数量
     * @return 比赛数量
     */
    public int getLength() {
        return schedule.size();
    }

    /**
     * 获取赛程的一个迭代器，初始指向首场比赛
     * @return 指向首场比赛的迭代器
     */
    @Override
    public ScheduleIterator iterator() {
        return new ScheduleIterator(this);
    }
}
