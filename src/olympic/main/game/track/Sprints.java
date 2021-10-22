package olympic.main.game.track;

import olympic.main.person.athlete.Athlete;

public class Sprints extends TrackGame {


    public Sprints(Athlete[] athletes) {
        super(athletes);
    }

    @Override
    public void start() {
        System.out.println("classname: (TrackGame) method: (start) action: (template method模式中运动员参与冲刺比赛) ");
//        athlete.participate(this);
        /// game detail to do
    }



    public String getName(){
        return "冲刺比赛";
    }
}
