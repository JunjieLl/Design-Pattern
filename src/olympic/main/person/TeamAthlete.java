package olympic.main.person;

import olympic.main.game.Game;

import java.util.ArrayList;
import java.util.List;

/**
 * 设计模式：桥接模式
 * 团体射击运动员
 */
public class TeamAthlete implements Athlete {
    private List<Athlete> athletes = new ArrayList<>();

    @Override
    public void participate(Game game) {
        System.out.println("classname: (TeamAthlete) method: (participate) action: (桥接模式中团体运动员参与比赛) ");
        for (Athlete athlete : athletes) {
            athlete.participate(game);
        }
    }

    @Override
    public void addChild(Athlete athlete) {
        athletes.add(athlete);
    }
}
