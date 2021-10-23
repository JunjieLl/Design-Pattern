package olympic.main.game;

/**
 * Iterator模式
 */
public class ScheduleIterator implements Iterator{
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
        }
        else {
            return false;
        }
    }

    @Override
    public Game next() {
        Game game = schedule.getGameAt(this.index);
        this.index++;
        return game;
    }
}
