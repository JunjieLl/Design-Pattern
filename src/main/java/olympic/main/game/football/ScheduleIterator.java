package olympic.main.game.football;

import olympic.main.game.Game;
import olympic.main.game.Iterator;
import olympic.main.game.football.Schedule;

/**
 * 赛程迭代器
 * Iterator模式
 */
public class ScheduleIterator implements Iterator {
    private Schedule schedule;
    private int index;

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
        if (this.index < schedule.getLength()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取当前指向的比赛，迭代器指向下一场比赛
     * @return 当前指向的比赛
     */
    @Override
    public FootballMatch next() {
        FootballMatch match = schedule.getGameAt(this.index);
        this.index++;
        return match;
    }
}
