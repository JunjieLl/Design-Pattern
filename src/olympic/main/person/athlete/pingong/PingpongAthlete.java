package olympic.main.person.athlete.pingong;

import olympic.main.game.pingponggame.Mode;
import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.IndividualAthlete;
import olympic.main.person.athlete.pingong.Strategy.Strategy;

import java.util.Random;

public class PingpongAthlete extends IndividualAthlete implements CallBack,PlayPingpong{
    public PingpongAthlete(String name, String nation,Integer capacity) {
        super(name, nation);
        this.capacity = capacity;
    }

    /**
     * 随机数用于模拟一些概率
     */
    private Random random = new Random();

    /**
     * 运动员的实力
     * 范围0-99，数越大能力越强，实力与接球概率有关
     */
    private Integer capacity;

    /**
     * 运动员采用的比赛策略
     */
    private Strategy strategy;

    public Integer getCapacity() {
        return capacity;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 与Oppoend进行对打
     * @param oppoent 对手
     * @return 是否击中球，没有击中球就输了这一小轮
     */
    @Override
    public Boolean playWith(Athlete oppoent){
        return strategy.playWith(oppoent);
    }

    /**
     * 发球
     */
    @Override
    public void serve(){
        if (Mode.getShowDetail()) {
            System.out.println(this.getName() + " 发乒乓球");
        }
    }

    /**
     * 回调函数，用于对打
     * @param oppoent
     * @return 是否击中球，没有击中球就输了这一小轮
     */
    @Override
    public Boolean call(Athlete oppoent) {
        if (Mode.getShowDetail()) {
            System.out.println("classname: (PingpongAthlete) method: (call) action: (回调模式中选手运用回调函数进行对打) ");
        }
        return this.playWith((PingpongAthlete)oppoent);
    }
}
