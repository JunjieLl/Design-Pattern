package olympic.main.person.athlete.pingong.Strategy;

import olympic.main.director.Mode;
import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.pingong.CallBack;
import olympic.main.person.athlete.pingong.PlayPingpong;

import java.util.Random;


/**
 * 防守策略
 */
public class PingpongDefendStrategy implements Strategy {

    /**
     * 归属者，运动员
     */
    private Athlete ownerAthlete;

    private Random random = new Random();

    /**
     * 球的状态，用于模拟能不能接到球
     */
//    private Integer ballState;

    /**
     * 用于模拟攻击或防守
     */
//    private Boolean offense;

    /**
     * 攻击概率
     */
//    private Integer offenseProb;
    @Override
    public Boolean playWith(CallBack oppoent) {
        if (Mode.getShowDetail()) {
            System.out.println("classname: (PingpongDefendStrategy) method: (playWith) action: (策略模式中" + ((Athlete) oppoent).getName() + "运用防御策略进行比赛) ");
        }

        // 随机生成球的状态（击球难度)
        if (random.nextInt(100) < ((PlayPingpong) ownerAthlete).getCapacity()) {
            if (Mode.getShowDetail()) {
                System.out.println(ownerAthlete.getName() + " 击球" + (random.nextInt(100) < 30 ? " 进攻" : " 防守"));
            }
            return !oppoent.call((CallBack) ownerAthlete);
        } else {
            if (Mode.getShowDetail()) {
                System.out.println(ownerAthlete.getName() + " 接球失败");
            }
            return false;
        }
    }

    @Override
    public void setOwnerAthlete(Athlete ownerAthlete) {
        this.ownerAthlete = ownerAthlete;
    }
}
