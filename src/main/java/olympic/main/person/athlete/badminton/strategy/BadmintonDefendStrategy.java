package olympic.main.person.athlete.badminton.strategy;

import olympic.main.director.Mode;
import olympic.main.person.athlete.Athlete;
import olympic.main.person.athlete.CallBack;
import olympic.main.person.athlete.Strategy;
import olympic.main.person.athlete.badminton.PlayBadminton;

import java.util.Random;


/**
 * 防守策略
 */
public class BadmintonDefendStrategy implements Strategy {

    /**
     * 归属者，运动员
     */
    private Athlete ownerAthlete;

    /**
     * 随机
     */
    private Random random = new Random();

    /**
     * 对打
     * @param oppoent 对手
     * @return 是否赢了
     */
    @Override
    public Boolean playWith(CallBack oppoent) {
        if (Mode.getShowDetail()) {
            System.out.println("classname: (PingpongDefendStrategy) method: (playWith) action: (策略模式中" + ((Athlete) oppoent).getName() + "运用防御策略进行比赛) ");
        }

        // 随机生成球的状态（击球难度)
        if (random.nextInt(100) < ((PlayBadminton) ownerAthlete).getCapacity()) {
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

    /**
     * 设置归属者
     * @param ownerAthlete 归属者
     */
    @Override
    public void setOwnerAthlete(Athlete ownerAthlete) {
        this.ownerAthlete = ownerAthlete;
    }
}
