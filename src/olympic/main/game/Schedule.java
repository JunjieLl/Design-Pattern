package olympic.main.game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

/**
 * Iterator模式
 */
public class Schedule implements Aggregate{
    protected ArrayList<Game> schedule = new ArrayList<>();

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
