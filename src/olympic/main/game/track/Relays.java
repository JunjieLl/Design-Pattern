package olympic.main.game.track;

import olympic.main.game.Game;
import olympic.main.person.athlete.Athlete;

import java.util.List;

/**
 * 使用template method设计模式
 * Relays是田径比赛的J接力跑
 */
public class Relays extends TrackGame {

    public Relays(List<Athlete> athletes) {
        super(athletes);

    }

    @Override
    public void start() {
        System.out.println("classname: (TrackGame) method: (start) action: (template method模式中运动员参与接力比赛) ");
        ContestDirector contestDirector=new ContestDirector(2,athletes);
        contestDirector.construct();
//        for(Athlete athlete:athletes) {
//            athlete.participate(this);
//        }
        /// game detail to do
    }



    public String getName(){
        return "接力比赛";
    }
}
