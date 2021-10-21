package olympic.main.game.shoot;

import olympic.main.game.Game;
import olympic.main.person.Athlete;


/**
 * 设计比赛
 */
public class ShootGame implements Game {
    @Override
    public String getName() {
        return "射击比赛";
    }

    /**
     * 设计模式：桥接模式
     * 团体和个人是两种行为
     */
    private Athlete athlete;

    @Override
    public void start() {
        athlete.participate(this);
        /// game detail to do
    }
}

