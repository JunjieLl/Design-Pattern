package olympic.main.game;

import java.util.ArrayList;
import java.util.List;

/**
 * Iterator模式
 */
public class Schedule implements Aggregate{
    protected List<Game> schedule = new ArrayList<>();

    public void addGame(Game game) {
        schedule.add(game);
    }

    public Game getGameAt(int index) {
        return schedule.get(index);
    }

    public int getLength() {
        return schedule.size();
    }

    @Override
    public ScheduleIterator iterator() {
        return new ScheduleIterator(this);
    }
}
