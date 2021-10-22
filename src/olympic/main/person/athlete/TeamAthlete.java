package olympic.main.person.athlete;

import olympic.main.game.Game;

import java.util.ArrayList;
import java.util.List;

/**
 * 设计模式：复合模式
 * 团体射击运动员
 */
public class TeamAthlete implements Athlete {
    private List<Athlete> athletes = new ArrayList<>();

    /**
     * 复合模式
     * @param game
     */
    @Override
    public void participate(Game game) {
        System.out.println("classname: (TeamAthlete) method: (participate) action: (复合模式中团体运动员参与比赛) ");
        for (Athlete athlete : athletes) {
            athlete.participate(game);
        }
    }

    @Override
    public void addChild(Athlete athlete) {
        athletes.add(athlete);
    }
}
