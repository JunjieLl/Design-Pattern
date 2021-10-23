package olympic.main.game.track;

import olympic.main.person.athlete.Athlete;

/**
 * 使用了桥接模式,作为桥接模式的具体实现者
 * Final是决赛，如果没有多次比赛就作为第一次
 */
public class Final extends ContestImpl{
    Final(Athlete[] athletes) {
        super(athletes);
    }

    public void start(){

    }

    public  void getResult(){

    }
}
