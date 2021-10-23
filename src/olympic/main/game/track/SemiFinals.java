package olympic.main.game.track;

import olympic.main.person.athlete.Athlete;
/**
 * 使用了桥接模式,作为桥接模式的具体实现者
 * SemiFinals是半决赛
 */
public class SemiFinals  extends ContestImpl{
    SemiFinals(Athlete[] athletes) {
        super(athletes);
    }

    public void start(){

    }

    public  void getResult(){

    }
}
