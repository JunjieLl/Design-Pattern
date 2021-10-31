package olympic.main.game.track;

import olympic.main.person.athlete.Athlete;

import java.util.List;

/**
 * 使用template method设计模式
 * Relays是田径比赛的J接力跑
 */
public class Relays extends TrackGame {
    /**
     *Relays构造方法
     * @param athletes 运动员列表
     */
    public Relays(List<Athlete> athletes) {
        super(athletes);

    }
    /**
     * start 方法是比赛开始
     */
    @Override
    public void start() {
        System.out.println("【"+getName()+"】");
        System.out.println("classname: (TrackGame) method: (start) action: (template method模式中运动员参与接力比赛) ");
        ContestDirector contestDirector=new ContestDirector(2,athletes);
        contestDirector.construct();

        for(int i=0;i<athletes.size();i++){
            athletes.get(i).setRank("Relays",i+1);
        }
    }

    /**
     * 获取比赛名称
     * @return 比赛名称
     */
    public String getName() {
        return "接力比赛";
    }
}
