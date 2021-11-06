package olympic.main.game.track;

import olympic.main.person.athlete.Athlete;

import java.util.List;

/**
 * 使用template method设计模式
 * Sprints是田径比赛的冲刺跑
 */
public class Sprints extends TrackGame {

    /**
     *Sprints构造方法
     * @param athletes 运动员列表
     */
    public Sprints(List<Athlete> athletes) {
        super(athletes);
    }

    /**
     * start 方法是比赛开始
     */
    @Override
    public void start() {
        System.out.println("【" + getName() + "】");
        System.out.println("classname: (TrackGame) method: (start) action: (template method模式中运动员参与冲刺比赛) ");
        ContestDirector contestDirector = new ContestDirector(3, athletes);
        contestDirector.construct();

        for (int i = 0; i < athletes.size(); i++) {
            athletes.get(i).setRank("Sprints", i + 1);
        }
    }


    /**
     * 获取比赛名称
     * @return 比赛名称
     */
    public String getName() {
        return "冲刺比赛";
    }
}
