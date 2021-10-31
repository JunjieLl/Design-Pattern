package olympic.main.game.diving;

import olympic.main.game.Valve;
import olympic.main.person.athlete.Athlete;

/**
 * 跳水初赛
 */
public class PreliminaryContest extends DivingGame {

    /**
     * 管道模式中下一轮比赛
     */
    private DivingGame nextDivingGame;
    private AthletePool athletePool = null;

    /**
     *获取管道模式中上一轮比赛的结果
     * @param athletePool 包含该轮比赛人员的对象池
     */
    public void takePlace(AthletePool athletePool) {
        this.athletePool=athletePool;
        start();
        if (this.nextDivingGame != null) {
            this.nextDivingGame.takePlace(athletePool);
        }
    }

    /**
     * 开始本轮比赛
     */
    @Override
    public void start(){
        System.out.println("\nclassname: (PreliminaryContest) method: (start) action: (管道模式下开始预赛) ");
        System.out.println("【"+athletePool.getStrategy().getName()+" 预赛】");
        for (int i = 1; i <= athletePool.getStrategy().getCycleNumber(); i++) {
            System.out.println("【第" + i + "轮】");
            for (int j = 0; j < athletePool.getSize(); j++) {
                Athlete curDivingAthlete = athletePool.appear();
                double score = athletePool.getStrategy().decideScore();
                if(athletePool.getDetail()) {
                    System.out.printf("来自\t%-19s\t的%-10s\t" + "第" + i + "轮分数为\t" + "%.3f\n", curDivingAthlete.getNation(), curDivingAthlete.getName(), score);
                }
                athletePool.addScore(curDivingAthlete,score);
                athletePool.disappear();
            }
            System.out.println("第" + i + "轮结束\n");
        }
        System.out.println("【预赛积分榜】");
        athletePool.getResult("预赛");
        athletePool.eliminate(18);
        System.out.println("让我们恭喜前18位选手进入下一轮！");
    }

    /**
     * 获取下一轮比赛
     * @param divingGame 下一轮比赛
     */
    @Override
    public Valve setNext(Valve divingGame){
        this.nextDivingGame = (DivingGame)divingGame;
        return null;
    }
}
