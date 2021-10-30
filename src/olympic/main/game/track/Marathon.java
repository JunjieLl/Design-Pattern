package olympic.main.game.track;

import olympic.main.person.athlete.Athlete;

import java.util.List;
/**
 * 使用template method设计模式
 * Marathon是田径比赛的马拉松
 */
public class Marathon extends TrackGame{
    public Marathon(List<Athlete> athletes) {
        super(athletes);
    }

    @Override
    public void start() {
        System.out.println("【"+getName()+"】");
        System.out.println("classname: (TrackGame) method: (start) action: (template method模式中运动员参与马拉松比赛) ");
        ContestDirector contestDirector=new ContestDirector(1,athletes);
        contestDirector.construct();

        for(int i=0;i<athletes.size();i++){
            athletes.get(i).setRank("Marathon",i+1);
        }
    }

    public String getName(){
        return "马拉松比赛";
    }
}
