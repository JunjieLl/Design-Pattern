package olympic.main.game.basketball;


import olympic.main.game.Iterator;


/**
 * 赛程迭代器
 * Iterator模式
 */
public class ScheduleIterator implements Iterator {
    /**
     * 赛程表
     */
    private Schedule schedule;

    /**
     * 索引
     */
    private int index;

    /**
     * 构造函数
     * @param schedule 赛程表
     */
    public ScheduleIterator(Schedule schedule) {
        this.schedule = schedule;
        this.index = 0;
    }

    /**
     * 当前位置是否存在下一场比赛
     * @return boolean
     */
    @Override
    public boolean hasNext() {
        return this.index < schedule.getLength();
    }

    /**
     * 获取当前指向的比赛，迭代器指向下一场比赛
     * @return 当前指向的比赛
     */
    @Override
    public BasketballMatch next() {
        BasketballMatch match = schedule.getGameAt(this.index);
        this.index++;
        return match;
    }
}
