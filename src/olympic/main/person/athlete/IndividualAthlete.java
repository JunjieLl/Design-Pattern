package olympic.main.person.athlete;

import olympic.main.game.Game;
import olympic.main.person.Athlete;

/**
 * 设计模式：桥接模式
 * 个人射击运动员
 */
public class IndividualAthlete extends Person implements Athlete {
    public IndividualAthlete(String name, String gender) {
        super(name, gender);
    }

    @Override
    public void participate(Game game) {
        System.out.println("classname: (IndividualAthlete) method: (participate) action: (桥接模式中个人运动员参与比赛) ");
        System.out.println(name + "参与"+game.getName());
    }
}