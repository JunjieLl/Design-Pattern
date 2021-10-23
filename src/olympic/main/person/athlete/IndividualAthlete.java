package olympic.main.person.athlete;

import olympic.main.game.Game;
import olympic.main.person.interview.Interviewee;

/**
 *
 * 个人运动员
 */
public class IndividualAthlete extends Interviewee implements Athlete {
    public IndividualAthlete(String name, String gender) {
        super(name, gender);
    }

    @Override
    public void participate(Game game) {
        System.out.println("classname: (IndividualAthlete) method: (participate) action: (个人运动员参与比赛) ");
        System.out.println(name + "参与"+game.getName());
    }

    @Override
    public void update(String content) {
        
    }
}