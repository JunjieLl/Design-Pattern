package olympic.main.game.football.round;

import olympic.main.game.football.FootballSchedule;
import olympic.main.person.athlete.footballathlete.FootballTeam;

import java.util.List;

/**
 * 一轮比赛
 * Pipeline模式
 * 相当于Valve
 */
public abstract class Round {
    protected FootballSchedule schedule = new FootballSchedule();
    private Round next = null;

    public abstract List<FootballTeam> play(List<FootballTeam> teams);

    public Round getNext() {
        return next;
    }

    public Round setNext(Round round) {
        next = round;
        return next;
    }
}
