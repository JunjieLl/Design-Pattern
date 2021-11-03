package olympic.main.game.football;

import olympic.main.game.Game;
import olympic.main.game.Iterator;
import olympic.main.game.football.Schedule;

/**
 * Iterator模式
 */
public class ScheduleIterator implements Iterator {
    private Schedule schedule;
    private int index;

    public ScheduleIterator(Schedule schedule) {
        this.schedule = schedule;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        if (this.index < schedule.getLength()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public FootballMatch next() {
        FootballMatch match = schedule.getGameAt(this.index);
        this.index++;
        return match;
    }
}
