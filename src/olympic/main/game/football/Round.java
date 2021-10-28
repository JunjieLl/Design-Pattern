package olympic.main.game.football;

import olympic.main.person.athlete.footballathlete.FootballTeam;

import java.util.ArrayList;

/**
 * 一轮比赛
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
