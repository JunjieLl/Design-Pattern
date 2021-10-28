package olympic.main.game.shoot;

import olympic.main.game.Game;
import olympic.main.person.athlete.Athlete;


/**
 * 设计模式：桥接模式
 * 设计比赛
 */
public class ShootGame extends Game {
    @Override
    public String getName() {
        return "射击比赛";
    }

    /**
     * 团体和个人是两种行为
     */
    private Athlete athlete;

    @Override
    public void start() {
        System.out.println("classname: (ShootGame) method: (start) action: (桥接模式中运动员参与射击比赛) ");
        athlete.participate(this);
        /// game detail to do
    }

    public ShootGame(Athlete athlete) {
        this.athlete = athlete;
    }
}

