package olympic.main.game.track;

import olympic.main.person.athlete.Athlete;
/**
 * 使用template method设计模式
 * Sprints是田径比赛的冲刺跑
 */
public class Sprints extends TrackGame {


    public Sprints(Athlete[] athletes) {
        super(athletes);
    }

    @Override
    public void start() {
        System.out.println("classname: (TrackGame) method: (start) action: (template method模式中运动员参与冲刺比赛) ");
        Contest contest1=new Contest(new Prelude(athletes));
        Contest contest2=new Contest(new SemiFinals(athletes));

        Contest contest3=new Contest(new Final(athletes));

        contest1.display();
        contest1.display();
        contest1.display();
        for(Athlete athlete:athletes){
            athlete.participate(this);
        }

        /// game detail to do
    }



    public String getName(){
        return "冲刺比赛";
    }
}
