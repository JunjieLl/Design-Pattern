package olympic.main.game.track;

import olympic.main.person.athlete.Athlete;

/**
 * 使用了桥接模式,作为桥接模式的实现者
 * ContestImpl是比赛的抽象类
 */
public abstract class ContestImpl {
    public Athlete[] athletes;
    ContestImpl(Athlete[] athletes){
        this.athletes=athletes;

    }
    public  void start(){
        
    }
    public abstract void getParticipants();
    public abstract void getResult();
}
