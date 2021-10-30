package olympic.main.game.pingponggame;

import olympic.main.person.athlete.Athlete;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * 一场乒乓球比赛，可以实例化为半决赛第一场、半决赛第二场
 */
public class PingpongGame {

    private String name;

    private HashMap<Athlete, Integer> result = new HashMap<>();

    public PingpongGame(String name) {
        this.name = name;
    }

    public void addAthlete(Athlete athlete) {
        result.put(athlete, 0);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void start() {
        List<Athlete> athletes = new ArrayList<>(result.keySet());
        System.out.println(athletes.get(0).getName() + " vs " + athletes.get(1).getName());
        System.out.println("===================================================");
        while (Math.max((Integer) result.values().toArray()[0], (Integer) result.values().toArray()[1]) < 3 ) {
            PingpongGameRound round = new PingpongGameRound();
            for (Athlete athlete: result.keySet()){
                round.addAthlete(athlete);
            }
            System.out.println("classname: (PingpongCame) method: (start) action: (第"+((Integer) result.values().toArray()[0]+(Integer) result.values().toArray()[1]+1)+"局开始) ");
            Athlete winner = round.start();
            result.replace(winner,result.get(winner)+1);
        }
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
        System.out.println("===================================================");
        System.out.print("【本局结束】");
        System.out.print("比分"+result.values().toArray()[0]+":"+result.values().toArray()[1]+" ");
        System.out.println(((Athlete)result.keySet().toArray()[winner]).getName()+" 获胜\n");
    }
}
