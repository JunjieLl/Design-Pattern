package olympic.main.person.athlete;

import olympic.main.game.Game;
import olympic.main.person.Person;

/**
 *
 * 个人运动员，继承自抽象类Person和Athlete接口
 */
public abstract class IndividualAthlete extends Person implements Athlete {
    protected IndividualAthlete(String name, String gender) {
        super(name, gender);
    }
}