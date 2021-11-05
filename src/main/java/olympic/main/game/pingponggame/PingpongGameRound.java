package olympic.main.game.pingponggame;

import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.CallBack;
import olympic.main.person.athlete.pingong.PlayPingpong;
import olympic.main.director.Mode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * 乒乓球比赛的一轮（比pingponggame更细的粒度）
 */
class PingpongGameRound {

    /**
     *
     */
    private HashMap<Athlete, Integer> result = new HashMap<>();

    /**
     * 比赛的一轮
     */
    private void startOneRound( ) {
        List<Athlete> athletes = new ArrayList<>(result.keySet());
        if (Mode.getShowDetail()) {
            System.out.println(athletes.get(0).getName() + " vs " + athletes.get(1).getName());
            System.out.println("===========================================");
        }
        //可以添加决定发球的方式（如抽签）
        Integer server = new Random().nextInt(2);
        ((PlayPingpong)athletes.get(server)).serve();
        Boolean win = ((PlayPingpong)athletes.get((server + 1) % 2)).playWith((CallBack) athletes.get(server));
        Integer winner = (win ? ((server + 1) % 2) : server);
        if (Mode.getShowDetail()) {
            System.out.println("本轮结束," + athletes.get(winner).getName() + "赢了");
        }
        result.replace(athletes.get(winner), result.get(athletes.get(winner)) + 1);
    }

    /**
     *
     * @param athlete
     */
    public void addAthlete(Athlete athlete) {
        result.put(athlete, 0);
    }

    /**
     * 对外接口，开始比赛
     * @return 获胜的运动员
     */
    public Athlete start() {
        while (Math.max((Integer) result.values().toArray()[0], (Integer) result.values().toArray()[1]) < 11 || Math.abs((Integer) result.values().toArray()[0] - (Integer) result.values().toArray()[1]) < 2) {
            startOneRound();
        }

        System.out.println("【比分】 "+result.values().toArray()[0]+" : "+result.values().toArray()[1]);
        if ((Integer) result.values().toArray()[0] > (Integer) result.values().toArray()[1]) {
            return (Athlete) result.keySet().toArray()[0];
        } else {
            return (Athlete) result.keySet().toArray()[1];
        }
    }
}


