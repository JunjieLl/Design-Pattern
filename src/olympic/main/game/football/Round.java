package olympic.main.game.football;

import java.util.ArrayList;

/**
 * Pipeline模式
 * 相当于Valve
 */
public abstract class Round {
    protected FootballSchedule schedule = new FootballSchedule();
    private Round next = null;

    public abstract ArrayList<FootballTeam> play(ArrayList<FootballTeam> teams);

    public Round getNext() {
        return next;
    }

    public Round setNext(Round round) {
        next = round;
        return next;
    }
}
