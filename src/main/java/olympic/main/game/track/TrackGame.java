package olympic.main.game.track;

import olympic.main.game.Game;
import olympic.main.person.athlete.Athlete;

import java.util.List;

/**
 * 使用template method设计模式
 * TrackGame是田径比赛的径赛，作为抽象类不可以实例化
 */
public abstract class TrackGame extends Game{
    /**
     *TrackGame构造方法
     * @param athletes 运动员列表
     */
    public TrackGame(List<Athlete> athletes) {
        super();
        this.athletes = athletes;
    }
    public List<Athlete> getAthletes() {
        return this.athletes;
    }



}
