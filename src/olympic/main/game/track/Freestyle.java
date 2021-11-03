package olympic.main.game.track;

import olympic.main.person.athlete.Athlete;

import java.util.List;

/**
 * 使用template method设计模式
 * Freestyle是自由泳比赛
 */
public class Freestyle extends TrackGame {
    /**
     *Hurdling构造方法
     * @param athletes 运动员列表
     */
    public Freestyle(List<Athlete> athletes) {
        super(athletes);

    }
    /**
     * start 方法是比赛开始
     */
    @Override
    public void start() {
        System.out.println("【"+getName()+"】");
        System.out.println("classname: (Freestyle) method: (start) action: (template method模式中运动员参与自由泳比赛) ");
        ContestDirector contestDirector=new ContestDirector(2,athletes);
        contestDirector.construct();

        for(int i=0;i<athletes.size();i++){
            athletes.get(i).setRank("Hurdling",i+1);
        }
    }
    /**
     * 获取比赛名称
     * @return 比赛名称
     */
    public String getName(){
        return "自由泳比赛";
    }
}