package olympic.main.game.football;

import olympic.main.game.Aggregate;
import olympic.main.game.Game;

import java.util.ArrayList;
import java.util.List;

/**
 * 赛程，即比赛的容器
 * Iterator模式
 */
public class Schedule implements Aggregate {
    protected List<FootballMatch> schedule = new ArrayList<>();

    public void addMatch(FootballMatch match) {
        schedule.add(match);
    }

    public FootballMatch getGameAt(int index) {
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
