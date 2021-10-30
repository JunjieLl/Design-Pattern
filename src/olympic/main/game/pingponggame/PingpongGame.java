package olympic.main.game.pingponggame;

import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.IndividualAthlete;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PingpongGame {
    private String name;

    private PingpongGame nextGame;

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

    public void setNextGame(PingpongGame nextGame) {
        this.nextGame = nextGame;
    }

    public void start() {
        List<Athlete> athletes = new ArrayList<>(result.keySet());
        System.out.println("classname: (PingpongCame) method: (start) action: (乒乓球比赛一局开始) ");
        System.out.println(athletes.get(0).getName() + " vs " + athletes.get(1).getName());
        System.out.println("===========================================");
        while (Math.max((Integer) result.values().toArray()[0], (Integer) result.values().toArray()[1]) < 3 ) {
            PingpongGameRound round = new PingpongGameRound();
            for (Athlete athlete: result.keySet()){
                round.addAthlete(athlete);
            }
            Athlete winner = round.start();
            result.replace(winner,result.get(winner)+1);
        }
        Integer winner;
        if ((Integer) result.values().toArray()[0] > (Integer) result.values().toArray()[1]) {
//            winner = (IndividualAthlete) result.keySet().toArray()[0];
            winner = 0;
            ((IndividualAthlete)result.keySet().toArray()[0]).setRank(name,0);
        } else {
//            winner = (IndividualAthlete) result.keySet().toArray()[1];
            winner = 1;
            ((IndividualAthlete)result.keySet().toArray()[0]).setRank(name,1);
        }
        ((IndividualAthlete)result.keySet().toArray()[winner]).setRank(name,0);
        ((IndividualAthlete)result.keySet().toArray()[1-winner]).setRank(name,1);
        System.out.println("比分"+result.values().toArray()[0]+" : "+result.values().toArray()[1]);
        System.out.println(((IndividualAthlete)result.keySet().toArray()[winner]).getName()+" 赢了");
    }
}
