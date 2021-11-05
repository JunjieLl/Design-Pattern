package olympic.main.game.badminton;

import olympic.main.person.athlete.Athlete;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * 一场乒乓球比赛，可以实例化为半决赛第一场、半决赛第二场
 */
public class BadmintonGame {

    /**
     * 名字
     */
    private String name;

    /**
     * 仅用于暂存这场比赛的成绩
     * 与最终athlele中的成绩无关
     */
    private HashMap<Athlete, Integer> result = new HashMap<>();

    /**
     * 构造函数
     * @param name 名字
     */
    public BadmintonGame(String name) {
        this.name = name;
    }

    /**
     * 设置名字
     * @param name 名字
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 添加运动员
     * @param athlete 运动员
     */
    public void addAthlete(Athlete athlete) {
        result.put(athlete, 0);
    }

    /**
     * 对外接口，开始比赛
     */
    public void start() {
        List<Athlete> athletes = new ArrayList<>(result.keySet());
        System.out.println("===========================================================================");
        System.out.print("                    [");
        System.out.print("\033[1;" + 34+"m");
        System.out.print(athletes.get(0).getName() + " vs " + athletes.get(1).getName());
        System.out.print("\033[0m");
        System.out.println("]");


        // 还没有一个运动员的分数到达三分的时候，需要继续比赛
        while (Math.max((Integer) result.values().toArray()[0], (Integer) result.values().toArray()[1]) < 2 ) {
            BadmintonGameRound round = new BadmintonGameRound();
            for (Athlete athlete: result.keySet()){
                round.addAthlete(athlete);
            }
            System.out.println("classname: (BadmintonGame) method: (start) action: (第"+((Integer) result.values().toArray()[0]+(Integer) result.values().toArray()[1]+1)+"局开始) ");
            Athlete winner = round.start();
            result.replace(winner,result.get(winner)+1);
        }

        // 比赛结束，为运动员设计成绩
        Integer winner;
        if ((Integer) result.values().toArray()[0] > (Integer) result.values().toArray()[1]) {
            winner = 0;
            ((Athlete)result.keySet().toArray()[0]).setRank(name,0);
        } else {
            winner = 1;
            ((Athlete)result.keySet().toArray()[0]).setRank(name,1);
        }
        ((Athlete)result.keySet().toArray()[winner]).setRank(name,1);
        ((Athlete)result.keySet().toArray()[1-winner]).setRank(name,2);

        System.out.println("===========================================================================");
        System.out.print("【本局结束】");
        System.out.print("比分"+result.values().toArray()[0]+":"+result.values().toArray()[1]+" ");
        System.out.println(((Athlete)result.keySet().toArray()[winner]).getName()+" 获胜\n");
    }
}
