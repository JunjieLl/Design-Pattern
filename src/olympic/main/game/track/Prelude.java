package olympic.main.game.track;

import olympic.main.person.athlete.Athlete;
/**
 * 使用了桥接模式,作为桥接模式的具体实现者
 * Prelude是初赛
 */
public class Prelude extends ContestImpl{
    Prelude(Athlete[] athletes) {
        super(athletes);
    }

    public void start(){

    }
    public  void getParticipants(){

    }
    public  void getResult(){

    }
}
