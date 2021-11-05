package olympic.main.person.athlete.pingong;

import olympic.main.director.Mode;
import olympic.main.person.athlete.CallBack;
import olympic.main.person.athlete.IndividualAthlete;
import olympic.main.person.athlete.pingong.Strategy.PingpongDefendStrategy;
import olympic.main.person.athlete.pingong.Strategy.PingpongOffenseStrategy;
import olympic.main.person.athlete.Strategy;

import java.util.Random;

public class PingpongAthlete extends IndividualAthlete implements PlayPingpong {

    /**
     * 构造函数
     * @param name 姓名
     * @param nation 国家
     */
    public PingpongAthlete(String name, String nation) {
        super(name, nation);

        Random random = new Random();
        if (random.nextInt() % 2 == 0) {
            this.strategy = new PingpongOffenseStrategy();
        } else {
            this.strategy = new PingpongDefendStrategy();
        }
        strategy.setOwnerAthlete(this);
        if (nation.equals("CHN")) {
            capacity = 99;
        } else {
            capacity = random.nextInt(8) + 90;
        }
    }

    /**
     * 运动员的实力
     * 范围0-99，数越大能力越强，实力与接球概率有关
     */
    private Integer capacity;

    /**
     * 运动员采用的比赛策略
     */
    private Strategy strategy;

    /**
     * 获取实力
     * @return 实力
     */
    @Override
    public Integer getCapacity() {
        return capacity;
    }

    /**
     * 设置策略
     * @param strategy 策略
     */
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 与Oppoend进行对打
     *
     * @param oppoent 对手
     * @return 是否击中球，没有击中球就输了这一小轮
     */
    @Override
    public Boolean playWith(CallBack oppoent) {
        return strategy.playWith(oppoent);
    }

    /**
     * 发球
     */
    @Override
    public void serve() {
        if (Mode.getShowDetail()) {
            System.out.println(this.getName() + " 发乒乓球");
        }
    }

    /**
     * 回调函数，用于对打
     * @param oppoent 1
     * @return 是否击中球，没有击中球就输了这一小轮
     */
    @Override
    public Boolean call(CallBack oppoent) {
        if (Mode.getShowDetail()) {
            System.out.println("classname: (PingpongAthlete) method: (call) action: (回调模式中选手运用回调函数进行对打) ");
        }
        return this.playWith(oppoent);
    }
}
