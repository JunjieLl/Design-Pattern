package olympic.main.game.pingponggame;

import olympic.main.game.badminton.BadmintonGame;
import olympic.main.person.athlete.Athlete;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * 一场乒乓球比赛，可以实例化为半决赛第一场、半决赛第二场
 */
public class PingpongGame {

    private String name;

    /**
     * 仅用于暂存这场比赛的成绩
     * 与最终athlele中的成绩无关
     */
    private HashMap<Athlete, Integer> result = new HashMap<>();

    public PingpongGame(String name) {
        this.name = name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void addAthlete(Athlete athlete) {
        result.put(athlete, 0);
    }

    /**
     * 对外接口，开始比赛
     */
    public void start() {
        List<Athlete> athletes = new ArrayList<>(result.keySet());
        System.out.println(athletes.get(0).getName() + " vs " + athletes.get(1).getName());
        System.out.println("===================================================");

        // 还没有一个运动员的分数到达三分的时候，需要继续比赛
        while (Math.max((Integer) result.values().toArray()[0], (Integer) result.values().toArray()[1]) < 3 ) {
            PingpongGameRound round = new PingpongGameRound();
            for (Athlete athlete: result.keySet()){
                round.addAthlete(athlete);
            }
            System.out.println("classname: (PingpongCame) method: (start) action: (第"+((Integer) result.values().toArray()[0]+(Integer) result.values().toArray()[1]+1)+"局开始) ");
            Athlete winner = round.start();
            result.replace(winner,result.get(winner)+1);
        }

        // 比赛结束，为运动员设计成绩
        Integer winner;
        BadmintonGame.generateScore(result, name);
    }
}
