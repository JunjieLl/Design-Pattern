package olympic.main.game.track;

import olympic.main.game.Game;
import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.TeamAthlete;

/**
 * 使用template method设计模式
 */
public class TrackGame implements Game{
    private Athlete[] athletes;
    public TrackGame(Athlete[] athletes) {
        this.athletes = athletes;
    }

    @Override
    public String getName() {
        return "田径比赛";
    }

    
    @Override
    public void start() {
        System.out.println("classname: (TrackGame) method: (start) action: (template method模式中运动员参与赛跑比赛) ");
        for (Athlete athlete : athletes) {
            athlete.participate(this);
        }
        /// game detail to do
    }


}
